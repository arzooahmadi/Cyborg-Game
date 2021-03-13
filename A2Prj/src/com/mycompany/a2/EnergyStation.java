package com.mycompany.a2;

public class EnergyStation extends Fixed {

	private int size;
	private int capacity;
	private int energyLevel;
	private int colorNum = 255;
	private String parentDesc;
	private String energyStation;
	private String myDesc;
	
	public EnergyStation() {
		//Setting the color to green
		setColor(0, 255, 0);
	}
	
	public int setSize(int i) {
		//Setting the size to i
		size = i;
		//Returning the size
		return size;
	}
	
	public int cyborgEnergy() {
		//Setting the energyLevel to capacity
		energyLevel = capacity;
		//Setting the capacity to 0
		capacity = 0;
		//Setting the colorNum to colorNum - 15
		colorNum = colorNum - 15;
		//Setting the color
		setColor(0, colorNum, 0);
		//Returning the energyLevel
		return energyLevel;
	}
	
	public int setCapacity() {
		//Setting the capacity to size
		capacity = size;
		//Returning the capacity
		return capacity;
	}
	
	public String toString() {
		//Creating strings
		parentDesc = super.toString();
		energyStation = "EnergyStation: ";
		myDesc = " size = " + size + " capacity = " + capacity;
		//Returning a combination of strings
        return energyStation + parentDesc + myDesc;
	}

}
