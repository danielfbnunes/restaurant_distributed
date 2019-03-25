package comInf;





import java.io.*;
import states.ChefStates;
import states.StudentStates;
import states.WaiterStates;


/**
 *
 * @author rd
 */
public class Message implements Serializable
{
    /**
     * Serialization key
     */
    private static final long serialVersionUID = 1001L;


    /* 1 - Messages types regarding the TABLE */

    /**
     * Response to student arrived.
     */
    public static final int RES_STUDARR = 1;

    /**
     * Signals the arrival of a student.
     */
    public static final int SENTER = 2;

    /**
     * The waiter salutes each student that enters the restaurant.
     */
    public static final int SALUTE = 3;

    /**
     * The student reads the menu, after the waiter presenting it to him.
     */
    public static final int READM = 4;

    /**
     * The first student prepares the order, waiting for all his companions
     * to inform him of their course choice.
     */
    public static final int PREPOR = 5;

    /**
     * All the students, except the first one arriving, inform the first one of
     * their course choices.
     */
    public static final int INFCOMP = 6;

    /**
     * Request has every body chosen.
     */
    public static final int REQHASCHO = 7;

    /**
     * All the students have chosen their courses.
     */
    public static final int HASEVCHO = 8;

    /**
     * Not all the students have chosen their courses.
     */
    public static final int N_HASEVCHO = 9;

    /**
     * When the waiter gets to the table, he takes out his pad to write down
     * the students order.
     */
    public static final int GETPAD = 10;

    /**
     * The first student describes the order to the waiter.
     */
    public static final int DESCORD = 11;

    /**
     * After describing the students order, the first student arriving joins
     * the talk.
     */
    public static final int JOTALK = 12;

    /**
     * The waiter delivers a portion to each student.
     */
    public static final int DELPOR = 13;

    /**
     * Once all the students have received their dishes, they start enjoying
     * their meals.
     */
    public static final int STAREAT = 14;

    /**
     * The students finish their courses.
     */
    public static final int ENDEAT = 15;

    /**
     * Request has everybody finished their dishes.
     */
    public static final int REQEVFIN = 16;

    /**
     * Everybody has finished their dishes.
     */
    public static final int EVFINISH = 17;

    /**
     * Everybody has finished their dishes.
     */
    public static final int N_EVFINISH = 18;

    /**
     * After all the student have finished their courses, the last one eating
     * signals the waiter so he can come, get the dirty dishes, and bring another
     * course, if there is one.
     */
    public static final int T_SIGWAIT = 19;

    /**
     * Request all clients have been served.
     */
    public static final int REQCLISERV = 20;

    /**
     * All clients have been served.
     */
    public static final int ALLSERV = 21;

    /**
     * Not all clients have been served.
     */
    public static final int N_ALLSERV = 22;

    /**
     * Once the meal is over, the last student asks the waiter to bring him the
     * bill.
     */
    public static final int SHAEARL = 23;

    /**
     * The waiter presents the bill to the last student arriving to the
     * restaurant.
     */
    public static final int PRESBILL = 24;

    /**
     * The last student arriving pays the bill.
     */
    public static final int HONBILL = 25;

    /**
     * After the bill is payed, the students leave the restaurant.
     */
    public static final int EXITTAB = 26;



    /* 2 - Message types regarding the KITCHEN */



    /**
     * While the chef hasn't received a note, he watches the news.
     */
    public static final int WATNEWS = 27;

    /**
     * The waiter hands the note to the chef.
     */
    public static final int HANDNOTE = 28;

    /**
     * The chef starts preparing the courses.
     */
    public static final int STARPREP = 29;

    /**
     * After preparing the courses, the chef proceeds to presentation.
     */
    public static final int PROCPRES = 30;

    /**
     * When the chef wants the portions to be picked up, he alerts the waiter.
     */
    public static final int K_ALWAIT = 31;

    /**
     * Request if all portions have been delivered.
     */
    public static final int REQALLDEL = 32;

    /**
     * Chef hasn't delivered all the portions.
     */
    public static final int N_ALLDEL = 33;

