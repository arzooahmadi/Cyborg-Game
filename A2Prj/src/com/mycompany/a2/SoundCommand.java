package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class SoundCommand extends Command {
	
	private GameWorld gw;
	
	public SoundCommand(GameWorld gameWorld) {
		//Label the button Sound
		super("Sound");
		gw = gameWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Call the sound method of GameWorld
		gw.sound();
		System.out.println("Sound command is invoked");
	}

}