package com.example.StreamAPI;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    String  add(String firstName, String lastName,Integer dep,Integer salary);
    String  remove(String firstName,String lastName,Integer dep,Integer salary);
    String  search(String firstName,String lastName,Integer dep,Integer salary);
    String max(Integer dep);
    String  min(Integer dep);
    Object[]  alldep(Integer dep);
    Object[] list();

}