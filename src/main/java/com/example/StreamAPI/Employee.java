package com.example.StreamAPI;

public class Employee {
    private String firstName;
    private String lastName;

    private int department;
    private int salary;


    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;


    }


    @Override
    public String toString() {
        return " " + firstName + " " + lastName  + " " + salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}


