/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsitebuilder;

import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/**
 *write all files to disk,
 * user from connection class is used here to output to correct path
 * @author CubeRyzen
 */
public class WriteToFile {

    private String user;

    public WriteToFile() {

    }

    public int writeFile(String page, int pageName, String pUser) {

        this.user = pUser;
        if (user == "1636326") {
            try {
                if (pageName == 0) {
                    PrintWriter writer = new PrintWriter("\\\\gcfserver01\\Students\\16\\1636326\\Desktop\\Contacts\\index.html", "UTF-8");
                    writer.println(page);
                    writer.close();
                } else {
                    PrintWriter writer = new PrintWriter("\\\\gcfserver01\\Students\\16\\1636326\\Desktop\\Contacts\\" + pageName + ".html", "UTF-8");
                    writer.println(page);
                    writer.close();

                }

            } catch (Exception e) {
                System.out.println("Error - " + e);
            } finally {

            }
        } else {
            try {
                if (pageName == 0) {
                    PrintWriter writer = new PrintWriter("C:\\Users\\" + user + "\\Desktop\\Contacts\\index.html", "UTF-8");
                    writer.println(page);
                    writer.close();
                } else {
                    PrintWriter writer = new PrintWriter("C:\\Users\\" + user + "\\Desktop\\Contacts\\" + pageName + ".html", "UTF-8");
                    writer.println(page);
                    writer.close();

                }

            } catch (Exception e) {
                System.out.println("Error - " + e);
            } finally {

            }
        }

        return 1;
    }
    // edit this to use strings that are descriptive instead of booleans that say nowt
    public int writeOutSite(ArrayList<DocumentObjectModel> pages, boolean toDisk, boolean toConsole, String pUser, int start, int end) {

        for (int i = start; i < end; i++) {
            if (toConsole) {
                System.out.println("Page: " + i);
                System.out.println(pages.get(i).page());
            }
            if (toDisk) {
                writeFile(pages.get(i).page(), i, pUser);
            }
        }
        if (toDisk) {
            try {
                writeCSSFile();
            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                writeJSFile();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return 1;
    }

    public int writeCSSFile() throws IOException {

        try {
            if ("1636326".equals(user)) {
                Path cssFile = Paths.get("C:\\Users\\1636326\\OneDrive - Dundee and Angus College\\year 2 work\\netbeansJavaProjects\\JavaWebSiteBuilder\\src\\javawebsitebuilder\\contactCSS.css");
                Path DestFile = Paths.get("\\\\gcfserver01\\Students\\16\\1636326\\Desktop\\Contacts\\contactCSS.css");
                System.out.println(Files.copy(cssFile, DestFile, StandardCopyOption.REPLACE_EXISTING) + " - Written");

            } else {
                Path cssFile = Paths.get("C:\\Users\\" + user + "\\OneDrive - Dundee and Angus College\\year 2 work\\netbeansJavaProjects\\JavaWebSiteBuilder\\src\\javawebsitebuilder\\contactCSS.css");
                Path DestFile = Paths.get("C:\\Users\\" + user + "\\Desktop\\Contacts\\contactCSS.css");
                System.out.println(Files.copy(cssFile, DestFile, StandardCopyOption.REPLACE_EXISTING) + " - Written");

            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return 1;
    }

    public int writeJSFile() throws IOException {

        try {
            if (user == "1636326") {
                Path JSFile = Paths.get("C:\\Users\\1636326\\OneDrive - Dundee and Angus College\\year 2 work\\netbeansJavaProjects\\JavaWebSiteBuilder\\src\\javawebsitebuilder\\contactJS.js");
                Path DestFile = Paths.get("\\\\gcfserver01\\Students\\16\\1636326\\Desktop\\Contacts\\contactJS.js");
                System.out.println(Files.copy(JSFile, DestFile, StandardCopyOption.REPLACE_EXISTING) + " - Written");
                
                Path JSFile2 = Paths.get("C:\\Users\\1636326\\OneDrive - Dundee and Angus College\\year 2 work\\netbeansJavaProjects\\JavaWebSiteBuilder\\src\\javawebsitebuilder\\datamaps.world.hires.min.js");
                Path DestFile2 = Paths.get("\\\\gcfserver01\\Students\\16\\1636326\\Desktop\\Contacts\\datamaps.world.hires.min.js");
                System.out.println(Files.copy(JSFile2, DestFile2, StandardCopyOption.REPLACE_EXISTING) + " - Written");
                

            } else {
                Path JSFile = Paths.get("C:\\Users\\" + user + "\\OneDrive - Dundee and Angus College\\year 2 work\\netbeansJavaProjects\\JavaWebSiteBuilder\\src\\javawebsitebuilder\\contactJS.js");
                Path DestFile = Paths.get("C:\\Users\\" + user + "\\Desktop\\Contacts\\contactJS.js");
                System.out.println(Files.copy(JSFile, DestFile, StandardCopyOption.REPLACE_EXISTING) + " - Written");

                Path JSFile2 = Paths.get("C:\\Users\\" + user + "\\OneDrive - Dundee and Angus College\\year 2 work\\netbeansJavaProjects\\JavaWebSiteBuilder\\src\\javawebsitebuilder\\datamaps.world.hires.min.js");
                Path DestFile2 = Paths.get("C:\\Users\\" + user + "\\Desktop\\Contacts\\datamaps.world.hires.min.js");
                System.out.println(Files.copy(JSFile2, DestFile2, StandardCopyOption.REPLACE_EXISTING) + " - Written");
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return 1;
    }
}
