package com.example.StreamAPI;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/department")
public class EmployeeController {

    private DepartmentService servis;

    public EmployeeController(DepartmentService servis) {
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

    @GetMapping("{id}/salary/max")
    public Optional<Employee> max(@PathVariable  String  id) {
        return servis.max(Integer.parseInt(id));

    }
    @GetMapping("{id}/salary/min")
    public Optional<Employee> min(@PathVariable  String  id) {
        return servis.min(Integer.parseInt(id));

    }
    @GetMapping("/{id}/salary/sum")
    public int sum(@PathVariable  String  id) {
        return servis.sum(Integer.parseInt(id));

    }
    @GetMapping("/employees")
    public Map all() {
        return servis.all();

    }
    @GetMapping("{id}/employees")
    public Map allDep(@PathVariable String  id) {
        return servis.alldep(Integer.parseInt(id));

    }
}