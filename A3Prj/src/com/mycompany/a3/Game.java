package com.mycompany.a3;

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
import com.codename1.ui.util.UITimer;

public class Game extends Form implements Runnable {
	
	//Creating variables
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private CheckBox sound = new CheckBox("Sound");
	private static int height;
	private static int width;
	private UITimer timer = new UITimer(this);

	
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
	private CreateButton position = new CreateButton();
	private CreateButton pause = new CreateButton();

	//Creating the commands
	private AccelerateCommand myAccelerateCommand;
	private LeftCommand myLeftCommand;
	private ChangeStrategiesCommand myChangeStrategiesCommand;
	private BrakeCommand myBrakeCommand;
	private RightCommand myRightCommand;
	private CollideNPCCommand myCollideNPCCommand;
	private CollideBaseCommand myCollideBaseCommand;
	private CollideEnergyCommand myCollideEnergyCommand;
	private CollideDroneCommand myCollideDroneCommand;
	private TickCommand myTickCommand;
	private PositionCommand myPositionCommand;
	private PauseCommand myPauseCommand;

	
	public Game() {
		gw = new GameWorld();
		mv = new MapView(gw);
		sv = new ScoreView(gw);
		
		//Adding observers
		gw.addObserver(mv);
		gw.addObserver(sv);
		
		//Setting the layout
		setLayout(new BorderLayout());
		
		//Setting the commands
		myAccelerateCommand = new AccelerateCommand(gw);
		myLeftCommand = new LeftCommand(gw);
		myChangeStrategiesCommand = new ChangeStrategiesCommand(gw);
		myBrakeCommand = new BrakeCommand(gw);
		myRightCommand = new RightCommand(gw);
		myCollideNPCCommand = new CollideNPCCommand(gw);
		myCollideBaseCommand = new CollideBaseCommand(gw);
		myCollideEnergyCommand = new CollideEnergyCommand(gw);
		myCollideDroneCommand = new CollideDroneCommand(gw);
		myTickCommand = new TickCommand(gw);
		myPositionCommand = new PositionCommand(gw);
		myPauseCommand = new PauseCommand(gw, this);
		
		
		//Accelerate Button Command
		accelerate.setCommand(myAccelerateCommand);
		addKeyListener('a', myAccelerateCommand);
		westContainer.add(accelerate);

		//Left Button Command
		left.setCommand(myLeftCommand);
		addKeyListener('l', myLeftCommand);
		westContainer.add(left);
		
		//Change Strategies Button Command
		changeStrategies.setCommand(myChangeStrategiesCommand);
		westContainer.add(changeStrategies);

		//Brake Button Command
		brake.setCommand(myBrakeCommand);
		addKeyListener('b', myBrakeCommand);
		eastContainer.add(brake);
		
		//Right Button Command
		right.setCommand(myRightCommand);
		addKeyListener('r', myRightCommand);
		eastContainer.add(right);
		
		//Collide with NPC Button Command
		collideNPC.setCommand(myCollideNPCCommand);
		//addKeyListener('c', myCollideNPCCommand);
		//southContainer.add(collideNPC);
		
		//Collide with Base Button Command
		collideBase.setCommand(myCollideBaseCommand);
		//southContainer.add(collideBase);
		
		//Collide with Energy Station Command
		collideEnergy.setCommand(myCollideEnergyCommand);
		//addKeyListener('e', myCollideEnergyCommand);
		//southContainer.add(collideEnergy);
		
		//Collide with Drone Command
		collideDrone.setCommand(myCollideDroneCommand);
		//addKeyListener('g', myCollideDroneCommand);
		//southContainer.add(collideDrone);
		
		//Tick Button Command
		tick.setCommand(myTickCommand);
		//addKeyListener('t', myTickCommand);
		//southContainer.add(tick);
		
		//Position Button Command
		position.setCommand(myPositionCommand);
		position.setEnabled(false);
		southContainer.add(position);
		
		//Pause Button Command
		pause.setCommand(myPauseCommand);
		southContainer.add(pause);

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

		//Getting the height
		height = mv.getHeight();
		
		//Getting the width
		width = mv.getWidth();

		//Calling the init method in GameWorld
		gw.init();
		
		this.show();
		
		//Starting the timer
		timer.schedule(150, true, this);
	}	
	
	public void pause() {
		//Setting the text
		pause.setText("Play");
		//Pausing the timer
		timer.cancel();
		
		//Unenabling the commands
		myAccelerateCommand.setEnabled(false);
		myLeftCommand.setEnabled(false);
		myChangeStrategiesCommand.setEnabled(false);
		myBrakeCommand.setEnabled(false);
		myRightCommand.setEnabled(false);
		myPositionCommand.setEnabled(true);
		
		//Unenabling the buttons
		accelerate.setEnabled(false);
		left.setEnabled(false);
		changeStrategies.setEnabled(false);
		brake.setEnabled(false);
		right.setEnabled(false);
		position.setEnabled(true);
		
		//Removing the key listeners
		removeKeyListener('a', myAccelerateCommand);
		removeKeyListener('l', myLeftCommand);
		removeKeyListener('b', myBrakeCommand);
		removeKeyListener('r', myRightCommand);
		
		//Pausing the game
		gw.pause();

	}
	
	public void play() {
		//Setting the text
		pause.setText("Pause");
		
		//Starting the timer
		timer.schedule(150, true, this);
		
		//Enabling the commands
		myAccelerateCommand.setEnabled(true);
		myLeftCommand.setEnabled(true);
		myChangeStrategiesCommand.setEnabled(true);
		myBrakeCommand.setEnabled(true);
		myRightCommand.setEnabled(true);
		myPositionCommand.setEnabled(false);
		
		//Enabling the buttons
		accelerate.setEnabled(true);
		left.setEnabled(true);
		changeStrategies.setEnabled(true);
		brake.setEnabled(true);
		right.setEnabled(true);
		position.setEnabled(false);
		
		//Adding the key listeners
		addKeyListener('a', myAccelerateCommand);
		addKeyListener('l', myLeftCommand);
		addKeyListener('b', myBrakeCommand);
		addKeyListener('r', myRightCommand);
		
		//Playing the game
		gw.play();
	}
	
	public static int height() {
		//Returning the height
		return height;
	}
	
	public static int width() {
		//Returning the width
		return width;
	}

	@Override
	public void run() {
		//Calling the tick method of GameWorld
		gw.tick();	
	}
	
}
