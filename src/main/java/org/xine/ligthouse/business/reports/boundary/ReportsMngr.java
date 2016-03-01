package org.xine.ligthouse.business.reports.boundary;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

import javax.ejb.Stateless;

import org.xine.ligthouse.business.reports.entity.Report;
import org.xine.ligthouse.business.reports.entity.Report.Builder;

@Stateless
public class ReportsMngr {

	public Collection<Report> getReports() {
		final Deque<Report> reports = new LinkedList<>();

		final Report cancerCervix = Builder.init()
				.id(1L)
				.name("cancer cervix")
				.description("this is the report ocancer cervix just for women.")
				.build();
		final Report lungCancer = Builder.init()
				.id(2L)
				.name("lung Cancer")
				.build();

		reports.add(cancerCervix);
		reports.add(lungCancer);


		return reports;
	}

}
