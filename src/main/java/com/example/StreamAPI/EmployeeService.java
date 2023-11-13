package com.example.peoples;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    Employee add(String firstName,String lastName);
    Employee remove(String firstName,String lastName);
    Employee search(String firstName,String lastName);
    Object[] list();

}