package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject implements IDrawable, ICollider {

	//Making the variables
	private int color;
	private float x;
	private float y;
	private double locationX;
	private double roundLocationX;
	private double locationY;
	private double roundLocationY;
	private Point location;
	private Random rand = new Random();	
	private int baseSize = 50;
	private int cyborgSize = 80;
	private int droneSize = rand.nextInt(40 + 1) + 10;
	private int energyStationSize = rand.nextInt(40 + 1) + 10;

	
	public GameObject() {
		//Setting the location
		location = new Point(x, y);
	}
	
	public int baseSize() {
		//Returning the size
		return baseSize;
	}
	
	public int cyborgSize() {
		//Returning size
		return cyborgSize;
	}
	
	public int droneSize() {
		//Returning size
		return droneSize;
	}
	
	public int energyStationSize() {
		//Returning size
		return energyStationSize;
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
	
	@Override
	public void handleCollision(GameObject otherObject, GameWorld gw) {
		//If object is a base call baseCollison
		if(otherObject instanceof Base) {
			gw.baseCollision((Base) otherObject);
		//If object is a non player cyborg call collide
		} else if (otherObject instanceof NonPlayerCyborg) {
			gw.collide();
		//If object is a drone call gotten
		} else if (otherObject instanceof Drone) {
			gw.gotten();
		//If object is a energy station call energy
		} else if (otherObject instanceof EnergyStation) {
			gw.energy((EnergyStation) otherObject);
		}
	}
	
	
	
}
