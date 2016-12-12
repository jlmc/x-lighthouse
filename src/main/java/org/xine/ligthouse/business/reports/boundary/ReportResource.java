package org.xine.ligthouse.business.reports.boundary;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.xine.ligthouse.business.reports.entity.Report;

@Path("report")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ReportResource {

	@Inject
	ReportsMngr reportMngr;

	@GET
	@Path("/")
	public Response all() {
		return Response.
				ok(reportMngr.getReports()).
				build();
	}
	
	@POST
	public Response create(Report report) {
		try{
			final Report reportlSaved = reportMngr.save(report);
			return Response.
					ok(reportlSaved).
					build();
		} catch (final IllegalArgumentException e) {
			return Response.
					status(Status.BAD_REQUEST).
					entity(e.getMessage()).
					build();
		} catch(final Exception e) {
			return Response.
					status(Response.Status.INTERNAL_SERVER_ERROR).
					entity(e.getMessage()).
					build();
		}
	}

	// @Consumes(MediaType.APPLICATION_JSON) @Path("{id:\\d+}")
	@DELETE
	@Path("{id : \\d+}")
	public Response delete(@PathParam("id") final Integer id) {
		try {
			reportMngr.delete(id);
			return Response.ok().build();
		} catch (final IllegalArgumentException e) {
			return Response.
					status(Status.BAD_REQUEST).
					entity(e.getMessage()).
					build();
		} catch(final Exception e) {
			return Response.
					status(Response.Status.INTERNAL_SERVER_ERROR).
					entity(e.getMessage()).
					build();
		}
	}
}
