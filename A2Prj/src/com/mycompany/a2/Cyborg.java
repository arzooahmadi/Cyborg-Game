package com.mycompany.a2;

public abstract class Cyborg extends Movable {
	
	private int size;
	private int heading;
	private int speed = 10;
	private int steeringDirection = 0;
	private int maximumSpeed = 50;
	private int energyLevel = 30;
	private int damageLevel = 0;
	private static int lastBaseReached = 1;
	private int colorNum = 255;
	private String parentDesc;
	private String cyborg;
	private String myDesc;
	
	public Cyborg() {
		//Setting the color of cyborg to red
		setColor(colorNum, 0, 0);

	}

	public int setSize(int i) {
		//Setting the size to i
		size = i;
		//Returning the size
		return size;		
	}
	
	public int setHeading(int i) {
		//Setting the heading to heading + i
		heading = heading + i;
		//Returning the heading
		return heading;
	}
	
	public int setSteer(int i) {
		//Setting the steeringDirection to steeringDirection + i
		steeringDirection = steeringDirection + i;
		//Returning the steeringDirection
		return steeringDirection;
	}
	
	public int setDamageLevel(int i) {
		//Setting the damageLevel to i
		damageLevel = i;
		//Returning the damageLevel
		return damageLevel;
	}
	
	public int cyborgDirectionLeft() {
		//Changing the steeringDirection
		if (steeringDirection <= 0) {
			steeringDirection = steeringDirection + 360;
		}
		steeringDirection = steeringDirection - 5;
		//Returning the steeringDirection
		return steeringDirection;

	}
	
	public int cyborgDirectionRight() {
		//Changing the steeringDirection
		if (steeringDirection >= 360) {
			steeringDirection = steeringDirection - 360;
		}
		steeringDirection = steeringDirection + 5;
		//Returning the steeringDirection
		return steeringDirection;

	}
	
	public static int lastBaseReached(int i) {
		//Changing the lastBaseReached
		if ((i - lastBaseReached) == 1) {
			lastBaseReached++;
		}
		//Returning the lastBaseReached
		return lastBaseReached;
	}
	
	public int playerDamageLevel() {
		if (damageLevel == 50) {
			//Changing the speed
			speed = 0;
		}
		//Changing the damageLevel
		damageLevel = damageLevel + 10;
		//Changing the maximumSpeed
		maximumSpeed = maximumSpeed - 10;
		//Changing the colorNum
		colorNum = colorNum - 15;
		//Setting the color
		setColor(colorNum, 0, 0);
		//Returning the damageLevel
		return damageLevel;
	}
	
	public int nonPlayerDamageLevel() {
		if (damageLevel == 80) {
			//Setting the speed to 0
			speed = 0;
		}
		//Setting the damageLevel to damageLevel + 10
		damageLevel = damageLevel + 10;
		//Returning the damageLevel
		return damageLevel;
	}
	
	public int currentDamageLevel() {
		//Returning the damageLevel
		return damageLevel;
	}
	
	public int energyLevel() {
		//Returning the energyLevel
		return energyLevel;
	}
	
	public int decreaseEnergyLevel(int i) {
		if (energyLevel > 0) {
			//Setting the energyLevel to energyLevel - i
			energyLevel = energyLevel - i;
		}
		if (energyLevel == 0) {
			//Setting the speed to 0
			speed = 0;
		}
		//Returning the energyLevel
		return energyLevel;
	}
	
	public int maxSpeed() {
		//Returning the maximumSpeed
		return maximumSpeed;
	}
	
	public int heading() {
		//Setting the heading to the steeringDirection
		heading = steeringDirection;
		//Returning the heading
		return heading;
	}

	public int setSpeed(int i) {
		//Setting the speed to i
		speed = i;
		//Returning the speed
		return speed;
	}
	
	public int setEnergyLevel(int i) {
		//Setting the energyLevel to 30
		energyLevel = 30;
		//Returning the energyLevel
		return energyLevel;
	}
	
	public int speed(int i) {
		if (speed > 0) {
			if (speed < 50) {
				//Setting the speed to speed + i
				speed = speed + i;
			}
		}
		if(speed <= 0) {
			//Setting the speed to 0
			speed = 0;
		}
		//Returning the speed
		return speed;
	}
	
	public int getSpeed() {
		//Returning the speed
		return speed;
	}
	
	public int energyConsumptionRate(int i) {
		if (energyLevel > 0) {
			//Setting the energyLevel to energyLevel - i
			energyLevel = energyLevel - i;
		}
		if (energyLevel == 0) {
			//Setting the speed to 0
			speed = 0;
		}
		//Returning the energyLevel
		return energyLevel;
	}
	
	public String toString() {
		//Setting the strings
		parentDesc = super.toString();
		cyborg = "Cyborg: ";
		myDesc = " heading = " + heading + " speed = " + speed + " size = " + size + 
				 "	\n	maxSpeed = " + maximumSpeed + " steeringDirection = " + steeringDirection + 
				 " energyLevel = " + energyLevel + " damageLevel = " + damageLevel;
		//Returning the combination of strings
        return cyborg + parentDesc + myDesc ;
	}
	
}
