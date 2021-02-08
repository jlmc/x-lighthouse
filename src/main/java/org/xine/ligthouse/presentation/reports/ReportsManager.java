package org.xine.ligthouse.presentation.reports;

import org.xine.ligthouse.business.reports.boundary.ReportsMngr;
import org.xine.ligthouse.business.reports.entity.Report;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@ViewScoped
public class ReportsManager implements Serializable {

    private static final long serialVersionUID = 1L;

    private Collection<Report> reports;

    private Report selectedReport;

    @Inject
    ReportsMngr reportsMngr;

    @PostConstruct
    public void initialize() {
        this.reports = this.reportsMngr.getReports();
        this.selectedReport = null;
    }

    public Collection<Report> getReports() {
        return this.reports;
    }

    public void setSelectedReport(final Report selectedReport) {
        this.selectedReport = selectedReport;
    }

    public Report getSelectedReport() {
        return this.selectedReport;
    }

}
