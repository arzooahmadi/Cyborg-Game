package com.mycompany.a1;

import com.codename1.charts.models.Point;

public abstract class Movable extends GameObject {
	private Point newLocation = new Point();
	private double deltaX;
	private double deltaY;
	public void cyborgMove(int x, int y) {
		x = 90 - x;
		deltaX = Math.cos(Math.toRadians(x)) * y;
		deltaY = Math.sin(Math.toRadians(x)) * y;
		newLocation.setX((float) (deltaX + getLocation().getX()));
		newLocation.setY((float) (deltaY + getLocation().getY()));
		setLocation(newLocation);
	}
	public int droneMove(int x, int y) {
		x = x + 5;
		if (x < 0) {
			x = x + 5;
		}
		if (x > 359) {
			x = x - 5;
		}
		deltaX = Math.cos(Math.toRadians(x)) * y;
		deltaY = Math.sin(Math.toRadians(x)) * y;
		deltaX = deltaX + getLocation().getX();
		deltaY = deltaY + getLocation().getY();
		if (deltaX >= 0 && deltaX <= 1000) {
			newLocation.setX((float) deltaX);
		} else {
			x = x + 5;
		}
		if (deltaY >= 0 && deltaY <= 1000){
			newLocation.setY((float) deltaY);
		} else {
			x = x + 5;
		}
		setLocation(newLocation);
		return x;
	}
}
