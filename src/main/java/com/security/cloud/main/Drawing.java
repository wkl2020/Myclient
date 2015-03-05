package com.security.cloud.main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing {

    JFrame jframe = new JFrame();
    public static JPanel GImage = null;

    public Drawing() {
        initFrame();
    }

    // 初始化窗口
    public void initFrame() {
        // 利用JPanel添加背景图片

        GImage = new JPanel() {

            protected void paintComponent(Graphics g) {
//                ImageIcon icon = new ImageIcon("image\\benbenla.jpg");
                ImageIcon icon = (ImageIcon) PicFrame.getIcon("title2.jpg");
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, icon.getIconWidth(),
                    icon.getIconHeight(), icon.getImageObserver());
                jframe.setSize(icon.getIconWidth(), icon.getIconHeight());

            }

        };
        
        
        
        
        
        jframe.setTitle("测试背景图片");
        jframe.add(GImage);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Drawing();

    }

}
