package org.xine.ligthouse.business.professionals.boundary;

import org.xine.ligthouse.business.professionals.control.ProfessionalRepository;
import org.xine.ligthouse.business.professionals.entity.Professional;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

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
