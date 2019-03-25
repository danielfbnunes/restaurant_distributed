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
import SharedRegions.SharedTable;
//Impor math random
import java.util.Random;
*/

//Import problem's constants
import static comInf.Simulator.NCOURSES;
import static comInf.Simulator.FIRST;

import states.StudentStates;


/**
 * Entity Student, containing his methods and life cycle ({@link #run() run}).
 * @author Daniel Nunes and Rafael Direito
 */
public class Student extends Thread
{
    //Define student ID
    private int ID;
    /*
    //Define shared regions.The Student will have access to the table and to the
    //bar, so he can call the waiter
    private SharedBar bar;
    private SharedTable tab;

    //Define random
    private Random rand;
    */

    //Define the student's state
    private StudentStates state;

    private BarStub barStub;
    private TabStub tabStub;

    /**
     * Student's default constructor.
     * @param bar restaurant's shared bar zone
     * @param table restaurant's shared table
     * @param ID student's ID
     */
    public Student(BarStub barStub, TabStub tabStub, int ID)
    {
        //Thread
        super();

        /*
        //Instanciate and initialize random
        rand = new Random();
        */
        //Initialize this student's ID
        this.ID = ID;


        this.barStub = barStub;
        this.tabStub = tabStub;

        /*
        //Initialize shared regions
        this.bar = bar;
        this.tab = table;
        */
    }


    /**
     * Used to set the student's state.
     * @param s receives Student State, from {@link Entities.States.StudentStates }.
     */
    public void setStudentState(StudentStates s) { state = s; }

    /**
     * Used to get the student's ID.
     * @return ID of the student
     */
    public int getStudentID() { return ID; }


    /**
     * Invoked by the student when he starts his life cycle.
     * Contains a sleep function with a random value.
     */
    public void walkABit()
    {
        try
        {
            Thread.sleep((long)(Math.random() * 300));
        }
        catch (InterruptedException ex)
        {
            System.err.print("Unable to realize sleep() inside the walkABit() method");
            System.exit(1);
        }
    }


    /**
     * Contains the student's life cycle, overriding the run method of
     * a generic thread.
     */
    @Override
    public void run()
    {
        int arrivalOrder;
        walkABit();
        arrivalOrder = tabStub.enter(ID);
        tabStub.readTheMenu(ID);

        if (arrivalOrder == FIRST)
        {
            while(!tabStub.hasEveryBodyChosen())
                tabStub.prepareTheOrder(ID);
            barStub.callTheWaiter(ID);
            tabStub.describeTheOrder();
            tabStub.joinTheTalk(ID);
        }
        else
        {
            tabStub.informCompanion(ID);
        }
        for(int nc=0; nc < NCOURSES ; nc++)
        {
            tabStub.startEating(ID);
            tabStub.endEating(ID);
            if(tabStub.hasEveryBodyFinished(ID))
            {
                if(nc==(NCOURSES-1))
                {
                    tabStub.shouldHaveArrivedEarlier(ID);
                    tabStub.honourTheBill();
                }
                else
                {
                    tabStub.signalTheWaiter(ID);
                }
            }
        }
        tabStub.exit(ID);
    }
}
