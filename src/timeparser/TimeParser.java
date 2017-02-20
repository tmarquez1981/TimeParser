/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timeparser;

/**
 *
 * @author tommarquez
 * CSCE 351
 * Assignment 2 #6
 * Changes I've made from previous submission: update regex code to accept
 * "d:dd (AM|FM) to d (AM|PM)" and also "d (AM|FM)".
 * This is a program that takes in a string (hardcoded string), uses regex
 * to parse the string, locate different formats of time (example HH:MM, military
 * time, and different time ranges such as "Time to Time") and prints out the matches
 * It follows the diagram of the the DFA I created (each deviation on the DFA is 
 * represented by the OR ("|") symbol in the regex )which is located on the PTF
 * for assignment 1. 
 * 
 * 
 * 
 */

import java.util.regex.*;

public class TimeParser {

    /**
     * @param args the command line arguments
     */
    // A time parsing method that uses regex to find different time formats
    // Some of the syntax was borrowed from the code example given by Professor Faye
    // via blackboard https://classes.alaska.edu/bbcswebdav/courses/CSCE_A351_001_201701/Code/RegExprTest.java
    public static void timeParse(String in)
    {
        //An interesting note: spaces aroud the OR symbol in the regex make a difference in the output. 
        
        Pattern p = Pattern.compile("(\\d{1,2}:\\d{2} (AM|PM) to \\d (AM|PM))|(\\d{1,2}(to|-)\\d{1,2} (AM|PM))|(at \\d{4})|(\\d{1,2}:\\d{2} (AM|PM))|(\\d{1,2} (AM|PM))");
        Matcher m = p.matcher(in);
        boolean result = m.find();
        
        while(result)
        {
            System.out.println(m.group());
            result = m.find();
        }
        
    }
    // Hardcoded string for the timeParse method
    public static void main(String[] args) {
        String text = "Hello Myra, the meeting is on 2/5 in room 1300. It will last from 1:30 AM to 2 PM. There will\n" +
            "be a sumptuous banquet afterward at 1800 hours. The address is 2300 Sycamore Lane.\n" +
            "Please RSVP by 5:30 PM on February 1 at 786-4819. You can check out our new wide\n" +
            "screen set with the 16:9 aspect ratio!";
        timeParse(text);
        
    }
    
}
