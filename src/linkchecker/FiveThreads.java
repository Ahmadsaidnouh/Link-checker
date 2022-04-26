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
public class FiveThreads {
    
    public static void main(String[] args) {

        String url = args[0];
        int depth = parseInt(args[1]);
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            int numberOfLinks = links.size();
            int num = numberOfLinks - numberOfLinks%5;
            Test[] tsts = new Test[numberOfLinks];
            int i;
            for(i = 0; i < num; i+=5)
            {
                tsts[i] = new Test(links.get(i).attr("abs:href"));
                tsts[i+1] = new Test(links.get(i + 1).attr("abs:href"));
                tsts[i+2] = new Test(links.get(i + 2).attr("abs:href"));
                tsts[i+3] = new Test(links.get(i + 3).attr("abs:href"));
                tsts[i+4] = new Test(links.get(i + 4).attr("abs:href"));
                tsts[i].start();
                tsts[i+1].start();
                tsts[i+2].start();
                tsts[i+3].start();
                tsts[i+4].start();
                try {
                    tsts[i].join();
                    tsts[i+1].join();
                    tsts[i+2].join();
                    tsts[i+3].join();
                    tsts[i+4].join();
                } catch (InterruptedException ex) {
                    System.out.println("Error!!");
                }
            }
            switch(numberOfLinks%5)
            {
                case 0:
                    break;
                case 1:
                    tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                    tsts[numberOfLinks - 1].start();
                    try {
                        tsts[numberOfLinks - 1].join();
                    } catch (InterruptedException ex) {
                        System.out.println("Error!!");
                    }
                    break;
                case 2:
                    tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                    tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                    tsts[numberOfLinks - 1].start();
                    tsts[numberOfLinks - 2].start();
                    try {
                        tsts[numberOfLinks - 1].join();
                        tsts[numberOfLinks - 2].join();
                    } catch (InterruptedException ex) {
                        System.out.println("Error!!");
                    }
                    break;     
                case 3:
                    tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                    tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                    tsts[numberOfLinks - 3] = new Test(links.get(numberOfLinks - 3).attr("abs:href"));
                    tsts[numberOfLinks - 1].start();
                    tsts[numberOfLinks - 2].start();
                    tsts[numberOfLinks - 3].start();
                    try {
                        tsts[numberOfLinks - 1].join();
                        tsts[numberOfLinks - 2].join();
                        tsts[numberOfLinks - 3].join();
                    } catch (InterruptedException ex) {
                        System.out.println("Error!!");
                    }
                    break;     
                case 4:
                    tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                    tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                    tsts[numberOfLinks - 3] = new Test(links.get(numberOfLinks - 3).attr("abs:href"));
                    tsts[numberOfLinks - 4] = new Test(links.get(numberOfLinks - 4).attr("abs:href"));
                    tsts[numberOfLinks - 1].start();
                    tsts[numberOfLinks - 2].start();
                    tsts[numberOfLinks - 3].start();
                    tsts[numberOfLinks - 4].start();
                    try {
                        tsts[numberOfLinks - 1].join();
                        tsts[numberOfLinks - 2].join();
                        tsts[numberOfLinks - 3].join();
                        tsts[numberOfLinks - 4].join();
                    } catch (InterruptedException ex) {
                        System.out.println("Error!!");
                    }
                    break;     
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
                    int num = numberOfLinks - numberOfLinks%5;
                    Test[] tsts = new Test[numberOfLinks];
                    int j;
                    for (j = 0; j < num ; j += 5) 
                    {
                        tsts[j] = new Test(links.get(j).attr("abs:href"));
                        tsts[j + 1] = new Test(links.get(j + 1).attr("abs:href"));
                        tsts[j + 2] = new Test(links.get(j + 2).attr("abs:href"));
                        tsts[j + 3] = new Test(links.get(j + 3).attr("abs:href"));
                        tsts[j + 4] = new Test(links.get(j + 4).attr("abs:href"));
                        tsts[j].start();
                        tsts[j + 1].start();
                        tsts[j + 2].start();
                        tsts[j + 3].start();
                        tsts[j + 4].start();
                        try {
                            tsts[j].join();
                            tsts[j + 1].join();
                            tsts[j + 2].join();
                            tsts[j + 3].join();
                            tsts[j + 4].join();
                        } catch (InterruptedException ex) {
                            System.out.println("Error!!");
                        }
                    }
                    switch (numberOfLinks % 5) 
                    {
                        case 0:
                            break;
                        case 1:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;
                        case 2:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            tsts[numberOfLinks - 2].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                                tsts[numberOfLinks - 2].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;
                        case 3:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                            tsts[numberOfLinks - 3] = new Test(links.get(numberOfLinks - 3).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            tsts[numberOfLinks - 2].start();
                            tsts[numberOfLinks - 3].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                                tsts[numberOfLinks - 2].join();
                                tsts[numberOfLinks - 3].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;
                        case 4:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                            tsts[numberOfLinks - 3] = new Test(links.get(numberOfLinks - 3).attr("abs:href"));
                            tsts[numberOfLinks - 4] = new Test(links.get(numberOfLinks - 4).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            tsts[numberOfLinks - 2].start();
                            tsts[numberOfLinks - 3].start();
                            tsts[numberOfLinks - 4].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                                tsts[numberOfLinks - 2].join();
                                tsts[numberOfLinks - 3].join();
                                tsts[numberOfLinks - 4].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;     
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
                    int num = numberOfLinks - numberOfLinks%5;
                    Test[] tsts = new Test[numberOfLinks];
                    int j;
                    for (j = 0; j < num ; j += 5) 
                    {
                        tsts[j] = new Test(links.get(j).attr("abs:href"));
                        tsts[j + 1] = new Test(links.get(j + 1).attr("abs:href"));
                        tsts[j + 2] = new Test(links.get(j + 2).attr("abs:href"));
                        tsts[j + 3] = new Test(links.get(j + 3).attr("abs:href"));
                        tsts[j + 4] = new Test(links.get(j + 4).attr("abs:href"));
                        tsts[j].start();
                        tsts[j + 1].start();
                        tsts[j + 2].start();
                        tsts[j + 3].start();
                        tsts[j + 4].start();
                        try {
                            tsts[j].join();
                            tsts[j + 1].join();
                            tsts[j + 2].join();
                            tsts[j + 3].join();
                            tsts[j + 4].join();
                        } catch (InterruptedException ex) {
                            System.out.println("Error!!");
                        }
                    }
                    switch (numberOfLinks % 5) 
                    {
                        case 0:
                            break;
                        case 1:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;
                        case 2:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            tsts[numberOfLinks - 2].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                                tsts[numberOfLinks - 2].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;
                        case 3:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                            tsts[numberOfLinks - 3] = new Test(links.get(numberOfLinks - 3).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            tsts[numberOfLinks - 2].start();
                            tsts[numberOfLinks - 3].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                                tsts[numberOfLinks - 2].join();
                                tsts[numberOfLinks - 3].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;
                        case 4:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                            tsts[numberOfLinks - 3] = new Test(links.get(numberOfLinks - 3).attr("abs:href"));
                            tsts[numberOfLinks - 4] = new Test(links.get(numberOfLinks - 4).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            tsts[numberOfLinks - 2].start();
                            tsts[numberOfLinks - 3].start();
                            tsts[numberOfLinks - 4].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                                tsts[numberOfLinks - 2].join();
                                tsts[numberOfLinks - 3].join();
                                tsts[numberOfLinks - 4].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;     
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
                    int num = numberOfLinks - numberOfLinks%5;
                    Test[] tsts = new Test[numberOfLinks];
                    int j;
                    for (j = 0; j < num ; j += 5) 
                    {
                        tsts[j] = new Test(links.get(j).attr("abs:href"));
                        tsts[j + 1] = new Test(links.get(j + 1).attr("abs:href"));
                        tsts[j + 2] = new Test(links.get(j + 2).attr("abs:href"));
                        tsts[j + 3] = new Test(links.get(j + 3).attr("abs:href"));
                        tsts[j + 4] = new Test(links.get(j + 4).attr("abs:href"));
                        tsts[j].start();
                        tsts[j + 1].start();
                        tsts[j + 2].start();
                        tsts[j + 3].start();
                        tsts[j + 4].start();
                        try {
                            tsts[j].join();
                            tsts[j + 1].join();
                            tsts[j + 2].join();
                            tsts[j + 3].join();
                            tsts[j + 4].join();
                        } catch (InterruptedException ex) {
                            System.out.println("Error!!");
                        }
                    }
                    switch (numberOfLinks % 5) 
                    {
                        case 0:
                            break;
                        case 1:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;
                        case 2:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            tsts[numberOfLinks - 2].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                                tsts[numberOfLinks - 2].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;
                        case 3:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                            tsts[numberOfLinks - 3] = new Test(links.get(numberOfLinks - 3).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            tsts[numberOfLinks - 2].start();
                            tsts[numberOfLinks - 3].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                                tsts[numberOfLinks - 2].join();
                                tsts[numberOfLinks - 3].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;
                        case 4:
                            tsts[numberOfLinks - 1] = new Test(links.get(numberOfLinks - 1).attr("abs:href"));
                            tsts[numberOfLinks - 2] = new Test(links.get(numberOfLinks - 2).attr("abs:href"));
                            tsts[numberOfLinks - 3] = new Test(links.get(numberOfLinks - 3).attr("abs:href"));
                            tsts[numberOfLinks - 4] = new Test(links.get(numberOfLinks - 4).attr("abs:href"));
                            tsts[numberOfLinks - 1].start();
                            tsts[numberOfLinks - 2].start();
                            tsts[numberOfLinks - 3].start();
                            tsts[numberOfLinks - 4].start();
                            try {
                                tsts[numberOfLinks - 1].join();
                                tsts[numberOfLinks - 2].join();
                                tsts[numberOfLinks - 3].join();
                                tsts[numberOfLinks - 4].join();
                            } catch (InterruptedException ex) {
                                System.out.println("Error!!");
                            }
                            break;     
                    }
                } catch (IOException ex) {
                    System.out.println("Error!!");
                }
            }
        }
    }
    
}
