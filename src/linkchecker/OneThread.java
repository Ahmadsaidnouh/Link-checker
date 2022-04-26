/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkchecker;

import static java.lang.Integer.parseInt;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OneThread {

    public static void main(String[] args) {

        String url = args[0];
        int depth = parseInt(args[1]);
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element lnk : links) 
            {
                if(Validator.isValidURL(lnk.attr("abs:href")))
                    Links.validLinks.add(lnk.attr("abs:href"));
                else
                    Links.invalidLinks.add(lnk.attr("abs:href"));
            }
        } catch (IOException ex) {
            System.out.println("Error!!");
        }
        if (depth == 1) 
        {
            int validSize = Links.validLinks.size();
            for (int i = 0; i < validSize; i++) 
            {
                try {
                    doc = Jsoup.connect(Links.validLinks.get(i)).get();
                    Elements links = doc.select("a[href]");
                    for (Element lnk : links) {
                        if (Validator.isValidURL(lnk.attr("abs:href"))) 
                            Links.validLinks.add(lnk.attr("abs:href")); 
                        else 
                            Links.invalidLinks.add(lnk.attr("abs:href"));
                        
                    }
                } catch (IOException ex) {
                    System.out.println("Error!!");
                }
            }
        }
        if(depth == 2)
        {
            int validSize = Links.validLinks.size();
            int i;
            for (i = 0; i < validSize; i++) 
            {
                try {
                    doc = Jsoup.connect(Links.validLinks.get(i)).get();
                    Elements links = doc.select("a[href]");
                    for (Element lnk : links) {
                        if(Validator.isValidURL(lnk.attr("abs:href")))
                            Links.validLinks.add(lnk.attr("abs:href"));
                        else
                            Links.invalidLinks.add(lnk.attr("abs:href"));
                    }
                } catch (IOException ex) {
                    System.out.println("Error!!");
                }
            }
            validSize = Links.validLinks.size();
            for ( ; i < validSize; i++) 
            {
                try {
                    doc = Jsoup.connect(Links.validLinks.get(i)).get();
                    Elements links = doc.select("a[href]");
                    for (Element lnk : links) {
                        if(Validator.isValidURL(lnk.attr("abs:href")))
                            Links.validLinks.add(lnk.attr("abs:href"));
                        else
                            Links.invalidLinks.add(lnk.attr("abs:href"));
                    }
                } catch (IOException ex) {
                    System.out.println("Error!!");
                }
            }
        }
    }

}
