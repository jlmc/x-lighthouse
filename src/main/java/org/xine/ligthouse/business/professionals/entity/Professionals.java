package org.xine.ligthouse.business.professionals.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Professionals {
	
	@XmlElement(name = "professional")
	public Collection<Professional> professionals = new ArrayList<>();
	
	protected Professionals() {}
	
	public static Professionals of(Collection<Professional> professionals) {
		final Professionals wrapper = new Professionals();
		wrapper.professionals = professionals;
		return wrapper;
	}
	
	public Collection<Professional> getProfessionals() {
		return professionals;
	}
	
	public void setProfessionals(Collection<Professional> professionals) {
		this.professionals = professionals;
	}

}
