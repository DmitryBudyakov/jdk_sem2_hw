package server.server;

public interface Repository {
    void saveInLog(String text);
    String readLog();
}
