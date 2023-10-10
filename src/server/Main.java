package server;

import server.client.ClientGUI;
import server.server.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        new ClientGUI(server);
        new ClientGUI(server);
    }
}
