/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.LoginAndRegisterSystem;

import static com.mycompany.LoginAndRegisterSystem.LoginANdRegisterSystem.loginUser;
import static com.mycompany.LoginAndRegisterSystem.LoginANdRegisterSystem.registerUser;
import static com.mycompany.LoginAndRegisterSystem.LoginANdRegisterSystem.returnLoginStatus;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class main {
  static void main(String[] args) {  
 
Scanner input = new Scanner(System.in);  
 
System.out.println("=== REGISTER ===");  
 
System.out.print("Enter username: ");  
 
String username = input.nextLine();  
 
System.out.print("Enter password: ");  
 
String password = input.nextLine();  
 
System.out.print("Enter SA cell number (+27...): ");  
 
String number = input.nextLine();  
 
String regMessage = registerUser(username, password, number);  
 
System.out.println(regMessage);  
 
if (regMessage.equals("User registered successfully.")) {  
 
System.out.println("\n=== LOGIN ===");  
 
System.out.print("Enter username: ");  
 
String loginUser = input.nextLine();  
 
System.out.print("Enter password: ");  
 
String loginPass = input.nextLine();  
 
boolean status = loginUser(loginUser, loginPass) ;  
 
System.out.println(returnLoginStatus(status));  
 
}  
 
input.close();  
 
}  
 
}