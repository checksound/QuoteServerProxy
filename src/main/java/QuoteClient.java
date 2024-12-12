import java.io.*;
import java.net.*;

/**
 * This program demonstrates how to implement a UDP client program.
 *
 * @author www.codejava.net
 */
public class QuoteClient {
    private final int port;
    private final DatagramSocket socket;
    private final InetAddress address;

    public QuoteClient(String hostname, int port) throws UnknownHostException, SocketException {
        address = InetAddress.getByName(hostname);
        this.port = port;
        socket = new DatagramSocket();
    }


    public void doRequest(long elapseTime) {

        while (true) {

            try {
                DatagramPacket request = new DatagramPacket(new byte[1], 1, address, port);
                socket.send(request);

                byte[] buffer = new byte[512];
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);

                String quote = new String(buffer, 0, response.getLength());

                System.out.println(quote);
                System.out.println();

                Thread.sleep(elapseTime);

            } catch (SocketTimeoutException ex) {
                System.out.println("Timeout error: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Client error: " + ex.getMessage());
            } catch (InterruptedException ex) {
                System.out.println("Client interrupted: " + ex.getMessage());
            }
        }

    }

}
