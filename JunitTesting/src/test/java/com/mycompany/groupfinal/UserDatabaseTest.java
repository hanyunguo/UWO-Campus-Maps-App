/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.groupfinal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hanyunguo
 */
public class UserDatabaseTest {
    
    public UserDatabaseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of registerUser method, of class UserDatabase.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String un = "doris";
        String pw = "123";
        UserDatabase instance = new UserDatabase();
        instance.registerUser(un, pw);
        String expResult = "doris";
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, instance.getUser(un).viewUserName());
    }

    /**
     * Test of registerAdmin method, of class UserDatabase.
     */
    @Test
    public void testRegisterAdmin() {
        System.out.println("registerAdmin");
        String un = "doris";
        String pw = "123";
        UserDatabase instance = new UserDatabase();
        instance.registerAdmin(un, pw);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(instance.activeUser, instance.getUser(un));
    }

        /**
     * Test of getUser method, of class UserDatabase.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String un = "doris";
        String pw = "123";
        UserDatabase instance = new UserDatabase();
        String expResult = "doris";
        instance.registerUser(un, pw);
        User result = instance.getUser(un);
        assertEquals(expResult, result.viewUserName());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAdmin method, of class UserDatabase.
     */
    @Test
    public void testGetAdmin() {
        System.out.println("getAdmin");
        String un = "doris";
        String pw = "123";
        UserDatabase instance = new UserDatabase();
        String expResult = "doris";
        instance.registerAdmin(un, pw);
        Admin result = instance.getAdmin(un);
        assertEquals(expResult, result.viewadminName());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of userisFull method, of class UserDatabase.
     */
    @Test
    public void testUserisFull() {
        System.out.println("userisFull");
        UserDatabase instance = new UserDatabase();
        boolean expResult = false;
        boolean result = instance.userisFull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of adminisFull method, of class UserDatabase.
     */
    @Test
    public void testAdminisFull() {
        System.out.println("adminisFull");
        UserDatabase instance = new UserDatabase();
        boolean expResult = false;
        boolean result = instance.adminisFull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of login method, of class UserDatabase.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String un = "doris";
        String pw = "1234";
        UserDatabase instance = new UserDatabase();
        instance.registerUser(un, pw);
        instance.login(un, pw);
        User expResult = instance.getUser(un);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, instance.activeUser);
    }

    /**
     * Test of logout method, of class UserDatabase.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        String un = "doris";
        String pw = "1234";
        UserDatabase instance = new UserDatabase();
        instance.registerUser(un, pw);
        instance.login(un, pw);
        instance.logout();
        String expResult = null;
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, instance.activeUser);
    }
    
}
