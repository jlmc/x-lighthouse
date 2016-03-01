package org.xine.ligthouse.business.reports.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report implements Serializable {

	enum Status {
		ENABLE, DISABLE
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Status status = Status.ENABLE;

	protected Report() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(final Status status) {
		this.status = status;
	}

	public static class Builder {
		private final Report report;

		private Builder() {
			this.report = new Report();
		}

		public Builder id(final Long id) {
			this.report.id = id;
			return this;
		}

		public Builder name(final String name) {
			this.report.name = name;
			return this;
		}

		public Builder status(final Status status) {
			this.report.status = status;
			return this;
		}

		public Builder description(final String description) {
			this.report.description = description;
			return this;
		}

		public Report build() {
			// some verifications
			return this.report;
		}

		public static Builder init() {
			return new Builder();
		}

		public static Report empty() {
			return new Report();
		}

	}

}
