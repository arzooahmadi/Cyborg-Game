package com.mycompany.a1;

public class EnergyStation extends Fixed{
	private int size;
	private int capacity;
	private int energyLevel;
	private int colorNum = 255;
	private String parentDesc;
	private String energyStation;
	private String myDesc;
	// green
	public EnergyStation() {
		setColor(0, 255, 0);
	}
	public int setSize(int i) {
		size = i;
		return size;
	}
	public int cyborgEnergy() {
		energyLevel = capacity;
		capacity = 0;
		colorNum = colorNum - 15;
		setColor(0, colorNum, 0);
		return energyLevel;
	}
	public int setCapacity() {
		capacity = size;
		return capacity;
	}
	public String toString() {
		parentDesc = super.toString();
		energyStation = "EnergyStation: ";
		myDesc = " size = " + size + " capacity = " + capacity;
        return energyStation + parentDesc + myDesc;
	}
}