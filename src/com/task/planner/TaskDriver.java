package com.task.planner;

import java.util.*;

public class TaskDriver {

    private final TaskPlannerApi taskPlannerApi;

    public TaskDriver(TaskPlannerApi taskPlannerApi) {
        this.taskPlannerApi = taskPlannerApi;
    }

    public void readTasksFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.println("First enter sprint with name and end Enter task details in the format " +
                "title,creator,assignee,status,type," + " on every new line " +
                "dueDate \nIf the type is feature add featuresummary, if type is bug add severity and if type is story " +
                "add story storysummary,storypoints as additional fields to task" );

        int i = 0;
        while (true) {
            String str = in.nextLine();
            String[] taskDetails = str.split(",");
            if ("end".equalsIgnoreCase(str)) {
                break;
            }
            String code = taskDetails[0]; //Task Details first element is always the type of api
            switch (code) {
                case "1": //Create an independent task
                    Task task = taskPlannerApi.addTask(taskDetails, null);
                    if (task != null) {
                        System.out.println("Task is successfully created with taskId = " + task.getId());
                    } else {
                        System.out.println("Task cannot created check input!");
                    }
                    break;
                case "2": //Create a Sprint
                    Sprint sprint = taskPlannerApi.createSprint(taskDetails[1]);
                    if (sprint != null) {
                        System.out.println("Sprint is created with Id " + sprint.getId());
                    } else {
                        System.out.println("Sprint could not be created check input!");
                    }
                    break;
                case "3": //add task to a sprint
                    String taskId = taskDetails[1];
                    String sprintId = taskDetails[2];
                    if (validateSprintAndTaskId(sprintId, taskId)) {
                        Sprint sprint1 = taskPlannerApi.sprintMap.get(sprintId);
                        Task task1 = taskPlannerApi.allTasks.get(taskId);
                        taskPlannerApi.addTaskToSprint(task1, sprint1);
                        System.out.println("Task is successfully added to sprint!");
                    }
                    break;
                case "4": //Display tasks assigned to a sprint!
                     String sprintId1 = taskDetails[1];
                     if (validateSprintId(sprintId1)) {
                         taskPlannerApi.printTasks(sprintId1);
                     }
                     break;
                case "5": //Display tasks assigned to a user
                    String asignedUser= taskDetails[3];
                    taskPlannerApi.printTasksOfUser(asignedUser);
                    break;
                case "6": //Change task status
                    System.out.println("Enter the taskId of the task whose status has to be changed");
                    String idTask = in.nextLine();
                    Task task1 = taskPlannerApi.getTaskfromId(idTask);
                    Task.TaskStatus status = taskPlannerApi.parseStatus(taskDetails[3]);
                    taskPlannerApi.changeStatus(task1,status);
                    break;
                case "7": //change task asignee
                    System.out.println("Enter the taskId of the task whose asignee has to be changed");
                    String idTask2 = in.nextLine();
                    Task task2 = taskPlannerApi.getTaskfromId(idTask2);
                    String asignee = taskDetails[4];
                    taskPlannerApi.changeAssignee(task2,asignee);
                    break;
                case "8": //Remove a Sprint
                    taskPlannerApi.removeSprint(taskDetails[1]);
                    System.out.println("Sprint removed successfully !");
                    break;
                case "9": //Remove task from a sprint
                    String tasknumb = taskDetails[1];
                    String sprintnumb = taskDetails[2];
                    if (validateSprintAndTaskId(tasknumb, sprintnumb)) {
                        Sprint sprint1 = taskPlannerApi.sprintMap.get(sprintnumb);
                        Task taskid12 = taskPlannerApi.allTasks.get(tasknumb);
                        taskPlannerApi.removeTaskFromSprint(taskid12, sprint1);
                        System.out.println("Task is successfully removed from sprint!");
                    }
                    break;

                default:
                    break;
            }
        }
    }

    public boolean validateSprintId(String sprintId) {
        if (!taskPlannerApi.sprintMap.containsKey(sprintId)) {
            System.out.println("Sprint Id provided is invalid " + sprintId);
            return false;
        }
        return true;
    }

    public boolean validateTaskId(String taskId) {
        if (!taskPlannerApi.allTasks.containsKey(taskId)) {
            System.out.println("Task Id provided is invalid " + taskId);
            return false;
        }
        return true;
    }

    public boolean validateSprintAndTaskId(String sprintId, String taskId) {
        if (!validateSprintId(sprintId) || !validateTaskId(taskId)) {
            System.out.println("Invalid sprint id or task id provided for assigning task to sprint!, " +
                    "please provide valid input");
            return false;

        }
        return true;
    }

    public static void main(String[] args) {
        TaskDriver taskDriver = new TaskDriver(new TaskPlannerApi());
        taskDriver.readTasksFromConsole();
    }
}
