package com.bpawan.halexample.resource;

import com.bpawan.halexample.controller.EmployeeController;
import com.bpawan.halexample.model.Department;
import com.bpawan.halexample.model.Employee;
import lombok.NonNull;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class EmployeeResourceAssembler extends ResourceAssemblerSupport<Employee, EmployeeResource> {

    @NonNull
    private final EntityLinks entityLinks;

    @Autowired
    public EmployeeResourceAssembler(EntityLinks entityLinks) {
        super(EmployeeController.class, EmployeeResource.class);
        this.entityLinks = entityLinks;
    }

    @Override
    public EmployeeResource toResource(Employee employee) {

        this.entityLinks.linkToSingleResource(Department.class, employee.getDepartment().getId());

        val employeeResource = new EmployeeResource();
        employeeResource.setEmployee(employee);

        employeeResource.add(linkTo(methodOn(EmployeeController.class).getById(employee.getIdentifier())).withSelfRel());

        return employeeResource;
    }
}
