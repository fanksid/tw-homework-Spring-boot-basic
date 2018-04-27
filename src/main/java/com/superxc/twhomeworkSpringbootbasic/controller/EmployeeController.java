package com.superxc.twhomeworkSpringbootbasic.controller;

import com.superxc.twhomeworkSpringbootbasic.domain.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class EmployeeController {

    // The reason to use TreeMap is that want employees sorted by ID
    // Map<ID, Employee>
    private Map<Long, Employee> employees = new TreeMap<>();

    /**
     * Get employees list
     * @return employees list
     */
    @GetMapping(value = "/employees")
    public List<Employee> list() {
        return new ArrayList<>(employees.values());
    }

    /**
     * Add employee
     * @param employee want to added
     * @return added employee
     */
    @PostMapping(value = "/employees")
    public Employee add(@ModelAttribute Employee employee) {
        // do not allow custom employee id
        if (employee.getId() != null) {
            return null;
        }

        employee.generateId();
        employees.put(employee.getId(), employee);
        return employee;
    }

    /**
     * Delete employee
     * @param id employee id
     * @return deleted employee
     */
    @DeleteMapping(value = "/employees/{id}")
    public Employee delete(@PathVariable Long id) {
        Employee employee = employees.get(id);
        employees.remove(id);
        return  employee;
    }

    /**
     * Update exist employee
     * @param id employee id
     * @param employeeNew new employee data
     * @return updated employee
     */
    @PutMapping(value = "/employees/{id}")
    public Employee update(@PathVariable Long id, @ModelAttribute Employee employeeNew) {
        Employee employeeOld = employees.remove(employeeNew.getId());
        if (employeeOld == null) {
            return null;
        }
        employees.put(employeeNew.getId(), employeeNew);
        return employeeNew;
    }

    /**
     * Get an employee
     * @param id employee id
     * @return employee
     */
    @GetMapping(value = "/employees/{id}")
    public Employee get(@PathVariable Long id) {
        return employees.get(id);
    }
}
