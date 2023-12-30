package com.example.StreamAPI.service.impl;

import com.example.StreamAPI.model.Employee;
import com.example.StreamAPI.service.DepartmentService;
import com.example.StreamAPI.service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Object max(Integer dep) {
        return employeeService.all().values().stream()
                .filter( employee -> employee.getDepartment() == dep)
                .max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Object min(Integer dep) {
        return employeeService.all().values().stream()
                .filter((Employee employee) -> employee.getDepartment() == dep)
                .max(Comparator.comparingInt(Employee::getSalary))
                ;
    }
    @Override
    public int sum(Integer dep) {
        return employeeService.all().values().stream()
                .filter((Employee employee) -> employee.getDepartment() == dep)
                .mapToInt(Employee::getSalary).sum();

    }
    @Override
    public Map<Integer, List<Employee>> alldep(Integer dep) {
        Map<Integer, List<Employee>> peopleDep = employeeService.all().values().stream()
                .filter( employee -> dep == null || employee.getDepartment() == dep)
                .collect(Collectors.groupingBy(Employee::getDepartment));

        return peopleDep;
    }
}
