package com.example.StreamAPI.Controller;

import com.example.StreamAPI.Interface.InterfaceDepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public class DepartmentController {
    private InterfaceDepartmentService servis;

    public DepartmentController(InterfaceDepartmentService servis) {
        this.servis = servis;

    }


    @GetMapping("{id}/salary/max")
    public Object max(@PathVariable String  id) {
        return servis.max(Integer.parseInt(id));

    }
    @GetMapping("{id}/salary/min")
    public Object min(@PathVariable  String  id) {
        return servis.min(Integer.parseInt(id));

    }
    @GetMapping("/{id}/salary/sum")
    public int sum(@PathVariable  String  id) {
        return servis.sum(Integer.parseInt(id));

    }
    @GetMapping("{id}/employees")
    public Map allDep(@PathVariable String  id) {
        return servis.alldep(Integer.parseInt(id));

    }

}
