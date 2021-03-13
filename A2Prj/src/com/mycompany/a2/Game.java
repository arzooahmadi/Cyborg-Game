package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

public class Game extends Form {
	
	//Creating variables
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private CheckBox sound = new CheckBox("Sound");
	private static int height;
	private static int width;
	
	//Creating west container with box layout
	private Container westContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
	private Container eastContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
	private Container southContainer = new Container(new FlowLayout(Component.CENTER));
	
	//Creating the buttons
	private CreateButton accelerate = new CreateButton();
	private CreateButton left = new CreateButton();
	private CreateButton changeStrategies = new CreateButton();
	private CreateButton brake = new CreateButton();
	private CreateButton right = new CreateButton();
	private CreateButton collideNPC = new CreateButton();
	private CreateButton collideBase = new CreateButton();
	private CreateButton collideEnergy = new CreateButton();
	private CreateButton collideDrone = new CreateButton();
	private CreateButton tick = new CreateButton();

	public Game() {
		gw = new GameWorld();
		mv = new MapView();
		sv = new ScoreView(gw);
		
		//Adding observers
		gw.addObserver(mv);
		gw.addObserver(sv);
		
		//Setting the layout
		setLayout(new BorderLayout());
		
		//Accelerate Button Command
		AccelerateCommand myAccelerateCommand = new AccelerateCommand(gw);
		accelerate.setCommand(myAccelerateCommand);
		addKeyListener('a', myAccelerateCommand);
		westContainer.add(accelerate);

		//Left Button Command
		LeftCommand myLeftCommand = new LeftCommand(gw);
		left.setCommand(myLeftCommand);
		addKeyListener('l', myLeftCommand);
		westContainer.add(left);
		
		//Change Strategies Button Command
		ChangeStrategiesCommand myChangeStrategiesCommand = new ChangeStrategiesCommand(gw);
		changeStrategies.setCommand(myChangeStrategiesCommand);
		westContainer.add(changeStrategies);

		//Brake Button Command
		BrakeCommand myBrakeCommand = new BrakeCommand(gw);
		brake.setCommand(myBrakeCommand);
		addKeyListener('b', myBrakeCommand);
		eastContainer.add(brake);
		
		//Right Button Command
		RightCommand myRightCommand = new RightCommand(gw);
		right.setCommand(myRightCommand);
		addKeyListener('r', myRightCommand);
		eastContainer.add(right);
		
		//Collide with NPC Button Command
		CollideNPCCommand myCollideNPCCommand = new CollideNPCCommand(gw);
		collideNPC.setCommand(myCollideNPCCommand);
		addKeyListener('c', myCollideNPCCommand);
		southContainer.add(collideNPC);
		
		//Collide with Base Button Command
		CollideBaseCommand myCollideBaseCommand = new CollideBaseCommand(gw);
		collideBase.setCommand(myCollideBaseCommand);
		southContainer.add(collideBase);
		
		//Collide with Energy Station Command
		CollideEnergyCommand myCollideEnergyCommand = new CollideEnergyCommand(gw);
		collideEnergy.setCommand(myCollideEnergyCommand);
		addKeyListener('e', myCollideEnergyCommand);
		southContainer.add(collideEnergy);
		
		//Collide with Drone Command
		CollideDroneCommand myCollideDroneCommand = new CollideDroneCommand(gw);
		collideDrone.setCommand(myCollideDroneCommand);
		addKeyListener('g', myCollideDroneCommand);
		southContainer.add(collideDrone);
		
		//Tick Button Command
		TickCommand myTickCommand = new TickCommand(gw);
		tick.setCommand(myTickCommand);
		addKeyListener('t', myTickCommand);
		southContainer.add(tick);

		//Adding the containers to the original border layout
		add(BorderLayout.WEST, westContainer);
		add(BorderLayout.EAST, eastContainer);
		add(BorderLayout.SOUTH, southContainer);
		add(BorderLayout.NORTH, sv);
		add(BorderLayout.CENTER, mv);

		//Creating toolbar
		Toolbar myToolbar = new Toolbar();
		//Setting the toolbar
		setToolbar(myToolbar);
		//Setting the title of the toolbar
		myToolbar.setTitle("Sili-Challenge Game");
		//Setting the side menu to true
		Toolbar.setOnTopSideMenu(true);
		
		//Adding commands to the side menu bar
		HelpCommand myHelpCommand = new HelpCommand();
		SoundCommand mySoundCommand = new SoundCommand(gw);
		AboutCommand myAboutCommand = new AboutCommand();
		ExitCommand myExitCommand = new ExitCommand();

		//Adding key listener for the Exit Command
		addKeyListener('x', myExitCommand);
		
		//Setting the style for the Sound Command
		sound.getAllStyles().setBgTransparency(255);
		sound.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		sound.getAllStyles().setPadding(TOP, 2);
		sound.getAllStyles().setPadding(BOTTOM, 2);
		sound.setCommand(mySoundCommand);
		
		//Adding commands to the title bar and side menu
		myToolbar.addCommandToRightBar(myHelpCommand);
		myToolbar.addCommandToSideMenu(myAccelerateCommand);		
		myToolbar.addComponentToSideMenu(sound);
		myToolbar.addCommandToSideMenu(myAboutCommand);
		myToolbar.addCommandToSideMenu(myExitCommand);
		
		//Setting the style for the containers
		westContainer.getAllStyles().setBorder(Border.createLineBorder(2,ColorUtil.BLACK));
		westContainer.getAllStyles().setPadding(Component.TOP, 100);
		eastContainer.getAllStyles().setBorder(Border.createLineBorder(2,ColorUtil.BLACK));
		eastContainer.getAllStyles().setPadding(Component.TOP, 100);
		southContainer.getAllStyles().setBorder(Border.createLineBorder(2,ColorUtil.BLACK));
		
		this.show();
		//Getting the height
		height = mv.getHeight();
		//Getting the width
		width = mv.getWidth();
		//Calling the init method in GameWorld
		gw.init();
	}	
	
	public static int height() {
		//Returning the height
		return height;
	}
	
	public static int width() {
		//Returning the width
		return width;
	}
	
}
