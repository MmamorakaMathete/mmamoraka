 import java.util.Scanner; 
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
        boolean length  = password.length() >= 8; 
        boolean capital = password.matches(".*[A-Z].*"); 
        boolean number  = password.matches(".*[0-9].*"); 
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
 

  
