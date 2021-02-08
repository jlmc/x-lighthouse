package org.xine.ligthouse.presentation.professionals;

import org.xine.ligthouse.business.professionals.boundary.ProfessionalMngr;
import org.xine.ligthouse.business.professionals.entity.Professional;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@RequestScoped
@FacesConverter(forClass = Professional.class)
public class ProfessionalConverter implements Converter<Professional> {

    //@Inject
    ProfessionalMngr bo;

    public ProfessionalConverter() {
        bo = CDI.current().select(ProfessionalMngr.class).get();
    }

    @Override
    public Professional getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        final String cc = value;
        return this.bo.getProfessional(Long.valueOf(cc));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Professional value) {
        if (value == null) {
            return "";
        }

        return value.getCc() == null ? null : value.getCc().toString();
    }
}
