/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Karyawan;

import java.sql.*;

public class Connector {
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        }
        
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
