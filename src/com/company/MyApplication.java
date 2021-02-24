package com.company;

import com.company.controllers.MedicineController;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApplication {
private final MedicineController controller;
private final Scanner scanner;
public MyApplication(MedicineController controller){
    this.controller = controller;
    scanner = new Scanner(System.in);
}
    public void start(){
    while (true){
        System.out.println();
        System.out.println("Here's the MyApplication");
        System.out.println("Select option: (0-5)");
        System.out.println("1.Get all medicines");
        System.out.println("2.Create medicine");
        System.out.println("3.Get medicine by id");
        System.out.println("4.Get medicine by name");
        System.out.println("5.Remove medicine");
        System.out.println("0.Exit");
        System.out.println();
        try {
            System.out.println("Enter the option: (0-5)");
            int option = scanner.nextInt();
            if(option==1){
            getAllMedicinesMenu();
            }
            else if(option==2){
             CreateMedicineMenu();
            }
            else if(option==3){
            getMedicineById();
            }
            else if(option==4){
            GetMedicineByName();
            }
            else if(option==5){

            }
            else if(option==0){
            break;
            }

        } catch (InputMismatchException e) {
            System.out.println("Input must be integer");
            scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("**********************************");
        }
    }
    public void getAllMedicinesMenu(){
    String response = controller.getAllMedicines();
        System.out.println(response);
    }
    public void getMedicineById(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getMedicine(id);
        System.out.println(response);
    }
    public void CreateMedicineMenu(){
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter price");
        int price = scanner.nextInt();
        System.out.println("Please enter expiration");
        String expiration = scanner.next();
        System.out.println("Please enter manufacturer");
        String manufacturer = scanner.next();
        String response = controller.createMedicine(name,price,expiration,manufacturer);
        System.out.println(response);
    }
   public void GetMedicineByName(){
       System.out.println("Please enter the name");
       String name = scanner.next();
       System.out.println(controller.getMedicineByName(name));
   }
}
