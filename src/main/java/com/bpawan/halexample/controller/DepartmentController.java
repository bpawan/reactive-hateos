package com.bpawan.halexample.controller;

import com.bpawan.halexample.resource.DepartmentResource;
import com.bpawan.halexample.resource.DepartmentResourceAssembler;
import com.bpawan.halexample.service.DepartmentService;
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
@ExposesResourceFor(DepartmentResource.class)
@RequestMapping("departments")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DepartmentController {

    @NonNull
    private final DepartmentService departmentService;

    @NonNull
    private final DepartmentResourceAssembler assembler;

    @GetMapping("/")
    public Flux<DepartmentResource> getAllDepartments() {
        return this.departmentService.getAllDepartments().map(this.assembler::toResource);
    }

    @GetMapping("/{id}")
    public Mono<DepartmentResource> getDepartmentById(@PathVariable Integer id) {
        return this.departmentService.getById(id).map(this.assembler::toResource);
    }
}
