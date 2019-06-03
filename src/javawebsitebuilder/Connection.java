/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebsitebuilder;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *Connects to local database using nested try catch statements to determine correct file paths for different machines. 
 * Selects all contacts and stores them in an arrayList.
 * determines correct user for writing to file path in writeToFile class
 * @author 1636326
 */
public class Connection {

    private static Connection unique;
    private ArrayList<String[]> DBDumpArrays = new ArrayList<>();
    private java.sql.Connection connection = null;
    private String user;

    private Connection() {

        try {

            try {// check which of three computers this is running on to get correct user paths
                connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\1636326\\OneDrive - Dundee and Angus College\\year 2 work\\netbeansJavaProjects\\JavaWebSiteBuilder\\src\\contacts2.db");
                System.out.println("Using college system.");
                this.user = "1636326";
            } catch (Exception errorm) {
                try {
                    connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\CubeRyzen\\OneDrive - Dundee and Angus College\\year 2 work\\netbeansJavaProjects\\JavaWebSiteBuilder\\src\\contacts2.db");
                    System.out.println("Using home system.");
                    this.user = "CubeRyzen";
                } catch (Exception errorm2) {
                    connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\martin\\OneDrive - Dundee and Angus College\\year 2 work\\netbeansJavaProjects\\JavaWebSiteBuilder\\src\\contacts2.db");
                    System.out.println("Using laptop.");
                    this.user = "martin";
                }
            }

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from contacts");
            ResultSetMetaData rsmd = rs.getMetaData();
            //column:
            //0 - first_name, 1 - last_name, 2 - email, 3 - countrycode, 4 - id, 5 - category
            int columnsNumber = rsmd.getColumnCount();
            int count = 0;
            while (rs.next()) {
                DBDumpArrays.add(new String[columnsNumber]);
                for (int i = 0; i < columnsNumber; i++) {
                    DBDumpArrays.get(count)[i] = rs.getString(i + 1);
                }
                count++;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + "connection error");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
/**
 * Ensures only one connection instance
 * @return Connection 
 */
    public static Connection getInstance() {

        if (unique == null) {
            unique = new Connection();
        }
        return unique;
    }
/**
 * 
 * @return ArrayList<String[]> of contacts
 */
    public ArrayList<String[]> getArray() {

        return DBDumpArrays;
    }
/**
 * Allows modifying of the contacts arrayList
 * @param DBArrays
 * @return 1
 */
    public int loadSortedArray(ArrayList<String[]> DBArrays) {
        DBDumpArrays = DBArrays;
        return 1;
    }
/**
 * returns the correct user from the connection try catch. This is used later in the write to file class
 * @return user 
 */
    public String getUser() {
        return this.user;
    }

}
