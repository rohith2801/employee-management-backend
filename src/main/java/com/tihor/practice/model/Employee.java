package com.tihor.practice.model;

import lombok.Data;

import java.io.Serializable;

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
     * Age.
     */
    private Integer age;
}
