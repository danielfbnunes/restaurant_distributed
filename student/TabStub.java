/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dn
 */
import comInf.Message;
import genclass.GenericIO;
import states.StudentStates;

public class TabStub {

    private String serverHostName = null;

    private int serverPortNumb;

    public TabStub(String serverHostName, int serverPortNumb) {
        this.serverHostName = serverHostName;
        this.serverPortNumb = serverPortNumb;
    }

    void saluteTheClient() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.SALUTE);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void getThePad() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.GETPAD);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void deliverPortion() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.DELPOR);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }


    boolean haveAllClientsBeenServed() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.REQCLISERV);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if ((inMessage.getMsgType() != Message.ALLSERV) && (inMessage.getMsgType() != Message.N_ALLSERV)) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();

        if (inMessage.getMsgType() == Message.ALLSERV)
            return true;
            else return false;
    }

    void presentTheBill() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.PRESBILL);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    int enter(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.STUDARR, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.RES_STUDARR) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
        ((Student) Thread.currentThread()).setStudentState(StudentStates.TASATT);
        return inMessage.getArrival_order();
    }

    void readTheMenu(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.READM, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
        ((Student) Thread.currentThread()).setStudentState(StudentStates.SELTCO);
    }

    boolean hasEveryBodyChosen() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.REQHASCHO);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if ((inMessage.getMsgType() != Message.HASEVCHO) && (inMessage.getMsgType() != Message.N_HASEVCHO)) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();

        if (inMessage.getMsgType() == Message.HASEVCHO)
            return true;
            else return false;
    }

    void prepareTheOrder(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.PREPOR, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();

        ((Student) Thread.currentThread()).setStudentState(StudentStates.ORGTOD);
    }

    void describeTheOrder() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.DESCORD);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void joinTheTalk(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.JOTALK, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
        ((Student) Thread.currentThread()).setStudentState(StudentStates.CHAWCO);
    }

    void informCompanion(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.INFCOMP, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
        ((Student) Thread.currentThread()).setStudentState(StudentStates.CHAWCO);
    }

    void startEating(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.STAREAT, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
        ((Student) Thread.currentThread()).setStudentState(StudentStates.ENJTME);
    }

    void endEating(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.ENDEAT, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
        ((Student) Thread.currentThread()).setStudentState(StudentStates.CHAWCO);
    }

    boolean hasEveryBodyFinished(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.REQEVFIN, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if ((inMessage.getMsgType() != Message.EVFINISH) && (inMessage.getMsgType() != Message.N_EVFINISH)) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();

        if (inMessage.getMsgType() == Message.EVFINISH)
            return true;
            else return false;
    }

    void shouldHaveArrivedEarlier(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.SHAEARL, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
        ((Student) Thread.currentThread()).setStudentState(StudentStates.PAYTBI);
    }

    void honourTheBill() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.HONBILL);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void signalTheWaiter(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.T_SIGWAIT, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void exit(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.EXITTAB, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
        ((Student) Thread.currentThread()).setStudentState(StudentStates.GOINHO);
    }
    
}
