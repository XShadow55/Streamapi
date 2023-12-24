package com.example.StreamAPI;



import java.util.Map;
import java.util.Optional;

public interface InterfaceService {
    Employee  add(String firstName, String lastName,Integer dep,Integer salary);
    Employee  remove(String firstName,String lastName,Integer dep,Integer salary);
    Employee  search(String firstName,String lastName,Integer dep,Integer salary);

    Map alldep(Integer dep);
    Map all();


}
