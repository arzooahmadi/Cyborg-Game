package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.plaf.Border;

public class CreateButton extends Button {

	public CreateButton() {
		//Setting the style of CreateButton
		getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		getUnselectedStyle().setBgTransparency(255);
		getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		getUnselectedStyle().setPadding(Component.TOP, 5);
		getAllStyles().setPadding(Component.BOTTOM, 5);
	}
	
}
