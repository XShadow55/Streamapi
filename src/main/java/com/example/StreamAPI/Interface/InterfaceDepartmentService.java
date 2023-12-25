package com.example.StreamAPI.Interface;

import java.util.Map;
import java.util.Optional;

public interface InterfaceDepartmentService {
    Object max(Integer dep);
    Object min(Integer dep);
    int sum(Integer dep);
    Map alldep(Integer dep);
}
