/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsitebuilder;

import java.util.ArrayList;

/**
 *Creates the main HTML document template HTML, Head, scripts, meta, links, title and body nodes
 * @author 1636326
 */
public class DocumentObjectModel {// 

    protected final DOMNode document;// root node
    protected final ArrayList<String[]> contacts;
    protected final int pageNumber;
/**
 * Creates the root document node
 * @param Con1
 * @param pPageNumber 
 */
    public DocumentObjectModel(Connection Con1, int pPageNumber) {// 
        document = new DOMNode();
        this.pageNumber = pPageNumber - 1;
        contacts = Con1.getArray();// get array of contacts

        template(); // create page DOM except for BODY nodes

    }

    public DOMNode getDocument() {

        return document;
    }

    private int template() {

        document.addNode("html", "", "", true);// html node
        document.getNode(0).addNode("head", "", "", true);// head node
        document.getNodes(new int[]{0, 0}).addNode("script", "", " src=\"https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.3/d3.min.js\"", true);// map svg data JS file
        document.getNodes(new int[]{0, 0}).addNode("script", "", " src=\"https://cdnjs.cloudflare.com/ajax/libs/topojson/1.6.9/topojson.min.js\"", true);
        document.getNodes(new int[]{0, 0}).addNode("script", "", " src='datamaps.world.hires.min.js'", true);
        document.getNodes(new int[]{0, 0}).addNode("meta", "", " charset='utf-8' name='viewport' content='width=device-width'", false);
        document.getNodes(new int[]{0, 0}).addNode("link", "", " href=\"https://fonts.googleapis.com/css?family=Quattrocento+Sans:700\" rel=\"stylesheet\"", false);
        document.getNodes(new int[]{0, 0}).addNode("script", "", " type=\"text/javascript\" src='contactJS.js'", true);// add Javascript node
        if (pageNumber == -1) {
            document.getNodes(new int[]{0, 0}).addNode("title", "Home page", "", true);
        } else {
            document.getNodes(new int[]{0, 0}).addNode("title", contacts.get(pageNumber)[0] + " " + contacts.get(pageNumber)[1], "", true);
        }
        document.getNodes(new int[]{0, 0}).addNode("link", "", " rel=\"stylesheet\" type=\"text/css\" href=\"contactCSS.css\"", false);// add CSS node
        document.getNode(0).addNode("body", "", " class='font' data-pagenum='" + pageNumber + "'", true);// body node
        //document.getNodes(new int[]{0, 1}).addNode("div", "", " id='container'", true);//main page div
        return 1;
    }
/**
 * starts a toString() cascade through the DOM tree :D
 * @return 
 */
    public String page() {
        return document.toString(); 
    }

}
