package com.debyendu.wicket.component.form;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.debyendu.model.Employee;
import com.debyendu.wicket.component.Page1;

public class ModelEditPanel extends FormComponentPanel<Employee> {

	private static final long serialVersionUID = 1L;
	
	private TextField<String> employeeId;
	private TextField<String> employeeName;
	private TextField<String> employeeSalary;
	private TextField<String> employeeDesignation;
	
	
	public ModelEditPanel(String id, IModel<Employee> employeeModel) {
		super(id, employeeModel);
		
		employeeId = new TextField<String>("employeeId", new Model<String>(""));
		employeeName = new TextField<String>("employeeName", new Model<String>(""));
		employeeSalary = new TextField<String>("employeeSalary", new Model<String>(""));
		employeeDesignation = new TextField<String>("employeeDesignation", new Model<String>(""));
		
		PopupWindow popupWindow = new PopupWindow("popupWindow");
    	add(popupWindow);
		
		
	    AjaxLink ajaxLink = new AjaxLink("show") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				popupWindow.show(target);
			}
	    	
	    };
	    add(ajaxLink);
		
		add(employeeId);
		add(employeeName);
		add(employeeSalary);
		add(employeeDesignation);
		
		
		employeeId.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			@Override
			protected void onUpdate(final AjaxRequestTarget target) {
				// Access the updated model object:
				final Object value = getComponent().getDefaultModelObject();
				// or:
				final String valueAsString = ((TextField<String>) getComponent()).getModelObject();
				employeeId.setModelObject(valueAsString);
								
				
			}
		});
		
		employeeName.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			@Override
			protected void onUpdate(final AjaxRequestTarget target) {
				// Access the updated model object:
				final Object value = getComponent().getDefaultModelObject();
				// or:
				final String valueAsString = ((TextField<String>) getComponent()).getModelObject();
				employeeName.setModelObject(valueAsString);
								
				
			}
		});
		
		employeeSalary.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			@Override
			protected void onUpdate(final AjaxRequestTarget target) {
				// Access the updated model object:
				final Object value = getComponent().getDefaultModelObject();
				// or:
				final String valueAsString = ((TextField<String>) getComponent()).getModelObject();
				employeeSalary.setModelObject(valueAsString);
								
				
			}
		});
		
		employeeDesignation.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			@Override
			protected void onUpdate(final AjaxRequestTarget target) {
				// Access the updated model object:
				final Object value = getComponent().getDefaultModelObject();
				// or:
				final String valueAsString = ((TextField<String>) getComponent()).getModelObject();
				employeeDesignation.setModelObject(valueAsString);
								
				
			}
		});
		
		
	}

	
	
	@Override
	public void convertInput() {
		/**
         * Build up a new Employee instance from the values in the fields.
         *
         */
		super.convertInput();
		Employee employee = new Employee(
				this.employeeId.getModelObject(), 
				this.employeeName.getModelObject(), 
				this.employeeSalary.getModelObject(), 
				this.employeeDesignation.getModelObject());
         
		 setConvertedInput(employee);
		 this.setModelObject(employee);
		 System.out.println("in convertInput "+employee);
	}
	
	/*
     * Here we pull out each field from the Employee if it exists and put the contents into the fields.
     */
    @Override
    protected void onBeforeRender() {
    	super.onBeforeRender(); 
    	Employee employee = this.getModelObject();
         
    	System.out.println("in onBeforeRender "+employee);
    	
        if (employee != null) {
            // copy the field values into the form fields.
            this.employeeId.setModelObject(employee.getEmpId());
            this.employeeName.setModelObject(employee.getEmpName());
            this.employeeSalary.setModelObject(employee.getEmpSalary());
            this.employeeDesignation.setModelObject(employee.getEmpDesignation());
        }
        
    }
	
	

}
