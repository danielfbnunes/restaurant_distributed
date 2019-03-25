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

public class BarStub {

    private String serverHostName = null;

    private int serverPortNumb;

    public BarStub(String serverHostName, int serverPortNumb) {
        this.serverHostName = serverHostName;
        this.serverPortNumb = serverPortNumb;
    }

    char lookAround() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.LOOKA);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.RES_LOOKA) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
        return inMessage.getOp();
    }

    void prepareTheBill() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.PREPBILL);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void sayGoodbye() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.SAYBYE);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void returnToTheBar() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.RETBAR);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void callTheWaiter(int studID) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.CALLW, studID);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void alertTheWaiter() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.B_ALWAIT);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Arranque da simulação: Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void studentArrived() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.STUDARR);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Arranque da simulação: Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void signalTheWaiter() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.B_SIGNAL);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Arranque da simulação: Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void waitForStudentToEat() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.WAITSEAT);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Arranque da simulação: Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void studentReadyToPayTheBill() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.SRPAY);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Arranque da simulação: Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }

    void studentIsLeaving() {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.SLEAV);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.ACKNOW) {
            GenericIO.writelnString("Arranque da simulação: Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }
    /*
    void probPar(String fName) {
        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        Message inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }
        outMessage = new Message(Message.INFILE, fName);
        con.writeObject(outMessage);
        inMessage = (Message) con.readObject();
        if (inMessage.getMsgType() != Message.SUCCFILE) {
            GenericIO.writelnString("Arranque da simulação: Tipo inválido!");
            GenericIO.writelnString(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }*/
}
