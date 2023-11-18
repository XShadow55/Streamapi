package com.example.StreamAPI;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeService {
    Employee  add(String firstName, String lastName,Integer dep,Integer salary);
    Employee  remove(String firstName,String lastName,Integer dep,Integer salary);
    Employee  search(String firstName,String lastName,Integer dep,Integer salary);
    Optional<Employee> max(Integer dep);
    Optional<Employee> min(Integer dep);
    Map alldep(Integer dep);
    Map all();


}