package org.xine.ligthouse.presentation.infrastructure;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


public class MessagesHelper implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;

	public void addMessageFlash(final FacesMessage message) {
		this.facesContext.getExternalContext()
		.getFlash()
		.setKeepMessages(true);
		this.facesContext.addMessage(null, message);
	}

	public void addMessage(final FacesMessage message) {
		this.facesContext.addMessage(null, message);
	}


}
