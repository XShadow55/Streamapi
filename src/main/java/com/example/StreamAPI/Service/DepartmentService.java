package com.example.StreamAPI.Service;

import com.example.StreamAPI.Model.Employee;
import com.example.StreamAPI.Interface.InterfaceDepartmentService;
import com.example.StreamAPI.Interface.InterfaceEmployeeService;

import java.util.Comparator;

public class DepartmentService implements InterfaceDepartmentService {
    private final InterfaceEmployeeService interfaceEmployeeService;

    public DepartmentService(InterfaceEmployeeService interfaceEmployeeService) {
        this.interfaceEmployeeService = interfaceEmployeeService;
    }


    @Override
    public Object max(Integer dep) {
        return interfaceEmployeeService.alldep(dep).values().stream().max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Object min(Integer dep) {
        return interfaceEmployeeService.all().values().stream().max(Comparator.comparingInt(Employee::getSalary))
                ;
    }
    @Override
    public int sum(Integer dep) {
        return interfaceEmployeeService.alldep(dep).values().stream().mapToInt(Employee::getSalary).sum();

    }
}
