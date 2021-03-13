package com.mycompany.a2;

import com.codename1.util.MathUtil;

public class MoveStrategy extends GameObject implements IStrategy {

	private NonPlayerCyborg nonPlayerCyborg;
	private Base base;
	private double x0;
	private double y0;
	private double x1;
	private double y1;
	private double a;
	private double b;
	private double angle;
	private static int nextBase = 0;
	
	public MoveStrategy(NonPlayerCyborg npc, Base b) {
		//Set nonPlayerCyborg equal to npc
		nonPlayerCyborg = npc;
		//Set base equal to b
		base = b;

	}
	
	public void apply() {
		//Set x0 equal to the X value of getLocation for nonPlayerCyborg
		x0 = nonPlayerCyborg.getLocation().getX();
		//Set y0 equal to the Y value of getLocation for nonPlayerCyborg
		y0 = nonPlayerCyborg.getLocation().getY();
		//Set x1 equal to the X value of getLocation for base
		x1 = base.getLocation().getX();
		//Set y1 equal to the Y value of getLocation for base
		y1 = base.getLocation().getY();
		//Set a equal to x0 - x1
		a = x0 - x1;
		//Set b equal to y0 - y1
		b = y0 - y1;
		//Set angle equal to atan(b/a)
		angle = MathUtil.atan(b/a);
		//Set angle to degrees
		angle = Math.toDegrees(angle);
		//Move the non player cyborg
		nonPlayerCyborg.nonPlayerCyborgMove(angle, nonPlayerCyborg.speed(0), x0, y0);
		if(x0 == x1 && y0 == y1) {
			//Increment nextBase
			nextBase++;
		}
	}
	
	public static int getNextBase() {
		//return nextBase
		return nextBase;
	}

}
