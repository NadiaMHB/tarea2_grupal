package org.example.tarea2.controller;

import org.example.tarea2.entity.Employee;
import org.example.tarea2.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
public class EmployeesController {

    final EmployeeRepository employeeRepository;
    public EmployeesController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Listar todos los empleados
    @GetMapping({"employee/list", "employee"})
    public String listarEmpleados(Model model) {
        List<Employee> lista = employeeRepository.findAll();
        model.addAttribute("employeeList", lista);
        return "employee/list";
    }

    @GetMapping("employee/info")
    public String informEmpleado(Model model, @RequestParam("id") int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            model.addAttribute("employee", employee);
            return "employee/info";
        } else {
            return "redirect:/employee/list";
        }
    }

    @PostMapping("/employee/save")
    public String guardarEmpleado(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employee/list";
    }


    @GetMapping("/employee/delete")
    public String borrarEmpleado(Model model,
                                      @RequestParam("id") int id) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            employeeRepository.deleteById(id);
            model.addAttribute("tipo_alert", "success");
            model.addAttribute("msg", "Se borro el empleado");
        }
        return "redirect:/employee/list";

    }


}
