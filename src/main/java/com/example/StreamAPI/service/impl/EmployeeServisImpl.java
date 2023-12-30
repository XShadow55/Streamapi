package com.example.StreamAPI.service.impl;

import com.example.StreamAPI.model.Employee;
import com.example.StreamAPI.exeption.AlreadyAddedException;
import com.example.StreamAPI.exeption.NotFoundException;
import com.example.StreamAPI.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeServisImpl implements EmployeeService {
    private final List<Employee> peoples = new ArrayList<>();

    @Override
    public Employee add(String firstName, String lastName, Integer dep, Integer salary) throws AlreadyAddedException {
        Employee a = new Employee(firstName,lastName,dep,salary);
        if (peoples.contains(a)){
            throw new AlreadyAddedException("Содрудник уже добавлен!");
        }
        peoples.add(a);
        return a;
    }

    @Override
    public Employee remove(String firstName, String lastName, Integer dep, Integer salary) throws NotFoundException {

        Employee a = new Employee(firstName,lastName,dep,salary);
        if (!peoples.contains(a)){
            throw new NotFoundException();
        }
        peoples.remove(a);
        return a;
    }

    @Override
    public Employee search(String firstName, String lastName, Integer dep, Integer salary)throws NotFoundException {

        Employee a = new Employee(firstName,lastName,dep,salary);
        if (!peoples.contains(a)){
            throw new NotFoundException();
        }
        return a;
    }



    @Override
    public Map<Integer, List<Employee>> all() {
        Map<Integer,List<Employee>> peopleDep = peoples.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return peopleDep;
    }

}
