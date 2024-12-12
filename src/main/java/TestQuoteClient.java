public class TestQuoteClient {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Syntax: QuoteClient <hostname> <port>");
            return;
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        System.out.println("Starting client to '" + hostname + "' linstning on port: " + port);
        QuoteUDPClient qClient = new QuoteUDPClient(hostname, port);

        qClient.doRequest(10_000);
    }
}
