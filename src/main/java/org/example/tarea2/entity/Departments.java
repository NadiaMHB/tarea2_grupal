package org.example.tarea2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", unique = true)
    private Integer departmentId;

    @Column(name = "department_name", length = 30)
    private String departmentName;

    @Column(name = "manager_id")
    private Integer managerId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations location;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
