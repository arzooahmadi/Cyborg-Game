package com.mycompany.a2;

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
	
	public String toString() {
		//Creating strings
		parentDesc = super.toString();
		drone = "Drone: ";
		myDesc = " heading = " + heading + " speed = " + speed + " size = " + size;
		//Returning the combination of strings
        return drone + parentDesc + myDesc ;
	}

}
