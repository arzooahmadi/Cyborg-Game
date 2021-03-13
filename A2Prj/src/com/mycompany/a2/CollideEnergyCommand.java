package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideEnergyCommand extends Command {
	
	private GameWorld gw;
	
	public CollideEnergyCommand(GameWorld gameWorld) {
		//Label the button Collide with Energy Station
		super("Collide with Energy Station");
		gw = gameWorld;
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Call the energy method in GameWorld
		gw.energy();
		System.out.println("Collide with energy station command is invoked");
	}

}