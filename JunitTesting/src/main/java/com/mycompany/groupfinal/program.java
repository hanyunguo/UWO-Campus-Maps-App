/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.groupfinal;

/**
 *
 * @author hanyunguo
 */
public class program {
    public static void main(String[]args){
        System.out.println("removePoi");
        Building buildingname = new Building("WSC","UWO Building");
        Map newMap = new Map("floor1",buildingname);
        Poi selectedPoi = new Poi(newMap, "room3", "classroom", "a room in UWO building", 12, 34, true);
        SystemDatabase instance = new SystemDatabase();
        // TODO review the generated test code and remove the default call to fail.
        instance.addBuilding(buildingname);
        instance.addMap(buildingname, newMap);
        instance.findBuilding(buildingname);
        instance.addPoi(buildingname, newMap, selectedPoi);
        instance.removePoi(buildingname, newMap, selectedPoi);
        String expResult = "";
        String result = instance.showPois(buildingname, newMap);
        System.out.println(result);
    
}
}
