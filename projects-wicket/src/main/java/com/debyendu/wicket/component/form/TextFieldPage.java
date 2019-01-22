package com.debyendu.wicket.component.form;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class TextFieldPage extends FormComponent<String> {
	private static final long serialVersionUID = 1L;
	public TextField<String> searchTextField = null;
	public TextFieldPage(String id) {
		super(id);

		searchTextField = new TextField<String>("searchText", Model.of("---")){
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {
				return true;
			}
		};
		searchTextField.setOutputMarkupId(true);
		searchTextField.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(final AjaxRequestTarget target) {
				final String valueAsString = ((TextField<String>) getComponent()).getModelObject();
				target.appendJavaScript("alert('"+valueAsString+"');");
			}
		});
	}
	public FormComponent<String> createTextField(){
		return searchTextField;
	}


}
