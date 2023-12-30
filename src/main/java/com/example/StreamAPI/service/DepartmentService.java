package com.example.StreamAPI.service;

import com.example.StreamAPI.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Object max(Integer dep);
    Object min(Integer dep);
    int sum(Integer dep);
    Map<Integer, List<Employee>> alldep(Integer dep);
}
