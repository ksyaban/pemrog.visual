/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Othak Kosonk
 */
public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            DriverManager.
                    registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost/visual2", "root", "kucink");
            
        } catch (SQLException ex) {
            System.err.println("Something error: "+ex.getMessage());
        }
        return connection;
    }
}
