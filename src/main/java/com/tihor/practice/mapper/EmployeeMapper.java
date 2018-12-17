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

    /**
     * Map employee to employee entity employee entity.
     *
     * @param employee the employee
     * @return the employee entity
     */
    public static EmployeeEntity mapEmployeeToEmployeeEntity(final Employee employee) {
        return new EmployeeEntity(employee.getId(), employee.getName(), employee.getDob());
    }
}
