package com.example.StreamAPI;

import com.example.StreamAPI.model.Employee;
import com.example.StreamAPI.service.impl.DepartmentServiceImpl;
import com.example.StreamAPI.service.impl.EmployeeServisImpl;
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
    int sum = maxSalary+minSalary+65000+15000;
    @Mock
    private EmployeeServisImpl employeeServisImpl;
    @InjectMocks
    private DepartmentServiceImpl departmentServiceImpl;
    private List<Employee> testList = new ArrayList<>(){{
        add(new Employee("dd","dd1",1,10000));
        add(new Employee("dd","dd2",1,15000));
        add(new Employee("dd","dd3",1,65000));
        add(new Employee("dd","dd4",1,100000));
    }};

    @Test
    void maxSalaryTest(){
        Map<Integer,List<Employee>> test = new HashMap<>();
        test.put(1,testList);
        when(employeeServisImpl.all()).thenReturn(test);
        Object max = departmentServiceImpl.max(department);
        Assertions.assertEquals(maxSalary,max);

    }
    @Test
    void minSalaryTest(){
        Map<Integer,List<Employee>> test = new HashMap<>();
        test.put(1,testList);
        when(employeeServisImpl.all()).thenReturn(test);
        Object min = departmentServiceImpl.min(department);
        Assertions.assertEquals(minSalary,min);

    }
    @Test
    void sumSalaryTest(){
        Map<Integer,List<Employee>> test = new HashMap<>();
        test.put(1,testList);
        when(employeeServisImpl.all()).thenReturn(test);
        int  summ = departmentServiceImpl.sum(department);
        Assertions.assertEquals(sum,summ);
    }
    @Test
    void allEmployeeTest(){
        Map<Integer,List<Employee>> test = new HashMap<>();
        test.put(1,testList);
        when(employeeServisImpl.all()).thenReturn(test);
        List  people = departmentServiceImpl.alldep(department);
        Assertions.assertEquals(people,testList);
    }
}
