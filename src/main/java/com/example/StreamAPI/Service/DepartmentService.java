package com.example.StreamAPI.Service;

import com.example.StreamAPI.Model.Employee;
import com.example.StreamAPI.Interface.InterfaceDepartmentService;
import com.example.StreamAPI.Interface.InterfaceEmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentService implements InterfaceDepartmentService {
    private final InterfaceEmployeeService interfaceEmployeeService;

    public DepartmentService(InterfaceEmployeeService interfaceEmployeeService) {
        this.interfaceEmployeeService = interfaceEmployeeService;
    }


    @Override
    public Object max(Integer dep) {
        return interfaceEmployeeService.all().values().stream()
                .filter( employee -> employee.getDepartment() == dep)
                .max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Object min(Integer dep) {
        return interfaceEmployeeService.all().values().stream()
                .filter((Employee employee) -> employee.getDepartment() == dep)
                .max(Comparator.comparingInt(Employee::getSalary))
                ;
    }
    @Override
    public int sum(Integer dep) {
        return interfaceEmployeeService.all().values().stream()
                .filter((Employee employee) -> employee.getDepartment() == dep)
                .mapToInt(Employee::getSalary).sum();

    }
    @Override
    public Map<Integer, List<Employee>> alldep(Integer dep) {
        Map<Integer, List<Employee>> peopleDep = interfaceEmployeeService.all().values().stream()
                .filter( employee -> dep == null || employee.getDepartment() == dep)
                .collect(Collectors.groupingBy(Employee::getDepartment));

        return peopleDep;
    }
}
