/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
import comInf.Message;
import comInf.MessageException;
import comInf.Simulator;

/**
 *
 * @author rd
 */
public class BarInterface {

    /*  Barbearia (representa o serviço a ser prestado)
    *
    *    @serialField bShop
     */
    private Bar bar;

    /**
     * Instanciação do interface à barbearia.
     *
     * @param bShop barbearia
     */
    public BarInterface(Bar bar) {
        this.bar = bar;
    }

    /**
     * Processamento das mensagens através da execução da tarefa correspondente.
     * Geração de uma mensagem de resposta.
     *
     * @param inMessage mensagem com o pedido
     *
     * @return mensagem de resposta
     *
     * @throws MessageException se a mensagem com o pedido for considerada
     * inválida
     */
    public Message processAndReply(Message inMessage) throws MessageException {
        Message outMessage = null;                           // mensagem de resposta

        /* validação da mensagem recebida */
        switch (inMessage.getMsgType()) {
            case Message.SHUT:
                break;
            case Message.LOOKA:
                break;
            case Message.B_ALWAIT:
                break;
            case Message.PREPBILL:
                break;
            case Message.SAYBYE:
                break;
            case Message.CALLW:
                break;
            case Message.STUDARR:
                break;
            case Message.B_SIGNAL:
                break;
            case Message.WAITSEAT:
                break;
            case Message.SRPAY:
                break;
            case Message.SLEAV:
                break;
            case Message.RETBAR:
                break;

            default:
                throw new MessageException("Tipo inválido!", inMessage);
        }

        /* seu processamento */
        switch (inMessage.getMsgType()) {
            case Message.SHUT:
                BarMain.waitConnection = false;
                (((ClientProxy) (Thread.currentThread())).getScon()).setTimeout(1);
                outMessage = new Message (Message.ACKNOW);
                break;
            case Message.LOOKA:
                char op = bar.lookAround();
                outMessage = new Message(Message.RES_LOOKA, op);
                break;
            case Message.B_ALWAIT:
                bar.alertTheWaiter();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.PREPBILL:
                bar.prepareTheBill();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.SAYBYE:
                bar.sayGoodbye();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.CALLW:
                bar.callTheWaiter();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.STUDARR:
                bar.studentArrived();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.B_SIGNAL:
                bar.signalTheWaiter();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.WAITSEAT:
                bar.waitForStudentToEat();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.SRPAY:
                bar.studentReadyToPayTheBill();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.SLEAV:
                bar.studentIsLeaving();
                outMessage = new Message(Message.ACKNOW);
                break;
            case Message.RETBAR:
                bar.returnToTheBar();
                outMessage = new Message(Message.ACKNOW);
                break;

            default:
                throw new MessageException("Tipo inválido!", inMessage);
        }

        return (outMessage);
    }

}
