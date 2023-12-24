package com.example.StreamAPI;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class EmployeeController {

    private InterfaceService servis;

    public EmployeeController(InterfaceService servis) {
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
    public Map all() {
        return servis.all();

    }
    @GetMapping("{id}/employees")
    public Map allDep(@PathVariable String  id) {
        return servis.alldep(Integer.parseInt(id));

    }
}