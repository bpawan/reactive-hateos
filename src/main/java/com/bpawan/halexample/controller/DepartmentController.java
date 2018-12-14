package com.bpawan.halexample.controller;

import com.bpawan.halexample.resource.DepartmentResource;
import com.bpawan.halexample.resource.DepartmentResourceAssembler;
import com.bpawan.halexample.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    private final DepartmentResourceAssembler assembler;


    @Autowired
    public DepartmentController(
            DepartmentService departmentService,
            DepartmentResourceAssembler assembler
    ) {
        this.departmentService = departmentService;
        this.assembler = assembler;
    }

    @GetMapping("/")
    public Flux<DepartmentResource> getAllDepartments() {
        return this.departmentService
                .getAllDepartments()
                .map(this.assembler::toResource);
    }

    @GetMapping("/{id}")
    public Mono<DepartmentResource> getDepartmentById(@PathVariable Integer id) {
        return this.departmentService
                .getById(id)
                .map(this.assembler::toResource);
    }
}
