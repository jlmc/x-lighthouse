package org.xine.ligthouse.presentation.infrastructure.converters;

import static org.xine.ligthouse.presentation.infrastructure.converters.Strings.isNullOrEmpty;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.xine.ligthouse.business.professionals.boundary.ProfessionalMngr;
import org.xine.ligthouse.business.professionals.entity.Professional;

@FacesConverter(forClass = Professional.class)
public class ProfessionalConverter implements Converter {

	@Inject
	ProfessionalMngr bo;

	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
		Professional result = null;
		if (!isNullOrEmpty(value)) {
			final String cc = value;
			result = this.bo.getProfessional(Long.valueOf(cc));
		}

		return result;
	}

	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
		if (value != null) {
			final Professional p = (Professional) value;
			// use the id
			return p.getCc() == null ? null : p.getCc().toString();
		}
		return "";
	}

}
