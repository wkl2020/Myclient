package com.security.cloud.main;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Drawing2 {
    JLabel jlpic = new JLabel();
    JFrame jframe = new JFrame();

    public Drawing2() {

        init1Frame();
    }

    public void init1Frame() {
        // ImageIcon icon = new ImageIcon("title2.jpg");

        ImageIcon icon = (ImageIcon) PicFrame.getIcon("title2.jpg");
        icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(), icon.getIconHeight(), Image.SCALE_DEFAULT));

        System.out.println(icon.getIconHeight() + "" + icon.getIconWidth());
        jlpic.setBounds(0, 0, 1366, 768);
        jlpic.setHorizontalAlignment(0);
        jlpic.setIcon(icon);

        jframe.setSize(1366, 768);
        jframe.add(jlpic);
        jframe.pack();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);

    }

    public static void main(String args[]) {

        new Drawing2();
    }
}