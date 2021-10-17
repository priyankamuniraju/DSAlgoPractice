package com.applications;

import com.algorithms.example.Utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompanyDriver {

    CEO ceo;
    Map<Integer, Employee> allEmployeeMap = new HashMap<>();

    public CEO getCeo() {
        return ceo;
    }

    public void setCeo(CEO ceo) {
        this.ceo = ceo;
    }

    public void addEmployeesUnderCEO() throws CannotSetManager, ManagerDoesNotExist {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the employee name, id, salary, rating, managerId, isManager - in the same order, separated by commas");

        while (true) {
            String str = in.nextLine();
            String[] empInfoList = str.split(",");
            if ("end".equalsIgnoreCase(str)) {
                break;
            }
            addEmployee(empInfoList);
        }
    }

    public void generateEmployees() throws CannotSetManager, ManagerDoesNotExist {
        String[] names = new String[]{"Jag", "sne"};
        int[] salaries = Utility.generateRandomArray(8, 50000);
        int[] ratings = Utility.generateRandomArray(8, 10);
        for (int i = 0; i < 8; i++) {
            String[] empDetails = new String[6];
            empDetails[0] = names[i];
            empDetails[1] = String.valueOf(i + 2);
            empDetails[2] = String.valueOf(salaries[i]);
            empDetails[3] = String.valueOf(ratings[i]);
            if (i < 2) {
                empDetails[4] = String.valueOf(1);
                empDetails[5] = "TRUE";
            } else {
                if (i % 2 == 0) {
                    empDetails[4] = String.valueOf(2);
                } else {
                    empDetails[4] = String.valueOf(3);
                }
                empDetails[5] = "FALSE";
            }
            addEmployee(empDetails);
        }
    }

    public void addEmployee(String[] empInfoList) throws ManagerDoesNotExist, CannotSetManager {
        if (empInfoList.length != 6) {
            System.out.println("Please enter a valid input");
            return;
        }

        String name = empInfoList[0];
        int empId = Integer.parseInt(empInfoList[1]);
        int salary = Integer.parseInt(empInfoList[2]);
        int rating = Integer.parseInt(empInfoList[3]);
        int mId = Integer.parseInt(empInfoList[4]);
        boolean isManager = Boolean.parseBoolean(empInfoList[5]);

        Employee existingEmp = allEmployeeMap.get(mId);
        Manager manager = null;
        if (!(existingEmp instanceof Manager)) {
            System.out.println("Please enter a valid input, managerId is invalid!");
            return;
        }
        manager = (Manager) existingEmp;

        Employee emp = allEmployeeMap.get(empId);
        if (emp != null) {
            emp.setSalary(salary);
            emp.setRating(rating);
            Manager currentMgr = emp.getManager();
            currentMgr.removeEmployee(emp);
            emp.setManager(manager);
            manager.addEmployee(emp);
        } else {
            if (isManager) {
                emp = new Manager(name, empId, rating, salary);
            } else {
                emp = new Employee(name, empId, rating, salary);
            }
            manager.addEmployee(emp);
            allEmployeeMap.put(empId, emp);
        }
    }

    public void printEmployeeHierarchy(Employee emp) throws ManagerDoesNotExist {
        if (emp instanceof Manager) {
            System.out.println(emp);
            Map<Integer, Employee> employeeMap = ((Manager) emp).getEmployeeList();
            System.out.println(employeeMap);
            Manager manager = emp.getManager();
            if (manager != null) {
                printEmployeeHierarchy(manager);
            }
        } else {
            System.out.println(emp);
        }
    }


    public static void main(String[] args) throws CannotSetManager, ManagerDoesNotExist {
        CompanyDriver companyDriver = new CompanyDriver();
        CEO ceo = new CEO("Pri", 1, 5, 1000000);
        companyDriver.setCeo(ceo);
        companyDriver.allEmployeeMap.put(1, ceo);
        companyDriver.generateEmployees();
        companyDriver.printEmployeeHierarchy(companyDriver.allEmployeeMap.get(6));
    }

}

