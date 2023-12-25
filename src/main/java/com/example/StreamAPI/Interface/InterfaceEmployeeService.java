package com.example.StreamAPI.Interface;



import com.example.StreamAPI.Model.Employee;

import java.util.Map;

public interface InterfaceEmployeeService {
    Employee add(String firstName, String lastName, Integer dep, Integer salary);
    Employee  remove(String firstName,String lastName,Integer dep,Integer salary);
    Employee  search(String firstName,String lastName,Integer dep,Integer salary);

    Map alldep(Integer dep);
    Map all();


}
