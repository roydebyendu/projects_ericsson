package com.debyendu.wicket.component;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.WebPage;

import com.debyendu.wicket.application.RestServiceCall;
import com.debyendu.wicket.application.SwaggerClientCall;

public class Hello extends WebPage {
	private static final long serialVersionUID = 1L;

    public Hello(final PageParameters parameters) {

       	//RestServiceCall rsc = new RestServiceCall();
       	SwaggerClientCall scc = new SwaggerClientCall();
    	String result = scc.callService();
    	
        add(new Label("message", result));
    }
}
