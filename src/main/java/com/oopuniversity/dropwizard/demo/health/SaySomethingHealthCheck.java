package com.oopuniversity.dropwizard.demo.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by jd on 5/20/2016.
 */
public class SaySomethingHealthCheck extends HealthCheck {
    private final String template;

    public SaySomethingHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }

}
