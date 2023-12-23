package com.example.StreamAPI;



import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    Employee  add(String firstName, String lastName,Integer dep,Integer salary);
    Employee  remove(String firstName,String lastName,Integer dep,Integer salary);
    Employee  search(String firstName,String lastName,Integer dep,Integer salary);
    int max(Integer dep);
    int min(Integer dep);
    int sum(Integer dep);
    Employee alldep(Integer dep);
    Map all();


}
