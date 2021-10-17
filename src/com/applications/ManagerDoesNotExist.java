package com.applications;

public class ManagerDoesNotExist extends Exception {
    ManagerDoesNotExist(String message) {
        super(message);
    }
}
