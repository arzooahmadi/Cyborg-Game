package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PauseCommand extends Command {

	private GameWorld gw;
	private Game g;
	private int count = 0;
	
	public PauseCommand(GameWorld gameWorld, Game game) {
		//Label the button Pause
		super("Pause");
		gw = gameWorld;
		g = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (count == 0) {
			System.out.println("Pause command is invoked");
			//Call the pause method in Game
			g.pause();
			count = 1;
		} else {
			System.out.println("Play command is invoked");
			//Call the play method in Game
			g.play();
			count = 0;
		}
	}
	
}
