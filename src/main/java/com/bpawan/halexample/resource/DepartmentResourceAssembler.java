package com.bpawan.halexample.resource;

import com.bpawan.halexample.controller.DepartmentController;
import com.bpawan.halexample.controller.EmployeeController;
import com.bpawan.halexample.model.Department;
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
    public DepartmentResource toResource(Department department) {

        val resource = new DepartmentResource();

        resource.setDepartment(department);
        resource.add(linkTo(methodOn(EmployeeController.class).getById(department.getIdentifier())).withSelfRel());

        return resource;
    }
}
