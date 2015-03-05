package com.security.cloud.main;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
 
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/**
 * 鏃犳爣棰樻爮銆佹棤妗嗙獥鍙ｏ紝鐨偆鑷畾涔�
 */
public class PicFrame extends JFrame {
 
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Point loc = null;
    private Point tmp = null;
    private boolean isDragged = false;
    private JLabel pic;
 
    public PicFrame() {
        pic = new JLabel();
        pic.setIcon(getIcon("title2.jpg"));
        pic.setBounds(0, 0, 510, 60);
 
        // 鍒濆鍖栫獥浣�
        setResizable(false);
        // 灏嗙獥浣撹缃垚鏃犳爣棰樻爮鐨勮鍙ワ紝setUndecorated();娉ㄦ剰姝よ鍙ヤ竴瀹氳鏀惧湪setVisible涔嬪墠锛屽惁鍒欎細鎶ラ敊
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(510, 60);
        setVisible(true);
        add(pic);
 
        // 璁剧疆绐椾綋涓哄睆骞曠殑涓ぎ浣嶇疆
        int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 510) / 2;
        int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 60) / 2;
        this.setLocation(w, h);
 
        // 涓虹獥浣撴坊鍔犻紶鏍囦簨浠�
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                isDragged = false;
                // 涓烘寚瀹氱殑鍏夋爣璁剧疆鍏夋爣鍥惧儚
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
 
            public void mousePressed(MouseEvent e) {
                tmp = new Point(e.getX(), e.getY());
                isDragged = true;
                setCursor(new Cursor(Cursor.MOVE_CURSOR));
            }
        });
 
        this.addMouseMotionListener(new MouseMotionAdapter() {
            // 榧犳爣鎸夐敭鍦ㄧ粍浠朵笂鎸変笅骞舵嫋鍔ㄦ椂璋冪敤銆�
            public void mouseDragged(MouseEvent e) {
                if (isDragged) {
                    loc = new Point(getLocation().x + e.getX() - tmp.x,
                            getLocation().y + e.getY() - tmp.y);
                    setLocation(loc);
                }
            }
        });
    }
 
    // 鑾峰彇鍥剧墖鐨勬柟娉�
    public static Icon getIcon(String path) {
        URL url = PicFrame.class.getClassLoader().getResource(path);
        System.out.println("URL: " + url.getPath());
        return new ImageIcon(url);
    }
 
    public static void main(String[] args) {
 
        new PicFrame();
 
    }
 
}
