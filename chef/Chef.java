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
//Import Shared Regions
import SharedRegions.SharedBar;
import SharedRegions.SharedKitchen;
*/

//Import problem's constants
import static comInf.Simulator.NCOURSES;
import static comInf.Simulator.NSTUDENTS;


//Import Chef's states
import states.ChefStates;

/**
 * Entity Chef, containing his methods and life cycle ({@link #run() run}).
 * @author Daniel Nunes and Rafael Direito.
 */
public class Chef extends Thread
{
    /*
    //Define shared regions
    //The Chef will have access to his kitchen and to the bar, so he can
    //call the waiter
    private SharedBar bar;
    private SharedKitchen kit;
    */

    //Define the chef's state
    private ChefStates state;

    private KitStub kitStub;


    /**
     * Chef's default constructor.
     * @param bar restaurant's shared bar zone
     * @param kit restaurant's shared kitchen zone
     */
    public Chef(KitStub kitStub)
    {
        //Thread
        super();

        this.kitStub = kitStub;


        //Set initial state
        state = ChefStates.WAITOD;

        /*
        //Initialize shared regions
        this.bar = bar;
        this.kit = kit;
        */
    }


    /**
     * Used to set the chef's state.
     * @param s receives Chef State, from {@link Entities.States.ChefStates }.
     */

    public void setChefState(ChefStates s) {  state = s; }

    /**
     * Contains the chef's life cycle, overriding the run method of
     * a generic thread.
     */
    @Override
    public void run()
    {
        kitStub.watchTheNews();
        kitStub.startPreparation();
        for ( int nc = 0; nc < NCOURSES; nc++ )
        {
            kitStub.proceedToPresentation();
            for ( int nst = 0; nst < NSTUDENTS; nst++ )
            {
                kitStub.alertTheWaiter();
                if (!kitStub.haveAllPortionsBeenDelivered()) kitStub.haveNextPortionReady();
            }
            if (!kitStub.hasTheOrderBeenCompleted()) kitStub.continuePreparation();
        }
        kitStub.cleanUp();
    }
}
