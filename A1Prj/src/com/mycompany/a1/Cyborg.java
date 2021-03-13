package com.mycompany.a1;

public class Cyborg extends Movable{
	
	private int size;
	private int heading;
	private int speed = 10;
	private int steeringDirection = 0;
	private int maximumSpeed = 50;
	private int energyLevel = 30;
	private int damageLevel = 0;
	private int lastBaseReached = 1;
	private int colorNum = 255;
	private String parentDesc;
	private String cyborg;
	private String myDesc;
	
	// red
	public Cyborg() {
		setColor(colorNum, 0, 0);
	}

	public int setSize(int i) {
		size = i;
		return size;		
	}
	
	public int setHeading(int i) {
		heading = heading + i;
		return heading;
	}
	
	public int setSteer(int i) {
		steeringDirection = steeringDirection + i;
		return steeringDirection;
	}
	
	public int setDamageLevel(int i) {
		damageLevel = i;
		return damageLevel;
	}
	
	public int cyborgDirectionLeft() {
		if (steeringDirection <= 0) {
			steeringDirection = steeringDirection + 360;
		}
		steeringDirection = steeringDirection - 5;
		return steeringDirection;

	}
	
	public int cyborgDirectionRight() {
		if (steeringDirection >= 360) {
			steeringDirection = steeringDirection - 360;
		}
		steeringDirection = steeringDirection + 5;
		return steeringDirection;

	}
	
	public int lastBaseReached(int i) {
		if ((i - lastBaseReached) == 1) {
			lastBaseReached++;
		}
		return lastBaseReached;
	}
	
	public int damageLevel() {
		if (damageLevel == 50) {
			speed = 0;
		}
		damageLevel = damageLevel + 10;
		maximumSpeed = maximumSpeed - 10;
		colorNum = colorNum - 15;
		setColor(colorNum, 0, 0);
		return damageLevel;
	}
	
	public int currentDamageLevel() {
		return damageLevel;
	}
	
	public int energyLevel() {
		return energyLevel;
	}
	
	public int decreaseEnergyLevel(int i) {
		if (energyLevel > 0) {
			energyLevel = energyLevel - i;
		}
		if (energyLevel == 0) {
			speed = 0;
		}
		return energyLevel;
	}
	
	public int maxSpeed() {
		return maximumSpeed;
	}
	
	public int heading() {
		heading = steeringDirection;
		return heading;
	}

	public int setSpeed(int i) {
		speed = i;
		return speed;
	}
	
	public int setEnergyLevel(int i) {
		energyLevel = 30;
		return energyLevel;
	}
	
	public int speed(int i) {
		if (speed > 0) {
			if (speed < 50) {
				speed = speed + i;
			}
		}
		if(speed <= 0) {
			speed = 0;
		}
		return speed;
	}
	
	public int energyConsumptionRate(int i) {
		if (energyLevel > 0) {
			energyLevel = energyLevel - i;
		}
		if (energyLevel == 0) {
			speed = 0;
		}
		return energyLevel;
	}
	
	public String toString() {
		parentDesc = super.toString();
		cyborg = "Cyborg: ";
		myDesc = " heading = " + heading + " speed = " + speed + " size = " + size + 
				 "	\n	maxSpeed = " + maximumSpeed + " steeringDirection = " + steeringDirection + 
				 " energyLevel = " + energyLevel + " damageLevel = " + damageLevel;
        return cyborg + parentDesc + myDesc ;
	}
}
