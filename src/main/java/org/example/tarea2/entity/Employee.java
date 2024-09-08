package org.example.tarea2.entity;


import jakarta.persistence.*;

@Entity
@Table(name ="employee" )
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;

    @Column(name = "email", length = 25, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 65, nullable = false)
    private String password;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "hire_date", nullable = false)
    private java.sql.Timestamp hireDate;

    @Column(name = "job_id", length = 10)
    private String jobId;

    @Column(name = "salary", precision = 8, scale = 2)
    private java.math.BigDecimal salary;

    @Column(name = "commission_pct", precision = 2, scale = 2)
    private java.math.BigDecimal commissionPct;

    @Column(name = "manager_id")
    private Integer managerId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;

    @Column(name = "enabled", nullable = false)
    private Integer enabled;



}
