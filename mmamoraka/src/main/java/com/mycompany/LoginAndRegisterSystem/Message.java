/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.LoginAndRegisterSystem;

/**
 *
 * @author Student
 */


import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
public class Message {
    
     private static int messageCounter = 0; 
    private static ArrayList<String> sentMessages = new ArrayList<>(); 

    private String messageID; 
    private String recipientNumber;
    private String messageContent; 
    private String messageHash;
    
      public Message(String recipientNumber, String messageContent) { 
        messageCounter++; 

        this.messageID    = generateMessageID(); 
        this.recipientNumber = recipientNumber; 
        this.messageContent  = messageContent; 
        this.messageHash  = createMessageHash(); 
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

         return json;
    }
            private String generateMessageID() { 
        return String.format("%010d", (int)(Math.random() * 1_000_000_000)); 

            }

    public String validateMessage() { 

        if (messageContent.length() <= 250) { 
            return "Message ready to send."; 

        } 

        int excess = messageContent.length() - 250; 
        return "Message exceeds 250 characters by " + excess 
             + "; please reduce the size."; 
    } 
    
      public String getMessageID()       { return messageID; } 
    public String getMessageHash()     { return messageHash; } 
    public String getRecipientNumber() { return recipientNumber; } 
    public String getMessageContent()  { return messageContent; } 
    public String getStatus()          {  String status = null;
return status; } 

        }



 

 


