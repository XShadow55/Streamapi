package com.example.StreamAPI;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class EmployeeServis implements DepartmentService{
    private final List<Employee> people = new ArrayList<>();
    @Override
    public Employee add(String firstName, String lastName, Integer dep, Integer salary) throws AlreadyAddedException {
        if (chect(firstName,lastName) == false){
            throw new AlreadyAddedException();
        }
        Employee a = new Employee(firstName,lastName,dep,salary);
        people.add(a);
        return a;
    }

    @Override
    public Employee remove(String firstName, String lastName, Integer dep, Integer salary) throws AlreadyAddedException{
        chect(firstName,lastName);
        Employee a = new Employee(firstName,lastName,dep,salary);
        people.remove(a);
        return a;
    }

    @Override
    public Employee search(String firstName, String lastName, Integer dep, Integer salary)throws AlreadyAddedException {
        chect(firstName,lastName);
        Employee a = new Employee(firstName,lastName,dep,salary);
        if (people.contains(a)){
            return a;
        }
        else {
            return null;
        }
    }

    @Override
    public Optional<Employee> max(Integer dep) {
        return people.stream().filter(people -> people.getDepartment() == dep).max(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Optional<Employee> min(Integer dep) {
        return people.stream().filter(people -> people.getDepartment() == dep).min(Comparator.comparing(Employee::getSalary));
    }
    @Override
    public int sum(Integer dep) {
        IntStream salary = people.stream().filter(people -> people.getDepartment() == dep).mapToInt(Employee::getSalary);
        return salary.sum();
    }



    @Override
    public Map alldep(Integer dep) {
        Map<Integer,List<Employee>> peopleDep = people.stream()
                .filter(employee -> dep == null || employee.getDepartment() == dep)
                .collect(Collectors.groupingBy(Employee::getDepartment));

        return peopleDep;


        }


    @Override
    public Map all() {
        Map<Integer,List<Employee>> peopleDep = people.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));


        return peopleDep;


    }

    private boolean chect (String firstName, String lastName){
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))){
            return false;

        }


        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeServis that = (EmployeeServis) o;
        return Objects.equals(people, that.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(people);
    }
}
