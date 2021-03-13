package com.mycompany.a2;

public class PlayerCyborg extends Cyborg {

	private static PlayerCyborg singleCyborg;
	
	private PlayerCyborg() { 
		
	}
	
	public static Cyborg getCyborg() {
		if (singleCyborg == null) {
			//Set singleCyborg equal to new PlayerCyborg
			singleCyborg =  new PlayerCyborg();
		}
		//return singleCyborg
		return singleCyborg;
	}

}
