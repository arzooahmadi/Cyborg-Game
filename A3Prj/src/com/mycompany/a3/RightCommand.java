package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class RightCommand extends Command {
	
	private GameWorld gw;
	
	public RightCommand(GameWorld gameWorld) {
		//Label the button Right
		super("Right");
		gw = gameWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Call the right method of GameWorld
		gw.right();
		System.out.println("Right command is invoked");
	}

}