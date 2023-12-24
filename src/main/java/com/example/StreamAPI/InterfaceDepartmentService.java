package com.example.StreamAPI;

import java.util.Optional;

public interface InterfaceDepartmentService {
    Optional max(Integer dep);
    Optional min(Integer dep);
    int sum(Integer dep);
}
