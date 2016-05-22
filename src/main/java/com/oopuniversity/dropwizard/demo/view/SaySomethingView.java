package com.oopuniversity.dropwizard.demo.view;

import com.oopuniversity.dropwizard.demo.api.Saying;
import io.dropwizard.views.View;

/**
 * Created by jd on 5/20/2016.
 */
public class SaySomethingView extends View {
    public Saying getSaying() {
        return saying;
    }

    final Saying saying;

    public SaySomethingView(Saying saying) {
        super("saying.ftl");
        this.saying = saying;

    }
}
