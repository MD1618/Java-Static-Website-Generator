/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsitebuilder;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Menu
 * @author CubeRyzen
 */
public class Menu {

    private static Menu unique;
    private final Scanner scanner = new Scanner(System.in);
    private final Connection con = Connection.getInstance();
    private final WriteToFile write1 = new WriteToFile();// create write object (should be static??)
    private final String user = con.getUser();// get user for correct paths
    private boolean websiteCreated = false;
    private ArrayList<DocumentObjectModel> site;
    private Website contacts;
    private final Sort sort1;
    private insertContent insertC;

    private Menu() {
        this.sort1 = new Sort(con);

    }
/**
 * Ensures the menu is only instantiated once
 * @return 
 */
    public static Menu getInstance() {

        if (unique == null) {
            unique = new Menu();
        }
        return unique;
    }

    public int showMenu() {

        boolean option = true;
        while (option) {
            System.out.println("Options - ");
            System.out.println("1 - Sort data");
            System.out.println("2 - View Pages and add content");
            System.out.println("3 - Show contacts in console");
            System.out.println("4 - Write to disk");
            System.out.println("5 - Test. Insertion sort by first name, add content to all pages then write to disk.");
            System.out.println("6 - Quit");

            int scan = tryScan();
            switch (scan) {
                case 1:
                    sortData();
                    option = false;
                    break;
                case 2:
                    //contacts = Website(con);// create website
                    insertC = new insertContent(Website.getInstance(con));
                    chooseView();
                    option = false;
                    break;
                case 3:
                    outputContactsToConsole();
                    break;
                case 4:
                    createAndWriteSite();
                    option = false;
                    break;
                case 5:

                    sort1.sortArray("insertion", "first");
                    // add content
                    insertC = new insertContent(Website.getInstance(con));
                    insertC.insertTestContent(contacts);
                    createAndWriteSite();
                    option = false;
                    break;
                case 6:
                    System.exit(0);

                    break;
                default:
                    if (scan != -1) {
                        System.out.println("");
                        System.out.println("--- Not an Option! ---");
                        System.out.println("");
                    }
                    break;
            }

        }
        return 1;
    }
    
     private int outputContactsToConsole() {
        boolean option = true;
        ArrayList<String[]> contactsList = con.getArray();
        while (option) {
            System.out.println("");
            System.out.println("All contacts or single contact?");
            System.out.println("1 - All contacts");
            System.out.println("2 - Single contact");
           
            int scan = tryScan();
            switch (scan) {
                case 1:
                    System.out.println("");
                    for (String[] strings : contactsList) {
                        for (String string : strings) {
                            System.out.println(string);
                        }
                        System.out.println(" ");
                    }
                    System.out.println("");
                    option = false;
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Enter a contact number from 1 - 1000");
                    int scan2 = tryScan();
                    String[] singleContact = contactsList.get(scan2);
                    for (String string : singleContact) {
                            System.out.println(string);
                        }
                    System.out.println("");
                    option = false;
                    break;
                default:
                    if (scan != -1) {
                        System.out.println("");
                        System.out.println("--- Not an Option! ---");
                        System.out.println("");
                    }
                    break;
            }
        }
        showMenu();
        return 1;
    }

    private int createAndWriteSite() {
        contacts = Website.getInstance(con);// 
        site = contacts.getSiteFiles();// get array of page DOMs
        write1.writeOutSite(site, true, false, user, 0, 1001);// (DOM Array,to disc,to console, start page,number of pages)
        return 1;
    }

    private int sortData() {
        boolean option = true;

        while (option) {
            System.out.println("");
            System.out.println("Sorting Options (Alphabetical)");
            System.out.println("1 - Sort by First Name");
            System.out.println("2 - Sort by Last Name");
            //Sort sort1 = new Sort(con);
            int scan = tryScan();
            switch (scan) {
                case 1:
                    sortType("first");
                    option = false;
                    break;
                case 2:
                    sortType("last");
                    option = false;
                    break;
                default:
                    if (scan != -1) {
                        System.out.println("");
                        System.out.println("--- Not an Option! ---");
                        System.out.println("");
                    }
                    break;
            }
        }
        showMenu();
        return 1;
    }

