/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupfinal;

/**
 *
 * @author hanyunguo
 */
public class Main {
    
    
    
    public static void main (String[] args) {
        SystemDatabase sysDb = new SystemDatabase();
        Building newBuilding = new Building ("WSC", "UWO");  
        
        sysDb.addBuilding(newBuilding);
        
        System.out.println(sysDb.showBuidings());
       
    }
    
}
