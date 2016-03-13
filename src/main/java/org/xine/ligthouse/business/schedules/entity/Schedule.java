package org.xine.ligthouse.business.schedules.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.xine.ligthouse.business.professionals.entity.Professional;
import org.xine.ligthouse.business.reports.entity.Report;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "name", length = 64, nullable = false)
	private String name;

	@ManyToOne(optional=false)
	@JoinColumn(name="reportId", nullable=false, updatable=false)
	private Report report;

	@ManyToMany
    @JoinTable(name="Schedule_Professionals",
        joinColumns=
            @JoinColumn(name="scheduleId", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="professionalId", referencedColumnName="cc")
        )
	private Set<Professional> professionals = new HashSet<>(0);

	@ElementCollection
	@CollectionTable(name = "emails", joinColumns = {@JoinColumn(name="scheduleId")})
	private Set<String> emails = new HashSet<>(0);

	Schedule() {}

	public Long getId() {
		return this.id;
	}

	public Report getReport() {
		return this.report;
	}

	public String getName() {
		return this.name;
	}

	public Set<String> getEmails() {
		return Collections.unmodifiableSet(this.emails);
	}

	public Set<Professional> getProfessionals() {
		return Collections.unmodifiableSet(this.professionals);
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setReport(final Report report) {
		this.report = report;
	}

	protected void setProfessionals(final Set<Professional> professionals) {
		this.professionals = professionals;
	}

	protected void setEmails(final Set<String> emails) {
		this.emails = emails;
	}

	protected void setId(final Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
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
		final Schedule other = (Schedule) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} 
		
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", name=" + name + "]";
	}
	
	
	public void addEmail(String... emails) {
		if(emails != null) {
			Arrays.stream(emails).forEach(email ->  {
				if(this.emails == null) {
					throw new IllegalArgumentException("can't add a null email on the Schedule.");
				}
				//TODO:: we can use InternetAddress with jpa converter
				//TODO:: some other validations
				
				this.emails.add(email.toLowerCase());
			});
		}
	}
	
	public void addProfessional(Professional... professionals) { 
		if (professionals != null) {
			Arrays.stream(professionals).forEach(p ->  {
				if(p == null) {
					throw new IllegalArgumentException("can't add a null professional on the Schedule.");
				}
				this.professionals.add(p);
			});
		}
	}
	
	public void removeEmail(String email) {
		if (email != null) {
			this.emails.remove(email.toLowerCase());
		}
	}
	
	public void removeProfessional(Professional professional) {
		if (professional == null) {
			this.professionals.remove(professional);
		}
	}



}
