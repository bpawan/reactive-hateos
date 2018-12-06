package com.bpawan.halexample.resource;

import com.bpawan.halexample.controller.EmployeeController;
import com.bpawan.halexample.model.Employee;
import lombok.NonNull;
import lombok.val;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class EmployeeResourceAssembler extends ResourceAssemblerSupport<Employee, EmployeeResource> {

    public EmployeeResourceAssembler() {
        super(EmployeeController.class, EmployeeResource.class);
    }

    @Override
    public EmployeeResource toResource(@NonNull Employee employee) {

        val employeeResource = new EmployeeResource();
        employeeResource.setEmployee(employee);

        employeeResource.add(linkTo(methodOn(EmployeeController.class).getById(employee.getIdentifier())).withSelfRel());

        return employeeResource;
    }
}
