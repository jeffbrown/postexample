package com.example;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.views.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

@Controller
public class DemoController {

    private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);

    @Get
    @Produces(MediaType.TEXT_HTML)
    @View("/index")
    HttpResponse index() {
        return HttpResponse.ok();
    }

    @Post("/save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    HttpResponse postSomeData(@Body Person person) {
        LOG.debug("Hello {} {}", person.getFirstName(), person.getLastName());
        return HttpResponse.seeOther(URI.create("/"));
    }

}
