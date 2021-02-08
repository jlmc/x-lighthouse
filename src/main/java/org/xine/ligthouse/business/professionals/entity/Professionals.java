package org.xine.ligthouse.business.professionals.entity;

import org.xine.ligthouse.core.jsonb.JsonbRepresentation;

import java.util.ArrayList;
import java.util.Collection;

@JsonbRepresentation
public class Professionals {

    public Collection<Professional> professionals = new ArrayList<>();

    protected Professionals() {}

    public static Professionals of(Collection<Professional> professionals) {
        final Professionals wrapper = new Professionals();
        wrapper.professionals = professionals;
        return wrapper;
    }

    public Collection<Professional> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(Collection<Professional> professionals) {
        this.professionals = professionals;
    }

}
