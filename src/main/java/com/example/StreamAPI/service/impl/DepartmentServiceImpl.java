package com.example.StreamAPI.service.impl;

import com.example.StreamAPI.model.Employee;
import com.example.StreamAPI.service.DepartmentService;
import com.example.StreamAPI.service.EmployeeService;

import java.util.*;

public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public int max(Integer dep) {

         return employeeService.all().get(dep).stream()
                 .mapToInt(Employee::getSalary).max().getAsInt()
                 ;
    }

    @Override
    public int min(Integer dep) {
        return employeeService.all().get(dep).stream()
                .mapToInt(Employee::getSalary).min().getAsInt()
                ;
    }
    @Override
    public int sum(Integer dep) {
        return employeeService.all().get(dep).stream()
                .mapToInt(Employee::getSalary).sum();

    }
    @Override
    public List<Employee> alldep(Integer dep) {
        return employeeService.all().get(dep);
    }
}
