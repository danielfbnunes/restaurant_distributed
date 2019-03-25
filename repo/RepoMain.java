
import genclass.GenericIO;
import java.net.SocketTimeoutException;

/**
 *   Este tipo de dados simula uma solução do lado do servidor do Problema dos Barbeiros Sonolentos que implementa o
 *   modelo cliente-servidor de tipo 2 (replicação do servidor) com lançamento estático dos threads barbeiro.
 *   A comunicação baseia-se em passagem de mensagens sobre sockets usando o protocolo TCP.
 */

public class RepoMain
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
        Repo repo;                                    // barbearia (representa o serviço a ser prestado)
        RepoInterface repoInt;                      // interface à barbearia
        ServerCom scon, sconi;                               // canais de comunicação
        ClientProxy cliProxy;                                // thread agente prestador do serviço

        /* estabelecimento do servico */

        scon = new ServerCom (portNumb);                     // criação do canal de escuta e sua associação
        scon.start ();                                       // com o endereço público
        repo = new Repo();                           // activação do serviço
        repoInt = new RepoInterface (repo);        // activação do interface com o serviço
        //ToDO - ver quem inicia o log.
        repo.writeHeader("log.txt");
        GenericIO.writelnString ("O serviço foi estabelecido!");
        GenericIO.writelnString ("O servidor esta em escuta.");
        GenericIO.writelnString ("Ficheiro de log iniciado.");
        /* processamento de pedidos */

        waitConnection = true;
        while (waitConnection)
            try
            { sconi = scon.accept ();                          // entrada em processo de escuta
            cliProxy = new ClientProxy(sconi, repoInt);  // lançamento do agente prestador do serviço
            cliProxy.start ();
            }
            catch (SocketTimeoutException e)
            {
            }
        scon.end ();                                         // terminação de operações
        GenericIO.writelnString ("O servidor foi desactivado.");
    }
}
