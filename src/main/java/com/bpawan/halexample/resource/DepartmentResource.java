package com.bpawan.halexample.resource;

import com.bpawan.halexample.model.Department;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
public class DepartmentResource extends ResourceSupport {
    private Department department;
}
