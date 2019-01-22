package com.debyendu.wicket.component;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;

//import com.debyendu.wicket.application.RestServiceCall;
import com.debyendu.wicket.validator.UsernameValidator;

public class UserPage extends WebPage {
	public UserPage(final PageParameters parameters) {

		add(new FeedbackPanel("feedback"));

		final TextField<String> username = new TextField<String>("username", Model.of("---"));
		username.setRequired(true);
		username.add(new UsernameValidator());

		username.add(new AjaxFormComponentUpdatingBehavior("onkeyup") {
			@Override
			protected void onUpdate(final AjaxRequestTarget target) {
				// Access the updated model object:
				final Object value = getComponent().getDefaultModelObject();
				// or:
				final String valueAsString = ((TextField<String>) getComponent()).getModelObject();
				
				target.appendJavaScript("alert('"+valueAsString+"');");				
				
			}
		});

		Form<?> form = new Form<Void>("userForm") {

			@Override
			protected void onSubmit() {

				// RestServiceCall rsc = new RestServiceCall();
				// String result = rsc.callService();

				final String usernameValue = username.getModelObject();

				PageParameters pageParameters = new PageParameters();
				pageParameters.add("username", usernameValue);
				setResponsePage(SuccessPage.class, pageParameters);

			}

		};

		add(form);
		form.add(username);

	}

}
