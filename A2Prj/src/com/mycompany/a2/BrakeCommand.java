package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class BrakeCommand extends Command {
	
	private GameWorld gw;
	
	public BrakeCommand(GameWorld gameWorld) {
		//Label the button Brake
		super("Brake");
		gw = gameWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Call the brake method in GameWorld
		gw.brake();
		System.out.println("Brake command is invoked");
	}
	
}
