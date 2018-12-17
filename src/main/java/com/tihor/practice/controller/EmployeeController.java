package com.tihor.practice.controller;

import com.tihor.practice.model.Employee;
import com.tihor.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Employee controller.
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    /**
     * Employee Service.
     */
    private EmployeeService employeeService;

    /**
     * Instantiates a new Employee controller.
     *
     * @param employeeService the employee service
     */
    @Autowired
    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Gets all employees.
     *
     * @return the all employees
     */
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    /**
     * Gets employee by id.
     *
     * @param id the id
     * @return the employee by id
     */
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable final Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    /**
     * Create employee response entity.
     *
     * @param employee the employee
     * @return the response entity
     */
    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody final Employee employee) {
        employee.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.saveEmployee(employee));
    }

    /**
     * Create employee response entity.
     *
     * @param id       the id
     * @param employee the employee
     * @return the response entity
     */
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> createEmployee(@PathVariable final Long id, @RequestBody final Employee employee) {
        employee.setId(id);
        return ResponseEntity.ok()
                .body(employeeService.saveEmployee(employee));
    }

    /**
     * Delete employee response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/employee/{id}")
    public ResponseEntity deleteEmployee(@PathVariable final Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }
}
