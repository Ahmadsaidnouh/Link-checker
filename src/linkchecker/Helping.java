/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkchecker;

import static java.lang.Integer.parseInt;

/**
 *
 * @author Ahmad Nouh
 */
public class Helping {
    public static int getExecutionTime(String start, String end)
    {
        System.out.println(start + "  " + end);
        String[] info1 = start.split(":");
        int startHour = parseInt(info1[0]);
        int startMin = parseInt(info1[1]);
        int startSec = parseInt(info1[2]);
        String[] info2 = end.split(":");
        int endHour = parseInt(info2[0]);
        int endMin = parseInt(info2[1]);
        int endSec = parseInt(info2[2]);
        
        if(startHour == endHour)
        {
            if(startMin == endMin)
                return endSec - startSec;
            else   
                return ((endMin - (startMin + 1))*60) + (endSec + (60 - startSec));
        }
        else if(startHour > endHour)
        {
            return (endHour*3600) + ((endMin + (59 - startMin))*60) + (endSec + (60 - startSec));
        }
        else
        {
            return ((endHour - (startHour + 1))*3600) + ((endMin + (60 - startMin))*60) + (endSec + (60 - startSec));
        }
        
            
        
    }
    
    
}
