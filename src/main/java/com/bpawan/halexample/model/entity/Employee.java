package com.bpawan.halexample.model.entity;

import lombok.*;
import org.springframework.hateoas.Identifiable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Identifiable<Integer> {
    private Integer identifier;

    private String name;

    private String address;

    private Integer age;

    private Department department;

    @Override
    public Integer getId() {
        return this.identifier;
    }
}
