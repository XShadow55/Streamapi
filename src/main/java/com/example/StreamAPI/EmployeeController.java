package com.example.StreamAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class EmployeeController {

    private EmployeeService servis;
    public EmployeeController(EmployeeService servis){
        this.servis = servis;

    }


    @GetMapping("/add")
    public String  add(@RequestParam String name,@RequestParam String lastname,Integer dep,Integer salary) {
        return servis.add(name, lastname,dep,salary);
    }
    @GetMapping("/remove")
    public String  remove(@RequestParam String name,@RequestParam String lastname,Integer dep,Integer salary) {
        return servis.remove(name, lastname,dep,salary);

}
