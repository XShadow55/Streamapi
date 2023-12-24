package com.example.StreamAPI;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.IntStream;

public class DepartmentService implements InterfaceDepartmentService{
    private final InterfaceService interfaceService;

    public DepartmentService(InterfaceService interfaceService) {
        this.interfaceService = interfaceService;
    }


    @Override
    public Optional max(Integer dep) {
        return interfaceService.alldep(dep).values().stream().max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Optional min(Integer dep) {
        return interfaceService.alldep(dep).values().stream().max(Comparator.comparing(Employee::getSalary));
    }
    @Override
    public int sum(Integer dep) {
        return interfaceService.alldep(dep).values().stream().mapToInt(Employee::getSalary).sum();

    }
}
