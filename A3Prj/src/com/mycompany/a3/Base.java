package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Base extends Fixed {

	private int size = 50;
	private int sequenceNumber;
	private String parentDesc;
	private String base;
	private String myDesc;
	private Cyborg cyborg;
	private GameWorld gw;
	private boolean isSelected;

	public Base() {
		//Set the color of the base to blue
		setColor(0, 0, 255);
	}
	
	public int setSize(int i) {
		//Set the size of the base to i
		size = i;
		//Return the size of the base
		return size;
	}
	
	
	public int setSequenceNumber(int i) {
		//Set the sequence number of the base to i
		sequenceNumber = i;
		//Return the sequence number of the base
		return sequenceNumber;
	}
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		//Get the points
		int x1 = (int) getLocation().getX() + pCmpRelPrnt.getX();
		int x2 = (int) getLocation().getX() + pCmpRelPrnt.getX() + (baseSize());
		int x3 = (int) getLocation().getX() + pCmpRelPrnt.getX() - (baseSize());
		int y1 = (int) getLocation().getY() + pCmpRelPrnt.getY();
		int y2 = (int) getLocation().getY() + pCmpRelPrnt.getY() - (baseSize());
		int y3 = (int) getLocation().getY() + pCmpRelPrnt.getY() - (baseSize());
		//Put the points in an array list
		int[] xPoints = {x1, x2, x3};
		int[] yPoints = {y1, y2, y3};
		if(isSelected()) {
			//Set the color
			g.setColor(ColorUtil.rgb(0, 204, 255));
			//Draw the triangle
			g.drawPolygon(xPoints, yPoints, 3);
			//Set the color
			g.setColor(ColorUtil.BLACK);
			//Draw the text
			g.drawString("" + sequenceNumber, (x1 - 5), (y1 - 50));
		} else {
			//Set the color
			g.setColor(ColorUtil.rgb(0, 204, 255));
			//Fill the triangle
			g.fillPolygon(xPoints, yPoints, 3);
			//Set the color
			g.setColor(ColorUtil.BLACK);
			//Draw the text
			g.drawString("" + sequenceNumber, (x1 - 5), (y1 - 50));
		}
	}
	
	public String toString() {
		parentDesc = super.toString();
		base = "Base: ";
		myDesc =  " size = " + size + " seqNum = " + sequenceNumber;
		//Return a combination of the different strings
		return base + parentDesc + myDesc ;
	}
	
	@Override
	public void setSelected(boolean b) { 
		//Set isSelected to b
		isSelected = b; 
	}
	
	@Override
	public boolean isSelected() { 
		//Return isSelected
		return isSelected; 
	}
	@Override
	public boolean collidesWith(GameObject otherObject) {
		boolean result = false;
		//Location of base object
		int thisCenterX = (int) this.getLocation().getX() + (this.size/2);
		int thisCenterY = (int) this.getLocation().getY() + (this.size/2);
		//Location of otherObject
		int otherCenterX = (int) otherObject.getLocation().getX() + (this.size/2);
		int otherCenterY = (int) otherObject.getLocation().getY() + (this.size/2);
		int dx = thisCenterX - otherCenterX;
		int dy = thisCenterY - otherCenterY;
		int distBetweenCentersSqr = (dx*dx + dy*dy);
		int thisRadius = this.size/2;
		int otherRadius = this.size/2;
		int radiiSqr = (thisRadius * thisRadius + 2 * thisRadius * otherRadius + otherRadius * otherRadius);
		if (distBetweenCentersSqr <= radiiSqr) { 
			result = true; 
		}
		return result ;
	}
	
	@Override
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		//Pointer's location relative to parent's orgin
		int px = pPtrRelPrnt.getX();
		int py = pPtrRelPrnt.getY();
		//Shape's location relative to parent's orgin
		int xLoc = (int) (pCmpRelPrnt.getX()+ this.getLocation().getX());
		int yLoc = (int) (pCmpRelPrnt.getY()+ this.getLocation().getY());
		if ((px >= xLoc - 20) && (px <= xLoc + this.size + 20) && (py >= yLoc - 40) && (py <= yLoc + this.size + 40)) {
			return true;
		} else {
			return false;
		}
	}
}
