package com.bpawan.halexample.service;

import com.bpawan.halexample.model.Employee;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    private DepartmentService departmentService;

    @Autowired
    public EmployeeService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public Flux<Employee> getEmployees() {

        return this.departmentService
                .getAllDepartments()
                .map(department -> new Employee(
                                department.getIdentifier(),
                                "John Doe",
                                "Jupiter street 23, Solar System",
                                23,
                                department
                        )
                );
    }

    public Mono<Employee> getEmployeeById(@NonNull Integer id) {

        return this.departmentService
                .getById(id)
                .map(department -> new Employee(
                        department.getIdentifier(),
                        "John Doe",
                        "Jupiter street 23, Solar System",
                        23,
                        department
                ));
    }
}
