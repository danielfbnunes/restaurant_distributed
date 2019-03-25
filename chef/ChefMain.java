
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dn
 */
public class ChefMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KitStub kitStub = new KitStub ("l040101-ws04.ua.pt", 22602);
        Chef chef = new Chef(kitStub);

        chef.start();

        try {
            chef.join();
        } catch (InterruptedException ex) {}
    }

}
