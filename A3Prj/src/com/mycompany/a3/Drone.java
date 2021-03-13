package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Drone extends Movable {

	private int size;
	private int heading;
	private int speed;
	private String parentDesc;
	private String drone;
	private String myDesc;
	
	public Drone() {
		//Setting the drone to purple
		setColor(255, 0, 255);
	}
	
	public int setSize(int i) {
		//Setting the size to i
		size = i;	
		//Returning the size
		return size;
	}
	
	public int setHeading(int i) {
		//Setting the heading to i
		heading = i;
		//Returning the heading
		return heading;
	}
	
	public int setSpeed(int i) {
		//Setting the speed to i
		speed = i;
		//Returning the speed
		return speed;		
	}
	
	public int heading() {
		//Setting the heading to heading + 5
		heading = heading + 5;
		if (heading >= 359) {
			//Setting the heading to 0
			setHeading(0);
		}
		//Returning the heading
		return heading;
	}
	
	public int speed() {
		//Returning the speed
		return speed;
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		//Set the points
		int x1 = (int) getLocation().getX() + pCmpRelPrnt.getX();
		int x2 = (int) getLocation().getX() + pCmpRelPrnt.getX() + (droneSize());
		int x3 = (int) getLocation().getX() + pCmpRelPrnt.getX() - (droneSize());
		int y1 = (int) getLocation().getY() + pCmpRelPrnt.getY();
		int y2 = (int) getLocation().getY() + pCmpRelPrnt.getY() - (droneSize());
		int y3 = (int) getLocation().getY() + pCmpRelPrnt.getY() - (droneSize());
		//Put the points in an array list
		int[] xPoints = {x1, x2, x3};
		int[] yPoints = {y1, y2, y3};
		//Set the color
		g.setColor(ColorUtil.BLACK);
		//Draw the triangle
		g.drawPolygon(xPoints, yPoints, 3);
	}
	
	public String toString() {
		//Creating strings
		parentDesc = super.toString();
		drone = "Drone: ";
		myDesc = " heading = " + heading + " speed = " + speed + " size = " + size;
		//Returning the combination of strings
        return drone + parentDesc + myDesc ;
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
