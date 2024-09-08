package org.example.tarea2.controller;

import org.example.tarea2.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EmployeesController {

    final EmployeeRepository employeeRepository;
    public EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping({"employee/list", "employee"})
    public String listarEmpleados() {
//        COMPLETAR
        return "XXXXXX";
    }

    @GetMapping("")
    public String informEmpleado() {
        //        COMPLETAR
        return "XXXXXX";
    }

    @GetMapping("")
    public String borrarEmpleado(Model model) {
        model.addAttribute("tipo_alert", "success");
        model.addAttribute("msg", "Se borro el empleado");
//        COMPLETAR
        return "XXXXXX";
    }
}
