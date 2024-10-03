package com.luv2code.employeedemo.dao;

import com.luv2code.employeedemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee theEmployee);

    Employee findByid(Integer id);

    List<Employee> findAll();

    List<Employee> findByLastname(String theLastName);

    void update(Employee theEmployee);

    void delete(Integer id);

    int deleteAll();
}
