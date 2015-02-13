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
 * swing程序最小化至系统托盘
 * 
 * @author seara
 */
public class TestSysteTray {

    // //1. Java设置软件图标即窗口上角图标
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

    // // 2. java最小化到托盘显示图标实现
    // public static void main(String args[]) {
    //
    // String title = "Frame Title";
    // Frame frame = new Frame(title);
    // frame.setSize(100, 100);
    //
    // // 设置软件在托盘上显示的图标
    // Toolkit tk = Toolkit.getDefaultToolkit();
    // Image img = tk.getImage("F:\\image.jpg");// *.gif与该类文件同一目录
    // SystemTray systemTray = SystemTray.getSystemTray(); // 获得系统托盘的实例
    // TrayIcon trayIcon = null;
    //
    // try {
    // trayIcon = new TrayIcon(img, "前20名网站排名点击器");
    // systemTray.add(trayIcon); // 设置托盘的图标，*.gif与该类文件同一目录
    // frame.setIconImage(img);
    // trayIcon.setImageAutoSize(true);
    // } catch (AWTException e2) {
    // e2.printStackTrace();
    // }
    //
    // // 窗口最小化时软件dispose
    // frame.addWindowListener(new WindowAdapter() {
    // // 图标化窗口时调用事件
    // public void windowIconified(WindowEvent e) {
    // frame.dispose(); // 窗口最小化时dispose该窗口
    // }
    // });
    //
    // // 双击托盘图标，软件正常显示
    // trayIcon.addMouseListener(new MouseAdapter() {
    // public void mouseClicked(MouseEvent e) {
    // if (e.getClickCount() == 1) // 双击托盘窗口再现
    // // 置此 frame 的状态。该状态表示为逐位掩码。
    // frame.setExtendedState(Frame.NORMAL); // 正常化状态
    // frame.setVisible(true);
    // }
    // });
    //
    // frame.setVisible(true);
    //
    // }

//    // 3. Java swing 窗口最小化到任务栏 点击右键显示菜单（复制代码即可运行查看效果）
//    public static void main(String args[]) {
//
//        TrayIcon trayIcon = null;
//        if (SystemTray.isSupported()) // 判断系统是否支持系统托盘
//        {
//            SystemTray tray = SystemTray.getSystemTray(); // 创建系统托盘
//            Image image = Toolkit.getDefaultToolkit().getImage("F:\\image.jpg");// 载入图片,这里要写你的图标路径哦
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
//            // 创建弹出菜单
//            PopupMenu popup = new PopupMenu();
//            // 主界面选项
//            MenuItem mainFrameItem = new MenuItem("主界面");
//            mainFrameItem.addActionListener(listener);
//
//            // 退出程序选项
//            MenuItem exitItem = new MenuItem("退出程序");
//            exitItem.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    if (JOptionPane.showConfirmDialog(null, "确定退出系统") == 0) {
//                        System.exit(0);
//                    }
//                }
//            });
//
//            popup.add(mainFrameItem);
//            popup.add(exitItem);
//
//            trayIcon = new TrayIcon(image, "seara", popup);// 创建trayIcon
//            trayIcon.addActionListener(listener);
//            try {
//                tray.add(trayIcon);
//            } catch (AWTException e1) {
//                e1.printStackTrace();
//            }
//        }
//    }
}