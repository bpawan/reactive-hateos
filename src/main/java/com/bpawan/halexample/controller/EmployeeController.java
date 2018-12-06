package com.bpawan.halexample.controller;

import com.bpawan.halexample.resource.EmployeeResource;
import com.bpawan.halexample.resource.EmployeeResourceAssembler;
import com.bpawan.halexample.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("employees")
@ExposesResourceFor(EmployeeResource.class)
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class EmployeeController {

    @NonNull
    private final EmployeeService employeeService;

    @NonNull
    private final EmployeeResourceAssembler employeeResourceAssembler;

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
