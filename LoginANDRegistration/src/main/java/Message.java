/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */


import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
public class Message {
    
    private static ArrayList<String> sentMessages = new ArrayList<>();
    private static ArrayList<String> disregardedMessages = new ArrayList<>();
    private static ArrayList<String> storedMessages = new ArrayList<>();
    private static ArrayList<String> messageIDs = new ArrayList<>();
    private static ArrayList<String> messageHashes = new ArrayList<>(); 
    
     private static int messageCounter = 0; 

    private String messageID; 
    private String recipientNumber;
    private String messageContent; 
    private String messageHash;
    private String status;
    
      public Message(String recipientNumber, String messageContent) { 
        messageCounter++; 

        this.messageID    = generateMessageID(); 
        this.recipientNumber = recipientNumber; 
        this.messageContent  = messageContent; 
        this.messageHash  = createMessageHash();
        messageIDs.add(this. messageID);
        messageHashes.add(this.messageHash);  
 } 

      private String generateMessageID() {
          return String.format("%010d",(int) (Math.random()*1_000_000));
      }
      
 public boolean checkMessageID(){
     return messageID != null && messageID.length() <= 10;
 }
 
 public String checkRecipientCell() { 

        if (recipientNumber != null 
                && recipientNumber.length() <= 10 
                && (recipientNumber.matches("\\+27\\d{9}") 
                    || recipientNumber.matches("0\\d{9}"))) { 

            return "Cell phone number successfully captured."; 
        } 
               return "Cell phone number is incorrectly formatted or does not contain."

              + "an international code. Please correct the number and try again."; 
 }
       public String createMessageHash() { 

        String idPart      = messageID.substring(0, Math.min(2, messageID.length())); 
        
        String[] words     = messageContent.trim().split("\\s+"); 
        String firstWord   = words[0]; 
        String lastword  = words[words.length - 1];
         String lastWord = words[words.length -1].replaceAll("[^a-zA-Z0-9]" , "");

        String hash = (idPart + ":" + messageCounter + ":" + firstWord + lastWord).toUpperCase(); 

        this.messageHash = hash; 

        return hash; 
  } 
                 
        public String SentMessage(int choice) { 
        switch (choice) { 
            case 1: 
            String status = "sent";
                sentMessages.add(printMessages()); 
                return "Message successfully sent."; 
 
            case 2: 
                status = "Disregarded"; 
                return "Press 0 to delete the message."; 
            case 3: 
                status = "Stored"; 
                storeMessage(); 
                return "Message successfully stored."; 
            default: 
                return "Invalid choice. Please select 1 (Send), 2 (Disregard), or 3 (Store)."; 
        }
    } 
         public String printMessages() { 

        return "Message ID: "   + messageID      + "\n"
             + "Message Hash: " + messageHash     + "\n" 
             + "Recipient: "    + recipientNumber + "\n"
             + "Message: "      + messageContent; 
    } 
            public static int returnTotalMessages() { 
        return sentMessages.size(); 
    }
          public String storeMessage() { 

        String json = "{/n"
        + " \"messageID\": \""   + messageID +"\",\n"
        + " \"messageHash\":\""    + messageHash +"\",\n"
        + " \"recipientNumber\":\""  + recipientNumber +"\",\n" 
        + " \"message\":\""      + messageContent+"\",\n"
        + " \"status\":  \"Stored\"\n"
        +"}";        
        try (FileWriter writer = new FileWriter ("messages.json", true)){
            writer.write(json);
            writer.write("\n");
         return "Message successfully stored to message.json.";
        }catch (IOException e) {
            return "Error storiong message:" + e.getMessage();
        }
    }
       

    public String validateMessage() { 

        if (messageContent.length() <= 250) { 
            return "Message ready to send."; 

        } 

        int excess = messageContent.length() - 250; 
        return "Message exceeds 250 characters by " + excess 
             + "; please reduce the size."; 
    } 
    
    public static String displayStoredMessages() {
        if(storedMessages.isEmpty()) {
            return "No stored messages.";           
        }
        StringBuilder sb = new StringBuilder();
        sb.append("=== Stored Messages ===\n");
        for (String msg : storedMessages){
            String[] parts = msg.split("\\|");
            sb.append("Recipient: ").append(parts[0]).append(" | Message: ").append(parts[1]).append("\n");
        }
        return sb.toString();
        }
    
    public static String displayLongestMessage() {
        String longest = "";
        for(String msg : sentMessages){
            String[] parts = msg.split("\\|");
            if (parts[1].length() > longest.length()) longest = parts[1];
        }
        for(String msg : storedMessages){
            String[] parts = msg.split("\\|");
            if(parts[1].length()> longest.length()) longest = parts[1];
        }
        if(longest.isEmpty()) return " no message found." ;
        return " Longest message :" + longest;
    }
    public static String searchByMessageID(String searchID) {
       for(int i = 0; i< messageIDs.size(); i++) {
           if(messageIDs.get(i).equals(searchID)){
           for (String msg : sentMessages){
               String[] parts = msg.split("\\|");
               return "Recipient :" + parts[0] +"\nMessage: " + parts[1];
           }
       for(String msg : storedMessages){
           String[] parts = msg.split("\\|");
           return "Recipient :" + parts[0] + "\nMessage :" + parts[1];
       }
           }
       }
       return " Message ID not found." ;
    }
    
    public static String searchByRecipient(String recipient) {
        StringBuilder sb = new StringBuilder();
        for(String msg : sentMessages) {
            String[] parts = msg.split("\\|");
        if( parts[0].equals(recipient)) sb.append(parts[1]).append("\n");
       }
       for (String msg : storedMessages){
           String[] parts = msg.split("\\|");
           if(parts[0].equals(recipient))sb.append(parts[1]).append("\n");
       }
       if (sb.length()== 0 ) return "No Message found for recipient: " + recipient;
       return sb.toString().trim();
    }
    
    public static String deleteByHash(String hash){
        for(int i=0; i <storedMessages.size(); i++){
            String[]parts = storedMessages.get(i).split("\\|");
            if (!parts[2].equalsIgnoreCase(hash)){
              String deleted = parts[1];
                storedMessages.remove(i);
                return"Message: \"" + deleted +"\" succecssfully deleted.";
            }
        }
        return " Message hash not found.";
    }
    
    public static String displayReport(){
        if(sentMessages.isEmpty()&& storedMessages.isEmpty()) {
            return " No message to display.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("=== Message Report===\n");
        sb.append("--- Sent Messages ---\n");
        for(String msg : sentMessages){
            String[] parts = msg.split("\\|");
            sb.append("Message Hash:").append(parts[2]).append("\n");
            sb.append("Recipient: ").append(parts[0]).append("\n");
            sb.append("Message: ").append(parts[1]).append("\n\n");
        }
        sb.append("---- Stored Messages---\n");
        for(String msg : storedMessages){
            String[]parts = msg.split("\\|");
            sb.append("Message Hash: ").append(parts[2]).append("\n");
            sb.append("Recipient:").append(parts[0]).append("\n");
            sb.append("Message: ").append(parts[1]).append("\n\n");
        }
        return sb.toString();
    }
      public String getMessageID()       { return messageID; } 
    public String getMessageHash()     { return messageHash; } 
    public String getRecipientNumber() { return recipientNumber; } 
    public String getMessageContent()  { return messageContent; } 
    public String getStatus()          {  String status = null;
return status; } 

        }



 

 




