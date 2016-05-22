package com.oopuniversity.dropwizard.demo.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.oopuniversity.dropwizard.demo.api.Saying;
import com.oopuniversity.dropwizard.demo.view.SaySomethingView;
import io.dropwizard.setup.Environment;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jd on 4/16/2016.
 */
@Path("/say-something")
@Produces(MediaType.APPLICATION_JSON)
//@Produces(MediaType.TEXT_HTML)
public class SaySomethingResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private final Environment environment;

    public SaySomethingResource(String template, String defaultName, Environment environment) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.environment = environment;
    }

    @GET
    @Path("JSON")
    public Saying sayHelloJSON(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }

    @GET
    @Timed
    @Produces(MediaType.TEXT_HTML)

    public SaySomethingView sayHello(@QueryParam("name") Optional<String> name) {

        return new SaySomethingView(sayHelloJSON(name));
    }
}
