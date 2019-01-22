package com.debyendu.wicket.component.form;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import com.debyendu.model.Employee;

public class DataTableModelPanel extends FormComponentPanel<List<Employee>> {

	private static final long serialVersionUID = 1L;
	
	
	public DataTableModelPanel(String id, IModel<List<Employee>> employeeModel) {
		super(id, employeeModel);
		
		PopupWindow popupWindow = new PopupWindow("popupWindow");
    	add(popupWindow);
		
		
	    /*AjaxLink ajaxLink = new AjaxLink("show") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				popupWindow.show(target);
			}
	    	
	    };*/
	    
		
		final DataView dataView = new DataView("simple", new ListDataProvider(employeeModel.getObject())) {
            public void populateItem(final Item item) {
                final Employee employee = (Employee) item.getModelObject();
                /*item.add(new TextField<String>("employeeId", new Model<String>(employee.getEmpId())));
                item.add(new TextField<String>("employeeName", new Model<String>(employee.getEmpName())));
                item.add(new TextField<String>("employeeSalary", new Model<String>(employee.getEmpSalary())));
                item.add(new TextField<String>("employeeDesignation", new Model<String>(employee.getEmpDesignation())));*/
                item.add(new Label("employeeId", employee.getEmpId()));
                item.add(new Label("employeeName", employee.getEmpName()));
                item.add(new Label("employeeSalary", employee.getEmpSalary()));
                item.add(new Label("employeeDesignation", employee.getEmpDesignation()));
                item.add(new AjaxLink("show") {

        			@Override
        			public void onClick(AjaxRequestTarget target) {
        				popupWindow.show(target);
        			}
        	    	
        	    });
            }
        };
 
         dataView.setItemsPerPage(2);
         
        add(dataView);
 
        add(new PagingNavigator("navigator", dataView));
		
		
	}

}
