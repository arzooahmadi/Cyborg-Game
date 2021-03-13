package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class ChangeStrategiesCommand extends Command {
	
	private GameWorld gw;
	private int count = 1;
	
	public ChangeStrategiesCommand(GameWorld gameWorld) {
		//Label the button Change Strategies
		super("Change Strategies");
		gw = gameWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if(count == 1) {
			//Increment the value of count by 1
			count++;
			//Call the change1 method in GameWorld
			gw.change1();
			System.out.println("Change strategies command is invoked");
		} else if (count == 2) {
			//Set the value of count equal to 1
			count = 1;
			//Call the change2 method in GameWorld
			gw.change2();
			System.out.println("Change strategies command is invoked");
		}
	}
	
}