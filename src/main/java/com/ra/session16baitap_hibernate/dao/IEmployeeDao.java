package com.ra.session16baitap_hibernate.dao;

import com.ra.session16baitap_hibernate.orm.Employee;

import java.util.List;

public interface IEmployeeDao
{
    List<Employee> findAll();

    Employee findById(Integer id);

    boolean insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(Integer id);

    List<Employee> searchByName(String name);
}
