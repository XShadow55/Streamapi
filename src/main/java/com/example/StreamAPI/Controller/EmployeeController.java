package com.example.StreamAPI.Controller;

import com.example.StreamAPI.Model.Employee;
import com.example.StreamAPI.Interface.InterfaceEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/department")
public class EmployeeController {

    private InterfaceEmployeeService servis;

    public EmployeeController(InterfaceEmployeeService servis) {
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

}