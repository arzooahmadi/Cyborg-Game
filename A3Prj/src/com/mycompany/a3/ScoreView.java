package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

public class ScoreView extends Container implements Observer {

	private Label time;
	private Label livesLeft;
	private Label lastBase;
	private Label energyLevel;
	private Label damageLevel;
	private Label sound;
	private GameWorld gw;
	
	public ScoreView(GameWorld gameWorld) {
		
		gw = gameWorld;
		
		//Set the layout to FlowLayout
		//Set the component to center
		setLayout(new FlowLayout(Component.CENTER));
		
		//Set time equal to new label
		time = new Label("Time: 000");
		//Set style of time
		time.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		//Set livesLeft equal to new label
		livesLeft = new Label("Lives Left: 3");
		//Set the style of livesLeft 
		livesLeft.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		//Set lastBase equal to new label
		lastBase = new Label("Player Last Base Reached: 1");
		//Set the style of lastBase
		lastBase.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		//Set energyLevel equal to new label
		energyLevel = new Label("Player Energy Level: 30");
		//Set the style of energyLevel
		energyLevel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		//Set damageLevel equal to new label
		damageLevel = new Label("Player Damage Level: 00");
		//Set the style of damageLevel
		damageLevel.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		//Set sound equal to new label
		sound = new Label("Sound: OFF");
		//Set the style of sound
		sound.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		//Add to ScoreView
		//Will be in flow layout
		add(time);
		add(livesLeft);
		add(lastBase);
		add(energyLevel);
		add(damageLevel);
		add(sound);
	}

	public void update(Observable o, Object arg) {
		//Set the text of time
		time.setText("Time: " + gw.getTime());
		//Set the text of lives left
		livesLeft.setText("Lives Left: " + gw.getLives());
		//Set the text of lastBase
		lastBase.setText("Player Last Base Reached: " + gw.getBaseNum());
		//Set the text of energyLevel
		energyLevel.setText("Player Energy Level: " + gw.getEnergy());
		//Set the text of damageLevel
		damageLevel.setText("Player Damage Level: " + gw.getDamage());
		if (gw.getSound()) {
			//Set the text of sound
			sound.setText("Sound: ON");
		} else {
			//Set the text of sound
			sound.setText("Sound: OFF");
		}
		//Call repaint to update ScoreView
		repaint();
	}
	
}
