package com.debyendu.wicket.component;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.extensions.markup.html.tabs.TabbedPanel;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

import com.debyendu.wicket.component.tab.TabbedDataPanel1;
import com.debyendu.wicket.component.tab.TabbedDataPanel2;


public class BasePage extends WebPage {
	public BasePage() {
		
		add(new FeedbackPanel("feedback"));
		addMainMenu();
		add(new Label("footer", "This is in the footer"));
		
		final TabbedPanel<ITab> tabsPanel = new AjaxTabbedPanel<>("configurationTabs", buildTabs());
		add(tabsPanel);
		
	}
	
	private void addMainMenu() {
        final Link<String> page1 = new Link<String>("page1") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                setResponsePage(Page1.class);
            }
        };
        final Link<String> page2 = new Link<String>("page2") {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick() {
                setResponsePage(Page2.class);
            }
        };
        
        add(page1);
        add(page2);
    }
	
	
	private List<ITab> buildTabs() {
        final List<ITab> tabs = new ArrayList<>();
        
        IModel<String> tabName1 = new Model<String>();
        IModel<String> tabName2 = new Model<String>();
        tabName1.setObject("Tab1");
        tabName2.setObject("Tab2");
        
        tabs.add(new AbstractTab(tabName1) {
            private static final long serialVersionUID = 1L;

            @Override
            public Panel getPanel(final String panelId) {
            	final TabbedDataPanel1 panel = new TabbedDataPanel1(panelId);
                return panel;
            }
        });

        tabs.add(new AbstractTab(tabName2) {
            private static final long serialVersionUID = 1L;

            @Override
            public Panel getPanel(final String panelId) {
            	final TabbedDataPanel2 panel = new TabbedDataPanel2(panelId);
                return panel;
            }
        });
        return tabs;
    }
}
