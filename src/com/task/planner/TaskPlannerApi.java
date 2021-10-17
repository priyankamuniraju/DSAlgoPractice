package com.task.planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskPlannerApi {

    Map<String, Sprint> sprintMap = new HashMap<>();
    Map<String, Task> allTasks = new HashMap<>();


    //create an independent task
    public Task addTask(String[] taskDetails, Sprint sprint) {
        if (taskDetails.length < 7) {
            System.out.println("Please enter a valid input");
            return null;
        }

        String title = taskDetails[1];
        String creator = taskDetails[2];
        String assignee = taskDetails[3];
        String status = taskDetails[4];
        String type = taskDetails[5];
        String dueDate = taskDetails[6];
        Task.TaskStatus parsedStatus = parseStatus(status);

        if (Utility.isEmpty(title) || Utility.isEmpty(creator) || Utility.isEmpty(assignee) || Utility.isEmpty(status) || Utility.isEmpty(type) || Utility.isEmpty(dueDate)) {
            System.out.println("Please enter valid input! some fields are empty");
            return null;
        }

        Task task = null;
        switch (type) {
            case "feature":
                String featureSummary = taskDetails[7];
                Feature.FeatureImpact impact = parseImpact(taskDetails[8]);
                task = new Feature(title, creator, assignee, parsedStatus, type, dueDate, featureSummary, impact);
                break;
            case "bug":
                Bug.Severity severity = pasrSeverity(taskDetails[7]);
                task = new Bug(title, creator, assignee, parsedStatus, type, dueDate, severity);
                break;
            case "story":
                task = new Story(title, creator, assignee, parsedStatus, type, dueDate, taskDetails[7],
                        Integer.parseInt(taskDetails[7]));
                break;

        }

        if (task == null) {
            System.out.println("Task details provided are incorrect");
            return null;
        }

        allTasks.put(task.getId(), task);
        if (sprint != null && !addTaskToSprint(task, sprint)) {
            return null;
        }
        return task;
    }

    //change status of the task
    public void changeStatus(Task task, Task.TaskStatus status) {
        task.setStatus(status);
    }

    //change asignee of the task
    public void changeAssignee(Task task, String assignee) {
        task.setAssignee(assignee);
    }

    //Display tasks assigned to a user
    public List<Task> getTasksAssignedToUser(String user) {
        List<Task> tasks = new ArrayList<>();
        if (Utility.isEmpty(user)) {
            return tasks;
        }
        for (String key : allTasks.keySet()) {
            Task task = allTasks.get(key);
            if (user.equalsIgnoreCase(task.getAssignee())) {
                tasks.add(task);
            }
        }

        return tasks;
    }

    //Display tasks assigned to a user
    public void printTasksOfUser(String userName) {
        List<Task> tasks = getTasksAssignedToUser(userName);
        System.out.println("User => " + userName);
        tasks.forEach(task -> {
            System.out.println(Utility.TAB + "Type => " + task.getType());
            System.out.println(Utility.TAB + "Title => " + task.getTitle());
            Sprint sprint = task.getSprint();
            if (sprint != null) {
                System.out.println(Utility.TAB + "Sprint => " + sprint.getName());
            } else {
                System.out.println(Utility.TAB + "Task is unassigned to any sprint");
            }

        });
    }

    //create sprint
    public Sprint createSprint(String name) {
        Sprint sprint = new Sprint(name);
        sprintMap.put(sprint.getId(), sprint);
        return sprint;
    }

    //delete sprint
    public void removeSprint(String id) {
        sprintMap.remove(id);
    }

    //add task to a sprint
    //check this method once again something modified due to ctrl+z
    public boolean addTaskToSprint(Task task, Sprint sprint) {
        String taskId = task.getId();
        for (String key : sprintMap.keySet()) {
            if (key.equalsIgnoreCase(sprint.getId())) {
                continue;
            }
            Map<String, Task> sprintTasks = sprintMap.get(key).getTasks();
            if (sprintTasks.containsKey(taskId)) {
                return false;
            }
        }
        sprint.getTasks().put(taskId, task);
        return true;
    }

    //remove task from sprint
    public boolean removeTaskFromSprint(Task task, Sprint sprint) {
        String taskId = task.getId();
        Map<String, Task> taskMap = sprint.getTasks();
        if (taskMap.containsKey(taskId)) {
            taskMap.remove(taskId);
            return true;
        }

        return false;
    }

    //Display sprint snapshot: Show tasks part of the sprint.
    public void printTasks(String sprintId) {
        Sprint sprint = sprintMap.get(sprintId);
        System.out.println("Sprint Title => " + sprint.getName());
        sprint.getTasks().forEach((k, v) -> {
            System.out.println(Utility.TAB + v.getTitle());
        });
    }


    public Feature.FeatureImpact parseImpact(String s) {
        switch (s) {
            case "low":
                return Feature.FeatureImpact.LOW;
            case "medium":
                return Feature.FeatureImpact.MEDIUM;
            case "high":
                return Feature.FeatureImpact.HIGH;
        }
        return Feature.FeatureImpact.UNKNOWN;
    }

    public Bug.Severity pasrSeverity(String s) {
        switch (s) {
            case "P1":
                return Bug.Severity.P1;
            case "P0":
                return Bug.Severity.PO;
            case "P2":
                return Bug.Severity.P2;
        }
        return Bug.Severity.UNKNOWN;
    }

    public Task.TaskStatus parseStatus(String status) {
        switch (status) {
            case "open":
                return Task.TaskStatus.OPEN;
            case "completed":
                return Task.TaskStatus.COMPLETED;
            case "inprogress":
                return Task.TaskStatus.INPROGRESS;
        }
        return Task.TaskStatus.UNKWOWN;
    }

    //get task based on taskId
    public Task getTaskfromId(String taskId){
        Task task = allTasks.get(taskId);
        return task;
    }
}
