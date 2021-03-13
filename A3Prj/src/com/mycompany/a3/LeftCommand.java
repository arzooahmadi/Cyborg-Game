package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class LeftCommand extends Command {
	
	private GameWorld gw;
	
	public LeftCommand(GameWorld gameWorld) {
		//Label the button Left
		super("Left");
		gw = gameWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Call the left method in GameWorld
		gw.left();
		System.out.println("Left command is invoked");
	}
	
}