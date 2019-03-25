
import genclass.GenericIO;
import java.net.SocketTimeoutException;

/**
 *   Este tipo de dados simula uma solução do lado do servidor do Problema dos Barbeiros Sonolentos que implementa o
 *   modelo cliente-servidor de tipo 2 (replicação do servidor) com lançamento estático dos threads barbeiro.
 *   A comunicação baseia-se em passagem de mensagens sobre sockets usando o protocolo TCP.
 */

public class TableMain
{
    /**
     *  Número do port de escuta do serviço a ser prestado (4000, por defeito)
     *
     *    @serialField portNumb
     */

    private static final int portNumb = 22602;
    public static boolean waitConnection;                              // sinalização de actividade

    /**
     *  Programa principal.
     */

    public static void main (String [] args)
    {
        RepoStub repo;                                   // barbearia (representa o serviço a ser prestado)
        ServerCom scon, sconi;                               // canais de comunicação
        ClientProxy cliProxy;                                // thread agente prestador do serviço
        Table tab;
        TableInterface tabInt;
        BarStub barStub;
        /* estabelecimento do servico */

        scon = new ServerCom (portNumb);                     // criação do canal de escuta e sua associação
        scon.start ();                                       // com o endereço público
        repo = new RepoStub(args[0], Integer.parseInt(args[1]));                           // activação do serviço
        barStub = new BarStub(args[2], Integer.parseInt(args[3]));
        tab = new Table(repo, barStub);
        tabInt = new TableInterface(tab);
        GenericIO.writelnString ("O serviço foi estabelecido!");
        GenericIO.writelnString ("O servidor esta em escuta.");
        /* processamento de pedidos */

        waitConnection = true;
        while (waitConnection)
            try
            { sconi = scon.accept ();                          // entrada em processo de escuta
            cliProxy = new ClientProxy(sconi, tabInt);  // lançamento do agente prestador do serviço
            cliProxy.start ();
            }
            catch (SocketTimeoutException e)
            {
            }
        scon.end ();                                         // terminação de operações
        GenericIO.writelnString ("O servidor foi desactivado.");
        repo.shutRepo();
    }
}
