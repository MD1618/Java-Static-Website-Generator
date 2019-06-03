/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsitebuilder;

import java.util.ArrayList;

/**
 *This class models the nodes of the DOM tree,
 * Each node contains an ArrayList of its children as well as its height or level in the DOM tree structure
 * @author CubeRyzen
 */
public class DOMNode {

    private final ArrayList<DOMNode> childNodes = new ArrayList<>(); // child elements
    private final Integer level; // DOM tree level
    private final String tag;
    private final String innerTEXT;
    private final String attribute;
    private boolean close;

    public DOMNode() {
        this.level = 0;
        this.tag = "";
        this.innerTEXT = "";
        this.attribute = "";

    }

    private DOMNode(Integer level, String tag, String innerTEXT, String attribute, boolean close) {

        this.level = level;
        this.close = close;
        this.tag = tag;
        this.innerTEXT = innerTEXT;
        this.attribute = attribute;
    }

    //
    /**
     * add new node at current node level
     * @param tag
     * @param innerTEXT
     * @param attribute
     * @param close
     * @return 
     */
    public ArrayList<DOMNode> addNode(String tag, String innerTEXT, String attribute, boolean close) {
        childNodes.add(new DOMNode((this.level + 1), tag, innerTEXT, attribute, close));
        return childNodes;
    }

    
    /**
     * return this nodes child elements in string format
     * @return 
     */
    private String childrenToString() {
        String children = "";
        for (int i = 0; i < childNodes.size(); i++) {
            children += childNodes.get(i).toString();
        }
        return children;
    }
    /**
     * returns a child node for a given index
     * @param getNode
     * @return 
     */
    public DOMNode getNode(int getNode) {
        return childNodes.get(getNode);
    }

    
    
    
    /**
     * this method allows the input of an array of node indexes to get a node,
     * this saves from calling the getNode method multiple times
     * @param nodeIndexes
     * @return 
     */
    public DOMNode getNodes(int[] nodeIndexes) {
        if (this.level == 0) {// will only run if root document node
            DOMNode temp = this;
            for (int i = 0; i < nodeIndexes.length; i++) {
                temp = temp.getNode(nodeIndexes[i]);
            }
            return temp;
        }
        return this;
    }
    /**
     * outputs nodes as strings with appropriate tabbing.
     * calculates how many tabs to add for current DOM tree level.
     * decides if new line needed for empty elements.
     * adds closing tags if needed
     * if root node adds <!doctype>
     * @return 
     */
    @Override
    public String toString() {
        // create appropriate size tabs for DOM level
        String closeString;
        String inner;
        String tab = "";
        
        for (int i = 0; i < this.level; i++) {
            tab += "\t";
        }
        // if no innerText don't use new line
        if (!"".equals(innerTEXT)) {
            inner = ">\n" + tab + innerTEXT;
        } else {
            inner = ">";
        }
        // check if closing tag needed
        if (close) {
            closeString = "" + childrenToString() + "\n" + tab + "</" + tag + ">";
        } else {
            closeString = "";//no closing tag also means no nested elements so this is empty
        }
        // if root document node then add doctype 
        if (this.level == 0) {
            return "<!DOCTYPE HTML>" + childrenToString() + "\n";
        } else {// 
            return "\n" + tab + "<" + tag + attribute + inner + closeString;
        }

    }

}
