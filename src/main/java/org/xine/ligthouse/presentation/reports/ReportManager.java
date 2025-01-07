package org.xine.ligthouse.presentation.reports;

import org.xine.ligthouse.business.reports.boundary.ReportsMngr;
import org.xine.ligthouse.business.reports.entity.Report;
import org.xine.ligthouse.business.reports.entity.Report.Status;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ReportManager implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    ReportsMngr bo;

    private Report report;

    private final Status[] statuss = Report.Status.values();

    public void initialize() {
        report = Report.Builder.empty();
    }

    public void save() {
        // TODO: Missing implementation
    }


    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Status[] getStatuss() {
        return statuss;
    }

}
