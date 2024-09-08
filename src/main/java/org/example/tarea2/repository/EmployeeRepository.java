package org.example.tarea2.repository;

import jakarta.transaction.Transactional;
import org.example.tarea2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE employees SET first_name = ?1, phone = ?2 WHERE id = ?3")
    void actualizarEmpleado(String firstName, String phone, Integer id);
}
