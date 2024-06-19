package com.curd.controllers;

import com.curd.entities.Employee;
import com.curd.services.EmpService;
import com.curd.services.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {

    @Autowired
    private EmpService service;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmp(@RequestBody Employee employee){
        employee = service.saveEmp(employee);
        if( employee != null )
        return new ResponseEntity<>(service.saveEmp(employee), HttpStatus.CREATED);
        else return new ResponseEntity<>(service.saveEmp(employee), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmpDetail(@PathVariable Integer id){
        Employee emp = service.getEmployeeById(id);
        if(emp!=null)
            return new ResponseEntity<>(emp,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public List<Employee> getAllEmployees(){
        return service.getAllEmployee();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        Employee emp = service.getEmployeeById(id);
        if(emp != null){
            emp.setName(employee.getName());
            emp.setCity(employee.getCity());
            emp = service.saveEmp(emp);
            return new ResponseEntity<>(emp,HttpStatus.ACCEPTED);
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id){
        Employee emp = service.getEmployeeById(id);
        if(emp != null){
            service.deleteEmployee(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
