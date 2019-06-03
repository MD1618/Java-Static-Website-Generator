/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsitebuilder;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1636326
 */
public class ConnectionTest {
    
    public ConnectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getInstance method, of class Connection.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Connection expResult = Connection.getInstance();
        Connection result = Connection.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArray method, of class Connection.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        Connection instance = Connection.getInstance();
        ArrayList expResult = instance.getArray();
        ArrayList result = instance.getArray();
        assertEquals(expResult, result);
    }

    /**
     * Test of loadSortedArray method, of class Connection.
     */
    @Test
    public void testLoadSortedArray() {
        System.out.println("loadSortedArray");
        ArrayList<String[]> DBArrays = new ArrayList();
        Connection instance = Connection.getInstance();
        int expResult = 1;
        int result = instance.loadSortedArray(DBArrays);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class Connection.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Connection instance = Connection.getInstance();
        String expResult = "test";
        String result = instance.getUser();
        assertTrue(expResult.getClass() == result.getClass());//checks results are both string types 
       
    }
    
}
