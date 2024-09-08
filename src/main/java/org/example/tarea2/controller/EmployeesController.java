package org.example.tarea2.controller;

import org.example.tarea2.entity.Employee;
import org.example.tarea2.entity.JobHistory;
import org.example.tarea2.entity.Jobs;
import org.example.tarea2.repository.EmployeeRepository;
import org.example.tarea2.repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
public class EmployeesController {

    // Reposirotorios
    final JobRepository jobRepository;
    final EmployeeRepository employeeRepository;

    public EmployeesController(EmployeeRepository employeeRepository, JobRepository jobRepository) {
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
    }

    // Listar todos los empleados
    @GetMapping({"employee/list", "employee"})
    public String listarEmpleados(Model model) {
        List<Employee> lista = employeeRepository.findByEnabled(1);

        model.addAttribute("employeeList", lista);
        return "employee/list";
    }

    @GetMapping("employee/info")
    public String informEmpleado(Model model, @RequestParam("id") int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            //List<Jobs> jobs = jobRepository.findAll();
            model.addAttribute("employee", employee);
            //model.addAttribute("jobs", jobs);

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
                                      @RequestParam("id") int id, RedirectAttributes redirectAttributes) {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {

            Employee employee = optionalEmployee.get();
            //employeeRepository.deleteById(id);
            employee.setEnabled(0);

            employeeRepository.save(employee);

            redirectAttributes.addFlashAttribute("tipo_alert", "success");
            redirectAttributes.addFlashAttribute("msg", "Se borro el empleado");
        }
        return "redirect:/employee/list";

    }


}
