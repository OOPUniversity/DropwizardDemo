package com.oopuniversity.dropwizard.demo.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oopuniversity.dropwizard.demo.model.Placeholder;
import com.oopuniversity.dropwizard.demo.view.ExternalServiceView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by jd on 5/21/2016.
 */
@Path("/external")
public class ExternalServiceResource {
    final Client client;

    public ExternalServiceResource(Client client) {
        this.client = client;
    }

    @GET
    @Path("html")
    @Produces(MediaType.TEXT_HTML)
    public ExternalServiceView displayExternalService(@QueryParam("id") Integer id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Placeholder p = doSomething(id).readEntity(Placeholder.class);
        return new ExternalServiceView(p);
    }

    @GET
    @Path("json")
    public Response doSomething(@QueryParam("id") Integer id) throws IOException {
        System.out.println("Loading post #" + id);
        Response response = client.target("http://jsonplaceholder.typicode.com/posts")
                .path(id.toString())
                .request()
                .get();
        return response;
    }
}
