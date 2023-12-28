package com.example.StreamAPI.Interface;

import com.example.StreamAPI.Model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InterfaceDepartmentService {
    Object max(Integer dep);
    Object min(Integer dep);
    int sum(Integer dep);
    Map<Integer, List<Employee>> alldep(Integer dep);
}
