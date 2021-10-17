package com.task.planner;

import java.util.Objects;
import java.util.UUID;

public class Task {
    private String title;
    private String creator;
    private String assignee;
    private String type;
    private TaskStatus status;
    private String duedate;
    private String id;

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }



    public Sprint getSprint() {
        return sprint;
    }

    public enum TaskStatus{
        OPEN, INPROGRESS, COMPLETED, UNKWOWN
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    private Sprint sprint;

    public Task(String title, String creator, String assignee, TaskStatus status, String type, String duedate) {
        title = title;
        creator = creator;
        assignee = assignee;
        status = status;
        type = type;
        duedate = duedate;
        this.id = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        creator = creator;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        assignee = assignee;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        duedate = duedate;
    }


    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
