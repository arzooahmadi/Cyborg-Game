package com.mycompany.a2;

public class NonPlayerCyborg extends Cyborg {

	private int colorNum = 200;
	private String parentDesc;
	private String nonPlayerCyborg;
	private String strategy;
	private String change;
	private IStrategy curStrategy;

	public NonPlayerCyborg() {
		//Set the color of non player cyborg
		setColor(colorNum, 0, 0);
	}
	
	public void setStrategy(IStrategy s) {
		//Set the curStrategy equal to s
		curStrategy = s;
	}
	
	public void invokeStrategy() {
		//Call the apply method
		curStrategy.apply();
	}
	
	public void saveMoveStrategy() {
		//Set change equal to Move
		change = "Move";
	}
	
	public void saveHeadingStrategy() {
		//Set change equal to Heading
		change = "Heading";
	}
	
	public String toString() {
		//Create strings
		parentDesc = super.toString();
		nonPlayerCyborg = "Non Player ";
		strategy = " Strategy: " + change;
		//Return combination of strings
		return nonPlayerCyborg + parentDesc + strategy;
	}
	
}




