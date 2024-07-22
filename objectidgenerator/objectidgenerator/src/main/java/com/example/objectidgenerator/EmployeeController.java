package com.example.objectidgenerator;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    @GetMapping("/api/employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    @PostMapping("/api/employees")
    public void saveEmployees(@RequestBody List<Employee> employees) {
        this.employees = employees;
    }

    @PatchMapping("/api/employees/{id}")
    public void updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                Employee employee = employees.get(i);
                if (updatedEmployee.getName() != null) {
                    employee.setName(updatedEmployee.getName());
                }
                if (updatedEmployee.getPosition() != null) {
                    employee.setPosition(updatedEmployee.getPosition());
                }
                if (updatedEmployee.getSalary() != 0) {
                    employee.setSalary(updatedEmployee.getSalary());
                }
                employees.set(i, employee);
                break;
            }
        }
    }
}