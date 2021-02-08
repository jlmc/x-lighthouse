package org.xine.ligthouse.presentation.infrastructure.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;
import java.util.Calendar;
import java.util.Date;

@FacesConverter(forClass = Calendar.class)
public class CalendarHtml5Converter implements Converter {

    private static DateTimeConverter originalConverter = new DateTimeConverter();

    static {
        originalConverter.setPattern("yyyy-MM-dd");
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        final Date date = (Date) originalConverter.getAsObject(context, component, value);

        if (date == null) {
            return null;
        }

        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }

        final Calendar cal = (Calendar) value;

        return originalConverter.getAsString(context, component, cal.getTime());
    }

}
