package com.debyendu.wicket.component.form;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class DropDownChoicePage extends FormComponent<String> {

	private static final long serialVersionUID = 1L;
	private final List<String> SEARCH_ENGINES = Arrays.asList(new String[] {"EmpId", "EmpName", "EmpPhone" });
	private String selected = "EmpId";
	DropDownChoice<String> listSearchType=null;
	FormComponent<String> dropDownChoice=null;
	
	public TextField<String> searchTextField = null;

	public DropDownChoicePage(String id, Component targetComponent) {
		super(id);

		//DropDown
		listSearchType = new DropDownChoice<String>( "searchType", new PropertyModel<String>(this, "selected"), SEARCH_ENGINES) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {
				return true;
			}
		};
		
		listSearchType.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			private static final long serialVersionUID = 1L;
			@Override
			protected void onUpdate(AjaxRequestTarget  target) {
				//error("Selected search engine : " + selected);
				TextField<String> tf = ((TextFieldPage)targetComponent).searchTextField;
				System.out.println(tf.getId());
				tf.setModelObject(selected);
				target.add(tf);
			}
		});
		
		
		
	}
	public FormComponent<String> createDropDown(){
		return listSearchType;
	}  

}
