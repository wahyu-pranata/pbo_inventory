/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
/**
 *
 * @author Wahyu Pranata
 */
public class Item {
    public int id;
    public String name;
    public int stock;
    public String unit;
    public String type;
    
    
    
    public Item(int id, String name, int stock, String unit, String type)
    {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.unit = unit;
        this.type = type;
    }
   
}
