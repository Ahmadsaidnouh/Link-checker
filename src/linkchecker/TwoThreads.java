/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkchecker;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Ahmad Nouh
 */
public class TwoThreads {
    
    public static void main(String[] args) {

        String url = args[0];
        int depth = parseInt(args[1]);
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            int numberOfLinks = links.size();
            int num = numberOfLinks - numberOfLinks%2;
            Test[] tsts = new Test[numberOfLinks];
            int i;
            for (i = 0; i < num; i += 2) 
            {
                tsts[i] = new Test(links.get(i).attr("abs:href"));
                tsts[i + 1] = new Test(links.get(i + 1).attr("abs:href"));
                tsts[i].start();
                tsts[i + 1].start();
                try {
                    tsts[i].join();
                    tsts[i + 1].join();
                } catch (InterruptedException ex) {
                    System.out.println("Error!!");
                }
            }
            if ((numberOfLinks % 2) != 0) 
            {
                tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                tsts[numberOfLinks - 1].start();
                try {
                    tsts[numberOfLinks - 1].join();
                } catch (InterruptedException ex) {
                    System.out.println("Error!!");
                }
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
                    int numberOfLinks = links.size();
                    int num = numberOfLinks - numberOfLinks%2;
                    Test[] tsts = new Test[numberOfLinks];
                    int j;
                    for (j = 0; j < num; j += 2) 
                    {
                        tsts[j] = new Test(links.get(j).attr("abs:href"));
                        tsts[j + 1] = new Test(links.get(j + 1).attr("abs:href"));
                        tsts[j].start();
                        tsts[j + 1].start();
                        try {
                            tsts[j].join();
                            tsts[j + 1].join();
                        } catch (InterruptedException ex) {
                            System.out.println("Error!!");
                        }
                    }
                    if ((numberOfLinks % 2) != 0) 
                    {
                        tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks).attr("abs:href"));
                        tsts[numberOfLinks - 1].start();
                        try {
                            tsts[numberOfLinks - 1].join();
                        } catch (InterruptedException ex) {
                            System.out.println("Error!!");
                        }
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
                    int numberOfLinks = links.size();
                    int num = numberOfLinks - numberOfLinks%2;
                    Test[] tsts = new Test[numberOfLinks];
                    int j;
                    for (j = 0; j < num; j += 2) 
                    {
                        tsts[j] = new Test(links.get(j).attr("abs:href"));
                        tsts[j + 1] = new Test(links.get(j + 1).attr("abs:href"));
                        tsts[j].start();
                        tsts[j + 1].start();
                        try {
                            tsts[j].join();
                            tsts[j + 1].join();
                        } catch (InterruptedException ex) {
                            System.out.println("Error!!");
                        }
                    }
                    if ((numberOfLinks % 2) != 0) {
                        tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                        tsts[numberOfLinks - 1].start();
                        try {
                            tsts[numberOfLinks - 1].join();
                        } catch (InterruptedException ex) {
                            System.out.println("Error!!");
                        }
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
                    int numberOfLinks = links.size();
                    int num = numberOfLinks - numberOfLinks%2;
                    Test[] tsts = new Test[numberOfLinks];
                    int j;
                    for (j = 0; j < num; j += 2) 
                    {
                        tsts[j] = new Test(links.get(j).attr("abs:href"));
                        tsts[j + 1] = new Test(links.get(j + 1).attr("abs:href"));
                        tsts[j].start();
                        tsts[j + 1].start();
                        try {
                            tsts[j].join();
                            tsts[j + 1].join();
                        } catch (InterruptedException ex) {
                            System.out.println("Error!!");
                        }
                    }
                    if ((numberOfLinks % 2) != 0) 
                    {
                        tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                        tsts[numberOfLinks - 1].start();
                        try {
                            tsts[numberOfLinks - 1].join();
                        } catch (InterruptedException ex) {
                            System.out.println("Error!!");
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("Error!!");
                }
            }
        }
    }
    
}