    private int sortType(String criteria) {
        boolean option = true;

        while (option) {
            System.out.println("");
            System.out.println("Sorting Method");
            System.out.println("1 - Bubble Sort");
            System.out.println("2 - Insertion Sort");
            System.out.println("3 - Selection Sort *** not implemented yet");
            System.out.println("4 - All 3 - Compare speeds *** not implemented yet");

            int scan = tryScan();
            switch (scan) {
                case 1:
                    sort1.sortArray("bubble", criteria);
                    option = false;
                    break;
                case 2:
                    sort1.sortArray("insertion", criteria);
                    option = false;
                    break;
                case 3:
                    //sort1.sortArray("selection", criteria);
                    //option = false;
                    System.out.println("Sorry this isn't working yet");
                    break;
                case 4:
                    System.out.println("Sorry this isn't working yet");
                    break;
                default:
                    if (scan != -1) {
                        System.out.println("");
                        System.out.println("--- Not an Option! ---");
                        System.out.println("");
                    }
                    break;
            }
        }
        showMenu();
        return 1;
    }

    private int chooseView() {
        boolean option = true;

        while (option) {
            System.out.println("");
            System.out.println("Options - ");
            System.out.println("1 - View Index.html");
            System.out.println("2 - View Details Page/s");
            System.out.println("3 - Add Content to a page");
            System.out.println("4 - Back to Main menu");
            System.out.println("5 - Quit");
            int scan = tryScan();
            switch (scan) {
                case 1:
                    viewIndexPage();
                    chooseView();
                    option = false;
                    break;
                case 2:
                    viewDetailPages();
                    chooseView();
                    option = false;
                    break;
                case 3:
                    addContent();
                    option = false;
                    break;
                case 4:
                    showMenu();
                    option = false;
                    break;
                case 5:
                    System.exit(0);
                    option = false;
                    break;
                default:
                    if (scan != -1) {
                        System.out.println("");
                        System.out.println("--- Not an Option! ---");
                        System.out.println("");
                    }

                    break;
            }
        }
        return 1;
    }

    private int addContent() {
        boolean option = true;
        while (option) {
            System.out.println("");
            System.out.println("Options - ");
            System.out.println("1 - Add content to Index.html");
            System.out.println("2 - Add content to a Details Page");
            System.out.println("3 - ");
            System.out.println("4 - Back to Main menu");
            System.out.println("5 - Quit");
            int scan = tryScan();
            switch (scan) {
                case 1:
                    insertC.insertContent(0, contacts);
                    option = false;
                    break;
                case 2:
                    System.out.println("Please enter the page number to add to:");
                    int scan2 = tryScan();
                    insertC.insertContent(scan2, contacts);
                    option = false;
                    break;
                case 3:

                    option = false;
                    break;
                case 4:
                    showMenu();
                    option = false;
                    break;
                case 5:
                    System.exit(0);
                    option = false;
                    break;
                default:
                    if (scan != -1) {
                        System.out.println("");
                        System.out.println("--- Not an Option! ---");
                        System.out.println("");
                    }
                    break;
            }
        }
        showMenu();
        return 1;
    }

    public int createContentElement(String pageToAddTo) {
        boolean option = true;
        while (option) {
            System.out.println("");
            System.out.println("Options - ");
            System.out.println("1 - Add Paragraph - <p>");
            System.out.println("2 - Add content to a Details Page");
            System.out.println("3 - ");
            System.out.println("4 - Back to Main menu");
            System.out.println("5 - Quit");
            int scan = tryScan();
            switch (scan) {
                case 1:

                    option = false;
                    break;
                case 2:

                    option = false;
                    break;
                case 3:

                    option = false;
                    break;
                case 4:

                    option = false;
                    break;
                case 5:
                    System.exit(0);
                    option = false;
                    break;
                default:
                    if (scan != -1) {
                        System.out.println("");
                        System.out.println("--- Not an Option! ---");
                        System.out.println("");
                    }
                    break;
            }
        }
        return 1;
    }

    private int viewIndexPage() {
        write1.writeOutSite(Website.getInstance(con).getSiteFiles(), false, true, user, 0, 1);// (DOM Array,to disc,to console, start page,number of pages)

        return 1;
    }

    private int viewDetailPages() {
        boolean option = true;
        int pagesScan;
        int numberPages;
        while (option) {
            System.out.println("");
            System.out.println("Details pages range from 1 - 1000");
            System.out.println("Enter start page:");
            pagesScan = tryScan();
            System.out.println("");
            System.out.println("Enter number of pages:");
            numberPages = tryScan();
            System.out.println("Getting " + numberPages + " pages.");
            write1.writeOutSite(Website.getInstance(con).getSiteFiles(), false, true, user, pagesScan, (pagesScan + numberPages));// (disk,console) write out to disk or console

            option = false;
        }

        return 1;
    }

    private int tryScan() {

        try {
            int inputScan = scanner.nextInt();
            return inputScan;
        } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("--- Numbers only please! ---");
            System.out.println("");
            scanner.nextLine();
        }
        return -1;
    }
}
