package com.mycompany.a1;

import java.util.ArrayList;
import java.util.Random;

public class GameWorld {
	private ArrayList <GameObject> objects = new ArrayList<GameObject>();
	private int numLives = 3;
	private int tick = 0;
	private int heading;
	private Random rand = new Random();
	private Base base1 = new Base();
	private Base base2 = new Base();
	private Base base3 = new Base();
	private Base base4 = new Base();
	private Cyborg cyborg = new Cyborg();
	private Drone drone1 = new Drone();
	private Drone drone2 = new Drone();
	private EnergyStation energyStation1 = new EnergyStation();
	private EnergyStation energyStation2 = new EnergyStation();
	public void init() {
		base1.setLocation(200, 200);
		base2.setLocation(200, 800);
		base3.setLocation(700, 800);
		base4.setLocation(900, 400);
		cyborg.setLocation(200, 200);
		drone1.setLocation(rand.nextInt(1000), rand.nextInt(1000));
		drone2.setLocation(rand.nextInt(1000), rand.nextInt(1000));
		energyStation1.setSize((rand.nextInt(49) + 1));

		energyStation1.setLocation(rand.nextInt(1000), rand.nextInt(1000));
		energyStation1.setCapacity();

		energyStation2.setLocation(rand.nextInt(1000), rand.nextInt(1000));
		energyStation2.setSize((rand.nextInt(49) + 1));

		energyStation2.setCapacity();


		base1.setSize(10);
		base2.setSize(10);
		base3.setSize(10);
		base4.setSize(10);
		cyborg.setSize(40);
		drone1.setSize(25);
		drone2.setSize(20);

		base1.setSequenceNumber(1);
		base2.setSequenceNumber(2);
		base3.setSequenceNumber(3);
		base4.setSequenceNumber(4);
		
		cyborg.setHeading(0);
		drone1.setHeading(rand.nextInt(359));
		drone1.setSpeed((rand.nextInt(49) + 1));
		drone2.setHeading(rand.nextInt(359));
		drone2.setSpeed((rand.nextInt(49) + 1));
		
		cyborg.setSteer(0);
		
		objects.add(base1);
		objects.add(base2);
		objects.add(base3);
		objects.add(base4);
		objects.add(cyborg);
		objects.add(drone1);
		objects.add(drone2);
		objects.add(energyStation1);
		objects.add(energyStation2);
	}
	public void newCyborg() {
		objects.remove(cyborg);
		objects.add(cyborg);
		cyborg.setSpeed(10);
		cyborg.setDamageLevel(0);
		cyborg.setEnergyLevel(30);
	}
	
	public Base getBase() {
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i) instanceof Base) {
				return (Base) objects.get(i);
			}
		}
		return null;
	}
	public Cyborg getCyborg() {
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i) instanceof Cyborg) {
				return (Cyborg) objects.get(i);
			}
		}
		return null;
	}
	public Drone getDrone() {
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i) instanceof Drone) {
				return (Drone) objects.get(i);
			}
		}
		return null;
	}
	public EnergyStation getEnergyStation() {
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i) instanceof EnergyStation) {
				return (EnergyStation) objects.get(i);
			}
		}
		return null;
	}
	public int lives() {
		if(cyborg.speed(0) == 0 | cyborg.energyLevel() == 0) {
			numLives = numLives - 1;
			System.out.println("You lost a life.");
			newCyborg();
		}
		if (numLives <= 0) {
			System.out.println("No more lives left. Game Over!");
		}
		return numLives;
	}
	public void accelerate() {
		cyborg.speed(5);
		cyborg.decreaseEnergyLevel(1);
		lives();
	}
	public void brake() {
		cyborg.speed(-5);	
		lives();
	}
	public void left() {
		cyborg.cyborgDirectionLeft();		
	}
	public void right() {
		cyborg.cyborgDirectionRight();
	}
	public void collide() {
		System.out.println("You have collided with another cyborg.");
		cyborg.damageLevel();
		lives();
	}
	public void one() {
		System.out.println("You have collided with base 1.");
		cyborg.lastBaseReached(1);
	}
	public void two() {
		System.out.println("You have collided with base 2.");
		cyborg.lastBaseReached(2);
	}
	public void three() {
		System.out.println("You have collided with base 3.");
		cyborg.lastBaseReached(3);
	}
	public void four() {
		System.out.println("You have collided with base 4.");
		cyborg.lastBaseReached(4);
	}
	public void energy() {
		System.out.println("You have collided with an energy station.");
		int whichEnergy = rand.nextInt(1) + 1;
		if (whichEnergy == 1) {
			energyStation1.cyborgEnergy();
			objects.remove(energyStation1);
			objects.add(energyStation1);
			energyStation1.setLocation(rand.nextInt(1000), rand.nextInt(1000));
			energyStation1.setSize((rand.nextInt(50) + 1));
			energyStation1.setCapacity();
		}
		if (whichEnergy == 2) {
			energyStation2.cyborgEnergy();
			objects.remove(energyStation2);
			objects.add(energyStation2);
			energyStation2.setLocation(rand.nextInt(1000), rand.nextInt(1000));
			energyStation2.setSize((rand.nextInt(50) + 1));
			energyStation2.setCapacity();
		}
	}
	public void exit() {
		System.exit(0);	
	}
	public void map() {
		for(int i = 0; i < objects.size(); i++)	{
			System.out.println(objects.get(i));
		}
	}
	public void gotten() {
		System.out.println("You and a drone have gotten to the same location.");
		cyborg.damageLevel();
	}
	public void tick() {
		tick++;
		lives();
		cyborg.cyborgMove(cyborg.heading(), cyborg.speed(0));
		heading = drone1.droneMove(drone1.heading(), drone1.speed());
		heading = drone2.droneMove(drone2.heading(), drone2.speed());
		cyborg.energyConsumptionRate(5);
	}

	public void display() {
		System.out.println("Number of Lives Left: " + numLives);
		System.out.println("Clock Value: " + tick);
		System.out.println("Base Number: " + cyborg.lastBaseReached(1));
		System.out.println("Cyborg Energy Level: " + cyborg.energyLevel());
		System.out.println("Cyborg Damage Level: " + cyborg.currentDamageLevel());

	}


}