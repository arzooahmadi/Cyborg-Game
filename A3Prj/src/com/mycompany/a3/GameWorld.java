package com.mycompany.a3;

import java.util.Observable;
import java.util.Random;

public class GameWorld extends Observable {

	private int numLives = 3;
	private int tick = 0;
	private int elapsedTime = 20;
	private int heading;
	private int count = 1;
	private boolean sound = false;
	private boolean play = true;
	private Random rand = new Random();
	private Base base1 = new Base();
	private Base base2 = new Base();
	private Base base3 = new Base();
	private Base base4 = new Base();
	private Base base = base1;
	private Cyborg cyborg = PlayerCyborg.getCyborg();
	private Drone drone1 = new Drone();
	private Drone drone2 = new Drone();
	private EnergyStation energyStation1 = new EnergyStation();
	private EnergyStation energyStation2 = new EnergyStation();
	private NonPlayerCyborg nonPlayerCyborg1 = new NonPlayerCyborg();
	private NonPlayerCyborg nonPlayerCyborg2 = new NonPlayerCyborg();
	private NonPlayerCyborg nonPlayerCyborg3 = new NonPlayerCyborg();
	private GameObjectCollection objects = new GameObjectCollection();	
	private Sound crash = new Sound("crash.wav");
	private Sound charge = new Sound("energy.wav");
	private Sound dying = new Sound("explosion.wav");
	private BGSound background = new BGSound("background.mp3");
	
	public void init() {
				
		//Setting base1
		base1.setLocation(500, 500);
		base1.setSize(50);
		base1.setSequenceNumber(1);
		
		//Setting base2
		base2.setLocation(300, 300);
		base2.setSize(50);
		base2.setSequenceNumber(2);
		
		//Setting base3
		base3.setLocation(900, 1000);
		base3.setSize(50);
		base3.setSequenceNumber(3);
		
		//Setting base4
		base4.setLocation(1200, 600);
		base4.setSize(50);
		base4.setSequenceNumber(4);
		
		//Setting cyborg
		cyborg.setLocation(500, 500);
		cyborg.setSize(40);
		cyborg.setHeading(0);
		cyborg.setSteer(0);
		
		//Setting drone1
		drone1.setLocation(rand.nextInt(1000), rand.nextInt(1000));
		drone1.setSize(25);
		drone1.setHeading(rand.nextInt(359));
		drone1.setSpeed((rand.nextInt(49) + 1));
		
		//Setting drone2
		drone2.setLocation(rand.nextInt(1000), rand.nextInt(1000));
		drone2.setSize(20);
		drone2.setHeading(rand.nextInt(359));
		drone2.setSpeed((rand.nextInt(49) + 1));
		
		//Setting energyStation1
		energyStation1.setLocation(rand.nextInt(1000), rand.nextInt(1000));
		energyStation1.setSize((rand.nextInt(49) + 1));
		energyStation1.setCapacity();
		energyStation1.setNumber(1);
		
		//Setting energyStation2
		energyStation2.setLocation(rand.nextInt(1000), rand.nextInt(1000));
		energyStation2.setSize((rand.nextInt(49) + 1));
		energyStation2.setCapacity();
		energyStation2.setNumber(2);
		
		//Setting nonPlayerCyborg1
		nonPlayerCyborg1.setLocation(300, 300);
		nonPlayerCyborg1.setSize(40);
		nonPlayerCyborg1.setHeading(0);
		nonPlayerCyborg1.setSteer(0);
		nonPlayerCyborg1.setSpeed(20);
		nonPlayerCyborg1.setStrategy(new HeadingStrategy(nonPlayerCyborg1, cyborg));
		nonPlayerCyborg1.saveHeadingStrategy();
		
		//Setting nonPlayerCyborg2
		nonPlayerCyborg2.setLocation(600, 600);
		nonPlayerCyborg2.setSize(40);
		nonPlayerCyborg2.setHeading(0);
		nonPlayerCyborg2.setSteer(0);
		nonPlayerCyborg2.setSpeed(20);
		nonPlayerCyborg2.setStrategy(new MoveStrategy(nonPlayerCyborg2, base));
		nonPlayerCyborg2.saveMoveStrategy();
		
		//Setting nonPlayerCyborg3
		nonPlayerCyborg3.setLocation(700, 700);
		nonPlayerCyborg3.setSize(40);
		nonPlayerCyborg3.setHeading(0);
		nonPlayerCyborg3.setSteer(0);
		nonPlayerCyborg3.setSpeed(20);
		nonPlayerCyborg3.setStrategy(new HeadingStrategy(nonPlayerCyborg3, cyborg));
		nonPlayerCyborg3.saveHeadingStrategy();
		
		//Adding the objects
		objects.add(base1);
		objects.add(base2);
		objects.add(base3);
		objects.add(base4);
		objects.add(cyborg);
		objects.add(drone1);
		objects.add(drone2);
		objects.add(energyStation1);
		objects.add(energyStation2);
		objects.add(nonPlayerCyborg1);
		objects.add(nonPlayerCyborg2);
		objects.add(nonPlayerCyborg3);
		
		setChanged();
		notifyObservers();
		
	}
	
