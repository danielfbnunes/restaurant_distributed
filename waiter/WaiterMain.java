/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dn
 */
public class WaiterMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        KitStub kitStub = new KitStub ("l040101-ws04.ua.pt", 22602);
        BarStub barStub = new BarStub ("l040101-ws08.ua.pt", 22602);
        TabStub tabStub = new TabStub ("l040101-ws05.ua.pt", 22602);

        Waiter waiter = new Waiter(barStub, tabStub, kitStub);

        waiter.start();

        try {
            waiter.join();
        } catch (InterruptedException ex) {}
        barStub.shutBar();
        tabStub.shutTab();
        kitStub.shutKit();
    }

}
