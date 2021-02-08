package org.xine.ligthouse.business.professionals.boundary;

import org.xine.ligthouse.business.professionals.entity.Professional;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.Collection;

@Path("professional")
@Produces({ MediaType.APPLICATION_JSON })
public class ProfessionalResource {

    @Inject
    ProfessionalMngr professionalMngr;

    @GET
    @Path("/")
    public Response getProfessionals() {
        Collection<Professional> professionals = professionalMngr.getProfessionals();

        GenericEntity<Collection<Professional>> po = new GenericEntity<>(professionals) {};
        return Response.ok(po).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
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
