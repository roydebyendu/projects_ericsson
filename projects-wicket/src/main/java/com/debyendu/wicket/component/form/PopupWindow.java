package com.debyendu.wicket.component.form;

import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.model.IModel;

public final class PopupWindow extends ModalWindow {

	private static final long serialVersionUID = 1L;
	
	private final PopupWindowPanel content;
	
	public PopupWindow(String id) {
		super(id);

		content = new PopupWindowPanel(getContentId(), this);
		setContent(content);
		setCookieName(getContentId());
		setCssClassName(ModalWindow.CSS_CLASS_GRAY);
		setResizable(false);
		setInitialHeight(150);
		setInitialWidth(330);
		setWidthUnit("px");
		setHeightUnit("px");
	}
	
	public void setContentModel(final IModel<String> model) {
		content.setDefaultModel(model);
	}

}
