/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsitebuilder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *Provides sorting functionality
 * @author CubeRyzen
 */
public class Sort {

    private final ArrayList<String[]> contacts;
    private final ArrayList<String[]> sortedContacts;
    private final Connection con1;
    private final String[] fNames;
    private final String[] lNames;
    private final int top;
    private double bubbleSpeed;
    private double insertionSpeed;
    private double selectionSpeed;

    public Sort(Connection con) {
        this.con1 = con;
        contacts = con1.getArray();
        sortedContacts = new ArrayList<>();
        top = contacts.size();
        fNames = new String[top];
        lNames = new String[top];

        for (int i = 0; i < top; i++) {
            fNames[i] = contacts.get(i)[0];
            lNames[i] = contacts.get(i)[1];
        }
    }

    public int outputSpeeds() {
        if (bubbleSpeed != 0) {
            System.out.println("Bubble speed: " + bubbleSpeed + "s");
        }
        if (insertionSpeed != 0) {
            System.out.println("Insertion speed: " + insertionSpeed + "s");
        }

        return 1;
    }

    public int sortContacts() {
        for (int i = 0; i < top; i++) {
            for (int j = 0; j < top; j++) {
                if (contacts.get(j)[0].equals(fNames[i]) && contacts.get(j)[1].equals(lNames[i])) {//checks first and last names match to ensure one person selcted
                    sortedContacts.add(contacts.get(j));
                }
            }
        }
        return 1;
    }

    public int sortArray(String sort, String criteria) {

        if (sort.equals("bubble")) {
            //System.out.println("");
            if (criteria.equals("first")) {
                bubbleSort("first");
                System.out.println("First names Bubble Sorted");

            } else if (criteria.equals("last")) {
                bubbleSort("last");
                System.out.println("Last names Bubble Sorted");

            }
            System.out.println("");
            outputSpeeds();
            //System.out.println("");
        } else if (sort.equals("insertion")) {
            System.out.println("");
            if (criteria.equals("first")) {
                InsertionSort("first");
                System.out.println("Insertion sorted by first names");
            } else if (criteria.equals("last")) {
                InsertionSort("last");
                System.out.println("Insertion sorted by last names ");
            }
            //System.out.println("");
            outputSpeeds();
            //System.out.println("");
        }

        sortContacts();
        con1.loadSortedArray(sortedContacts);
        return 1;
    }

    private int bubbleSort(String criteria) {

        double startnano = System.nanoTime();//Start time
        int i, j;
        String temp;
        String temp2;
        for (i = 0; i < fNames.length - 1; i++) {
            for (j = i + 1; j < fNames.length; j++) {
                if (criteria.equals("first")) {

                    if (fNames[i].compareToIgnoreCase(fNames[j]) > 0) {
                        swap(i, j);
                    }
                } else if (criteria.equals("last")) {
                    if (lNames[i].compareToIgnoreCase(lNames[j]) > 0) {
                        swap(i, j);
                    }
                }
            }
        }
        double endNano = System.nanoTime(); //End time
        this.bubbleSpeed = (endNano - startnano) / 1000000000;
        return 1;
    }

    private int swap(int i, int j) {
        String temp;
        String temp2;
        temp = fNames[i];
        fNames[i] = fNames[j];    // swapping
        fNames[j] = temp;
        temp2 = lNames[i];
        lNames[i] = lNames[j];    // swapping
        lNames[j] = temp2;
        return 1;
    }

    private int InsertionSort(String criteria) {

        double startnano = System.nanoTime();//Start time
        int right = 1;
        int left = 0;

        while (right < top) {
            left = right - 1;
            if (criteria.equals("first")) {

                if (fNames[left].compareToIgnoreCase(fNames[right]) > 0) {
                    for (int i = left; i + 1 > 0; i--) {
                        if (fNames[i].compareToIgnoreCase(fNames[i + 1]) > 0) {
                            swap(i, i + 1);
                        }
                    }
                }
            } else if (criteria.equals("last")) {
                if (lNames[left].compareToIgnoreCase(lNames[right]) > 0) {
                    for (int i = left; i + 1 > 0; i--) {
                        if (lNames[i].compareToIgnoreCase(lNames[i + 1]) > 0) {
                            swap(i, i + 1);
                        }
                    }
                }
            }
            right++;
        }
        //sortContacts();
        //con1.loadSortedArray(sortedContacts);
        double endNano = System.nanoTime(); //End time
        this.insertionSpeed = (endNano - startnano) / 1000000000;
        return 1;
    }

}
