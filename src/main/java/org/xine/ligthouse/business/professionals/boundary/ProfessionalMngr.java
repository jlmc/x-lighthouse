package org.xine.ligthouse.business.professionals.boundary;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.xine.ligthouse.business.professionals.control.ProfessionalRepository;
import org.xine.ligthouse.business.professionals.entity.Professional;

@Stateless
public class ProfessionalMngr {

	@Inject
	ProfessionalRepository professionalRepository;

	public Collection<Professional> getProfessionals() {
		return professionalRepository.shearch();
	}

	public Professional save(final Professional professional) {
		return professionalRepository.save(professional);
	}

	public Professional getProfessional(final Long cc) {
		return professionalRepository.getProfessional(cc);
	}


}
