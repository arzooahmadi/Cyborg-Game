package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AccelerateCommand extends Command {
	
	private GameWorld gw;

	public AccelerateCommand(GameWorld gameWorld) {
		//Label the button Accelerate
		super("Accelerate");
		gw = gameWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Call the accelerate method in GameWorld
		gw.accelerate();
		System.out.println("Accelerate command is invoked");
	}
	
}
