/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import inventory_pbo.Conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Item;

/**
 *
 * @author Wahyu Pranata
 */
public class ItemController {
    Connection conn = (new Conn()).getConnection();
    String table = "items";
    public List<Item> getItems()
    {
        List<Item> items = new ArrayList<Item>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + table);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int stock = rs.getInt("stock");
                String unit = rs.getString("unit");
                String type = rs.getString("type");

                Item item = new Item(id, name, stock, unit, type);
                items.add(item);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong\n" + e.getMessage());
        }
        return items;
    }
    
    public boolean insertItem(String name, int stock, String unit, String type)
    {
        boolean isSuccess = false;
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO " + table + " (name, stock, type, unit) VALUES (?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setInt(2, stock);
            ps.setString(3, unit);
            ps.setString(4, type);
            if(ps.executeUpdate() > 0) {
                isSuccess = true;
            }
        } catch(SQLException e) {
            System.out.println("Something went wrong\n" + e.getMessage());
        }
        return isSuccess;
    }
}