    /**
     * Chef has delivered all the portions.
     */
    public static final int ALLDEL = 34;

    /**
     * The waiter collects a portion from the kitchen.
     */
    public static final int COLPOR = 35;

    /**
     * The chef prepares the next portion
     */
    public static final int HAVENEXT = 36;

    /**
     * Request if order have been completed.
     */
    public static final int REQORDCOMP = 37;

    /**
     * The order hasn't been completed.
     */
    public static final int N_HASORDCOMP = 39;

    /**
     * The order has been completed.
     */
    public static final int HASORDCOMP = 40;

    /**
     * If the order hasn't been completed the chef continues the preparation.
     */
    public static final int CONTPREP = 41;

    /**
     * After the order has been completed, the chef closes the kitchen, cleaning
     * it up.
     */
    public static final int CLEANUP = 42;



    /* 3 - Messages regarding the BAR */

    /**
     * Response to look around.
     */
    public static final int RES_LOOKA = 43;

    /**
     * While the waiter hasn't received any order he looks around the bar.
     */
    public static final int LOOKA = 44;

    /**
     * The waiter returns to the bar.
     */
    public static final int RETBAR = 45;

    /**
     * A student has arrived to the restaurant.
     */
    public static final int STUDARR = 46;

    /**
     * The waiter is called after all the students have chosen their courses.
     */
    public static final int CALLW = 47;

    /**
     * The waiter is called by the chef to pick up the course portions.
     */
    public static final int B_ALWAIT = 48;

    /**
     * Informs the waiter that the last student arriving is ready to pay the bill.
     */
    public static final int SRPAY = 49;

    /**
     * A student is leaving the restaurant.
     */
    public static final int SLEAV = 50;

    /**
     * All the students have left the restaurant.
     */
    public static final int ALLLEFT = 51;

    /**
     * Once all the students have eaten their course, the waiter is called.
     */
    public static final int K_SIGWAIT = 52;

    /**
     * The waiter has to wait for the students to eat each course.
     */
    public static final int WAITSEAT = 53;

    /**
     * The waiter prepares the bill.
     */
    public static final int PREPBILL = 54;

    /**
     * The waiter says good bye to all the students, once each one is leaving.
     */
    public static final int SAYBYE = 55;



    /* 4 - Message types regarding the REPO */

    /**
     * Update chef's sate.
     */
    public static final int UPCHEF = 56;

    /**
     * Update waiter's sate.
     */
    public static final int UPWAIT = 57;

    /**
     * Update student's sate.
     */
    public static final int UPSTUD = 58;

    /**
     * Update course number.
     */
    public static final int UPCOUR = 59;

    /**
     * Write the header of the log file.
     */
    public static final int WRHEAD = 60;

    /**
     * Append a line to the log file.
     */
    public static final int APPLIN = 61;

    /**
     * Append a string to the log file. Only used for testing purposes.
     */
    public static final int CUSTAPP = 62;

    /**
     * Initialize the log file.
     */
    public static final int INFILE = 63;

    /**
     * Log file successful initialized.
     */
    public static final int SUCCFILE = 64;

    /**
     * Successful operation (answer given by server).
     */
    public static final int ACKNOW = 65;

    /**
     *
     */
    public static final int B_SIGNAL = 66;

    /**
     *
     */
    public static final int SHUT = 67;


    /* Message fields */

    /**
     * Identifies the message type.
     */
    private int msgType = -1;

    /**
     * Identifies the student's ID.
     */
    private int studID = -1;

    /**
     * Identifies the name of the log file.
     */
    private String fName = null;

    /**
     * Define the number of students.
     */
    private int nStuds = -1;

    /**
     * Define the number of courses.
     */
    private int nCourses = -1;

    /**
     * Define the arrival order of the first student arriving.
     */
    private int first = -1;

    /**
     * Define the arrival order of the last student arriving.
     */
    private int last = -1;

    /**
     * Define the ID of the first student arriving.
     */
    private int firstID = -1;

    /**
     * Define the ID of the last student arriving.
     */
    private int lastID = -1;

