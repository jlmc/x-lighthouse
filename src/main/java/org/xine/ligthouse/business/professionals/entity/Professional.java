package org.xine.ligthouse.business.professionals.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.xine.ligthouse.business.schedules.entity.Schedule;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Professional implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Specialty {
		DOCTOR, NURSE
	}

	@Id
	private Long cc;
	private String name;
	private String phone;
	private String mobile;
	private String email;;
	private LocalDate dateOfBirth;
	private String observations;
	private Specialty specialty = Specialty.DOCTOR;

	@Version
	@Column(name = "OPTLOCK")
	private int version;

	@ElementCollection
	@CollectionTable(name = "Adresses", joinColumns = { @JoinColumn(name = "professionalCC") })
	private List<Address> adresses = new ArrayList<>();

	@ManyToMany(mappedBy = "professionals")
	private Set<Schedule> schedules;

	protected Professional() {
	}

	public void addAddress(final Address address) {
		if (address == null) {
			throw new IllegalArgumentException("address can't be null");
		}
		this.adresses.add(address);
	}

	public void addAdress(final Address... addresses) {
		if (addresses != null) {
			Arrays.stream(addresses).forEach(a -> addAddress(a));
		}
	}

	public Specialty getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(final Specialty specialty) {
		this.specialty = specialty;
	}

	public List<Address> getAdresses() {
		return Collections.unmodifiableList(this.adresses);
	}

	protected void setAdresses(final List<Address> adresses) {
		this.adresses = adresses;
	}

	public String getObservations() {
		return this.observations;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public String getPhone() {
		return this.phone;
	}

	public Long getCc() {
		return this.cc;
	}

	public String getName() {
		return this.name;
	}

	public void setCc(final Long cc) {
		this.cc = cc;
	}

	public void setDateOfBirth(final LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setMobile(final String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setObservations(final String observations) {
		this.observations = observations;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	protected int getVersion() {
		return this.version;
	}

	protected void setVersion(final int version) {
		this.version = version;
	}

	public Set<Schedule> getSchedules() {
		return Collections.unmodifiableSet(this.schedules);
	}

	protected void setSchedules(final Set<Schedule> schedules) {
		this.schedules = schedules;
	}

	@Override
	public String toString() {
		return "Professional [cc=" + this.cc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.cc);
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
		final Professional other = (Professional) obj;

		if (this.cc == null) {
			if (other.cc != null) {
				return false;
			}
		}

		return Objects.equals(this.cc, other.cc);
	}

	public static class Builder {
		private final Professional professional;

		private Builder() {
			this.professional = new Professional();
		}

		public Builder cc(final Long cc) {
			if (cc == null) {
				throw new IllegalArgumentException("CC can´t be null.");
			}
			this.professional.cc = cc;
			return this;
		}

		public Builder name(final String name) {
			if (name == null) {
				throw new IllegalArgumentException("Name can´t be null.");
			}

			if (name.length() > 100) {
				throw new IllegalArgumentException("Name length must be less than 100.");
			}
			this.professional.name = name;
			return this;
		}

		public Builder email(final String email) {
			if (email == null) {
				throw new IllegalArgumentException("Email can´t be null.");
			}

			if (email.length() > 100) {
				throw new IllegalArgumentException("Email length must be less than 100.");
			}
			this.professional.email = email;
			return this;
		}

		public Builder phone(final String phone) {
			this.professional.phone = phone;
			return this;
		}

		public Builder mobile(final String mobile) {
			this.professional.mobile = mobile;
			return this;
		}

		public Builder dateOfBirth(final LocalDate dateOfBirth) {
			this.professional.dateOfBirth = dateOfBirth;
			return this;
		}

		public Builder observations(final String observations) {
			this.professional.observations = observations;
			return this;
		}

		public Builder specialty(final Specialty specialty) {
			final EnumSet<Specialty> allSpecialty = EnumSet.allOf(Specialty.class);
			if (!allSpecialty.contains(specialty)) {
				throw new IllegalArgumentException("Specialty is not validid.");
			}

			this.professional.specialty = specialty;
			return this;
		}

		public Professional build() {
			if (this.professional.cc == null) {
				throw new IllegalArgumentException("CC can´t be null.");
			}
			if (this.professional.name == null) {
				throw new IllegalArgumentException("Name can´t be null.");
			}
			if (this.professional.email == null) {
				throw new IllegalArgumentException("Email can´t be null.");
			}

			return this.professional;
		}

		public static Builder init() {
			return new Builder();
		}

		public static Professional empty() {
			return new Professional();
		}

	}

}
