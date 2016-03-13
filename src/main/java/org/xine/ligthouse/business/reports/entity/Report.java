package org.xine.ligthouse.business.reports.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Report implements Serializable {

	public enum Status {
		ENABLE, DISABLE
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String name;
	@NotNull
	@Size(min = 1, max = 100)
	private String description;
	@NotNull
	private Status status = Status.ENABLE;

	protected Report() {
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(final Status status) {
		this.status = status;
	}

	public static class Builder {
		private final Report report;

		private Builder() {
			report = new Report();
		}

		public Builder id(final Long id) {
			report.id = id;
			return this;
		}

		public Builder name(final String name) {
			report.name = name;
			return this;
		}

		public Builder status(final Status status) {
			report.status = status;
			return this;
		}

		public Builder description(final String description) {
			report.description = description;
			return this;
		}

		public Report build() {
			// some verifications
			return report;
		}

		public static Builder init() {
			return new Builder();
		}

		public static Report empty() {
			return new Report();
		}

	}

}
