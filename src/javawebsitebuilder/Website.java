/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsitebuilder;

import java.util.ArrayList;

/**
 *This class instantiates the DOM classes to create an arrayList of pages, i.e a website 
 * @author CubeRyzen
 */
public class Website {
    
    private static Website unique;
    private ArrayList<DocumentObjectModel> pages = new ArrayList<>();

    private Website(Connection connection) {

        ArrayList<String[]> contacts = connection.getArray();
        int numberOfPages = contacts.size() + 1;

        for (int i = 0; i < numberOfPages; i++) {
            if (i == 0) {
                pages.add(new IndexDOM(connection, i));
            } else {
                pages.add(new DetailsDOM(connection, i));
            }
        }
    }

    public static Website getInstance(Connection connection) {

        if (unique == null) {
            unique = new Website(connection);
        }
        return unique;
    }

    protected ArrayList<DocumentObjectModel> getSiteFiles() {
        return pages;
    }

    protected DocumentObjectModel getPageDOM(int pageNumber) {

        return pages.get(pageNumber);
    }

    protected int setNewPage(DocumentObjectModel updatedPage, int pageNumber) {
        pages.set(pageNumber, updatedPage);
        return 1;
    }

    protected int setNewSite(ArrayList<DocumentObjectModel> newPages) {
        this.pages = newPages;
        return 1;
    }

}
