package org.xine.ligthouse.business.reports.control;

import org.xine.ligthouse.business.reports.entity.Report;
import org.xine.ligthouse.business.reports.entity.Report.Builder;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Startup
@Singleton
public class ReportRepository {

    private Set<Report> reports;

    private AtomicLong sec;

    @PostConstruct
    public void initialize() {
        this.reports = new LinkedHashSet<>();
        this.sec = new AtomicLong(0L);

        final Report cancerCervix = Builder.init().id(1L).name("cancer cervix")
                .description("this is the report ocancer cervix just for women.").build();
        final Report lungCancer = Builder.init().id(2L).name("lung Cancer").build();

        this.reports.add(cancerCervix);
        this.reports.add(lungCancer);
    }

    public Report save(final Report report) {
        if (report != null) {
            if (report.getId() == null) {
                report.setId(this.sec.incrementAndGet());
            }
            this.reports.add(report);
            return report;
        }
        return null;
    }

    public Collection<Report> shearch() {
        return Collections.unmodifiableSet(new HashSet<>(this.reports));
    }

    public Report getReport(final Long id) {
        return this.reports.stream()
                           .filter(r -> r.getId().equals(id))
                           .findFirst()
                           .orElse(null);
    }

}
