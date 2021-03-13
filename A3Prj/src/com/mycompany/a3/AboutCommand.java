package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {
		
	public AboutCommand() {
		//Label the button About
		super("About");
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Create an OK command to close the dialog box
		Command cOk = new Command("Ok");
		String about = ("Arzoo Ahmadi\n"
					  + "CSC 133 - 06\n"
					  + "Assignment 2");
		Command c = Dialog.show("About", about, cOk);
		System.out.println("About command is invoked");
	}
	
}