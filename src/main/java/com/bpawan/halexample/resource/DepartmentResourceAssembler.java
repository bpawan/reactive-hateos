package com.bpawan.halexample.resource;

import com.bpawan.halexample.controller.DepartmentController;
import com.bpawan.halexample.model.entity.Department;
import lombok.NonNull;
import lombok.val;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class DepartmentResourceAssembler extends ResourceAssemblerSupport<Department, DepartmentResource> {

    public DepartmentResourceAssembler() {
        super(DepartmentController.class, DepartmentResource.class);
    }

    @Override
    public DepartmentResource toResource(@NonNull Department department) {

        val resource = DepartmentResource
                .builder()
                .identifier(department.getId())
                .name(department.getName())
                .head(department.getHead())
                .build();

        resource.add(linkTo(methodOn(DepartmentController.class).getDepartmentById(department.getIdentifier())).withSelfRel());

        return resource;
    }
}
