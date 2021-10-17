package com.applications;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Manager extends Employee{

    private Map<Integer, Employee> employeeList;

    public Manager(String name, int id, int rating, int salary) {
        super(name, id, rating, salary);
        this.employeeList = new HashMap<>();
    }

    public void addEmployee(Employee employee){
        employeeList.put(employee.getId(), employee);
    }

    public void removeEmployee(Employee employee){
        employeeList.remove(employee.getId());
    }

    public Employee getEmployee(int id) {
        return employeeList.get(id);
    }

    public Map<Integer, Employee> getEmployeeList() {
        return employeeList;
    }

}
