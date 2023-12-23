package com.example.StreamAPI;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class EmployeeServis implements DepartmentService{
    private final Map<Integer,Employee> peoples = new HashMap<>();
    @Override
    public Employee add(String firstName, String lastName, Integer dep, Integer salary) throws AlreadyAddedException {
        Employee a = new Employee(firstName,lastName,dep,salary);
        if (peoples.containsValue(a)){
            throw new AlreadyAddedException("Содрудник уже добавлен!");
        }

        peoples.put(a.getDepartment(),a);
        return a;
    }

    @Override
    public Employee remove(String firstName, String lastName, Integer dep, Integer salary) throws NotFoundException{

        Employee a = new Employee(firstName,lastName,dep,salary);
        if (!peoples.containsValue(a)){
            throw new NotFoundException();
        }
        peoples.remove(a);
        return a;
    }

    @Override
    public Employee search(String firstName, String lastName, Integer dep, Integer salary)throws NotFoundException {

        Employee a = new Employee(firstName,lastName,dep,salary);
        if (!peoples.containsValue(a)){
            throw new NotFoundException();
        }
        return a;
    }

    @Override
    public int max(Integer dep) {
        return max(peoples.get(dep).getDepartment());
    }

    @Override
    public int min(Integer dep) {
        return min(peoples.get(dep).getDepartment());}
    @Override
    public int sum(Integer dep) {
        return sum(peoples.get(dep).getDepartment());
    }
    @Override
    public Employee alldep(Integer dep) {
        return peoples.get(dep);
        }
    @Override
    public Map all() {
        return peoples;
    }
}
