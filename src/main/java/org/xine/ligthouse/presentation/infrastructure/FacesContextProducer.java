package org.xine.ligthouse.presentation.infrastructure;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ApplicationScoped
public class FacesContextProducer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Produces
    @RequestScoped
    public FacesContext get() {
        return FacesContext.getCurrentInstance();
    }

}
