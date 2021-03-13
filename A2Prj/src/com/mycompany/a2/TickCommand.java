package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TickCommand extends Command {
	
	private GameWorld gw;
	
	public TickCommand(GameWorld gameWorld) {
		//Label the button Tick
		super("Tick");
		gw = gameWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Call the tick method of GameWorld
		gw.tick();
		//Call the map method of GameWorld
		gw.map();
		System.out.println("Tick command is invoked");
	}

}