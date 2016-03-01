package org.xine.ligthouse.business.professionals.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.Test;
import org.xine.ligthouse.business.professionals.entity.Professional.Specialty;


public class ProfessionalTest {

	@Test
	public void createPressionalWithAll() {

		final Professional professional = Professional.Builder.init()
				.cc(1L)
				.name("Maria Madalena")
				.email("mariamadalena@domain.com")
				.dateOfBirth(LocalDate.of(1982, Month.JANUARY, 5))
				.phone("12345678")
				.mobile("23456789")
				.specialty(Specialty.NURSE)
				.observations("nothing to say!!!")
				.build();


		assertNotNull(professional);
	}

	@Test
	public void addAdreass() {
		final Professional professional = Professional.Builder.init().cc(1L).name("messi").email("messi@domain.com")
				.dateOfBirth(LocalDate.of(1982, Month.JANUARY, 5)).phone("12345678").mobile("23456789")
				.specialty(Specialty.NURSE).observations("nothing to say!!!").build();

		final Address addressEs = Address.of("Spain", "Barcelona", "abs street", "10");
		final Address addressAn = Address.of("Argentina", "Boenos Aires", "Ag street", "10");

		professional.addAddress(addressAn);
		professional.addAddress(addressEs);

		final List<Address> adresses = professional.getAdresses();

		assertEquals(2, adresses.size());
	}

}
