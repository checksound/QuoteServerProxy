import java.io.*;
import java.net.*;

/**
 * Il proxy server che fa richieste al QuoteServer tramite socket UDP.
 * Risponde invece al QuoteProxyClient su uan connessione TCP.
 *
 */
public class QuoteProxyServer {

    public static void main(String[] args) {

        if(args.length != 3) {
            System.out.println("Syntax: " +
                    "QuoteProxyServer <porta> <host_quote_server> <porta_quote_server>");
            return;
        }

    }
}
