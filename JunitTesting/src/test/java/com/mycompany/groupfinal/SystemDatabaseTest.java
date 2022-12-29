/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.groupfinal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hanyunguo
 */
public class SystemDatabaseTest {
    
    public SystemDatabaseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    /**
     * Test of addBuilding method, of class SystemDatabase.
     */
    @Test
    public void testAddBuilding() {
        System.out.println("addBuilding");
        Building newBuilding = new Building("WSC","UWO");
        SystemDatabase instance = new SystemDatabase();
        instance.addBuilding(newBuilding);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("WSC", newBuilding.getName());
    }
    
    
    /**
     * Test of showBuidings method, of class SystemDatabase.
     */
    
    @Test
    public void testShowBuidings() {
        System.out.println("showBuidings");
        Building newBuilding = new Building("WSC","UWO");
        SystemDatabase instance = new SystemDatabase();
        instance.addBuilding(newBuilding);
        String expResult = "WSC";
        String result = instance.showBuidings();
        assertEquals(expResult, result.trim());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of showMaps method, of class SystemDatabase.
     */
    @Test
    public void testShowMaps() {
        System.out.println("showMaps");
        Building newBuilding = new Building("WSC","UWO Building");
        Map newMap = new Map("WSC",newBuilding);
        SystemDatabase instance = new SystemDatabase();
        instance.addBuilding(newBuilding);
        instance.addMap(newBuilding, newMap);
        instance.findBuilding(newBuilding);
        String expResult = "WSC";
        String result = instance.showMaps(newBuilding);
        assertEquals(expResult, result.trim());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of showLayers method, of class SystemDatabase.
     */
    @Test
    public void testShowLayers() {
        System.out.println("showLayers");
        Building buildingname = new Building("WSC","UWO Building");
        Map newMap = new Map("floor1",buildingname);
        SystemDatabase instance = new SystemDatabase();
        instance.addBuilding(buildingname);
        instance.addMap(buildingname, newMap);
        instance.findBuilding(buildingname);
        Layer newLayer = new Layer(newMap, "floor1", "floor", 123, 4, 5);
        instance.addLayer(buildingname, newMap, newLayer);
        String expResult = "floor1";
        String result = instance.showLayers(buildingname, newMap);
        assertEquals(expResult, result.trim());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of showPois method, of class SystemDatabase.
     */
    @Test
    public void testShowPois() {
        System.out.println("showPois");
        Building buildingname = new Building("WSC","UWO Building");
        Map newMap = new Map("floor1",buildingname);
        Poi newPoi = new Poi(newMap, "room3", "classroom", "a room in UWO building", 12, 34, true);
        SystemDatabase instance = new SystemDatabase();
        instance.addBuilding(buildingname);
        instance.addMap(buildingname, newMap);
        instance.findBuilding(buildingname);
        instance.addPoi(buildingname, newMap, newPoi);
        String expResult = "room3";
        String result = instance.showPois(buildingname, newMap);
        assertEquals(expResult, result.trim());
        // TODO review the generated test code and remove the default call to fail.
    }


    /**
     * Test of addMap method, of class SystemDatabase.
     */
    @Test
    public void testAddMap() {
        System.out.println("addMap");
        Building buildingname = new Building("WSC","UWO Building");
        Map newMap = new Map("floor1",buildingname);
        SystemDatabase instance = new SystemDatabase();
        instance.addBuilding(buildingname);
        instance.addMap(buildingname, newMap);
        instance.findBuilding(buildingname);
        String expResult = "floor1";
        instance.addMap(buildingname, newMap);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, newMap.getName().trim());
        
    }

    /**
     * Test of addLayer method, of class SystemDatabase.
     */
    @Test
    public void testAddLayer() {
        System.out.println("addLayer");
        Building buildingname = new Building("WSC","UWO Building");
        Map newMap = new Map("floor1",buildingname);
        Layer newLayer = new Layer(newMap, "floor1", "floor", 123, 4, 5);
        SystemDatabase instance = new SystemDatabase();
        instance.addLayer(buildingname, newMap, newLayer);
        // TODO review the generated test code and remove the default call to fail.
        String expResult = "floor1";
        assertEquals(expResult, newLayer.getName().trim());
        
    }

    /**
     * Test of removeMap method, of class SystemDatabase.
     */
    @Test
    public void testRemoveMap() {
        System.out.println("removeMap");
        Building buildingname = new Building("WSC","UWO Building");
        Map newMap = new Map("floor1",buildingname);
        SystemDatabase instance = new SystemDatabase();
        instance.addBuilding(buildingname);
        instance.addMap(buildingname, newMap);
        instance.findBuilding(buildingname);
        instance.removeMap(buildingname, newMap);
        String result = instance.showMaps(buildingname);
        // TODO review the generated test code and remove the default call to fail.
        String expResult = "";
        assertEquals(expResult, result);
    }

    /**
     * Test of removeLayer method, of class SystemDatabase.
     */
    @Test
    public void testRemoveLayer() {
        System.out.println("removeLayer");
        Building buildingname = new Building("WSC","UWO Building");
        Map newMap = new Map("floor1",buildingname);
        Layer selectedLayer = new Layer(newMap, "floor1", "floor", 123, 4, 5);
        SystemDatabase instance = new SystemDatabase();
        instance.addLayer(buildingname, newMap, selectedLayer);
        instance.removeLayer(buildingname, newMap, selectedLayer);
        // TODO review the generated test code and remove the default call to fail.
        String result = instance.showLayers(buildingname, newMap);
        String expResult = "";
        assertEquals(expResult, result);
    }

    /**
     * Test of removePoi method, of class SystemDatabase.
     */
    @Test
    public void testRemovePoi() {
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
        assertEquals(expResult, result);
    }

    /**
     * Test of findBuilding method, of class SystemDatabase.
     */
    @Test
    public void testFindBuilding() {
        System.out.println("findBuilding");
        Building buildingname = new Building("WSC","UWO Building");
        SystemDatabase instance = new SystemDatabase();
        Building expResult = buildingname;
        instance.addBuilding(buildingname);
        Building result = instance.findBuilding(buildingname);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
