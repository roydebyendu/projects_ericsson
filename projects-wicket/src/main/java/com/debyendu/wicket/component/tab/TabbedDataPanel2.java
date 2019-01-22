package com.debyendu.wicket.component.tab;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class TabbedDataPanel2 extends Panel {

	private static final long serialVersionUID = 1L;
	
	public TabbedDataPanel2(String id) {
		super(id);
		// TODO Auto-generated constructor stub
		add(new Label("tabbedDataPanelContent", "This is the tabbed panel 2"));
	}

	

}
