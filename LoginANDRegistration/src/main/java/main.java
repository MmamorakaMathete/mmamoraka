import java.util.Scanner; 

 

/** 

 * @author Student 

 */ 

public class main { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 

 

        // --- REGISTRATION --- 
        System.out.println("=== Welcome to QuickChat ==="); 
        System.out.print("Enter username: "); 
        String username = scanner.nextLine(); 

 System.out.print("Enter password: "); 
 String password = scanner.nextLine(); 

        System.out.print("Enter cell phone number: "); 
        String number = scanner.nextLine(); 

 

        String regResult = LoginANdRegisterSystem.registerUser(username, password, number); 
        System.out.println(regResult); 

        if (!regResult.equals("User registered successfully.")) { 
            System.out.println("Registration failed. Exiting."); 
            scanner.close(); 
            return; 
        } 
        
         boolean loginStatus = false; 

        int attempts = 0; 

        int maxAttempts = 3; 

 

        System.out.println("\n=== Please Login ==="); 

        while (attempts < maxAttempts) { 

            System.out.print("Enter username: "); 
            String loginUser = scanner.nextLine(); 

            System.out.print("Enter password: "); 
            String loginPass = scanner.nextLine(); 

            loginStatus = LoginANdRegisterSystem.loginUser(loginUser, loginPass);     System.out.println(LoginANdRegisterSystem.returnLoginStatus(loginStatus)); 

 

            if (loginStatus) { 
                break;  

            } else { 

                attempts++; 

                int remaining = maxAttempts - attempts; 
                if (remaining > 0) { 
                    System.out.println("You have " + remaining + " attempt(s) remaining."); 
                } else { 
                    System.out.println("Too many failed attempts. Exiting."); 
                    scanner.close(); 
                    return; 

                } 

            } 

        }      

        // --- LOGIN --- 
        System.out.println("\n=== Please Login ==="); 
        System.out.print("Enter username: "); 
        String loginUser = scanner.nextLine(); 

        System.out.print("Enter password: "); 
        String loginPass = scanner.nextLine(); 

        
        System.out.println(LoginANdRegisterSystem.returnLoginStatus(loginStatus)); 

 
        if (!loginStatus) { 
            System.out.println("User registered successfully ."); 
            scanner.close(); 
            return; 
        }  

                loginStatus = false; 
        
        boolean running = true; 

        while (running) { 
            System.out.println("\n=== QuickChat Main Menu ==="); 
            System.out.println("1) Send Messages"); 
            System.out.println("2) Show Recently Sent Messages"); 
            System.out.println("3) Quit"); 
            System.out.println("4) Stored Messages"); 
            System.out.print("Enter choice: "); 

            int menuChoice = Integer.parseInt(scanner.nextLine()); 

            switch (menuChoice) { 

                case 1: 
                    System.out.print("How many messages would you like to send? "); 
                    int numMessages = Integer.parseInt(scanner.nextLine()); 

                    for (int i = 0; i < numMessages; i++) { 
                        System.out.println("\n--- Message " + (i + 1) + " ---"); 

 
                        System.out.print("Enter recipient number: "); 
                        String recipient = scanner.nextLine(); 

                        System.out.print("Enter message: "); 
                        String messageText = scanner.nextLine(); 

                        Message msg = new Message(recipient, messageText); 

                        System.out.println(msg.validateMessage()); 
                        System.out.println(msg.checkRecipientCell()); 
                        System.out.println("Message ID generated: " + msg.getMessageID()); 
                        System.out.println("Message Hash: " + msg.getMessageHash()); 

                        System.out.println("\n1) Send Message"); 
                        System.out.println("2) Disregard Message"); 
                        System.out.println("3) Store Message"); 
                        System.out.print("Enter choice: "); 

                        int choice = Integer.parseInt(scanner.nextLine()); 

                        System.out.println(msg.SentMessage(choice)); 
                        System.out.println("\n" + msg.printMessages()); 
                    } 

                    System.out.println("\nTotal Messages Sent: " + Message.returnTotalMessages()); 
                    break; 

                case 2: 
                    System.out.println(Message.displayReport()); 
                    break; 
                case 3: 
                    System.out.println("Goodbye!"); 
                    running = false; 
                    break; 
                case 4: 
                    boolean storedMenu = true; 
                    while (storedMenu) { 

                        System.out.println("\n=== Stored Messages Menu ==="); 
                        System.out.println("a) Display all stored messages"); 
                        System.out.println("b) Display longest message"); 
                        System.out.println("c) Search by Message ID"); 
                        System.out.println("d) Search by recipient"); 
                        System.out.println("e) Delete message by hash"); 
                        System.out.println("f) Display full report"); 
                        System.out.println("x) Back to main menu"); 

                        System.out.print("Enter choice: "); 
                        String sub = scanner.nextLine().trim().toLowerCase(); 

                        switch (sub) { 
                            case "a": 
                                System.out.println(Message.displayStoredMessages()); 
                                break; 
                            case "b": 
                                System.out.println(Message.displayLongestMessage()); 
                                break; 
                            case "c": 
                                System.out.print("Enter Message ID: "); 
                                
                                String searchID = scanner.nextLine(); 
                                System.out.println(Message.searchByMessageID(searchID)); 
                                break; 
                            case "d": 
                                System.out.print("Enter recipient number: "); 

                                String recipient = scanner.nextLine(); 
                                System.out.println(Message.searchByRecipient(recipient)); 
                                break; 

                            case "e": 
                                System.out.print("Enter message hash to delete: "); 
                                String hash = scanner.nextLine(); 
                                System.out.println(Message.deleteByHash(hash)); 
                                break; 

                            case "f": 
                                System.out.println(Message.displayReport()); 
                                break; 
                            case "x": 
                                storedMenu = false; 
                                break; 

                            default: 
                                System.out.println("Invalid choice."); 
                        } 
                    } 
                    break; 
                default: 
                    System.out.println("Invalid choice. Please try again."); 
            } 
        } 
        scanner.close(); 
    } 
} 