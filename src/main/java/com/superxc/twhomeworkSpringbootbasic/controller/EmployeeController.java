package com.superxc.twhomeworkSpringbootbasic.controller;

import com.superxc.twhomeworkSpringbootbasic.domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
public class EmployeeController {

    private Map<Integer, Employee> employees = new TreeMap<>();

    /**
     * 查看雇员列表
     * @return
     */
    @GetMapping(value = "/employees")
    public List<Employee> list() {
        return new ArrayList<>(employees.values());
    }


}
