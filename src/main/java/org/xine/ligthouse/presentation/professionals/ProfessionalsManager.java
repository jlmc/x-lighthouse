package org.xine.ligthouse.presentation.professionals;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.xine.ligthouse.business.professionals.boundary.ProfessionalMngr;
import org.xine.ligthouse.business.professionals.entity.Professional;

@Named
@ViewScoped
public class ProfessionalsManager implements Serializable {
	private static final long serialVersionUID = 1L;

	private Collection<Professional> professionals;

	private Professional selectedProfessional;

	@Inject
	ProfessionalMngr bo;

	@PostConstruct
	public void initialize() {
		this.professionals = this.bo.getProfessionals();
		this.selectedProfessional = null;
	}

	public Collection<Professional> getProfessionals() {
		return this.professionals;
	}

	public Professional getSelectedProfessional() {
		return this.selectedProfessional;
	}

	public void setSelectedProfessional(final Professional selectedProfessional) {
		this.selectedProfessional = selectedProfessional;
	}

	public Object onEditClick() {
		if (this.selectedProfessional != null) {
			return "/professionals/professionalManager?professional=" + this.selectedProfessional.getCc()
			+ "&&faces-redirect=true";
		}
		return null;
	}

}
