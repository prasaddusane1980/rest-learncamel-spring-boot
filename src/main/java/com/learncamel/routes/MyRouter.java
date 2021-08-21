package com.learncamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:start")
                .setBody(constant("GoodBye"))
                .to("file:output");

    }
}
