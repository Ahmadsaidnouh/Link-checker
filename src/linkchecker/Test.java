/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkchecker;

/**
 *
 * @author Ahmad Nouh
 */
public class Test extends Thread{
    String link;
    public Test(String link)
    {
        this.link = link;
    }
    public void run()
    {
        if(Validator.isValidURL(link))
            Links.validLinks.add(link);
        else
            Links.invalidLinks.add(link);
    }
    
}