	public void newCyborg() {
		//Remove cyborg
		objects.remove(cyborg);
		//Add cyborg
		objects.add(cyborg);
		//Set cyborg
		cyborg.setSpeed(10);
		cyborg.setDamageLevel(0);
		cyborg.setEnergyLevel(30);
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public Base getBase() {
		//Get base
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i) instanceof Base) {
				return (Base) objects.get(i);
			}
		}
		//Update ScoreView
		setChanged();
		notifyObservers();
		return null;
	}
	
	public Cyborg getCyborg() {
		//Get Cyborg
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i) instanceof Cyborg) {
				return (Cyborg) objects.get(i);
			}
		}
		//Update ScoreView
		setChanged();
		notifyObservers();
		return null;
	}
	
	public Drone getDrone() {
		//Get Drone
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i) instanceof Drone) {
				return (Drone) objects.get(i);
			}
		}
		//Update ScoreView
		setChanged();
		notifyObservers();
		return null;
	}
	
	public EnergyStation getEnergyStation() {
		//Get Energy Station
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i) instanceof EnergyStation) {
				return (EnergyStation) objects.get(i);
			}
		}
		//Update ScoreView
		setChanged();
		notifyObservers();
		return null;
	}
	
	public int lives() {
		if(cyborg.speed(0) == 0 | cyborg.energyLevel() == 0) {
			//Decrease number of lives
			numLives = numLives - 1;
			System.out.println("You lost a life.");
			//Check if sound is on
			if (sound) {
				dying.play();
			}
			newCyborg();
		}
		if (numLives < 0) {
			System.out.println("No more lives left. Game Over!");
			//Call exit method
			exit();
		}
		//Update ScoreView
		setChanged();
		notifyObservers();
		return numLives;
	}
	
	public void accelerate() {
		//Set cyborg speed
		cyborg.speed(5);
		//Decrease energy of cyborg
		cyborg.decreaseEnergyLevel(1);
		//Check lives
		lives();
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void brake() {
		//Decrease cyborg speed
		cyborg.speed(-5);	
		//Check lives
		lives();
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void left() {
		//Set cyborg direction
		cyborg.cyborgDirectionLeft();	
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void right() {
		//Set cyborg direction
		cyborg.cyborgDirectionRight();
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void collide() {
		//Check if sound is on
		if (sound) {
			crash.play();
		}
		System.out.println("You have collided with a non-player cyborg");
		//Set cyborg damage
		cyborg.playerDamageLevel();
		if (count == 1) {
			//Set nonPlayerCyborg1 damage level
			nonPlayerCyborg1.nonPlayerDamageLevel();
			//Increment count
			count++;
		} else if (count == 2) {
			//Set nonPlayerCyborg2 damage level
			nonPlayerCyborg2.nonPlayerDamageLevel();
			//Increment count
			count++;
		} else if (count == 3) {
			//Set nonPlayerCyborg3 damage level
			nonPlayerCyborg3.nonPlayerDamageLevel();
			//Set count to 1
			count = 1;
		}
		//Check lives
		lives();
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void baseCollision(Base base) {
		//Get the sequence number of the base
		int baseNum = base.getSequenceNumber();
		System.out.println("You have collided with base " + baseNum);
		//Set last base reached to baseNum
		Cyborg.lastBaseReached(baseNum);
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void one() {
		System.out.println("You have collided with base 1");
		//Set last base reached to 1
		Cyborg.lastBaseReached(1);
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	public void two() {
		System.out.println("You have collided with base 2");
		//Set last base reached to 2
		Cyborg.lastBaseReached(2);
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void three() {
		System.out.println("You have collided with base 3");
		//Set last base reached to 3
		Cyborg.lastBaseReached(3);
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void four() {
		System.out.println("You have collided with base 4");
		//Set last base reached to 4
		Cyborg.lastBaseReached(4);
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void energy() {
		//Set whichEnergy to a random number
		int whichEnergy = rand.nextInt(1) + 1;
		if (whichEnergy == 1) {
			//Set energy of energy station
			energyStation1.cyborgEnergy();
			//Remove Energy Station
			objects.remove(energyStation1);
			//Add Energy Station
			objects.add(energyStation1);
			//Set Energy Station
			energyStation1.setLocation(rand.nextInt(1000), rand.nextInt(1000));
			energyStation1.setSize((rand.nextInt(50) + 1));
			energyStation1.setCapacity();
		}
		if (whichEnergy == 2) {
			//Set energy of energy station
			energyStation2.cyborgEnergy();
			//Remove energy station
			objects.remove(energyStation2);
			//Add energy station
			objects.add(energyStation2);
			//Set energy station
			energyStation2.setLocation(rand.nextInt(1000), rand.nextInt(1000));
			energyStation2.setSize((rand.nextInt(50) + 1));
			energyStation2.setCapacity();
		}
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void energy(EnergyStation energy) {
		//Check if sound is on
		if (sound) {
			charge.play();
		}
		System.out.println("You have collided with an energy station");
		int whichEnergy = energy.getNumber();
		if (whichEnergy == 1) {
			//Set energy of energy station
			energyStation1.cyborgEnergy();
			//Remove Energy Station
			objects.remove(energyStation1);
			//Add Energy Station
			objects.add(energyStation1);
			//Set Energy Station
			energyStation1.setLocation(rand.nextInt(1000), rand.nextInt(1000));
			energyStation1.setSize((rand.nextInt(50) + 1));
			energyStation1.setCapacity();
			energyStation1.setNumber(1);
		}
		if (whichEnergy == 2) {
			//Set energy of energy station
			energyStation2.cyborgEnergy();
			//Remove energy station
			objects.remove(energyStation2);
			//Add energy station
			objects.add(energyStation2);
			//Set energy station
			energyStation2.setLocation(rand.nextInt(1000), rand.nextInt(1000));
			energyStation2.setSize((rand.nextInt(50) + 1));
			energyStation2.setCapacity();
			energyStation2.setNumber(2);
		}
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void exit() {
		//Exit
		System.exit(0);	
	}
	
	public void map() {
		for(int i = 0; i < objects.size(); i++)	{
			//Get the object located at i
			System.out.println(objects.get(i));
		}
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void gotten() {
		System.out.println("You and a drone have gotten to the same area");
		//Set cyborg damage
		cyborg.playerDamageLevel();
		//Check lives
		lives();
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void tick() {
		//Increment tick
		tick++;
		//Check lives
		lives();
		//Set cyborg location
		cyborg.cyborgMove(cyborg.heading(), cyborg.speed(0), elapsedTime);
		heading = drone1.droneMove(drone1.heading(), drone1.speed(), elapsedTime);
		heading = drone2.droneMove(drone2.heading(), drone2.speed(), elapsedTime);
		//Decrease energy
		cyborg.energyConsumptionRate(1);
		//Invoke the strategy for all non player cyborgs
		nonPlayerCyborg1.invokeStrategy();
		nonPlayerCyborg2.invokeStrategy();
		nonPlayerCyborg3.invokeStrategy();
		//Check if moving caused any collisions
		IIterator iter = getObjects().getIterator();
		while(iter.hasNext()) {
			ICollider curObj = (ICollider) iter.getNext();
			IIterator iter2 = getObjects().getIterator();
			while(iter2.hasNext()){
				GameObject otherObj = iter2.getNext();
				if(otherObj != curObj){
					if(curObj.collidesWith(otherObj)){
						curObj.handleCollision(otherObj, this);
					}
				}
			}
		}
		//Update ScoreView
		setChanged();
		notifyObservers();
		
	}
	

	public void display() {
		//Print number of lives left
		System.out.println("Number of Lives Left: " + numLives);
		//Print clock value
		System.out.println("Clock Value: " + tick);
		//Print last base reached of cyborg
		System.out.println("Base Number: " + cyborg.lastBaseReached(1));
		//Print cyborg energy level
		System.out.println("Cyborg Energy Level: " + cyborg.energyLevel());
		//Print cyborg damage level
		System.out.println("Cyborg Damage Level: " + cyborg.currentDamageLevel());
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void sound() {
		if(sound) {
			//Set sound to false
			sound = false;
			background.pause();
		} else {
			//Set sound to true
			sound = true;
		}
		if (play == true && sound == true) {
			//Play the background music
			background.play();
		}
		
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public boolean getSound() {
		//Return sound
		return sound;
	}
	
	public int getTime() {
		//Return tick
		return tick;
	}

	public int getLives() {
		//Return numLives
		return numLives;
	}

	public int getBaseNum() {
		//Return last base reached of cyborg
		return Cyborg.lastBaseReached(1);
	}

	public int getEnergy() {
		//Return cyborg energy level
		return cyborg.energyLevel();
	}

	public int getDamage() {
		//Return cyborg damage level
		return cyborg.currentDamageLevel();
	}

	public void change1() {
		//Call whichBase method
		whichBase();
		//Set nonPlayerCyborg1 to Move Strategy
		nonPlayerCyborg1.setStrategy(new MoveStrategy(nonPlayerCyborg1, base));
		//Save Move Strategy
		nonPlayerCyborg1.saveMoveStrategy();
		//Set nonPlayerCyborg2 to Heading Strategy
		nonPlayerCyborg2.setStrategy(new HeadingStrategy(nonPlayerCyborg2, cyborg));
		//Save Heading Strategy
		nonPlayerCyborg2.saveHeadingStrategy();
		//Set nonPlayerCyborg3 to Move Strategy
		nonPlayerCyborg3.setStrategy(new MoveStrategy(nonPlayerCyborg3, base));
		//Save Move Strategy
		nonPlayerCyborg3.saveMoveStrategy();
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void change2() {
		//Call whichBase method
		whichBase();
		//Set nonPlayerCyborg1 to Heading Strategy
		nonPlayerCyborg1.setStrategy(new HeadingStrategy(nonPlayerCyborg1, cyborg));
		//Save Heading Strategy
		nonPlayerCyborg1.saveHeadingStrategy();
		//Set nonPlayerCyborg2 to Move Strategy
		nonPlayerCyborg2.setStrategy(new MoveStrategy(nonPlayerCyborg2, base));
		//Save Move Strategy
		nonPlayerCyborg2.saveMoveStrategy();
		//Set nonPlayerCyborg3 to Heading Strategy
		nonPlayerCyborg3.setStrategy(new HeadingStrategy(nonPlayerCyborg3, cyborg));
		//Save Heading Strategy
		nonPlayerCyborg3.saveHeadingStrategy();
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public void whichBase() {
		if(MoveStrategy.getNextBase() == 0) {
			//Set base equal to base1
			base = base1;
		} else if(MoveStrategy.getNextBase() == 1) {
			//Set base equal to base2
			base = base2;
		} else if(MoveStrategy.getNextBase() == 2) {
			//Set base equal to base3
			base = base3;
		} else {
			//Set base equal to base4
			base = base4;
			//A non player cyborg wins
			System.out.println("Game over, a non-player cyborg wins!");
			//Exit
			exit();
		}
		//Update ScoreView
		setChanged();
		notifyObservers();
	}
	
	public GameObjectCollection getObjects() {
		return objects;
	}

	public void createSounds() {
		Sound crash = new Sound("crash.wav");
		Sound charge = new Sound("energy.wav");
		Sound dying = new Sound("explosion.wav");
		BGSound background = new BGSound("background.mp3");
	}
	
	public void pause() {
		//Set play to false
		play = false;
		if (sound) {
			//Pause the background music
			background.pause();
		}
	}
	
	public void play() {
		//Set play to true
		play = true;
		//Play the background music
		background.play();
	}
}
