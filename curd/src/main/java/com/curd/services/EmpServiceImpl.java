package com.curd.services;

import com.curd.entities.Employee;
import com.curd.exceptions.ResourceNotFoundException;
import com.curd.repositories.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpRepository empRepository;

    @Override
    public Employee saveEmp(Employee employee) {
        return empRepository.save(employee);
    }


    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> byId = empRepository.findById(id);
        return byId.orElseThrow(()-> new ResourceNotFoundException("Employee is not found on given Id on server"));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return empRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        return empRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        empRepository.deleteById(id);
    }
}
