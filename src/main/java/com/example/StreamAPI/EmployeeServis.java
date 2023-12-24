package com.example.StreamAPI;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class EmployeeServis implements InterfaceService {
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
    public Employee remove(String firstName, String lastName, Integer dep, Integer salary) throws NotFoundException{

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
    public Map alldep(Integer dep) {
        Map<Integer,List<Employee>> peopleDep = peoples.stream()
                .filter(employee -> dep == null || employee.getDepartment() == dep)
                .collect(Collectors.groupingBy(Employee::getDepartment));

        return peopleDep;
        }
    @Override
    public Map all() {
        Map<Integer,List<Employee>> peopleDep = peoples.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return peopleDep;
    }
    private boolean check (String firstName, String lastName) {
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))) {
            return false;

        }
        return true;
    }
}
