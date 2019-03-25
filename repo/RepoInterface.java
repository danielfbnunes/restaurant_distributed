
import comInf.Message;
import comInf.MessageException;
import static comInf.Simulator.NCOURSES;
import static comInf.Simulator.NSTUDENTS;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author rd
 */
public class RepoInterface
{
    /*  Barbearia (representa o serviço a ser prestado)
    *
    *    @serialField bShop
    */

    private Repo repo;

    private int counter = 0;

    /**
     *  Instanciação do interface à barbearia.
     *
     *    @param bShop barbearia
     */

    public RepoInterface (Repo repo)
    {
        this.repo = repo;
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
        Message outMessage = null;

        /* validação da mensagem recebida */

        switch (inMessage.getMsgType ())
        {
            //ToDo Alterar nos stubs o proBar apra usar o write header.
            //ToDO remove INITFILE da mensagem
                //TODO, criar um getOPT para os numeros!!!!!
            case Message.APPLIN:
                if ((inMessage.getfName()== null) || (inMessage.getfName ().equals ("")))
                    throw new MessageException ("Nome do ficheiro inexistente!", inMessage);
                if((inMessage.getOp()!= 0) && (inMessage.getOp()!= 1))
                    throw new MessageException ("Option for appending line not recognized!", inMessage);
                break;

            case Message.UPCOUR:
                if (inMessage.getnCourses() > NCOURSES)
                    throw new MessageException ("Course number doesn't exist!", inMessage);
                break;

            case Message.UPSTUD:
                if ((inMessage.getStudID() < 0) || (inMessage.getStudID () >= NSTUDENTS ))
                    throw new MessageException ("Id do cliente inválido!", inMessage);
                break;

            case Message.UPCHEF:
                break;
            case Message.UPWAIT:
                if (inMessage.getWaiterState() == null)
                    throw new MessageException ("WaiterState null!", inMessage);
                break;
            case Message.SHUT:
                break;
            default:
                throw new MessageException ("Tipo inválido!", inMessage);
        }

        /* seu processamento */

        switch (inMessage.getMsgType ())
        {

                //TODO, criar um getOPT para os numeros!!!!!
            case Message.APPLIN:
                repo.appendLine(inMessage.getfName(), inMessage.getOp());
                outMessage = new Message(Message.SUCCFILE);
                break;

            case Message.UPCOUR:
                repo.updateCourse(inMessage.getnCourses());
                outMessage = new Message(Message.SUCCFILE);
                break;

                //ToDo adicioanr métodos para guardar os estados do estudante, chef e waiter
            case Message.UPSTUD:
                repo.updateStudentState(inMessage.getStudentState(), inMessage.getStudID());
                outMessage = new Message(Message.SUCCFILE);
                break;

            case Message.UPCHEF:
                repo.updateChefState(inMessage.getChefState());
                outMessage = new Message(Message.SUCCFILE);
                break;

            case Message.UPWAIT:
                repo.updateWaiterState(inMessage.getWaiterState());
                outMessage = new Message(Message.SUCCFILE);
                break;

            case Message.SHUT:
                counter++;
                if (counter == 3){
                    RepoMain.waitConnection = false;
                    (((ClientProxy) (Thread.currentThread())).getScon()).setTimeout(1);
                }
                outMessage = new Message(Message.ACKNOW);
                break;
            default:
                throw new MessageException ("Tipo inválido!", inMessage);
        }

        return (outMessage);
    }
}
