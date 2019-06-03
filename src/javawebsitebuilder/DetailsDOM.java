/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsitebuilder;

/**
 *extends the DocumentObjectModel class template with inner body content of contact details
 * @author 1636326
 */
public class DetailsDOM extends DocumentObjectModel {

    public DetailsDOM(Connection Con1, int pPageNumber) {
        super(Con1, pPageNumber);
        details();
    }
 /**
  * container elements, background image element, loading animation elements
  * @return 
  */
    private int details() {

        document.getNodes(new int[]{0, 1}).addNode("div", "", " id='container' class='' style='padding-left:0;'", true);//main page div
        document.getNodes(new int[]{0, 1, 0}).addNode("a", "Back to Contacts", " class='backLink' onclick='backButton()'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("div", "", " class='bannerCont' ", true);
        document.getNodes(new int[]{0, 1, 0, 1}).addNode("img", "", " id='bannerImg' class='bgImg' ", true);
        document.getNodes(new int[]{0, 1, 0, 1}).addNode("div", "Loading...", " id='scannerC' class='scannerCont' ", true);
        document.getNodes(new int[]{0, 1, 0, 1, 1}).addNode("div", "", " id='' class='nightRider1' ", true);
        document.getNodes(new int[]{0, 1, 0, 1, 1}).addNode("div", "", " id='' class='nightRider2' ", true);
        document.getNodes(new int[]{0, 1, 0, 1, 1}).addNode("div", "", " id='' class='nightRider3' ", true);
        document.getNodes(new int[]{0, 1, 0, 1, 1}).addNode("div", "", " id='' class='nightRider4' ", true);
        document.getNodes(new int[]{0, 1, 0, 1}).addNode("div", "", " id='titleGradient' class='tGradient' ", true);
        addContactDetails();
        return 1;
    }
/**
 * Creates all the elements for the details of the contact.
 * 
 * @return 
 */
    private int addContactDetails() {// 
        String clubIconURL = "https://img.icons8.com/windows/64/000000/dancing-party.png";
        String businessIconURL = "https://img.icons8.com/windows/64/000000/client-company.png";
        String privateIconURL = "https://img.icons8.com/windows/64/000000/lock.png";
        document.getNodes(new int[]{0, 1, 0}).addNode("h1", contacts.get(pageNumber)[0] + " " + contacts.get(pageNumber)[1], " id='nameTitle'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("img", "", " id='flagImg' flag='" + contacts.get(pageNumber)[3] + "' src=\"https://www.countryflags.io/" + contacts.get(pageNumber)[3] + "/shiny/64.png\" alt='Flag'", false);
        document.getNodes(new int[]{0, 1, 0}).addNode("a", "", " id='flagCountry'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("h4", "Email: " + contacts.get(pageNumber)[2], " id='DEmail' class='details dEmail'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("div", "" + contacts.get(pageNumber)[5], " id='DCat' class='details dCat'", true);
        String catString = contacts.get(pageNumber)[5];
        if ("club".equals(catString)) {
            document.getNodes(new int[]{0, 1, 0, 6}).addNode("img", "", " class='catIconDetails' src=" + clubIconURL + "", false);
        } else if ("business".equals(catString)) {
            document.getNodes(new int[]{0, 1, 0, 6}).addNode("img", "", " class='catIconDetails' src=" + businessIconURL + "", false);
        } else if ("private".equals(catString)) {
            document.getNodes(new int[]{0, 1, 0, 6}).addNode("img", "", " class='catIconDetails' src=" + privateIconURL + "", false);
        }
        document.getNodes(new int[]{0, 1, 0}).addNode("h4", "ID: " + contacts.get(pageNumber)[4], " class='details dID'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("div", "Info<span id='close'>Close</span>", " id='info' class='infoContainer'", true);
        document.getNodes(new int[]{0, 1, 0, 8}).addNode("div", "Website Links:", " id='innerInfo'", true);
        document.getNodes(new int[]{0, 1, 0, 8, 0}).addNode("div", "Images of countries from <a href='https://unsplash.com/'  target='_blank'>Unsplash.com</a>", " id='innerInfoItem1'", true);
        document.getNodes(new int[]{0, 1, 0, 8, 0}).addNode("div", "Flags from <a href='https://countryflags.io/'  target='_blank'>CountryFlags.io</a>", " id='innerInfoItem2'", true);
        document.getNodes(new int[]{0, 1, 0, 8, 0}).addNode("div", "Icons from <a href='https://icons8.com/icons'  target='_blank'>Icon8.com</a>", " id='innerInfoItem3'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("div", "", " id='contentCont' ", true);
        document.getNodes(new int[]{0, 1, 0, 9}).addNode("div", "", " id='contentInnerCont' ", true);
        return 1;
    }

}
