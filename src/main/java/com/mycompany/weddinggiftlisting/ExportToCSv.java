/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.weddinggiftlisting;

/**
 *
 * @author lokeshmakode
 */
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExportToCSv {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:/Users/lokeshmakode/Documents/work/git/WeddingGiftListing/target/data_L1.db"; // Change to your database file
        String csvFile = "/Users/lokeshmakode/Documents/work/git/WeddingGiftListing/target/data_L1.csv";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM entries");
             FileWriter csvWriter = new FileWriter(csvFile)) {

            int columnCount = rs.getMetaData().getColumnCount();

            // Write headers
            for (int i = 1; i <= columnCount; i++) {
                csvWriter.append(rs.getMetaData().getColumnName(i));
                if (i < columnCount) csvWriter.append(",");
            }
            csvWriter.append("\n");

            // Write rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    csvWriter.append(rs.getString(i));
                    if (i < columnCount) csvWriter.append(",");
                }
                csvWriter.append("\n");
            }

            System.out.println("CSV file saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}