package task.tracker;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


/**
 *
 * @Ronald Kiplangat
 * github.com/RonKirui
 */
public interface TaskInterface {
    void Add(Scanner scanner);
    void Update(Scanner scanner);
    void Delete(Scanner scanner);
    void ChangeStatus(Scanner scanner, String status);
    void List(String filter);
       
}
