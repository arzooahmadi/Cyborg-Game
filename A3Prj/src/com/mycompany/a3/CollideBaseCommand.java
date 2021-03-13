package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

public class CollideBaseCommand extends Command {
	
	private GameWorld gw;
	
	public CollideBaseCommand(GameWorld gameWorld) {
		//Label the button Collide with Base
		super("Collide With Base");
		gw = gameWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Create an OK command to close the dialog box
		Command cOk = new Command("Ok");
		//Create a CANCEL command to close the dialog box
		Command cCancel = new Command("Cancel");
		//Create a list of commands
		Command[] cmds = new Command[] {cOk, cCancel};
		//Create a text field
		TextField myTF = new TextField();
		//Create a command to show the dialog
		Command c = Dialog.show("Enter the Base Number:", myTF, cmds);
		if (c == cOk) {
			String baseNum = myTF.getText().toString();
			//Clear the text field
			myTF.clear();
			if(baseNum.length() != 0) {
				switch (baseNum.charAt(0)) {
					case '1':
						//Call the method one in GameWorld
						gw.one();
						break;
					case '2':
						//Call the method two in GameWorld
						gw.two();
						break;
					case '3':
						//Call the method three in GameWorld
						gw.three();
						break;
					case '4':
						//Call the method four in GameWorld
						gw.four();
						break;
					default:
						System.out.println("You have entered an invalid value.");
						break;
				}
			}
		}
		System.out.println("Collide with base command is invoked");
	}
}