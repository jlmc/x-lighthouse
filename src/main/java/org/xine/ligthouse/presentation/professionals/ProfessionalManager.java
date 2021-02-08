package org.xine.ligthouse.presentation.professionals;

import org.xine.ligthouse.business.professionals.boundary.ProfessionalMngr;
import org.xine.ligthouse.business.professionals.entity.Address;
import org.xine.ligthouse.business.professionals.entity.Professional;
import org.xine.ligthouse.business.professionals.entity.Professional.Specialty;
import org.xine.ligthouse.presentation.infrastructure.Messages;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;

@Named
@ViewScoped
public class ProfessionalManager implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Collection<Address> addresses = new LinkedHashSet<>();

    private Address address;

    private Professional professional;

    private final Specialty[] specialtys = Specialty.values();

    @Inject
    ProfessionalMngr bo;
    @Inject
    Messages messagesHelper;

    @PostConstruct
    public void initialize() {
        System.out.println("in INITIALIZE");
        this.professional = Professional.Builder.empty();
        this.addresses.clear();
    }

    public void init() {
        System.out.println("in INIT");
    }

    public void onSaveProfessional() {
        if (this.professional != null) {
            this.professional.addAdress(this.addresses.toArray(new Address[0]));

            this.bo.save(this.professional);

            this.messagesHelper.addMessageFlash(new FacesMessage("Professional saved!"));
            initialize();
        }
    }

    public Collection<Address> getAddresses() {
        return this.addresses;
    }

    public String onClear() {
        initialize();
        return "/professionals/professionalManager?faces-redirect=true";
    }

    public void onNewAddressClick() {
        this.address = Address.empty();
    }

    public void onAddressAddClick() {
        this.addresses.add(this.address);
        this.address = null;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Professional getProfessional() {
        return this.professional;
    }

    public void setProfessional(final Professional professional) {
        if (professional != null) {
            this.professional = professional;
        }
    }

    public Specialty[] getSpecialtys() {
        return this.specialtys;
    }

}
