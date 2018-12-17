package com.tihor.practice.service;

import com.tihor.practice.entity.EmployeeEntity;
import com.tihor.practice.exception.EmployeeNotFoundException;
import com.tihor.practice.mapper.EmployeeMapper;
import com.tihor.practice.model.Employee;
import com.tihor.practice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
