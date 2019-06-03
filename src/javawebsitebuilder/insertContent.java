/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsitebuilder;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Takes input of user content and modifies corresponding arrayList item
 * @author 1636326
 */
public class insertContent {

    private Website currentSite;
    private DocumentObjectModel selectedPage;
    private final Scanner scanner2 = new Scanner(System.in);

    public insertContent(Website currentSite) {
        this.currentSite = currentSite;
    }

    public int insertContent(int pageNumber, Website contacts) {

        selectedPage = currentSite.getPageDOM(pageNumber);
        DOMNode document = selectedPage.document;
        System.out.println("");
        System.out.println("Please enter the title of your content");
        String StTitle = scanner2.nextLine();
        System.out.println("Please enter your content (HTML5 content works too, eg - new line = <br>).");
        String StContent = tryScan();
        if (pageNumber == 0) {
            document.getNodes(new int[]{0, 1, 0, 2, 0}).addNode("div", StTitle + "<br>", " id='adminContentTitle'", true);
            document.getNodes(new int[]{0, 1, 0, 2, 0}).addNode("p", StContent + "<br>", " id='adminContent'", true);
            System.out.println(document.getNodes(new int[]{0, 1, 0, 2, 0}).toString());
        } else {
            document.getNodes(new int[]{0, 1, 0, 9, 0}).addNode("div", StTitle + "<br>", " id='adminContentTitle'", true);
            document.getNodes(new int[]{0, 1, 0, 9, 0}).addNode("p", StContent + "<br>", " id='adminContent'", true);
            System.out.println(document.getNodes(new int[]{0, 1, 0, 9, 0}).toString());
        }

        return 1;
    }

    public int insertTestContent(Website contacts) {

        selectedPage = currentSite.getPageDOM(0);
        DOMNode document = selectedPage.document;
        document.getNodes(new int[]{0, 1, 0, 2, 0}).addNode("div", "New contacts bonus <br>", " id='adminContentTitle'", true);
        document.getNodes(new int[]{0, 1, 0, 2, 0}).addNode("div", "For every new contact you get a gluten and taste free doughnut at the new trendy beard friendly reclaimed wood coffee bar<br>", " id='adminContent'", true);
         document.getNodes(new int[]{0, 1, 0, 2, 0}).addNode("div", "Trendy Coffee is now open <br>", " id='adminContentTitle'", true);
        document.getNodes(new int[]{0, 1, 0, 2, 0}).addNode("div", "New coffee bar is now open for business. If you love crappy over-priced coffee  and underpaid staff attitude then look no further.<br>", " id='adminContent'", true);
         document.getNodes(new int[]{0, 1, 0, 2, 0}).addNode("div", "No more phone abuse <br>", " id='adminContentTitle'", true);
        document.getNodes(new int[]{0, 1, 0, 2, 0}).addNode("div", "Stop calling the French and calling them names please.<br>", " id='adminContent'", true);
        System.out.println("Index page content added");

        for (int i = 1; i <= 1000; i++) {
            DocumentObjectModel selectedDetailPage = currentSite.getPageDOM(i);
            DOMNode documentDetail = selectedDetailPage.document;
            documentDetail.getNodes(new int[]{0, 1, 0, 9, 0}).addNode("div", "Admin notice.<br>", " id='adminContentTitle'", true);
            documentDetail.getNodes(new int[]{0, 1, 0, 9, 0}).addNode("div", "Please respect timezones. Calling customers in the middle of night is not goning to boost sales.<br>", " id='adminContent'", true);
        }

        System.out.println("Detail pages content added");

        return 1;
    }

    private String tryScan() {

        try {
            String inputScan = scanner2.nextLine();
            return inputScan;
        } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("--- Input mismatch---");
            System.out.println("");
            scanner2.nextLine();
        }
        return "";
    }
}
