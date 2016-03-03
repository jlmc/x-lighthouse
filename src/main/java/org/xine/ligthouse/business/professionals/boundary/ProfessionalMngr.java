package org.xine.ligthouse.business.professionals.boundary;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.xine.ligthouse.business.professionals.control.ProfessionalRepository;
import org.xine.ligthouse.business.professionals.entity.Professional;

@Path("professional")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Stateless
public class ProfessionalMngr {

	@Inject
	ProfessionalRepository professionalRepository;


	@GET
	@Path("/")
	public Collection<Professional> getProfessionals() {
		return this.professionalRepository.shearch();
	}

	public Professional save(final Professional professional) {
		return this.professionalRepository.save(professional);
	}

	public Professional getProfessional(final Long cc) {
		return this.professionalRepository.getProfessional(cc);
	}


}
