package com.applications;

public class Employee {
    private String name;
    private final int id;
    private int rating;
    private int salary;

    public Employee(String name, int id, int rating, int salary) {
        this.name = name;
        this.id = id;
        this.rating = rating;
        this.salary = salary;
    }

    private Manager manager;

    public Manager getManager() throws ManagerDoesNotExist {
        return manager;
    }

    public void setManager(Manager manager) throws CannotSetManager {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", rating=" + rating +
                ", salary=" + salary +
                ", manager=" + manager +
                '}';
    }
}
