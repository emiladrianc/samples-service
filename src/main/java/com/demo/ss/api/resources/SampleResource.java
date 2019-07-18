package com.demo.ss.api.resources;

import com.demo.ss.api.models.SampleModel;
import com.demo.ss.services.SamplesService;
import com.demo.ss.services.domains.SampleDomain;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/v1/samples")
@Api("Samples")
public class SampleResource {

    private static final Logger logger = Logger.getLogger(SampleResource.class);

    @Inject
    private SamplesService samplesService;

    @Context
    private ServletContext context;

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Lists all sample.",
            response = SampleModel.class,
            responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 200, message = "List all samples.")
    })
    public Response get() {
        logger.info("[GET] - get samples");

        final List<SampleModel> response = new ArrayList<>();
        final List<SampleDomain> sampleDomains = samplesService.get();

        for (final SampleDomain domain : sampleDomains) {
            response.add(SampleModel.builder().id(domain.getId()).name(domain.getName()).build());
        }

        return Response.ok(response).status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "get sample.",
            response = SampleModel.class,
            responseContainer = "Sample detail")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sample details.")
    })
    public Response getById(@PathParam("id") final Integer id) {

        logger.info("[GET] - get samples");

        final SampleDomain domain = samplesService.get(id);

        final SampleModel response = SampleModel.builder().id(domain.getId()).name(domain.getName()).build();

        return Response.ok(response).status(Response.Status.OK).build();
    }
}