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
 * @author CubeRyzen
 */
public class DOMNodeTest {
    
    public DOMNodeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addNode method, of class DOMNode.
     */
    @Test
    public void testAddNode() {
        System.out.println("addNode");
        String tag = "";
        String innerTEXT = "";
        String attribute = "";
        boolean close = false;
        DOMNode instance = new DOMNode();
        ArrayList<DOMNode> expResult = new ArrayList();
        ArrayList<DOMNode> result = instance.addNode(tag, innerTEXT, attribute, close);
        assertTrue(expResult.getClass() == result.getClass());
    }

    /**
     * Test of getNode method, of class DOMNode.
     */
    @Test
    public void testGetNode() {
        System.out.println("getNode");
        int getNode = 0;
        DOMNode instance = new DOMNode();
        instance.addNode("div", "", "", true);
        DOMNode expResult = new DOMNode();
        DOMNode result = instance.getNode(getNode);
        assertTrue(expResult.getClass() == result.getClass());
    }

    /**
     * Test of getNodes method, of class DOMNode.
     */
    @Test
    public void testGetNodes() {
        System.out.println("getNodes");
        int[] nodeIndexes = {1};
        DOMNode instance = new DOMNode();
        instance.addNode("div", "", "", true);
        instance.addNode("div", "", "", true);
        DOMNode expResult = new DOMNode();
        DOMNode result = instance.getNodes(nodeIndexes);
        assertTrue(expResult.getClass() == result.getClass());
    }

    /**
     * Test of toString method, of class DOMNode.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DOMNode instance = new DOMNode();
        String expResult = "";
        String result = instance.toString();
        assertTrue(expResult.getClass() == result.getClass());
    }
    
}
