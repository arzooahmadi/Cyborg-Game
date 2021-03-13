package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideDroneCommand extends Command {
	
	private GameWorld gw;
	
	public CollideDroneCommand(GameWorld gameWorld) {
		//Label the button Collide with Drone
		super("Collide with Drone");
		gw = gameWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Call the gotten method in GameWorld
		gw.gotten();
		System.out.println("Collide with drone command is invoked");
	}
	
}