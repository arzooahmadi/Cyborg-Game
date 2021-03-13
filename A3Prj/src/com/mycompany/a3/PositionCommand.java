package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class PositionCommand extends Command {

	private GameWorld gw;
	private int x;
	private int y;
	
	public PositionCommand(GameWorld gameWorld) {
		//Label the button Position
		super("Position");
		gw = gameWorld;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		//Loop through the game objects
		for (int i = 0; i < gw.getObjects().size(); i++) {
			//Set shape equal to the game object located at i
			GameObject shape = gw.getObjects().get(i);
			//Check if the shape can be selected
			if (shape instanceof ISelectable) {
				while (MapView.getBoolean()) {
					//Set the count to 1
					MapView.setCount();
				}
				//Get the points
				x = MapView.pointX();
				y = MapView.pointY();
				//Set the location
				shape.setLocation(x + 750, y + 750);
			}
		}
		System.out.println("Position command is invoked");
	}
}
