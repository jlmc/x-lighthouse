package org.xine.ligthouse.business.reports.boundary;

import org.xine.ligthouse.business.reports.control.ReportRepository;
import org.xine.ligthouse.business.reports.entity.Report;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
public class ReportsMngr {

    @Inject
    ReportRepository repository;

    public Collection<Report> getReports() {
        return repository.shearch();
    }

    public Report save(Report report) {
        // validate the data...
        return repository.save(report);
    }

    public Report getReport(Long reportId) {
        return repository.getReport(reportId);
    }

    public void delete(Integer id) {
        // TODO Auto-generated method stub

    }

}
