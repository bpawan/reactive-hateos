package com.bpawan.halexample.model.entity;

import lombok.*;
import org.springframework.hateoas.Identifiable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Department implements Identifiable<Integer> {
    private Integer identifier;

    private String name;

    private String head;

    @Override
    public Integer getId() {
        return this.identifier;
    }
}
