package javawebsitebuilder;

import java.util.ArrayList;

public class DOM {// this class creates pages. 

    private final DOMNode document = new DOMNode();// root node
    private final ArrayList<String[]> contacts;
    private final int pageNumber;

    public DOM(String pageTemplate, Connection Con1, int pPageNumber) {

        this.pageNumber = pPageNumber - 1;
        contacts = Con1.getArray();// get array of contacts

        template(); // create page DOM except for BODY nodes
        if ("index".equals(pageTemplate)) {// add index page BODY nodes
            index();
        } else if ("details".equals(pageTemplate)) {// add details page BODY nodes
            details();
        }

    }

    private int template() {

        document.addNode("html", "", "", true);// html node
        document.getNode(0).addNode("head", "", "", true);// head node
        document.getNodes(new int[]{0, 0}).addNode("script", "", " type=\"text/javascript\" src='contactJS.js'", true);// add Javascript node
        document.getNodes(new int[]{0, 0}).addNode("meta", "", " charset='utf-8' name='viewport' content='width=device-width'", false);
        document.getNodes(new int[]{0, 0}).addNode("link", "", " href=\"https://fonts.googleapis.com/css?family=Quattrocento+Sans:700\" rel=\"stylesheet\"", false);
        if (pageNumber == -1) {
            document.getNodes(new int[]{0, 0}).addNode("title", "Home page", "", true);
        } else {
            document.getNodes(new int[]{0, 0}).addNode("title", contacts.get(pageNumber)[0] + " " + contacts.get(pageNumber)[1], "", true);
        }
        document.getNodes(new int[]{0, 0}).addNode("link", "", " rel=\"stylesheet\" type=\"text/css\" href=\"contactCSS.css\"", false);// add CSS node
        document.getNode(0).addNode("body", "", " class='font'", true);// body node
        return 1;
    }

