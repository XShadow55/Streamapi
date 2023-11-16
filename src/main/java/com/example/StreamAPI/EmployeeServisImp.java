package com.example.StreamAPI;

import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class EmployeeServisImp implements EmployeeService{
    private final List<Employee> people = new ArrayList<>(List.of( new Employee("ww","rr",1,10000),
            new Employee("ll","vv",1,15000),
            new Employee("wt","rl",1,54000)));
    @Override
    public Employee add(String firstName, String lastName, Integer dep, Integer salary) {
        Employee a = new Employee(firstName,lastName,dep,salary);
        people.add(a);
        return a;
    }

    @Override
    public Employee remove(String firstName, String lastName, Integer dep, Integer salary) {
        Employee a = new Employee(firstName,lastName,dep,salary);
        people.remove(a);
        return a;
    }

    @Override
    public Employee search(String firstName, String lastName, Integer dep, Integer salary) {
        Employee a = new Employee(firstName,lastName,dep,salary);
        if (people.contains(a)){
            return a;
        }
        else {
            return null;
        }
    }

    @Override
    public Optional<Employee> max(Integer dep) {
        return people.stream().filter(people -> people.getDepartment() == dep).max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Optional<Employee> min(Integer dep) {
        return people.stream().filter(people -> people.getDepartment() == dep).min(Comparator.comparing(Employee::getSalary));
    }



    @Override
    public List alldep(Integer dep) {
        if (dep == null){
            return List.of(people.toArray());
        }
        else {
            return List.of(people.stream().filter(employee -> employee.getDepartment() == dep).toArray());
        }

    }


}
