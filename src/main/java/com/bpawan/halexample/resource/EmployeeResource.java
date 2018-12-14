package com.bpawan.halexample.resource;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
@Builder
public class EmployeeResource extends ResourceSupport {

    private String identifier;

    private String name;

    private String address;

    private Integer age;

    private DepartmentResource department;
}
