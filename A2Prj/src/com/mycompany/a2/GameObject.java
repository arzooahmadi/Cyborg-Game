package com.mycompany.a2;

import java.util.Random;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {

	private int size;
	private int color;
	private float x;
	private float y;
	private double locationX;
	private double roundLocationX;
	private double locationY;
	private double roundLocationY;
	private Point location;
	private Random rand = new Random();	
	
	public GameObject() {
		//Setting the location
		location = new Point(x, y);
	}
	
	public int baseSize() {
		//Setting the size to 10
		size = 10;
		//Returning the size
		return size;
	}
	
	public int cyborgSize() {
		//Setting size to 40
		size = 40;
		//Returning size
		return size;
	}
	
	public int droneSize() {
		//Setting size to a random number
		size = rand.nextInt(40 + 1) + 10;
		//Returning size
		return size;
	}
	
	public int energyStationSize() {
		//Setting size to a random number
		size = rand.nextInt(40 + 1) + 10;
		//Returning size
		return size;
	}

	public Point getLocation() {
		//Returning location
		return location;
	}
	
	public void setLocation(int angle, int y) {
		//Setting the x value of location
		location.setX(angle);
		//Setting the y value of location
		location.setY(y);
	}
	
	public void setLocation(Point p) {
		//Setting location
		this.location = p;
	}
	
	public int getColor() {
		//Returning color
		return color;
	}
	
	public void setColor(int r, int g, int b) {
		//Setting color
		color = ColorUtil.rgb(r, g, b);
	}
	
	public String toString() {
		//Getting values for string
		locationX = location.getX();
		locationY = location.getY();
		roundLocationX = Math.round(locationX * 10) / 10;
		roundLocationY = Math.round(locationY * 10) / 10;
		//Creating string s to return
		String s = "loc = " + roundLocationX + ", " + roundLocationY
				 + " color =  [" + ColorUtil.red(color) + ", " + ColorUtil.green(color) + ", " +  ColorUtil.blue(color) + "]";
		//Returning s
		return s;
	}
	
}
