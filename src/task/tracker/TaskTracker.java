/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task.tracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @RONALD KIPLANGAT
 * GITHUB: github.com/RonKirui
 */
public class TaskTracker implements TasksInterface{

    
    public static void main(String[] args) {
        // TODO code application logic here
        TaskTracker t = new TaskTracker();
        
        t.Add();
    }

    @Override
    public void Add() {
        ArrayList<String> arr = new ArrayList<String>();
        
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter task Id: ");
        String taskId = scn.nextLine();
        System.out.println("Enter the task: ");
        String task = scn.nextLine();
        String taskstatus = "In Progress";
        
        arr.add(taskId);
        arr.add(task);
        arr.add(taskstatus);
        
        System.out.println();
        
        System.out.println("TaskId\t Task\t\t Status\t");
        
        for(String i : arr){
            System.out.print(i+"\t");
        }
        System.out.println();
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Update() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Delete() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
