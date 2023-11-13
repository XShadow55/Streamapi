package com.example.peoples;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService servis;
    public EmployeeController(EmployeeService servis){
        this.servis = servis;

    }


    @GetMapping("/add")
    public Employee add(@RequestParam String name,@RequestParam String lastname) {
        return servis.add(name, lastname);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String name,@RequestParam String lastname) {
        return servis.remove(name, lastname);
    }
    @GetMapping("/search")
    public Employee search(@RequestParam String name,@RequestParam String lastname) {
        return servis.search(name, lastname);
    }
    @GetMapping
    public Object[] list(){
        return servis.list();
    }

}
