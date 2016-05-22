package com.oopuniversity.dropwizard.demo;

import com.oopuniversity.dropwizard.demo.health.SaySomethingHealthCheck;
import com.oopuniversity.dropwizard.demo.resources.ExternalServiceResource;
import com.oopuniversity.dropwizard.demo.resources.SaySomethingResource;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import javax.ws.rs.client.Client;

/**
 * Hello world!
 */
public class App extends Application<DemoConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }


    @Override
    public void initialize(Bootstrap<DemoConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<DemoConfiguration>());

    }

    @Override
    public void run(DemoConfiguration configuration,
                    Environment environment) {
        final SaySomethingResource resource = new SaySomethingResource(
                configuration.getTemplate(),
                configuration.getDefaultName(), environment
        );
        environment.jersey().register(resource);
        final SaySomethingHealthCheck healthCheck =
                new SaySomethingHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);

        final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
                .build(getName());
        environment.jersey().register(new ExternalServiceResource(client));

    }
}
