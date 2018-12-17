package com.tihor.practice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Employee entity.
 */
@Data
@Table(name = "employee", schema = "employee")
@Entity
public class EmployeeEntity {
    /**
     * Instantiates a new Employee entity.
     *
     * @param id   the id
     * @param name the name
     * @param dob  the dob
     */
    public EmployeeEntity(final Long id, final String name, final Date dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    /**
     * Instantiates a new Employee entity.
     *
     * @param name the name
     * @param dob  the dob
     */
    public EmployeeEntity(final String name, final Date dob) {
        this.name = name;
        this.dob = dob;
    }

    /**
     * Instantiates a new Employee entity.
     */
    private EmployeeEntity() {
    }

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name.
     */
    private String name;

    /**
     * Date of Birth.
     */
    private Date dob;
}
