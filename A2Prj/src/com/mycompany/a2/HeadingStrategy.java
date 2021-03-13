package com.mycompany.a2;

public class HeadingStrategy implements IStrategy {

	private NonPlayerCyborg nonPlayerCyborg;
	private Cyborg cyborg;
	private int heading;
	private int speed;
	
	public HeadingStrategy(NonPlayerCyborg npc, Cyborg c) {
		//Set nonPlayerCyborg equal to npc
		nonPlayerCyborg = npc;
		//Set cyborg equal to c
		cyborg = c;
	}
	
	public void apply() {
		//Set heading equal to cyborg heading
		heading = cyborg.heading();
		//Set speed equal to nonPlayerCyborg speed
		speed = nonPlayerCyborg.getSpeed();
		//Set nonPlayerCyborg heading
		nonPlayerCyborg.setHeading(heading);
		//Move the cyborg
		nonPlayerCyborg.cyborgMove(heading, speed);
	}

}
