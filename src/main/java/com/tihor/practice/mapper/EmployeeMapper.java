package com.tihor.practice.mapper;

import com.tihor.practice.entity.EmployeeEntity;
import com.tihor.practice.model.Employee;
import org.springframework.beans.BeanUtils;

/**
 * The type Employee mapper.
 */
public final class EmployeeMapper {
    /**
     * Map employee entity to employee employee.
     *
     * @param entity the entity
     * @return the employee
     */
    public static Employee mapEmployeeEntityToEmployee(final EmployeeEntity entity) {
        final Employee response = new Employee();
        BeanUtils.copyProperties(entity, response);

        return response;
    }
}
