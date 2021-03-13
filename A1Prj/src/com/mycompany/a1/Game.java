package com.mycompany.a1;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form {
	
	private GameWorld gw;
	private boolean response = false;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}	
	private void play() {
		Label myLabel = new Label ("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				if(sCommand.length() != 0)
					switch (sCommand.charAt(0)) {
						case 'a':
							gw.accelerate();
							break;
						case 'b':
							gw.brake();
							break;
						case 'l':
							gw.left();
							break;
						case 'r':
							gw.right();
							break;
						case 'c':
							gw.collide();
							break;
						case '1':
							gw.one();
							break;
						case '2':
							gw.two();
							break;
						case '3':
							gw.three();
							break;
						case '4':
							gw.four();
							break;
						case 'e':
							gw.energy();
							break;
						case 'g':
							gw.gotten();
							break;
						case 't':
							gw.tick();
							break;
						case 'd':
							gw.display();
							break;
						case 'm':
							gw.map();
							break;
						case 'x':
							System.out.println("Would you like to quit (y/n)?");
							response = true;
							break;
						case 'y':
							if(response) {
								gw.exit();
							}
							break;
						case 'n':
							response = false;
							break;
						default:
							break;
					} // switch
			} // actionPerformed
		} // new ActionListener()
		); // addActionListener
		} //play
}