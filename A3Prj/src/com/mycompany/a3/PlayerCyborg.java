package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class PlayerCyborg extends Cyborg {

	private static PlayerCyborg singleCyborg;
	
	private PlayerCyborg() { 
		
	}
	
	public static Cyborg getCyborg() {
		if (singleCyborg == null) {
			//Set singleCyborg equal to new PlayerCyborg
			singleCyborg =  new PlayerCyborg();
		}
		//return singleCyborg
		return singleCyborg;
	}

	public void draw(Graphics g, Point pCmpRelPrnt) {
		//Set the points
		int x1 = (int) (getLocation().getX() + pCmpRelPrnt.getX());
		int y1 = (int) (getLocation().getY() + pCmpRelPrnt.getY());
		//Set the color
		g.setColor(ColorUtil.rgb(255, 0, 0));
		//Fill in a square
		g.fillRect(x1, y1, (cyborgSize()), (cyborgSize()));
	}
	

}
