package com.mycompany.a3;

import com.codename1.charts.models.Point;

public abstract class Movable extends GameObject {

	private Point newLocation = new Point();
	private double deltaX;
	private double deltaY;
	
	public void cyborgMove(int angle, int y, int elapsedTime) {
		//Set angle equal to 90 - angle
		angle = 90 - angle;
		//Set deltaX
		deltaX = Math.cos(Math.toRadians(angle)) * y;
		//Set deltaY
		deltaY = Math.sin(Math.toRadians(angle)) * y;
		//Set newLocation value X
		newLocation.setX((float) (deltaX + getLocation().getX()));
		//Set newLocation value Y
		newLocation.setY((float) (deltaY + getLocation().getY()));
		//Set location to newLocation
		setLocation(newLocation);
	}
	
	public int droneMove(int x, int y, int elapsedTime) {
		//Set x equal to x + 5
		x = x + 5;
		if (x < 0) {
			//Set x equal to x + 5
			x = x + 5;
		}
		if (x > 359) {
			//Set x equal to x - 5
			x = x - 5;
		}
		//Set deltaX
		deltaX = Math.cos(Math.toRadians(x)) * y;
		//Set deltaY
		deltaY = Math.sin(Math.toRadians(x)) * y;
		//Set deltaX
		deltaX = deltaX + getLocation().getX();
		//Set deltaY
		deltaY = deltaY + getLocation().getY();
		if (deltaX >= 0 && deltaX <= Game.width()) {
			//Set the newLocation value of X
			newLocation.setX((float) deltaX);
		} else {
			//Set x equal to x + 5
			x = x + 5;
		}
		if (deltaY >= 0 && deltaY <= Game.height()){
			//Set the newLocation value of Y
			newLocation.setY((float) deltaY);
		} else {
			//Set x equal to x + 5
			x = x + 5;
		}
		//Set the location to newLocation
		setLocation(newLocation);
		//Return x
		return x;
	}
	
	public void nonPlayerCyborgMove(double angle, int speed, double a, double b, int elapsedTime) {
		//Set angle equal to 90 - angle
		angle = 90 - angle;
		//Set deltaX
		deltaX = Math.cos(Math.toRadians(angle)) * speed;
		//Set deltaY
		deltaY = Math.sin(Math.toRadians(angle)) * speed;
		//Set the x value of newLocation
		newLocation.setX((float) (a - deltaX));
		//Set the y value of newLocation
		newLocation.setY((float) (b - deltaY));
		//Set the location to newLocation
		setLocation(newLocation);
	}

}
