/*
 * The problem:
 * "Events portray activities that take place when a group of students, enrolled in
 * Computação Distribuída, go to a famous restaurant downtown for a gourmet dinner
 * to celebrate the beginning of the second semester. There are three main locations
 * within the restaurant that should be accounted for: the table where the students
 * sit to have their meal, the kitchen where the chef prepares it according to the
 * orders placed by the students, and the bar where the waiter stands waiting for
 * service requests. There are, furthermore, three kinds of interacting entities:
 * N students , one waiter and one chef."
 *
 * The main goal of this project is to design and implement a solution to the
 * problem given above.
 *
 * This project was developed during the course of Distributed Computing, at the
 * University of Aveiro, under the supervision of Prof. António Rui Borges.
 */

/*
package Entities;

//Import Shared Regions
import SharedRegions.SharedBar;
import SharedRegions.SharedKitchen;
import SharedRegions.SharedTable;
*/

//Import Waiter's states
import states.WaiterStates;

/**
 * Entity Waiter, containing his methods and life cycle ({@link #run() run}).
 * @author Daniel Nunes and Rafael Direito
 */
public class Waiter extends Thread
{
    //Define shared regions
    //The Waiter will have access to the table, to the bar and to the kitchen
    private TabStub tabStub;
    private KitStub kitStub;
    private BarStub barStub;

    private WaiterStates state;


    /**
     * Waiter's default constructor.
     * @param bar restaurant's shared bar zone
     * @param tab restaurant's shared table
     * @param kit restaurant's shared kitchen
     */
    public Waiter(BarStub barStub, TabStub tabStub, KitStub kitStub)
    {
        //Thread
        super();

        /*
        //Initialize shared regions
        this.bar = bar;
        this.tab = tab;
        this.kit = kit;
        */

        this.barStub = barStub;
        this.kitStub = kitStub;
        this.tabStub = tabStub;
    }

   public void setWaiterState(WaiterStates s) {
        state = s;
    }


    /**
     * Contains the student's life cycle, overriding the run method of
     * a generic thread.
     */
    @Override
    public void run()
    {
        char alt;

        while((alt = barStub.lookAround()) != 'E')
        {
            switch(alt)
            {
                case 'N':
                    tabStub.saluteTheClient();
                    break;

                case 'O' :
                    tabStub.getThePad();
                    kitStub.handNoteToTheChef();
                    break;

                case 'C' :
                    do
                    {
                        kitStub.collectPortion();
                        tabStub.deliverPortion();
                    } while(!tabStub.haveAllClientsBeenServed());
                    break;

                case 'P' :
                    barStub.prepareTheBill();
                    tabStub.presentTheBill();
                    break;

                case 'G' :
                    barStub.sayGoodbye();
                    break;
            }

            if(alt != 'G') barStub.returnToTheBar();
        }
    }
}