    private int index() {

        document.getNodes(new int[]{0, 1}).addNode("div", "", " id='container'", true);//main page div
        document.getNodes(new int[]{0, 1, 0}).addNode("h1", "Contacts", " id='contactHeader'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("div", "", " id='contactListContainer'", true);
        document.getNodes(new int[]{0, 1, 0, 1}).addNode("div", "", " id='innerListContainer'", true);
        addContactElements();
        document.getNodes(new int[]{0, 1, 0}).addNode("div", "", " id='latestContainer'", true);
        document.getNodes(new int[]{0, 1, 0, 2}).addNode("div", "", " id='innerLatestContainer'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("div", "", " id='buttonsContainer'", true);
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("input", "", " type=\"text\" id=\"countrySearch\" onkeyup=\"search([ '#444', '#cc9900', '#357' ])\" placeholder=\"Country..\"", false);
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("input", "", " type=\"text\" id=\"nameSearch\" onkeyup=\"search([ '#444', '#cc9900', '#357' ]);\" placeholder=\"Name..\"", false);
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("div", " Search Totals - ", " id='findresult'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("div", "Info", " id='info'", true);
        document.getNodes(new int[]{0, 1, 0, 4}).addNode("div", "Website Links:", " id='innerInfo'", true);
        document.getNodes(new int[]{0, 1, 0, 4, 0}).addNode("div", "Images of cats and dogs from Unsplash.com", " id='innerInfoItem1'", true);
        document.getNodes(new int[]{0, 1, 0, 4, 0}).addNode("div", "Flags from..", " id='innerInfoItem2'", true);
        document.getNodes(new int[]{0, 1, 0, 4, 0}).addNode("div", "Icons from..", " id='innerInfoItem3'", true);

        int[] catstats = getcategoryAmounts();
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("div", "", " id='selectCat1t' class='categoryButtonView' onclick='' style=''", true);
        //document.getNodes(new int[]{0, 1, 0, 3, 3}).addNode("img", "", " class='catIconAll catButtonIcons' src=\"https://img.icons8.com/windows/32/000000/100-percents.png\"", false);
        document.getNodes(new int[]{0, 1, 0, 3, 3}).addNode("div", "Viewing: ", " id='viewing' class='categoryViewing'", true);
        //document.getNodes(new int[]{0, 1, 0, 3, 3}).addNode("div", Integer.toString(catstats[0] + catstats[1] + catstats[2]), " id='selectAllData' class='categoryData'", true);
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("div", "", " id='selectCat2' class='categoryButtons' onclick='catButtons(this.id);'", true);
        document.getNodes(new int[]{0, 1, 0, 3, 4}).addNode("img", "", " class='catIconClub catButtonIcons' src=\"https://img.icons8.com/windows/32/000000/dancing-party.png\"", false);
        document.getNodes(new int[]{0, 1, 0, 3, 4}).addNode("div", "Club", " id='selectClub' class='categoryLabel'", true);
        document.getNodes(new int[]{0, 1, 0, 3, 4}).addNode("div", Integer.toString(catstats[0]), " id='selectClubData' class='categoryData'", true);
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("div", "", " id='selectCat3' class='categoryButtons' onclick='catButtons(this.id);'", true);
        document.getNodes(new int[]{0, 1, 0, 3, 5}).addNode("img", "", " class='catIconBusiness catButtonIcons' src=\"https://img.icons8.com/windows/32/000000/client-company.png\"", false);
        document.getNodes(new int[]{0, 1, 0, 3, 5}).addNode("div", "Business", " id='selectBusiness' class='categoryLabel'", true);
        document.getNodes(new int[]{0, 1, 0, 3, 5}).addNode("div", Integer.toString(catstats[1]), " id='selectBusinessData' class='categoryData'", true);
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("div", "", " id='selectCat4' class='categoryButtons' onclick='catButtons(this.id);'", true);
        document.getNodes(new int[]{0, 1, 0, 3, 6}).addNode("img", "", " class='catIconPrivate catButtonIcons' src=\"https://img.icons8.com/windows/32/000000/lock.png\"", false);
        document.getNodes(new int[]{0, 1, 0, 3, 6}).addNode("div", "Private", " id='selectPrivate' class='categoryLabel'", true);
        document.getNodes(new int[]{0, 1, 0, 3, 6}).addNode("div", Integer.toString(catstats[2]), " id='selectPrivateData' class='categoryData'", true);
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("canvas", "", " id='pie' width='170' height='170' style='margin-top:15px;'", true);
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("div", "", " id='selectCat1'  style='' onclick='catButtons(this.id);'", true);
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("div", "", " id='pieRing'  style=''", true);
        document.getNodes(new int[]{0, 1, 0, 3, 8}).addNode("div", "Total", " id='selectAll' class='categoryLabelAll'", true);
        document.getNodes(new int[]{0, 1, 0, 3, 8}).addNode("div", Integer.toString(catstats[0] + catstats[1] + catstats[2]), " id='selectAllData' class='categoryDataAll'", true);
        document.getNodes(new int[]{0, 1, 0, 3, 8}).addNode("div", "ALL", " id='total' class='totalAll'", true);
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("div", "Clear", " class='clearButtons clearCountry' onclick='clearSearch(\"country\")'", true);
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("div", "Clear", " class='clearButtons clearName' onclick='clearSearch(\"name\")'", true);
        return 1;
    }

    private int addContactElements() {
        //each contact item is made here with an <a> element with a <div> inside it for the name.
        // the flag and country are added client-side through Javacript
        for (int i = 0; i < contacts.size(); i++) {
            document.getNodes(new int[]{0, 1, 0, 1, 0}).addNode("div", "", "   name='" + contacts.get(i)[0] + "' lastName='" + contacts.get(i)[1] + "' country='" + contacts.get(i)[3] + "' category='" + contacts.get(i)[5] + "' class='listFlags' ", true);
            document.getNodes(new int[]{0, 1, 0, 1, 0}).getNode(i).addNode("a", contacts.get(i)[0] + " " + contacts.get(i)[1], " href='" + (i + 1) + ".html' class='nameDivs'", true);
            addIcons(i);
        }
        return 1;
    }

    private int addIcons(int nodeI) {

        String clubIconURL = "https://img.icons8.com/windows/48/000000/dancing-party.png";
        String businessIconURL = "https://img.icons8.com/windows/48/000000/client-company.png";
        String privateIconURL = "https://img.icons8.com/windows/48/000000/lock.png";

        String category = contacts.get(nodeI)[5];
        if ("club".equals(category)) {
            document.getNodes(new int[]{0, 1, 0, 1, 0}).getNode(nodeI).addNode("img", "", " class='catIconClub catIcons' src=" + clubIconURL + "", false);
        } else if ("business".equals(category)) {
            document.getNodes(new int[]{0, 1, 0, 1, 0}).getNode(nodeI).addNode("img", "", " class='catIconBusiness catIcons' src=" + businessIconURL + "", false);
        } else if ("private".equals(category)) {
            document.getNodes(new int[]{0, 1, 0, 1, 0}).getNode(nodeI).addNode("img", "", " class='catIconPrivate catIcons' src=" + privateIconURL + "", false);
        }
        return 1;
    }

    private int details() {

        document.getNodes(new int[]{0, 1}).addNode("div", "", " id='container' class='' style='padding-left:0;'", true);//main page div
        document.getNodes(new int[]{0, 1, 0}).addNode("a", "Back to Contacts", " class='backLink' onclick='backButton()'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("div", "", " class='bgImg' ", true);
        addContactDetails();
        return 1;
    }

    private int addContactDetails() {// 
        String clubIconURL = "https://img.icons8.com/windows/64/000000/dancing-party.png";
        String businessIconURL = "https://img.icons8.com/windows/64/000000/client-company.png";
        String privateIconURL = "https://img.icons8.com/windows/64/000000/lock.png";
        document.getNodes(new int[]{0, 1, 0}).addNode("h1", contacts.get(pageNumber)[0] + " " + contacts.get(pageNumber)[1], " id='nameTitle'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("img", "", " id='flagImg' flag='" + contacts.get(pageNumber)[3] + "' src=\"https://www.countryflags.io/" + contacts.get(pageNumber)[3] + "/shiny/64.png\" alt='Flag'", false);
        document.getNodes(new int[]{0, 1, 0}).addNode("a", "", " id='flagCountry'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("h4", "Email: " + contacts.get(pageNumber)[2], " class='details dEmail'", true);
        document.getNodes(new int[]{0, 1, 0}).addNode("div", "Category: " + contacts.get(pageNumber)[5], " class='details dCat'", true);
        String catString = contacts.get(pageNumber)[5];
        if ("club".equals(catString)) {
            document.getNodes(new int[]{0, 1, 0, 6}).addNode("img", "", " class='catIconDetails' src=" + clubIconURL + "", false);
        } else if ("business".equals(catString)) {
            document.getNodes(new int[]{0, 1, 0, 6}).addNode("img", "", " class='catIconDetails' src=" + businessIconURL + "", false);
        } else if ("private".equals(catString)) {
            document.getNodes(new int[]{0, 1, 0, 6}).addNode("img", "", " class='catIconDetails' src=" + privateIconURL + "", false);
        }
        document.getNodes(new int[]{0, 1, 0}).addNode("h4", "ID: " + contacts.get(pageNumber)[4], " class='details dID'", true);
        return 1;
    }

    public int[] getcategoryAmounts() { //for initial category counts

        int club = 0;
        int business = 0;
        int privateInt = 0;

        for (int i = 0; i < contacts.size(); i++) {
            String temp = contacts.get(i)[5];
            if (null != temp) {
                switch (temp) {
                    case "club":
                        club++;
                        break;
                    case "business":
                        business++;
                        break;
                    case "private":
                        privateInt++;
                        break;
                    default:
                        break;
                }
            }
        }
        int[] catstats = {club, business, privateInt};
        return catstats;
    }

    public String page() {
        return document.toString(); // this starts a fun fractal toString() cascade through the DOM tree :D
    }

}
