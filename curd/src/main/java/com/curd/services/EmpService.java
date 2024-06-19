package com.curd.services;

import com.curd.entities.Employee;

import java.util.List;

public interface EmpService {

    public Employee saveEmp(Employee employee);

    public Employee getEmployeeById(Integer id);

    public List<Employee> getAllEmployee();

    public Employee updateEmployee(Integer id, Employee employee);

    public void deleteEmployee(Integer id);


}
