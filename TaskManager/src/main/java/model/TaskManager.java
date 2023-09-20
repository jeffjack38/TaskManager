/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Sep 20, 2023
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	//set list to store tasks
    private static List<Task> tasks = new ArrayList<>();
    //variable that will assign unique IDs to tasks
    private static int nextId = 1;

    //method that will return a list of all tasks
    public static List<Task> getAllTasks() {
        return tasks;
    }

    //addTask() method take Task variables and set next Id and from list tasks add from Task task class
    public static void addTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
    }
    
    //updateTask() will update an existing task based on its ID.
    public static void updateTask(Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId() == updatedTask.getId()) {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setStatus(updatedTask.getStatus());
                return;
            }
        }
    }

    //deleteTask() method that will delete a task based on ID
    public static void deleteTask(int taskId) {
        tasks.removeIf(task -> task.getId() == taskId);
    }
}