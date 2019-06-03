/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsitebuilder;

/**
 *extends the DocumentObjectModel class template with inner body content of the index page
 * 
 * @author 1636326
 */
public class IndexDOM extends DocumentObjectModel{
    
    
    /**
     * Create a page using the parent class then calls the inner body elements method
     * @param Con1
     * @param pPageNumber 
     */
    public IndexDOM( Connection Con1, int pPageNumber){
        super( Con1, pPageNumber);
        index();
    }
    /**
     * inner body elements method
     * @return 
     */
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
        document.getNodes(new int[]{0, 1, 0}).addNode("div", "Info<span id='close'>Close</span>", " id='info' class='infoContainer' ", true);
        document.getNodes(new int[]{0, 1, 0, 4}).addNode("div", "Website Links:", " id='innerInfo'", true);
        document.getNodes(new int[]{0, 1, 0, 4, 0}).addNode("div", "Images of countries from <a href='https://unsplash.com/'  target=\"_blank\">Unsplash.com</a>", " id='innerInfoItem1'", true);
        document.getNodes(new int[]{0, 1, 0, 4, 0}).addNode("div", "Flags from <a href='https://countryflags.io/'  target=\"_blank\">CountryFlags.io</a>", " id='innerInfoItem2'", true);
        document.getNodes(new int[]{0, 1, 0, 4, 0}).addNode("div", "Icons from <a href='https://icons8.com/icons'  target=\"_blank\">Icon8.com</a>", " id='innerInfoItem3'", true);
        document.getNodes(new int[]{0, 1}).addNode("div",""," id='mapDiv' class='mapCont' style=\"position: relative; width: 100vw; height: 100vh;\"",true);
        document.getNodes(new int[]{0, 1, 1}).addNode("img",""," id='' class='' onclick='mapHide()' style=\"position:absolute;top:20px;right:20px;\" src=\"https://img.icons8.com/small/48/000000/delete-sign.png\"",true);
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
        document.getNodes(new int[]{0, 1, 0, 3}).addNode("div", "Map", " class='clearButtons map' onclick='mapShow()'", true);
        return 1;
    }
    /**
     * 
     * @return 
     */
    private int addContactElements() {
        
        // the flag and country are added client-side through Javacript
        for (int i = 0; i < contacts.size(); i++) {
            document.getNodes(new int[]{0, 1, 0, 1, 0}).addNode("div", "", "   name=\"" + contacts.get(i)[0] + "\" lastName=\"" + contacts.get(i)[1] + "\" country='" + contacts.get(i)[3] + "' category='" + contacts.get(i)[5] + "' class='listFlags' ", true);
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
    /**
     * counts the amount of each category and returns this in an integer array
     * @return 
     */
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
    
}
