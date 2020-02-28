package com.spring.restapi.report.model;

import com.spring.restapi.report.controller.ReportController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ReportResource implements RepresentationModelProcessor<EntityModel<Report>> {

    @Override
    public EntityModel<Report> process(EntityModel<Report> model) {

        model.add(linkTo(ReportController.class).withSelfRel());

        if (model.getContent().isAddUrl())
            model.add(linkTo(ReportController.class).slash("gotoTrue").withRel(LinkRelation.of("isAddUrlTrue")));
        else
            model.add(linkTo(ReportController.class).slash("gotoFalse").withRel(LinkRelation.of("isAddUrlFalse")));

        return model;
    }
}