    /**
     * Char op for look around.
     */
    private char op = '0';

    /**
     * Arrival order.
     */
    private int arrival_order = 0;

    /**
     * Chef's state.
     */
    private ChefStates chefState = null;

    /**
     * Waiter's state.
     */
    private WaiterStates waiterState = null;

    /**
     * Student's state.
     */
    private StudentStates studentState = null;


    /**
     * Used as a flag to write in the file.
     */
    private int appendOption = -1;






    /* Message constructors */

    /**
     * Type 1 of instanciation
     * @param msgType message's type
     */
    public Message ( int msgType )
    {
        this.msgType = msgType;
    }

    public Message ( int msgType, char op )
    {
        this.msgType = msgType;
        this.op = op;
    }
    /**
     * Type 2 of instanciation.
     * @param msgType message's type
     * @param studID student's ID
     */
    public Message ( int msgType, int studID )
    {
        this.msgType = msgType;
        this.studID = studID;
    }



    public Message ( int msgType, String fName , int appendOption)
    {
        this.msgType = msgType;
        this.fName = fName;
        this.appendOption = appendOption;
    }

    /**
     * Type 4 of instanciation
     * @param msgType message's type
     * @param nStuds number of students
     * @param nCourses number of courses
     */
    public Message ( int  msgType, int nStuds, int nCourses )
    {
        this.msgType = msgType;
        this.nStuds = nStuds;
        this.nCourses = nCourses;
    }

    public Message ( int  msgType, ChefStates chefState )
    {
        this.msgType = msgType;
        this.chefState = chefState;
    }

    public Message ( int  msgType, WaiterStates waiterState )
    {
        this.msgType = msgType;
        this.waiterState = waiterState;
    }

    public Message ( int  msgType, StudentStates studentState, int studID )
    {
        this.msgType = msgType;
        this.studentState = studentState;
        this.studID = studID;
    }






    /* Getters */

    public int getArrival_order() {
        return arrival_order;
    }

    public char getOp() {
        return op;
    }

    /**
     * Get the message type.
     * @return message's type
     */
    public int getMsgType() { return msgType; }

    /**
     * Get the student ID.
     * @return ID of a student
     */
    public int getStudID() { return studID; }

    /**
     * Get the log file's name.
     * @return log file's name
     */
    public String getfName() { return fName; }

    /**
     * Get the number of student of the problem.
     * @return number of student of the problem
     */
    public int getnStuds() { return nStuds; }

    /**
     * Get number of courses.
     * @return number of courses
     */
    public int getnCourses() { return nCourses; }

    /**
     * Get the arrival order of the first student arriving.
     * @return arrival order of the first student arriving
     */
    public int getFirst() { return first; }

    /**
     * Get the arrival order of the last student arriving.
     * @return arrival order of the last student arriving
     */
    public int getLast() { return last; }

    /**
     * Get the ID the first student arriving.
     * @return ID of the first student arriving
     */
    public int getFirstID() { return firstID; }

    /**
     * Get the ID the last student arriving.
     * @return ID of the last student arriving
     */
    public int getLastID() { return lastID;}

    /**
     * Get the state of a student.
     * @return student's state.
     */
    public StudentStates getStudentState(){return studentState;}

    /**
     * Get the state of the waiter.
     * @return waiter's state.
     */
    public WaiterStates getWaiterState(){return waiterState;}

    /**
     * Get the state of the cheft.
     * @return chef's state.
     */
    public ChefStates getChefState(){return chefState;}






    /* To string method */

    /**
     * Print internal fields. This method is used for debugging.
     * @return string containing all the message's fields
     */
    @Override
    public String toString() {
        return "msgType=" + msgType +
                "\nstudID=" + studID +
                "\nfName=" + fName +
                "\nnStuds=" + nStuds +
                "\n nCourses=" + nCourses +
                "\n first=" + first +
                "\nlast=" + last +
                "\nfirstID=" + firstID +
                "\nlastID=" + lastID +
                "\nop=" + op
                ;
    }

}
