package com.mycompany.a1;

import java.util.Random;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {
	private int size;
	private float x;
	private float y;
	private double locationX;
	private double roundLocationX;
	private double locationY;
	private double roundLocationY;
	private Point location;
	private int color;
	private Random rand = new Random();	
	
	public GameObject() {
		location = new Point(x, y);
	}
	public int baseSize() {
		size = 10;
		return size;
	}
	public int cyborgSize() {
		size = 40;
		return size;
	}
	public int droneSize() {
		size = rand.nextInt(40 + 1) + 10;
		return size;
	}
	public int energyStationSize() {
		size = rand.nextInt(40 + 1) + 10;
		return size;
	}

	public Point getLocation() {
		return location;
	}
	public void setLocation(int x, int y) {
		location.setX(x);
		location.setY(y);
	}
	public void setLocation(Point p) {
		this.location = p;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int r, int g, int b) {
		color = ColorUtil.rgb(r, g, b);
	}
	public String toString() {
		locationX = location.getX();
		locationY = location.getY();
		roundLocationX = Math.round(locationX * 10) / 10;
		roundLocationY = Math.round(locationY * 10) / 10;
		String s = "loc = " + roundLocationX + ", " + roundLocationY
				 + " color =  [" + ColorUtil.red(color) + ", " + ColorUtil.green(color) + ", " +  ColorUtil.blue(color) + "]";
		return s;
	}
}