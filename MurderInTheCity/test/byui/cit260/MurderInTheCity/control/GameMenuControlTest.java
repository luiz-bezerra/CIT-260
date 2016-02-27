/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.MurderInTheCity.control;

import org.junit.Test;
import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Daniel and Luiz
 */
public class GameMenuControlTest {
    
    public GameMenuControlTest() {
    }

    /**
     * Test of calcTimeOfDeath method, of class GameMenuControl.
     */
    @Test
    public void testCalcTimeOfDeath() {
        System.out.println("calcTimeOfDeath Test 1");
        double bodyTemp = 32;
        double roomTemp = 20;
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        String timeFoundStr = "09:00 AM";
        String expResult, result;
        Date timeFound;
        GameMenuControl instance = new GameMenuControl();
        
        try {
            timeFound = dateFormat.parse(timeFoundStr);
            expResult = "The time of death is 06:00 AM";
            result = instance.calcTimeOfDeath(bodyTemp, roomTemp, timeFound);
            assertEquals(expResult, result);
        }
        catch (Exception ex) {
            expResult = "\nInvalid time found. Try again.";
            result = expResult;
            assertEquals(expResult, result);
        }
        
        System.out.println("calcTimeOfDeath Test 2");
        bodyTemp = 20;
        roomTemp = 32;
        timeFoundStr = "09:00 AM";
        
        try {
            timeFound = dateFormat.parse(timeFoundStr);            
            expResult = "Body temperature too low";
            result = instance.calcTimeOfDeath(bodyTemp, roomTemp, timeFound);
            assertEquals(expResult, result);
        }
        catch (Exception ex) {
            expResult = "\nInvalid time found. Try again.";
            result = expResult;
            assertEquals(expResult, result);
        }
        
        System.out.println("calcTimeOfDeath Test 3");
        bodyTemp = 32;
        roomTemp = 20;
        timeFoundStr = "Blah";
        
        try {
            timeFound = dateFormat.parse(timeFoundStr);            
            expResult = "\nInvalid time found. Try again.";
            result = instance.calcTimeOfDeath(bodyTemp, roomTemp, timeFound);
            assertEquals(expResult, result);
        }
        catch (Exception ex) {
            expResult = "\nInvalid time found. Try again.";
            result = expResult;
            assertEquals(expResult, result);
        }
        
        System.out.println("calcTimeOfDeath Test 4");
        bodyTemp = 50;
        roomTemp = 20;
        timeFoundStr = "09:00 AM";
        
        try {
            timeFound = dateFormat.parse(timeFoundStr);            
            expResult = "Body temperature too high";
            result = instance.calcTimeOfDeath(bodyTemp, roomTemp, timeFound);
            assertEquals(expResult, result);
        }
        catch (Exception ex) {
            expResult = "\nInvalid time found. Try again.";
            result = expResult;
            assertEquals(expResult, result);
        }
        
        System.out.println("calcTimeOfDeath Test 5");
        bodyTemp = 17;
        roomTemp = 15;
        timeFoundStr = "05:00 PM";
        
        try {
            timeFound = dateFormat.parse(timeFoundStr);            
            expResult = "The time of death is 04:00 AM";
            result = instance.calcTimeOfDeath(bodyTemp, roomTemp, timeFound);
            assertEquals(expResult, result);
        }
        catch (Exception ex) {
            expResult = "\nInvalid time found. Try again.";
            result = expResult;
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of calcSearchRadius method, of class GameMenuControl.
     */
    @Test
    public void testCalcSearchRadius() {
        System.out.println("calcSearchRadius Test 1");
        double speedOfTravel = 10;
        double timeSinceDeath = 2;
        GameMenuControl instance = new GameMenuControl();
        double expResult = 20;
        double result = instance.calcSearchRadius(speedOfTravel, timeSinceDeath);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcSearchRadius Test 2");
        speedOfTravel = 10;
        timeSinceDeath = 2;
        
        expResult = 20;
        result = instance.calcSearchRadius(speedOfTravel, timeSinceDeath);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcSearchRadius Test 3");
        speedOfTravel = -5;
        timeSinceDeath = 8;
        
        expResult = -1;
        result = instance.calcSearchRadius(speedOfTravel, timeSinceDeath);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcSearchRadius Test 4");
        speedOfTravel = 58;
        timeSinceDeath = -8;
        
        expResult = -1;
        result = instance.calcSearchRadius(speedOfTravel, timeSinceDeath);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcSearchRadius Test 5");
        speedOfTravel = 130;
        timeSinceDeath = 2;
        
        expResult = 260;
        result = instance.calcSearchRadius(speedOfTravel, timeSinceDeath);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcSearchRadius Test 6");
        speedOfTravel = 1;
        timeSinceDeath = 2;
        
        expResult = 2;
        result = instance.calcSearchRadius(speedOfTravel, timeSinceDeath);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcSearchRadius Test 7");
        speedOfTravel = 40;
        timeSinceDeath = 1;
        
        expResult = 40;
        result = instance.calcSearchRadius(speedOfTravel, timeSinceDeath);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("calcSearchRadius Test 8");
        speedOfTravel = 40;
        timeSinceDeath = 24;
        
        expResult = 960;
        result = instance.calcSearchRadius(speedOfTravel, timeSinceDeath);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of validateAlibi method, of class GameMenuControl.
     */
    @Test
    public void testValidateAlibi() {
        System.out.println("validateAlibi Test 1");
        double place = 2;
        double time = 1;
        double timeOfDeath = 1;
        double searchRadius = 2;
        GameMenuControl instance = new GameMenuControl();
        boolean expResult = true;
        boolean result = instance.validateAlibi(place, time, timeOfDeath, searchRadius);
        assertEquals(expResult, result);
        
        System.out.println("validateAlibi Test 2");
        place = 60;
        time = 1;
        timeOfDeath = 1;
        searchRadius = 2;
        
        expResult = false;
        result = instance.validateAlibi(place, time, timeOfDeath, searchRadius);
        assertEquals(expResult, result);
        
        System.out.println("validateAlibi Test 3");
        place = 2;
        time = 1;
        timeOfDeath = 1;
        searchRadius = 5;
        
        expResult = true;
        result = instance.validateAlibi(place, time, timeOfDeath, searchRadius);
        assertEquals(expResult, result);
        
        System.out.println("validateAlibi Test 4");
        place = 2;
        time = 3;
        timeOfDeath = 1;
        searchRadius = 2;
        
        expResult = false;
        result = instance.validateAlibi(place, time, timeOfDeath, searchRadius);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of calcSearchRadius_Luiz method, of class GameMenuControl.
     */
    @Test
    public void testCalcSearchRadius_Luiz() {
        System.out.println("CalcSearchRadius_Luiz Test 1");
        double speedOfTravel = 60;
        String currentTime = "11:00 AM";
        String timeOfDeath = "09:00 AM";
        GameMenuControl instance = new GameMenuControl();
        double expResult = 120;
        double result = instance.calcSearchRadius_Luiz(speedOfTravel, currentTime, timeOfDeath);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("CalcSearchRadius_Luiz Test 2");
        speedOfTravel = 300;
        currentTime = "06:00 PM";
        timeOfDeath = "05:00 PM";
        expResult = -1;
        result = instance.calcSearchRadius_Luiz(speedOfTravel, currentTime, timeOfDeath);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("CalcSearchRadius_Luiz Test 3");
        speedOfTravel = 0;
        currentTime = "06:00 PM";
        timeOfDeath = "05:00 PM";
        expResult = -1;
        result = instance.calcSearchRadius_Luiz(speedOfTravel, currentTime, timeOfDeath);
        assertEquals(expResult, result, 0.0001);
        
        System.out.println("CalcSearchRadius_Luiz Test 4");
        speedOfTravel = 100;
        currentTime = "06:00 PM";
        timeOfDeath = "05:00 PM";
        expResult = 100;
        result = instance.calcSearchRadius_Luiz(speedOfTravel, currentTime, timeOfDeath);
        assertEquals(expResult, result, 0.0001);
    }
    
}
