package com.tihor.practice.service;

import com.tihor.practice.entity.EmployeeEntity;
import com.tihor.practice.exception.EmployeeNotFoundException;
import com.tihor.practice.mapper.EmployeeMapper;
import com.tihor.practice.model.Employee;
import com.tihor.practice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Employee service.
 */
@Service
public class EmployeeService {
    /**
     * Employee Repository.
     */
    @Resource
    private EmployeeRepository employeeRepository;

    /**
     * Gets employee by id.
     *
     * @param id the id
     * @return the employee by id
     */
    public Employee getEmployeeById(final Long id) {
        Optional<EmployeeEntity> entityOptional = employeeRepository.findById(id);
        if (!entityOptional.isPresent()) {
            throw new EmployeeNotFoundException();
        }

        return EmployeeMapper.mapEmployeeEntityToEmployee(entityOptional.get());
    }

    /**
     * Save employee employee.
     *
     * @param employee the employee
     * @return the employee
     */
    @Transactional
    public Employee saveEmployee(final Employee employee) {
        if (employee.getId() != null) {
            Optional<EmployeeEntity> entityOptional = employeeRepository.findById(employee.getId());
            if (!entityOptional.isPresent()) {
                throw new EmployeeNotFoundException();
            }
        }

        EmployeeEntity entity = EmployeeMapper.mapEmployeeToEmployeeEntity(employee);
        entity = employeeRepository.save(entity);

        return EmployeeMapper.mapEmployeeEntityToEmployee(entity);
    }

    /**
     * Delete employee by id.
     *
     * @param id the id
     */
    @Transactional
    public void deleteEmployeeById(final Long id) {
        Optional<EmployeeEntity> entityOptional = employeeRepository.findById(id);
        if (!entityOptional.isPresent()) {
            throw new EmployeeNotFoundException();
        }

        employeeRepository.delete(entityOptional.get());
    }

    /**
     * Gets all employees.
     *
     * @return the all employees
     */
    public List<Employee> getAllEmployees() {
        List<Employee> response = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(entity -> response.add(EmployeeMapper.mapEmployeeEntityToEmployee(entity)));

        return response;
    }
}
