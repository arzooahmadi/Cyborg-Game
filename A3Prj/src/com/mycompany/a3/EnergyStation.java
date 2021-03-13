package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class EnergyStation extends Fixed {

	private int size;
	private int capacity;
	private int energyLevel;
	private int colorNum = 255;
	private int number;
	private String parentDesc;
	private String energyStation;
	private String myDesc;
	private GameWorld gw;
	
	public EnergyStation() {
		//Setting the color to green
		setColor(0, 255, 0);
	}
	
	public int setSize(int i) {
		//Setting the size to i
		size = i;
		//Returning the size
		return size;
	}
	
	public int cyborgEnergy() {
		//Setting the energyLevel to capacity
		energyLevel = capacity;
		//Setting the capacity to 0
		capacity = 0;
		//Setting the colorNum to colorNum - 15
		colorNum = colorNum - 15;
		//Setting the color
		setColor(0, colorNum, 0);
		//Returning the energyLevel
		return energyLevel;
	}
	
	public int setCapacity() {
		//Setting the capacity to size
		capacity = size;
		//Returning the capacity
		return capacity;
	}
	
	public void setNumber(int i) {
		//Set number equal to i
		number = i;
	}
	
	public int getNumber() {
		//Return the number
		return number;
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		//Get the points
		int x = (int) this.getLocation().getX() + pCmpRelPrnt.getX();
		int y = (int) this.getLocation().getX() + pCmpRelPrnt.getX();
		//Set the size
		int r = this.size;
		if (isSelected()) {
			//Set the color
			g.setColor(ColorUtil.GREEN);
			//Draw the circle
			g.drawArc(x, y, (3 * r), (3 * r), 0, 360);
			//Set the color
			g.setColor(ColorUtil.BLACK);
			//Draw the text
			g.drawString("" + capacity, x + r, y);
		} else {
			//Set the color
			g.setColor(ColorUtil.GREEN);
			//Fill the circle
			g.fillArc(x, y, (3 * r), (3 * r), 0, 360);
			//Set the color
			g.setColor(ColorUtil.BLACK);
			//Draw the text
			g.drawString("" + capacity, x + r, y);
		}
	}
	
	public String toString() {
		//Creating strings
		parentDesc = super.toString();
		energyStation = "EnergyStation: ";
		myDesc = " size = " + size + " capacity = " + capacity;
		//Returning a combination of strings
        return energyStation + parentDesc + myDesc;
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
		if ((px >= xLoc - 100) && (px <= xLoc + energyStationSize() + 100) && (py >= yLoc - 50) && (py <= yLoc + energyStationSize() + 50)) {
			return true;
		} else {
			return false;
		}
	}
	
}
