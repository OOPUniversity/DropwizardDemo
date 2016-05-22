package com.oopuniversity.dropwizard.demo.view;

import com.oopuniversity.dropwizard.demo.model.Placeholder;
import io.dropwizard.views.View;

/**
 * Created by jd on 5/22/2016.
 * {
 "userId": 1,
 "id": 1,
 "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
 "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
 }
 */
public class ExternalServiceView extends View {
    Placeholder placeholder;

    public ExternalServiceView(Placeholder placeholder) {
        super("placeholder.ftl");
        this.placeholder = placeholder;
    }

    public Placeholder getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(Placeholder placeholder) {
        this.placeholder = placeholder;
    }
}
