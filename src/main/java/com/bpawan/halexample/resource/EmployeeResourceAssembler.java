package com.bpawan.halexample.resource;

import com.bpawan.halexample.controller.EmployeeController;
import com.bpawan.halexample.model.entity.Employee;
import lombok.NonNull;
import lombok.val;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class EmployeeResourceAssembler extends ResourceAssemblerSupport<Employee, EmployeeResource> {

    private final DepartmentResourceAssembler departmentResourceAssembler;

    public EmployeeResourceAssembler(DepartmentResourceAssembler departmentResourceAssembler) {
        super(EmployeeController.class, EmployeeResource.class);
        this.departmentResourceAssembler = departmentResourceAssembler;
    }

    @Override
    public EmployeeResource toResource(@NonNull Employee employee) {

        val departmentResource = this.departmentResourceAssembler.toResource(employee.getDepartment());


        val employeeResource = EmployeeResource
                .builder()
                .name(employee.getName())
                .address(employee.getAddress())
                .age(employee.getAge())
                .department(departmentResource)
                .build();

        employeeResource.add(linkTo(methodOn(EmployeeController.class).getById(employee.getIdentifier())).withSelfRel());

        return employeeResource;
    }
}
