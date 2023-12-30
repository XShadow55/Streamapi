package com.example.StreamAPI.controller;

import com.example.StreamAPI.model.Employee;
import com.example.StreamAPI.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class EmployeeController {

    private EmployeeService servis;

    public EmployeeController(EmployeeService servis) {
        this.servis = servis;

    }


    @GetMapping("/add")
    public Employee add(@RequestParam String name, @RequestParam String lastname, Integer dep, Integer salary) {
        return servis.add(name, lastname, dep, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String name, @RequestParam String lastname, Integer dep, Integer salary) {
        return servis.remove(name, lastname, dep, salary);
    }
    @GetMapping("/search")
    public Employee search(@RequestParam String name,@RequestParam String lastname,Integer dep,Integer salary) {
        return servis.search(name, lastname,dep,salary);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> all() {
        return servis.all();

    }

}