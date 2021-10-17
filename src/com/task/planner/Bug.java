package com.task.planner;

public class Bug extends Task{

    private Severity severity;

    public Bug(String title, String creator, String assignee, TaskStatus status, String type, String duedate, Severity severity) {
        super(title, creator, assignee, status, type, duedate);
        this.severity = severity;
    }

    public enum Severity {
        PO, P1, P2, UNKNOWN
    }
}
