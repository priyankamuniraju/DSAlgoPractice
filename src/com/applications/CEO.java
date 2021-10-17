package com.applications;
public class CEO extends Manager {

    public CEO(String name, int id, int rating, int salary) {
        super(name, id, rating, salary);
    }

    @Override
    public Manager getManager() throws ManagerDoesNotExist {
        throw new ManagerDoesNotExist("CEO Cannot have a Manager!");
    }

    @Override
    public void setManager(Manager manager) throws CannotSetManager{
        throw new CannotSetManager("Cannot set manager to CEO");
    }
}
