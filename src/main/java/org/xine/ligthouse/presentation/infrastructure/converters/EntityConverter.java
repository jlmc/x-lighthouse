package org.xine.ligthouse.presentation.infrastructure.converters;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

@FacesConverter(value = "entityConverter")
public class EntityConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (isEmpty(value)) {
            return null;
        }

        final UISelectItems uiComponent = (UISelectItems) component.getChildren().get(0);

        final Collection<?> objects = (Collection<?>) uiComponent.getValue();

        return objects.stream()
        .filter(entity -> getAsString(context, uiComponent, entity).equals(value))
        .findFirst()
        .orElse(null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        final Field field = findEntityIdField(value);
        return getEntityIdValue(field, value);
    }

    private String getEntityIdValue(Field idField, Object value) {

        try {
            final Field field = value.getClass().getDeclaredField(idField.getName());
            field.setAccessible(true);

            return field.get(value).toString();

        } catch (IllegalArgumentException |
                 IllegalAccessException |
                 NoSuchFieldException |
                 SecurityException e) {
            throw new ConverterException("can´t getEntityIdValue from " + value);
        }
    }

    private Field findEntityIdField(Object value) {
        return Arrays.stream(value.getClass().getDeclaredFields())
                .filter((field) -> field.getAnnotation(Id.class) != null)
                .findFirst()
                .orElseThrow();
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }



}