/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
import comInf.Message;
import comInf.MessageException;

/**
 *
 * @author rd
 */
public class KitchenInterface
{
    /*  Barbearia (representa o serviço a ser prestado)
    *
    *    @serialField bShop
    */

    private Kitchen kit;

    /**
     *  Instanciação do interface à barbearia.
     *
     *    @param bShop barbearia
     */

    public KitchenInterface (Kitchen kit)
    {
        this.kit = kit;
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
            case Message.WATNEWS:
                break;
            case Message.STARPREP:
                break;
            case Message.PROCPRES:
                break;
            case Message.REQALLDEL:
                break;
            case Message.HAVENEXT:
                break;
            case Message.REQORDCOMP:
                break;
            case Message.CONTPREP:
                break;
            case Message.HANDNOTE:
                break;
            case Message.COLPOR:
                break;
            case Message.K_ALWAIT:
                break;
            case Message.CLEANUP:
                break;
            default:
                throw new MessageException ("Tipo inválido!", inMessage);
        }

        /* seu processamento */

        switch (inMessage.getMsgType ())
        {
            case Message.SHUT:
                KitchenMain.waitConnection = false;
                (((ClientProxy) (Thread.currentThread())).getScon()).setTimeout(1);
                outMessage = new Message (Message.ACKNOW);
                break;
            case Message.CLEANUP:
                kit.cleanUp();
                outMessage = new Message (Message.ACKNOW);
                break;
            case Message.K_ALWAIT:
                kit.alertTheWaiter();
                outMessage = new Message (Message.ACKNOW);
                break;
            case Message.WATNEWS:
                kit.watchTheNews();
                outMessage = new Message (Message.ACKNOW);
                break;
            case Message.STARPREP:
                kit.startPreparation();
                outMessage = new Message (Message.ACKNOW);
                break;
            case Message.PROCPRES:
                kit.proceedToPresentation();
                outMessage = new Message (Message.ACKNOW);
                break;
            case Message.REQALLDEL:
                if (kit.haveAllPortionsBeenDelivered())
                    outMessage = new Message (Message.ALLDEL);
                else outMessage = new Message (Message.N_ALLDEL);
                break;
            case Message.HAVENEXT:
                kit.haveNextPortionReady();
                outMessage = new Message (Message.ACKNOW);
                break;
            case Message.REQORDCOMP:
                if (kit.hasTheOrderBeenCompleted())
                    outMessage = new Message (Message.HASORDCOMP);
                else outMessage = new Message (Message.N_HASORDCOMP);
                break;
            case Message.CONTPREP:
                kit.continuePreparation();
                outMessage = new Message (Message.ACKNOW);
                break;
            case Message.HANDNOTE:
                kit.handNoteToTheChef();
                outMessage = new Message (Message.ACKNOW);
                break;
            case Message.COLPOR:
                kit.collectPortion();
                outMessage = new Message (Message.ACKNOW);
                break;
            default:
                throw new MessageException ("Tipo inválido!", inMessage);
        }

        return (outMessage);
    }

}
