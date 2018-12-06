package com.bpawan.halexample.resource;

import com.bpawan.halexample.model.Employee;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
public class EmployeeResource extends ResourceSupport {
    private Employee employee;
}
