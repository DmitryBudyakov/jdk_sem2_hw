package server.server;

import server.client.Client;
import java.util.ArrayList;
import java.util.List;

public class Server {
    List<Client> clientList;
//    ServerGUI serverGUI;
    ServerView serverView;  // для связи с методами ServerGUI, реализованными через ServerView
    Repository repository;  // для связи с методами Storage, реализованными через Repository
    boolean work;

    public Server(ServerView serverView, Repository repository){
        clientList = new ArrayList<>();
//        this.serverGUI = new ServerGUI(this);
        this.serverView = serverView;
        this.repository = repository;
    }

//    public int getServerGuiX() {
//        return serverGUI.getX();
//    }
//
//    public int getServerGuiY() {
//        return serverGUI.getY();
//    }

    public boolean connectUser(Client client) {
        if (!work) {
            return false;
        }
        clientList.add(client);
        return true;
    }

    public String getHistory() {
//        return repository.readLog();
        return repository.readLog();
    }

    public void disconnectUser(Client client) {
        if (client != null) {
            client.disconnect();
        }
        clientList.remove(client);
    }

    public void disonnectAll(){
        for (int i = clientList.size() - 1; i >= 0; i--) {
            disconnectUser(clientList.get(i));
        }
    }

    public void answerAll(String text) {
        for (Client client : clientList) {
            client.serverAnswer(text);
        }
    }

    public void sendMessage(String text) {
        if (!work) {
            return;
        }
        serverView.showMessage(text);
        answerAll(text);
        repository.saveInLog(text);
    }


}
