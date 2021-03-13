package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideNPCCommand extends Command {
	
	private GameWorld gw;
	
	public CollideNPCCommand(GameWorld gameWorld) {
		//Label the button Collide with NPC
		super("Collide with NPC");
		gw = gameWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Call the collide method in GameWorld
		gw.collide();
		System.out.println("Collide with NPC command is invoked");
	}
	
}