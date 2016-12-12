package org.xine.ligthouse.business.professionals.boundary;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.xine.ligthouse.business.professionals.entity.Professional;
import org.xine.ligthouse.business.professionals.entity.Professionals;

@Path("professional")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ProfessionalResource {

	@Inject
	ProfessionalMngr professionalMngr; 

	@GET
	@Path("/")
	public Response getProfessionals() {
		return Response.ok(Professionals.of(professionalMngr.getProfessionals())).build();
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response create(Professional professional) {
		try{
			final Professional professionalSaved = professionalMngr.save(professional);
			return Response.ok(professionalSaved).build();
		} catch(final Exception e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	@DELETE
	@Path("{id : \\d+}")
	public Response delete(@PathParam("id") Long cc) {
		//this.professionalMngr.delete(cc);
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}
}
