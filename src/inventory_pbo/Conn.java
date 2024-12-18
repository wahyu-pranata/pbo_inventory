/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_pbo;
import java.sql.*;

/**
 *
 * @author Wahyu Pranata
 */
public class Conn {
  static final String DB_URL = "jdbc:mysql://localhost:3306/inventory_pbo";
  static final String DB_USER = "root";
  static final String DB_PASS = "";
  static private Connection dbConn = null;

    public Connection getConnection() {
      try {
        dbConn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);        
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
      return dbConn;
    }
}
