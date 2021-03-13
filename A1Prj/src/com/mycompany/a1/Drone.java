package com.mycompany.a1;

public class Drone extends Movable {
	
	private int size;
	private int heading;
	private int speed;
	private String parentDesc;
	private String drone;
	private String myDesc;
	
	public Drone() {
		setColor(255, 0, 255);
	}
	public int setSize(int i) {
		size = i;	
		return size;
	}
	public int setHeading(int i) {
		heading = i;
		return heading;
	}
	public int setSpeed(int i) {
		speed = i;
		return speed;		
	}
	public int heading() {
		heading = heading + 5;
		if (heading >= 359) {
			setHeading(0);
		}
		return heading;
	}
	public int speed() {
		return speed;
	}
	public String toString() {
		parentDesc = super.toString();
		drone = "Drone: ";
		myDesc = " heading = " + heading + " speed = " + speed + " size = " + size;
        return drone + parentDesc + myDesc ;
	}
}
