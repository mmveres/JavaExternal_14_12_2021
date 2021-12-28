package ua.univer.lesson04;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program {
    static Object mutex = new Object();
    public static void main(String[] args) {
        JFrame win = new JFrame("TH1");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(500, 400);
        JPanel panel = new JPanel();
        JTextField txt = new JTextField("                     ");
        JButton btn = new JButton("Ok");
        btn.addActionListener(
                (e) -> {
                    new Thread(
                            () -> {
                                synchronized (mutex) {
                                    for (int i = 0; i < 100; i++) {
                                        txt.setText("Hi" + i + " : " + Thread.currentThread().getId());
                                        try {
                                            Thread.sleep(20);
                                        } catch (InterruptedException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                }
                            }
                    ).start();

                });
        panel.add(txt);
        panel.add(btn);
        win.setContentPane(panel);
        win.setVisible(true);

        System.out.println("main end");
    }
}
