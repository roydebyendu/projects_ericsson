package com.debyendu.wicket.component;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

import com.debyendu.model.Employee;
import com.debyendu.wicket.application.SpringBootSwaggerClientCall;
import com.debyendu.wicket.component.form.ModelEditPanel;

public class Page2 extends BasePage {
	
	private final AjaxLink linkSave;
	
	public Page2() {
		add(new Label("label2", "This is the page 2"));
		
		SpringBootSwaggerClientCall scc = new SpringBootSwaggerClientCall();
		Employee employee = scc.getData("Debyendu");
		
		Model<Employee> modelEmployee = new Model<Employee>();
		modelEmployee.setObject(employee);
		
		ModelEditPanel modelEditPanel = new ModelEditPanel("modelEditPanel",  modelEmployee); 
		add(modelEditPanel); 
		
		linkSave = new AjaxLink("save") {
	       	 public void onClick(AjaxRequestTarget target) {
	       		modelEditPanel.convertInput();
	       		Employee employee = modelEditPanel.getModelObject();
	       		System.out.println("ModelEditPanel " + employee);
	       		
	       		modelEditPanel.setModelObject(scc.saveData(employee));
	       	 }
	    };
	    add(linkSave);
			
			
	}
}
