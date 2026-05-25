/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package com.mycompany.LoginAndRegisterSystem;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Student
 */
public class MessageNGTest {
    
    public MessageNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        Message instance = null;
        boolean expResult = false;
        boolean result = instance.checkMessageID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        Message instance = null;
        String expResult = "";
        String result = instance.checkRecipientCell();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Message instance = null;
        Object expResult = null;
        Object result = instance.createMessageHash();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SentMessage method, of class Message.
     */
    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        int choice = 0;
        Message instance = null;
        String expResult = "";
        String result = instance.SentMessage(choice);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessages method, of class Message.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Message instance = null;
        String expResult = "";
        String result = instance.printMessages();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class Message.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int expResult = 0;
        int result = Message.returnTotalMessages();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class Message.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        Message instance = null;
        String expResult = "";
        String result = instance.storeMessage();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateMessage method, of class Message.
     */
    @Test
    public void testValidateMessage() {
        System.out.println("validateMessage");
        Message instance = null;
        String expResult = "";
        String result = instance.validateMessage();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageID method, of class Message.
     */
    @Test
    public void testGetMessageID() {
        System.out.println("getMessageID");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageID();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageHash method, of class Message.
     */
    @Test
    public void testGetMessageHash() {
        System.out.println("getMessageHash");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageHash();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecipientNumber method, of class Message.
     */
    @Test
    public void testGetRecipientNumber() {
        System.out.println("getRecipientNumber");
        Message instance = null;
        String expResult = "";
        String result = instance.getRecipientNumber();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageContent method, of class Message.
     */
    @Test
    public void testGetMessageContent() {
        System.out.println("getMessageContent");
        Message instance = null;
        String expResult = "";
        String result = instance.getMessageContent();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Message.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Message instance = null;
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
