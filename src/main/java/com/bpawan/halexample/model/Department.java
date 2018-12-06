package com.bpawan.halexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Identifiable;

@Data
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
