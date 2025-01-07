package org.xine.ligthouse.business.professionals.entity;

import org.xine.ligthouse.core.jsonb.JsonbRepresentation;

import javax.persistence.Embeddable;
import java.io.Serializable;

@JsonbRepresentation
@Embeddable
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    private String country;
    private String city;
    private String street;
    private String number;

    protected Address() {
    }

    public static Address of(
            final String country,
            final String city,
            final String street,
            final String number) {
        final Address address = new Address();
        address.country = country;
        address.city = city;
        address.street = street;
        address.number = number;

        return address;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getNumber() {
        return this.number;
    }

    public String getStreet() {
        return this.street;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.city == null) ? 0 : this.city.toLowerCase().hashCode());
        result = prime * result + ((this.country == null) ? 0 : this.country.toLowerCase().hashCode());
        result = prime * result + ((this.number == null) ? 0 : this.number.toLowerCase().hashCode());
        result = prime * result + ((this.street == null) ? 0 : this.street.toLowerCase().hashCode());
        return result;
    }
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (this.city == null) {
            if (other.city != null) {
                return false;
            }
        } else if (!this.city.equals(other.city)) {
            return false;
        }
        if (this.country == null) {
            if (other.country != null) {
                return false;
            }
        } else if (!this.country.equals(other.country)) {
            return false;
        }
        if (this.number == null) {
            if (other.number != null) {
                return false;
            }
        } else if (!this.number.equals(other.number)) {
            return false;
        }
        if (this.street == null) {
            return other.street == null;
        } else return this.street.equalsIgnoreCase(other.street);
    }

    public static Address empty() {
        return new Address();
    }


}
