package com.example.StreamAPI;

import com.example.StreamAPI.Model.Employee;
import com.example.StreamAPI.Service.DepartmentService;
import com.example.StreamAPI.Service.EmployeeServis;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiseTest {
    int department = 1;
    int maxSalary = 100_000;
    int minSalary = 10_000;
    @Mock
    private EmployeeServis employeeServis;
    @InjectMocks
    private DepartmentService departmentService;
    private List<Employee> testList = new ArrayList<>(){{
        add(new Employee("dd","dd1",1,10000));
        add(new Employee("dd","dd2",1,15000));
        add(new Employee("dd","dd3",1,65000));
        add(new Employee("dd","dd4",1,100000));
    }};

    @Test
    void maxSalaryTest(){
        Map<Integer,Employee> test = new HashMap<>();
        for(Employee employee: testList){
            test.put(employee.getDepartment(),employee);
        }
        when(employeeServis.alldep(department)).thenReturn(test);
        Object max = departmentService.max(department);
        Assertions.assertEquals(maxSalary,max);

    }
    @Test
    void minSalaryTest(){
        Map<Integer,Employee> test = new HashMap<>();
        for(Employee employee: testList){
            test.put(employee.getDepartment(),employee);
        }
        when(employeeServis.alldep(department)).thenReturn(test);
        Object min = departmentService.min(department);
        Assertions.assertEquals(minSalary,min);

    }
}
