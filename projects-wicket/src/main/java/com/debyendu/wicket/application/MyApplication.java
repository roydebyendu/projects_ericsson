package com.debyendu.wicket.application;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import com.debyendu.wicket.component.Hello;
//import com.debyendu.wicket.component.UserPage;
import com.debyendu.wicket.component.BasePage;


public class MyApplication extends WebApplication {
	@Override
	public Class<? extends Page> getHomePage() {
		//return Hello.class; //return default page
		//return UserPage.class;
		return BasePage.class;
	}

}
