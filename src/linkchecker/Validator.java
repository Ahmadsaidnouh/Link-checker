/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkchecker;

import java.io.IOException;
import java.net.URL;
import java.net.*;

/**
 *
 * @author Ahmad Nouh
 */
public class Validator {
    
    public static boolean isValidDepth(String depth)
    {
        if(depth.length() != 1)
            return false;
        else
        {
            if(depth.charAt(0) == '0' || depth.charAt(0) == '1' || depth.charAt(0) == '2')
                return true;
            else
                return false;
        }
    }
    
    
    public static boolean isValidURL(String url)
    {
        int response;
        try {
            URL testingURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) testingURL.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            response = connection.getResponseCode();
        } catch (IOException | ClassCastException ex) {
            response = 0;
        } catch (Exception e) {
            response  = 0;
        }
        
        
        if(response == 200)
        {
            System.out.println(url + " (Valid)");
            return true;
        }
        
        System.out.println(url + " (Invalid)");
        return false;
    }
}
