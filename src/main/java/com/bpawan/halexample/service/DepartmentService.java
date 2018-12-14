package com.bpawan.halexample.service;

import com.bpawan.halexample.model.entity.Department;
import lombok.NonNull;
import lombok.val;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private List<Department> departmentList = new ArrayList<>();

    public DepartmentService() {

        val department1 = new Department(1, "Software Development", "Roberto Rokos");
        val department2 = new Department(2, "Software Development", "Roberto Rokos");
        val department3 = new Department(3, "Software Development", "Roberto Rokos");
        val department4 = new Department(4, "Software Development", "Roberto Rokos");

        this.departmentList.add(department1);
        this.departmentList.add(department2);
        this.departmentList.add(department3);
        this.departmentList.add(department4);
    }

    public Flux<Department> getAllDepartments() {
        return Flux.fromIterable(this.departmentList);
    }

    public Mono<Department> getById(@NonNull Integer id) {
        return Mono.just(this.departmentList.get(id));
    }
}
