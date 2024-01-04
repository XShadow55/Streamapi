package com.example.StreamAPI.service;

import com.example.StreamAPI.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    int max(Integer dep);
    int min(Integer dep);
    int sum(Integer dep);
    List<Employee> alldep(Integer dep);
}
