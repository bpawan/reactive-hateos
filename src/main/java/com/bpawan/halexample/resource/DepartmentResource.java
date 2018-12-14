package com.bpawan.halexample.resource;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

@Getter
@Setter
@Builder
public class DepartmentResource extends ResourceSupport {
   private Integer identifier;

   private String name;

   private String head;
}
