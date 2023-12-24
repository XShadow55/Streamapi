package com.example.StreamAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public class DepartmentController {
    private InterfaceDepartmentService servis;

    public DepartmentController(InterfaceDepartmentService servis) {
        this.servis = servis;

    }


    @GetMapping("{id}/salary/max")
    public Optional max(@PathVariable String  id) {
        return servis.max(Integer.parseInt(id));

    }
    @GetMapping("{id}/salary/min")
    public Optional min(@PathVariable  String  id) {
        return servis.min(Integer.parseInt(id));

    }
    @GetMapping("/{id}/salary/sum")
    public int sum(@PathVariable  String  id) {
        return servis.sum(Integer.parseInt(id));

    }

}
