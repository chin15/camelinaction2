package com.camelinaction;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Camel as client that calls the hello service using a timer every 2nd seconds and logs the response
 */
@Component
public class HelloRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:foo?period=2000")
            // call the service using {{service:name}}
            .to("http4://{{service:helloswarm-kubernetes}}?connectionClose=true")
            .log("${body}");
    }
}



