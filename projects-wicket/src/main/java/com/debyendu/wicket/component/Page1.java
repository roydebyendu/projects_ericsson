package com.debyendu.wicket.component;

import java.util.List;
import java.util.ArrayList;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.IModel;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.AjaxRequestTarget;

/*import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;*/

import com.debyendu.wicket.component.form.DropDownChoicePage;
import com.debyendu.wicket.component.form.PopupWindow;
import com.debyendu.wicket.component.form.TextFieldPage;
import com.debyendu.wicket.component.form.DataTableModelPanel;

import com.debyendu.model.Employee;
import com.debyendu.wicket.application.SpringBootSwaggerClientCall;


public class Page1 extends BasePage {
	public Page1() {
		addMainMenu();
		
		SpringBootSwaggerClientCall scc = new SpringBootSwaggerClientCall();
		List<Employee> employeeList = scc.getAllData();
		
		IModel<List<Employee>> modelEmployeeList = new Model();
		modelEmployeeList.setObject(employeeList);
		
		DataTableModelPanel DataTableModelPanel = new DataTableModelPanel("dataTableModelPanel", modelEmployeeList);
		add(DataTableModelPanel);
		
	}
	
	private void addMainMenu() {
		TextFieldPage textFieldPage = new TextFieldPage("searchText");
		DropDownChoicePage dropDownChoicePage = new DropDownChoicePage("searchType", textFieldPage); 
		add(new Label("searchTypeLabel", "Search Type"));
		add(dropDownChoicePage.createDropDown());
		add(new Label("searchTextLabel", "Search Text"));
		add(textFieldPage.createTextField());
		
		PopupWindow popupWindow = new PopupWindow("popupWindow");
    	add(popupWindow);
		
		
	    AjaxLink ajaxLink = new AjaxLink("show") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				popupWindow.show(target);
			}
	    	
	    };
	    add(ajaxLink);
	    	    
    }
	

	
}
