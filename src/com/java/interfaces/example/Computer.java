package com.java.interfaces.example;

interface DisplayModule{
    public void display();
}

class Monitor implements DisplayModule{
    @Override
    public void display() {
        System.out.println("Display through monitor");
    }
}

class Projector implements DisplayModule{
    @Override
    public void display() {
        System.out.println("Display through projector");
    }
}

public class Computer {
    DisplayModule displayModule ;
    public void setDisplayModule(DisplayModule displayModule){
        this.displayModule = displayModule;
    }
    public void getdisplay(){
        displayModule.display();
    }
    public static void main(String args[]){
        Computer computer = new Computer();
        DisplayModule displayModuleMon = new Monitor();
        DisplayModule displayModuleProj = new Projector();

        computer.setDisplayModule(displayModuleMon);
        computer.getdisplay();
        computer.setDisplayModule(displayModuleProj);
        computer.getdisplay();
    }
}
