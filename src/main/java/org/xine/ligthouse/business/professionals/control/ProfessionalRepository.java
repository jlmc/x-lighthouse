package org.xine.ligthouse.business.professionals.control;

import org.xine.ligthouse.business.professionals.entity.Professional;
import org.xine.ligthouse.business.professionals.entity.Professional.Specialty;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static org.xine.ligthouse.business.professionals.entity.Professional.Builder.init;

@Singleton
public class ProfessionalRepository {

    public Set<Professional> professionals = new LinkedHashSet<>();

    @PostConstruct
    public void initialize() {
        //create some dummy objects

        this.professionals.add(init().cc(1L)
                .name("Maria Madalena")
                .email("mariamadalena@domain.com")
                .dateOfBirth(LocalDate.of(1982, Month.JANUARY, 5))
                .phone("12345678")
                .mobile("23456789")
                .specialty(Specialty.NURSE)
                .observations("nothing to say!!!")
                .build());
        this.professionals.add(init().cc(2L)
                .name("Lionel Messi")
                .email("messi@domain.com")
                .dateOfBirth(LocalDate.of(1990, Month.FEBRUARY, 10))
                .phone("1234867379")
                .mobile("94757758")
                .specialty(Specialty.DOCTOR)
                .observations("nothing to say!!!")
                .build());
        this.professionals.add(init().cc(3L)
                .name("Roger federer")
                .email("federer@domain.com")
                .dateOfBirth(LocalDate.of(1981, Month.MAY, 30))
                .phone("872834648")
                .mobile("839474857")
                .specialty(Specialty.DOCTOR)
                .observations("nothing to say!!!")
                .build());
    }

    public Professional save(final Professional professional) {
        if (professional == null) {
            throw new IllegalArgumentException("Can´t save a null professional");
        }

        this.professionals.add(professional);

        return professional;
    }

    public void remove(final Professional professional) {
        this.professionals.remove(professional);
    }

    public Collection<Professional> shearch() {
        return Collections.unmodifiableList(new ArrayList<>(this.professionals));
    }

    public Professional getProfessional(final Long cc) {
        return this.professionals.stream()
                .filter(p -> p.getCc().equals(cc))
                .findFirst()
                .orElseGet(null);
    }

}
