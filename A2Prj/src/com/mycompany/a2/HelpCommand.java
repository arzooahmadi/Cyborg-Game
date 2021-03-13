package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class HelpCommand extends Command {
	
	public HelpCommand() {
		//Label the Button Help
		super("Help");
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Help command is invoked");
		//Create an OK command to close the dialog box
		Command cOk = new Command("Ok");
		//Create string help
		String help = ("Press a to accelerate.\n"
						 + "Press b to brake.\n"
						 + "Press l to turn left.\n"
						 + "Press r to turn right.\n"
						 + "Press e to collide with an energy station.\n"
						 + "Press g to collide with a drone.\n"
						 + "Press t to invoke a tick.\n"
						 + "Press x to exit.");
		//Create Command c
		Command c = Dialog.show("Help", help, cOk);
	}

}