package com.tihor.practice.repository;

import com.tihor.practice.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Employee repository.
 */
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
}
