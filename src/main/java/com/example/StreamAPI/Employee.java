package com.example.StreamAPI;

public class Employee {
    private String firstName;
    private String lastName;
    private String surName;
    private int department;
    private int salary;
    private int id;
    private static int count = 0;

    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.department = department;
        this.salary = salary;
        id = count;
        ++count;

    }

    @Override
    public String toString() {
        return   " " + firstName + " " + lastName  +" "+ department + " " + salary;
    }

    public String toString1() {
        return lastName + " " + firstName + " " + salary ;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurName() {
        return surName;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
