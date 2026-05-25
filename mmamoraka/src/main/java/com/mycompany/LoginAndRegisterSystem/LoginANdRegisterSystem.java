/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.LoginAndRegisterSystem;

/**
 *
 * @author Student
 */
import static com.mycompany.LoginAndRegisterSystem.LoginANdRegisterSystem.LoginANdRegisterSystem.loginUser;
import static com.mycompany.LoginAndRegisterSystem.LoginANdRegisterSystem.LoginANdRegisterSystem.registerUser;
import static com.mycompany.LoginAndRegisterSystem.LoginANdRegisterSystem.LoginANdRegisterSystem.returnLoginStatus;
import java.util.Scanner;  


    static boolean checkPassword(String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
/**
 *
 * @author Student
 */
public class LoginANdRegisterSystem {  
 
static String storedUsername;  
 
static String storedPassword;  
 
public static boolean checkUserName(String username) {  
 
return username.contains("_") && username.length() <= 5;  
 
}  
 
public static boolean checkPassword(String password) {  
 
boolean length = password.length() >= 8;  
 
boolean capital = password.matches(".*[A-Z].*");  
 
boolean number = password.matches(".*[0-9].*");  
 
boolean special = password.matches(".*[^a-zA-Z0-9].*");  
 
return length && capital && number && special;  
 
}  
 
static boolean checkCellPhoneNumber(String number) {  
 
return number.matches("\\+27\\d{9}");  
 
}  
 
public static String registerUser(String username, String password, String number) {  
 
if (!checkUserName(username)) {  
 
return "Username is not correctly formatted.";  
 
}  
 
if (!checkPassword(password)) {  
 
return "Password is incorrectly formatted.";  
 
}  
 
if (!checkCellPhoneNumber(number)) {  
 
return "Cell number is incorrectly formatted.";  
 
}  
 
storedUsername = username;  
 
storedPassword = password;  
 
return "User registered successfully.";  
 
}  
 
public static boolean loginUser(String username, String password) {  
 
return username.equals(storedUsername) && password.equals(storedPassword);  
 
}  
 
static String returnLoginStatus(boolean status) {  
 
if (status) {  
 
return "Welcome, it is great to see you again!";  
 
} else {  
 
return "Username or password incorrect please try again.";  
 
}  
 
}
}
 
public static void main(String[] args){

 

        Scanner scanner = new Scanner(System.in); 

 

        // --- REGISTRATION --- 

        System.out.println("=== Welcome to QuickChat ==="); 

        System.out.print("Enter username: "); 

        String username = scanner.nextLine(); 

 

        System.out.print("Enter password: "); 

        String password = scanner.nextLine(); 

 

        System.out.print("Enter cell phone number: "); 

        String number = scanner.nextLine(); 

 

        String regResult = registerUser(username, password, number); 

        System.out.println(regResult); 

 

        if (!regResult.equals("User registered successfully.")) { 

            System.out.println("Registration failed. Exiting."); 

            return; 

        } 

 

        // --- LOGIN --- 

        System.out.println("\n=== Please Login ==="); 

        System.out.print("Enter username: "); 

        String loginUser = scanner.nextLine(); 

 

        System.out.print("Enter password: "); 

        String loginPass = scanner.nextLine(); 

 

        boolean loginStatus = loginUser(loginUser, loginPass); 

        System.out.println(returnLoginStatus(loginStatus)); 

 

        if (!loginStatus) { 

            System.out.println("Login failed. Exiting."); 

            return; 

        } 

 

        // --- MESSAGES --- 

        System.out.println("\n=== QuickChat Messaging ==="); 

        int numMessages = 2; 

        for (int i = 0; i < numMessages; i++) { 

            System.out.println("\n--- Message " + (i + 1) + " ---"); 

            System.out.print("Enter recipient number: "); 

            String recipient = scanner.nextLine(); 

 
            System.out.print("Enter message: "); 

            String messageText = scanner.nextLine(); 

 
            Message msg = new Message(recipient, messageText); 

 

            // Validate message length 
            System.out.println(msg.validateMessage()); 
 

            // Check recipient 
            System.out.println(msg.checkRecipientCell()); 
            System.out.println("Message ID generated: " + msg.getMessageID()); 

 

            // Show hash 

            System.out.println("Message Hash: " + msg.getMessageHash()); 

 

            // Ask user what to do 

            System.out.println("\nWhat would you like to do?"); 

            System.out.println("1) Send Message"); 

            System.out.println("2) Disregard Message"); 

            System.out.println("3) Store Message"); 

            System.out.print("Enter choice: "); 

            int choice = Integer.parseInt(scanner.nextLine()); 

 

            System.out.println(msg.SentMessage(choice)); 

 

            // Show full message details 

            System.out.println("\n" + msg.printMessages()); 

        } 

 

        // --- TOTAL MESSAGES SENT --- 

        System.out.println("\n=== Total Messages Sent: " + Message.returnTotalMessages() + " ==="); 

 

        scanner.close(); 

    } 

