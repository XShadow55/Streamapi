package com.example.StreamAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/max-salary")
    public Optional<Employee> max(@RequestParam  Integer departmentId) {
        return servis.max(departmentId);

    }
    @GetMapping("/min-salary")
    public Optional<Employee> min(@RequestParam  Integer departmentId) {
        return servis.min(departmentId);

    }
    @GetMapping("/all")
    public List all(Integer departmentId) {
        return servis.alldep(departmentId);

    }
}