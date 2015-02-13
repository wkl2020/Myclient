package com.security.cloud.main;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * swing������С����ϵͳ����
 * 
 * @author seara
 */
public class TestSysteTray {

    // //1. Java�������ͼ�꼴�����Ͻ�ͼ��
    // public static void main(String[] args) {
    // // TODO Auto-generated method stub
    // // Create frame
    // String title = "Frame Title";
    // Frame frame = new Frame(title);
    //
    // // Set icon
    // Image icon = Toolkit.getDefaultToolkit().getImage("F:\\image.jpg");
    // frame.setIconImage(icon);
    // frame.setSize(100, 100);
    // frame.setVisible(true);
    // }

    // // 2. java��С����������ʾͼ��ʵ��
    // public static void main(String args[]) {
    //
    // String title = "Frame Title";
    // Frame frame = new Frame(title);
    // frame.setSize(100, 100);
    //
    // // �����������������ʾ��ͼ��
    // Toolkit tk = Toolkit.getDefaultToolkit();
    // Image img = tk.getImage("F:\\image.jpg");// *.gif������ļ�ͬһĿ¼
    // SystemTray systemTray = SystemTray.getSystemTray(); // ���ϵͳ���̵�ʵ��
    // TrayIcon trayIcon = null;
    //
    // try {
    // trayIcon = new TrayIcon(img, "ǰ20����վ���������");
    // systemTray.add(trayIcon); // �������̵�ͼ�꣬*.gif������ļ�ͬһĿ¼
    // frame.setIconImage(img);
    // trayIcon.setImageAutoSize(true);
    // } catch (AWTException e2) {
    // e2.printStackTrace();
    // }
    //
    // // ������С��ʱ���dispose
    // frame.addWindowListener(new WindowAdapter() {
    // // ͼ�껯����ʱ�����¼�
    // public void windowIconified(WindowEvent e) {
    // frame.dispose(); // ������С��ʱdispose�ô���
    // }
    // });
    //
    // // ˫������ͼ�꣬���������ʾ
    // trayIcon.addMouseListener(new MouseAdapter() {
    // public void mouseClicked(MouseEvent e) {
    // if (e.getClickCount() == 1) // ˫�����̴�������
    // // �ô� frame ��״̬����״̬��ʾΪ��λ���롣
    // frame.setExtendedState(Frame.NORMAL); // ������״̬
    // frame.setVisible(true);
    // }
    // });
    //
    // frame.setVisible(true);
    //
    // }

//    // 3. Java swing ������С���������� ����Ҽ���ʾ�˵������ƴ��뼴�����в鿴Ч����
//    public static void main(String args[]) {
//
//        TrayIcon trayIcon = null;
//        if (SystemTray.isSupported()) // �ж�ϵͳ�Ƿ�֧��ϵͳ����
//        {
//            SystemTray tray = SystemTray.getSystemTray(); // ����ϵͳ����
//            Image image = Toolkit.getDefaultToolkit().getImage("F:\\image.jpg");// ����ͼƬ,����Ҫд���ͼ��·��Ŷ
//
//            ActionListener listener = new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    JFrame frame = new JFrame();
//                    frame.setBounds(400, 400, 200, 200);
//                    JLabel label = new JLabel("welcome JDK1.6");
//                    frame.add(label);
//                    frame.setVisible(true);
//                }
//
//            };
//            // ���������˵�
//            PopupMenu popup = new PopupMenu();
//            // ������ѡ��
//            MenuItem mainFrameItem = new MenuItem("������");
//            mainFrameItem.addActionListener(listener);
//
//            // �˳�����ѡ��
//            MenuItem exitItem = new MenuItem("�˳�����");
//            exitItem.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    if (JOptionPane.showConfirmDialog(null, "ȷ���˳�ϵͳ") == 0) {
//                        System.exit(0);
//                    }
//                }
//            });
//
//            popup.add(mainFrameItem);
//            popup.add(exitItem);
//
//            trayIcon = new TrayIcon(image, "seara", popup);// ����trayIcon
//            trayIcon.addActionListener(listener);
//            try {
//                tray.add(trayIcon);
//            } catch (AWTException e1) {
//                e1.printStackTrace();
//            }
//        }
//    }
}