package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command {
	
	public ExitCommand() {
		//Label the button Exit
		super("Exit");
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Creating a boolean
		Boolean bOk = Dialog.show("Confirm Quit", "Are you sure you want to quit?", "Ok", "Cancel");
		if (bOk) {
			Display.getInstance().exitApplication();
		}
		System.out.println("Exit command is invoked");
	}
	
}