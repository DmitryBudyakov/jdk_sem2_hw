package server.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements ServerView{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JButton btnStart, btnStop;
    JTextArea log;
    Server server;

    public ServerGUI(Server server) {
        this.server = server;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);
        createPanel();
        setVisible(true);
    }

    @Override
    public void showMessage(String text) {
        appendLog(text);
    }

    private void appendLog(String text) {
        log.append(text + "\n");
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.work) {
                    appendLog("Сервер уже был запущен");
                } else {
                    server.work = true;
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!server.work) {
                    appendLog("Сервер уже был остановлен");
                } else {
                    server.work = false;
                    server.disonnectAll();
                    appendLog("Сервер остановлен!");
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}
