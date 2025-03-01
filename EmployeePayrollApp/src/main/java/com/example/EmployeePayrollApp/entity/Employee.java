package com.example.EmployeePayrollApp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees") // Explicit table name
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID
    private Long id;

    @Column(nullable = false) // Ensures name is not null
    private String name;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private double salary;
}
