/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task.tracker;

/**
 *
 * @Ronald Kiplangat
 * github.com/RonKirui
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import task.tracker.handlers.TaskManager;
import task.tracker.models.Task;

public class TaskTracker implements TaskInterface{
    private static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tasks = TaskManager.loadTasks(); // Load existing tasks
        tasks = new ArrayList<>(tasks); //Make a mutable list
        
        System.out.println("Welcome to Task Tracker CLI!");
        while (true) {
            System.out.println("\n1 - Add Task");
            System.out.println("2 - Update Task");
            System.out.println("3 - Delete Task");
            System.out.println("4 - Mark Task as In Progress");
            System.out.println("5 - Mark Task as Done");
            System.out.println("6 - List All Tasks");
            System.out.println("7 - List Done Tasks");
            System.out.println("8 - List Not Done Tasks");
            System.out.println("9 - List In Progress Tasks");
            System.out.println("0 - Exit");

            System.out.print("> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            TaskTracker tsk = new TaskTracker();
            switch (choice) {
                case 1 -> tsk.Add (scanner);
                case 2 -> tsk.Update(scanner);
                case 3 -> tsk.Delete(scanner);
                case 4 -> tsk.ChangeStatus(scanner, "in-progress");
                case 5 -> tsk.ChangeStatus(scanner, "done");
                case 6 -> tsk.List("all");
                case 7 -> tsk.List("done");
                case 8 -> tsk.List("todo");
                case 9 -> tsk.List("in-progress");
                case 0 -> {
                    TaskManager.saveTasks(tasks);
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    
    @Override
    public void Add(Scanner scanner) {
    System.out.print("Enter task title: ");
    String title = scanner.nextLine();
    Task task = new Task(tasks.size() + 1, title, "todo");
    tasks.add(task);
    TaskManager.saveTasks(tasks);
    System.out.println("Task added successfully!");
}

    @Override
    public void Update(Scanner scanner) {
    System.out.print("Enter Task ID to update: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    for (Task task : tasks) {
        if (task.getId() == id) {
            System.out.print("Enter new title: ");
            String newTitle = scanner.nextLine();
            task.setTitle(newTitle);
            TaskManager.saveTasks(tasks);
            System.out.println("Task updated successfully!");
            return;
        }
    }
    System.out.println("Task not found!");
}

    @Override
    public void Delete(Scanner scanner) {
    System.out.print("Enter Task ID to delete: ");
    int id = scanner.nextInt();
    tasks.removeIf(task -> task.getId() == id);
    TaskManager.saveTasks(tasks);
    System.out.println("Task deleted successfully!");
}
    @Override
    public void ChangeStatus(Scanner scanner, String status) {
    System.out.print("Enter Task ID: ");
    int id = scanner.nextInt();
    for (Task task : tasks) {
        if (task.getId() == id) {
            task.setStatus(status);
            TaskManager.saveTasks(tasks);
            System.out.println("Task marked as " + status + "!");
            return;
        }
    }
    System.out.println("Task not found!");
}

    @Override
    public void List(String filter) {
         System.out.println("\nTasks:");
            for (Task task : tasks) {
                if (filter.equals("all") || task.getStatus().equals(filter)) {
            System.out.println(task.getId() + ". " + task.getTitle() + " [" + task.getStatus() + "]");
        }
    }
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
