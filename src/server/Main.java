package server;

import server.client.ClientGUI;
import server.server.Server;
import server.server.ServerGUI;

public class Main {
    public static void main(String[] args) {
        ServerGUI serverGUI = new ServerGUI();
        new ClientGUI(serverGUI);
        new ClientGUI(serverGUI);
    }
}
