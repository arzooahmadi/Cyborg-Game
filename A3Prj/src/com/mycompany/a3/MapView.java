package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {
	
	private GameWorld gw;
	private static int count = 0;
	private static int pointX;
	private static int pointY;
	private static int click = 0;
	private static boolean boo = false;

	public MapView(GameWorld gameWorld) {
		gw = gameWorld;
		//Change the border color to red
		getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.rgb(255, 0, 0)));
	}
	
	public void update (Observable o, Object arg) {
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(getX(),getY());
		//Move through the objects
		for (int i = 0; i < gw.getObjects().size(); i++) {
			//Call the draw method for each object
			gw.getObjects().get(i).draw(g, pCmpRelPrnt);
		}
	}
	
	public void pointerPressed(int x, int y) {
		//Set x
		x = x - getParent().getAbsoluteX();
		//Set y
		y = y - getParent().getAbsoluteY();
		//Set pPtrRelPrnt
		Point pPtrRelPrnt = new Point(x, y);
		//Set pCmpRelPrnt
		Point pCmpRelPrnt = new Point(getX(), getY()); 
		//Loop through all the game objects
		for (int i = 0; i < gw.getObjects().size(); i++) {
			//Set shape to the game object located at i
			GameObject shape = gw.getObjects().get(i);
				//Check if the shape is selectable
				if (shape instanceof ISelectable) {
					if (((ISelectable) shape).contains(pPtrRelPrnt, pCmpRelPrnt)) {	
						//Set setSelected to true
						((ISelectable) shape).setSelected(true);
					} else {
						//Set setSelected to false
						((ISelectable) shape).setSelected(false);
					}
				}
		}
		//Check if statement
		if (count == 1) {
			//Set the variables
			click = 1;
			pointX = x - getParent().getAbsoluteX();
			pointY = y - getParent().getAbsoluteY();
			count = 0;
		}
		//Call repaint()
		repaint();
	}
	
	public static int pointX() {
		//Return pointX
		return pointX;
	}
	
	public static int pointY() {
		//Return pointY
		return pointY;
	}

	public static void setCount() {
		//Set count to 1
		count = 1;		
	}
	public static int getCount() {
		//Return count
		return count;
	}
	
	public static int getClick() {
		//Return click
		return click;
	}
	
	public static boolean getBoolean() {
		//Check the if statement
		if(count == 1 && click == 1) {
			//Set boo to true
			boo = true;
		}
		//Return boo
		return boo;
	}

}
