package com.learncamel.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.apache.camel.test.spring.DisableJmx;
import org.apache.camel.test.spring.MockEndpoints;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by z001qgd on 1/13/18.
 */

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest(properties = {"camel.springboot.java-routes-include-pattern=com/learncamel/routes/MyRouter"})
@MockEndpoints("file:output")
public class MyRouteMockTest extends CamelTestSupport{

    @EndpointInject(uri="mock:file:output")
    MockEndpoint mockEndpoint;

    @Autowired
    private ProducerTemplate producerTemplate;

    @Test
    public void testMethod() throws InterruptedException {
        mockEndpoint.expectedBodiesReceived("GoodBye");
        template.sendBody("direct:start",null);
        mockEndpoint.assertIsSatisfied();
    }

}
