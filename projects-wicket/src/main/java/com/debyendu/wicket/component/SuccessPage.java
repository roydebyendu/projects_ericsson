package com.debyendu.wicket.component;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;


public class SuccessPage extends WebPage {
	public SuccessPage(final PageParameters parameters) {

		String username = "";
		
		if(parameters.get("username") != null){
			username = parameters.get("username").toString();
		}
		
		final Label result = new Label("result", "Username : " + username);
		add(result);
		
	}

}
