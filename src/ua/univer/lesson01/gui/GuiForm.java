package ua.univer.lesson01.gui;

import javax.swing.*;
import java.awt.event.*;


public class GuiForm {
    static JTextField txt1;
    static JTextField txt2;
    static JTextField txt3;
    static JButton btn1;
    static JButton btn2;
    static JButton btn3;
    public static void main(String[] args) {
        JFrame win = new JFrame("win");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(300,400);

        JPanel panel = new JPanel();
        txt1 = new JTextField("                           ");
        txt2 = new JTextField("                           ");
        txt3 = new JTextField("                           ");
        btn1 = new JButton("+");
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int x = Integer.parseInt(txt1.getText().trim());
                int y = Integer.parseInt(txt2.getText().trim());
                txt3.setText(String.valueOf(x+y));
            }
        });
        btn2 = new JButton("*");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(txt1.getText().trim());
                int y = Integer.parseInt(txt2.getText().trim());
                txt3.setText(String.valueOf(x*y));
            }
        });
        btn3 = new JButton("-");
        btn3.addActionListener(e -> {
                int x = Integer.parseInt(txt1.getText().trim());
                int y = Integer.parseInt(txt2.getText().trim());
                txt3.setText(String.valueOf(x*y));

        });
        panel.add(txt1);
        panel.add(txt2);
        panel.add(txt3);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);

        win.setContentPane(panel);
        win.setVisible(true);
    }

    static class MyMouseListener2 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = Integer.parseInt(txt1.getText().trim());
            int y = Integer.parseInt(txt2.getText().trim());
            txt3.setText(String.valueOf(x*y));
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    static class MyMouseListener3 implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = Integer.parseInt(txt1.getText().trim());
            int y = Integer.parseInt(txt2.getText().trim());
            txt3.setText(String.valueOf(x-y));
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
