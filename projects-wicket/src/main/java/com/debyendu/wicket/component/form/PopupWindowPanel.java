package com.debyendu.wicket.component.form;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.markup.html.panel.Panel;

public class PopupWindowPanel extends Panel { 
    private static final long serialVersionUID = 1L;
    private final Label popupLabel;
    private final AjaxLink linkClose;
    
    public PopupWindowPanel(final String id, ModalWindow mw) {
        super(id);
        
        popupLabel = new Label("popupLabel", new PopupLabel().getObject());
        add(popupLabel);
        
        linkClose = new AjaxLink("close") {
        	 public void onClick(AjaxRequestTarget target) {
        		 mw.close(target);
        	 }
        };
        add(linkClose);
        
    }
    
    private final class PopupLabel extends AbstractReadOnlyModel<String> {
		private static final long serialVersionUID = 1L;
		@Override
		public String getObject() {
			String msg = "This is woriking test";
			return msg;
		}
	}
    
}
