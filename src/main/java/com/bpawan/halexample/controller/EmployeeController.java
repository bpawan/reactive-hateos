package com.bpawan.halexample.controller;

import com.bpawan.halexample.resource.EmployeeResource;
import com.bpawan.halexample.resource.EmployeeResourceAssembler;
import com.bpawan.halexample.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeResourceAssembler employeeResourceAssembler;

    public EmployeeController(
            EmployeeService employeeService,
            EmployeeResourceAssembler employeeResourceAssembler
    ) {
        this.employeeService = employeeService;
        this.employeeResourceAssembler = employeeResourceAssembler;
    }

    @GetMapping("/")
    public Flux<EmployeeResource> getAll() {
        return this.employeeService
                .getEmployees()
                .map(this.employeeResourceAssembler::toResource);
    }

    @GetMapping("/{employeeId}")
    public Mono<EmployeeResource> getById(@PathVariable Integer employeeId) {
        return this.employeeService
                .getEmployeeById(employeeId)
                .map(this.employeeResourceAssembler::toResource);

    }
}
