/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task.tracker;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TaskTracker {
    private static final String FILE_NAME = "tasks.json";
    
    private static List<Map<String, Object>> tasks = new ArrayList<>();

    public static void main(String[] args) {
        loadTasks();
        if (args.length < 1) {
            System.out.println("Usage: java TaskTrackerCLI <command> [arguments]");
            return;
        }
        String command = args[0];

        switch (command) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: java TaskTrackerCLI add \"task description\"");
                    return;
                }
                addTask(args[1]);
                break;
            case "list":
                listTasks(args.length > 1 ? args[1] : null);
                break;
            case "update":
                if (args.length < 3) {
                    System.out.println("Usage: java TaskTrackerCLI update <id> \"new description\"");
                    return;
                }
                updateTask(Integer.parseInt(args[1]), args[2]);
                break;
            case "delete":
                if (args.length < 2) {
                    System.out.println("Usage: java TaskTrackerCLI delete <id>");
                    return;
                }
                deleteTask(Integer.parseInt(args[1]));
                break;
            case "mark-in-progress":
                if (args.length < 2) {
                    System.out.println("Usage: java TaskTrackerCLI mark-in-progress <id>");
                    return;
                }
                updateStatus(Integer.parseInt(args[1]), "in-progress");
                break;
            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Usage: java TaskTrackerCLI mark-done <id>");
                    return;
                }
                updateStatus(Integer.parseInt(args[1]), "done");
                break;
            default:
                System.out.println("Invalid command.");
        }
        saveTasks();
    }

    private static void addTask(String description) {
        int id = tasks.isEmpty() ? 1 : (int) tasks.get(tasks.size() - 1).get("id") + 1;
        Map<String, Object> task = new HashMap<>();
        task.put("id", id);
        task.put("description", description);
        task.put("status", "todo");
        task.put("createdAt", new Date().toString());
        task.put("updatedAt", new Date().toString());
        tasks.add(task);
        System.out.println("Task added successfully (ID: " + id + ")");
    }

    private static void listTasks(String statusFilter) {
        for (Map<String, Object> task : tasks) {
            if (statusFilter == null || task.get("status").equals(statusFilter)) {
                System.out.println(task);
            }
        }
    }

    private static void updateTask(int id, String newDescription) {
        for (Map<String, Object> task : tasks) {
            if ((int) task.get("id") == id) {
                task.put("description", newDescription);
                task.put("updatedAt", new Date().toString());
                System.out.println("Task updated successfully.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    private static void deleteTask(int id) {
        tasks.removeIf(task -> (int) task.get("id") == id);
        System.out.println("Task deleted successfully.");
    }

    private static void updateStatus(int id, String newStatus) {
        for (Map<String, Object> task : tasks) {
            if ((int) task.get("id") == id) {
                task.put("status", newStatus);
                task.put("updatedAt", new Date().toString());
                System.out.println("Task status updated to: " + newStatus);
                return;
            }
        }
        System.out.println("Task not found.");
    }

    private static void loadTasks() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;
            String content = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            if (!content.isEmpty()) {
                tasks = parseJson(content);
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks.");
        }
    }

    private static void saveTasks() {
        try {
            String json = toJson(tasks);
            Files.write(Paths.get(FILE_NAME), json.getBytes());
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    private static String toJson(List<Map<String, Object>> list) {
        StringBuilder json = new StringBuilder("[\n");
        for (Map<String, Object> task : list) {
            json.append("  {\n");
            for (Map.Entry<String, Object> entry : task.entrySet()) {
                json.append("    \"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\",\n");
            }
            json.setLength(json.length() - 2);
            json.append("\n  },\n");
        }
        if (!list.isEmpty()) json.setLength(json.length() - 2);
        json.append("\n]");
        return json.toString();
    }

    private static List<Map<String, Object>> parseJson(String json) {
        List<Map<String, Object>> list = new ArrayList<>();
        json = json.replace("[", "").replace("]", "").trim();
        if (json.isEmpty()) return list;

        String[] entries = json.split("},");
        for (String entry : entries) {
            entry = entry.replace("{", "").replace("}", "").trim();
            String[] keyValues = entr
