package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class NonPlayerCyborg extends Cyborg {

	private int colorNum = 200;
	private int size = getSize();
	private String parentDesc;
	private String nonPlayerCyborg;
	private String strategy;
	private String change;
	private IStrategy curStrategy;

	public NonPlayerCyborg() {
		//Set the color of non player cyborg
		setColor(colorNum, 0, 0);
	}
	
	public void setStrategy(IStrategy s) {
		//Set the curStrategy equal to s
		curStrategy = s;
	}
	
	public void invokeStrategy() {
		//Call the apply method
		curStrategy.apply();
	}
	
	public void saveMoveStrategy() {
		//Set change equal to Move
		change = "Move";
	}
	
	public void saveHeadingStrategy() {
		//Set change equal to Heading
		change = "Heading";
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		//Get the points
		int x1 = (int) (getLocation().getX() + pCmpRelPrnt.getX());
		int y1 = (int) (getLocation().getY() + pCmpRelPrnt.getY());
		//Set the color
		g.setColor(ColorUtil.rgb(255, 0, 0));
		//Draw the square
		g.drawRect(x1, y1, (cyborgSize()), (cyborgSize()));
	}
	
	public String toString() {
		//Create strings
		parentDesc = super.toString();
		nonPlayerCyborg = "Non Player ";
		strategy = " Strategy: " + change;
		//Return combination of strings
		return nonPlayerCyborg + parentDesc + strategy;
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
	
}