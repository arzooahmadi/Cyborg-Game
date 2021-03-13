package com.mycompany.a3;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public abstract class Fixed extends GameObject implements ISelectable {

	private boolean isSelected;
	
	public void setSelected(boolean b) { 
		isSelected = b; 
	}
	
	public boolean isSelected() { 
		return isSelected; 
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		
	}
	
	public boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		return false;
	}
}
