package io.quarkus.workshop.superheroes.villain;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.net.URI;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;

@Path("/api/villains")
@ApplicationScoped
public class VillainResource {

    Logger logger;
    VillainService villainService;

    public VillainResource(Logger logger, VillainService villainService) {

        this.logger = logger;
        this.villainService = villainService;
    }

    @Operation(summary = "Returns a random villain")
    @GET
    @Path("/random")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Villain.class, required = true)))
    public Response getRandomVillain() {

        Villain villain = villainService.findRandomVillain();
        logger.debug("Found random villain" + villain);
        return Response.ok(villain).build();
    }

    @Operation(summary = "Returns all the villains from the database")
    @GET
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Villain.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "204", description = "No villains")
    public Response getAllVillains() {

        List<Villain> villains = villainService.findAllVillains();
        logger.debug("Total number of villains " + villains.size());
        return Response.ok(villains).build();
    }

    @Operation(summary = "Returns a villain for a given identifier")
    @GET
    @Path("/{id}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Villain.class)))
    @APIResponse(responseCode = "204", description = "The villain is not found for a given identifier")
    public Response getVillain(@RestPath Long id) {

        Villain villain = villainService.findVillainById(id);
        if (villain != null) {
            logger.debug("Found villain " + villain);
            return Response.ok(villain).build();
        }
        logger.debug("No villain found with id " + id);
        return Response.noContent().build();
    }

    @Operation(summary = "Creates a valid villain")
    @POST
    @APIResponse(responseCode = "201", description = "The URI of the created villain", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = URI.class)))
    public Response createVillain(@Valid Villain villain, @Context UriInfo uriInfo) {

        villain = villainService.persistVillain(villain);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(Long.toString(villain.id));
        logger.debug("New villain created with URI " + uriBuilder.build().toString());
        return Response.created(uriBuilder.build()).build();
    }

    @Operation(summary = "Updates an exiting  villain")
    @PUT
    @APIResponse(responseCode = "200", description = "The updated villain", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Villain.class)))
    public Response updateVillain(@Valid Villain villain) {

        villain = villainService.updateVillain(villain);
        logger.debug("Villain updated with new values " + villain);
        return Response.ok(villain).build();
    }

    @Operation(summary = "Deletes an exiting villain")
    @DELETE
    @Path("/{id}")
    @APIResponse(responseCode = "204")
    public Response deleteVillain(Long id) {

        villainService.deleteVillain(id);
        logger.debug("Villain deleted with id " + id);
        return Response.noContent().build();
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        return "Hello villain";
    }
}
