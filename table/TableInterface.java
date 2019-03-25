/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
import comInf.Message;
import comInf.MessageException;
import static comInf.Simulator.NSTUDENTS;

/**
 *
 * @author rd
 */
public class TableInterface
{
    /*  Barbearia (representa o serviço a ser prestado)
    *
    *    @serialField bShop
    */

    private Table tab;

    /**
     *  Instanciação do interface à barbearia.
     *
     *    @param bShop barbearia
     */

    public TableInterface (Table tab)
    {
        this.tab = tab;
    }

    /**
     *  Processamento das mensagens através da execução da tarefa correspondente.
     *  Geração de uma mensagem de resposta.
     *
     *    @param inMessage mensagem com o pedido
     *
     *    @return mensagem de resposta
     *
     *    @throws MessageException se a mensagem com o pedido for considerada inválida
     */

    public Message processAndReply (Message inMessage) throws MessageException
    {
        Message outMessage = null;                           // mensagem de resposta

        /* validação da mensagem recebida */

        switch (inMessage.getMsgType ())
        {
            case Message.SHUT:
                break;
            case Message.SALUTE:
                break;
            case Message.GETPAD:
                break;
            case Message.DELPOR:
                break;
            case Message.REQCLISERV:
                break;
            case Message.PRESBILL:
                break;
            case Message.STUDARR:
                if (inMessage.getStudID() < 0 || inMessage.getStudID() >= NSTUDENTS)
                    throw new MessageException("Invalid ID", inMessage);
                break;
            case Message.READM:
                if (inMessage.getStudID() < 0 || inMessage.getStudID() >= NSTUDENTS)
                    throw new MessageException("Invalid ID", inMessage);
                break;
            case Message.REQHASCHO:
                break;
            case Message.PREPOR:
                if (inMessage.getStudID() < 0 || inMessage.getStudID() >= NSTUDENTS)
                    throw new MessageException("Invalid ID", inMessage);
                break;
            case Message.DESCORD:
                break;
            case Message.JOTALK:
                if (inMessage.getStudID() < 0 || inMessage.getStudID() >= NSTUDENTS)
                    throw new MessageException("Invalid ID", inMessage);
                break;
            case Message.INFCOMP:
                if (inMessage.getStudID() < 0 || inMessage.getStudID() >= NSTUDENTS)
                    throw new MessageException("Invalid ID", inMessage);
                break;
            case Message.STAREAT:
                if (inMessage.getStudID() < 0 || inMessage.getStudID() >= NSTUDENTS)
                    throw new MessageException("Invalid ID", inMessage);
                break;
            case Message.ENDEAT:
                if (inMessage.getStudID() < 0 || inMessage.getStudID() >= NSTUDENTS)
                    throw new MessageException("Invalid ID", inMessage);
                break;
            case Message.REQEVFIN:
                if (inMessage.getStudID() < 0 || inMessage.getStudID() >= NSTUDENTS)
                    throw new MessageException("Invalid ID", inMessage);
                break;
            case Message.SHAEARL:
                if (inMessage.getStudID() < 0 || inMessage.getStudID() >= NSTUDENTS)
                    throw new MessageException("Invalid ID", inMessage);
                break;
            case Message.HONBILL:
                break;
            case Message.T_SIGWAIT:
                if (inMessage.getStudID() < 0 || inMessage.getStudID() >= NSTUDENTS)
                    throw new MessageException("Invalid ID", inMessage);
                break;
            case Message.EXITTAB:
                if (inMessage.getStudID() < 0 || inMessage.getStudID() >= NSTUDENTS)
                    throw new MessageException("Invalid ID", inMessage);
                break;

            default:
                throw new MessageException ("Tipo inválido!", inMessage);
        }

        /* seu processamento */

        switch (inMessage.getMsgType ())
        {
            case Message.SHUT:
                TableMain.waitConnection = false;
                (((ClientProxy) (Thread.currentThread())).getScon()).setTimeout(1);
                outMessage = new Message (Message.ACKNOW);
                break;
            case Message.SALUTE:
                tab.saluteTheClient();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.GETPAD:
                tab.getThePad();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.DELPOR:
                tab.deliverPortion();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.REQCLISERV:
                if (tab.haveAllClientsBeenServed())
                    outMessage = new Message(Message.ALLSERV);
                else outMessage = new Message(Message.N_ALLSERV);
                break;
            case Message.PRESBILL:
                tab.presentTheBill();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.STUDARR:
                int arrival = tab.enter(inMessage.getStudID());
                outMessage = new Message(Message.RES_STUDARR, arrival );
                break;
            case Message.READM:
                tab.readTheMenu(inMessage.getStudID());
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.REQHASCHO:
                if (tab.hasEveryBodyChosen())
                    outMessage = new Message(Message.HASEVCHO);
                else outMessage = new Message(Message.N_HASEVCHO);
                break;
            case Message.PREPOR:
                tab.prepareTheOrder(inMessage.getStudID());
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.DESCORD:
                tab.describeTheOrder();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.JOTALK:
                tab.joinTheTalk(inMessage.getStudID());
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.INFCOMP:
                tab.informCompanion(inMessage.getStudID());
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.STAREAT:
                tab.startEating(inMessage.getStudID());
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.ENDEAT:
                tab.endEating(inMessage.getStudID());
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.REQEVFIN:
                if (tab.hasEveryBodyFinished(inMessage.getStudID()))
                    outMessage = new Message(Message.EVFINISH);
                else outMessage = new Message(Message.N_EVFINISH);
                break;
            case Message.SHAEARL:
                tab.shouldHaveArrivedEarlier(inMessage.getStudID());
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.HONBILL:
                tab.honourTheBill();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.T_SIGWAIT:
                tab.signalTheWaiter(inMessage.getStudID());
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.EXITTAB:
                tab.exit(inMessage.getStudID());
                outMessage = new Message(Message.ACKNOW);
                break;
            default:
                throw new MessageException ("Tipo inválido!", inMessage);
        }

        return (outMessage);
    }

}
