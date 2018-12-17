package com.tihor.practice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Employee.
 */
@Data
public class Employee implements Serializable {
    /**
     * Id.
     */
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
