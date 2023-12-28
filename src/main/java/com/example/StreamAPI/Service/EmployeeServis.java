package com.example.StreamAPI.Service;

import com.example.StreamAPI.Model.Employee;
import com.example.StreamAPI.Exeption.AlreadyAddedException;
import com.example.StreamAPI.Exeption.NotFoundException;
import com.example.StreamAPI.Interface.InterfaceEmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeServis implements InterfaceEmployeeService {
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
