package com.security.cloud.main;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Index {
    public void add(JFrame frame) {
        frame.setTitle("向JFrame窗口添加按钮");// 修改窗口标题
        frame.setLayout(null);// 不采用任何布局管理器
        JButton button = new JButton("确定", new ImageIcon("open.png"));// 创建一个指定文本和图像的按钮对象
        button.setBounds(175, 135, 50, 30);// 设置按钮的显示位置及大小
        button.setMargin(new Insets(0, 0, 0, 0));// 设置边框和标签的间距
        button.setHorizontalTextPosition(JButton.CENTER);// 设置文本相对于图像的显示位置
        button.setRolloverIcon(new ImageIcon("cut.png"));// 设置当光标移动到按钮上时显示的图像
        button.setPressedIcon(new ImageIcon("find.png"));// 设置当按钮被按下时显示的图像
        button.addActionListener(new ActionListener() {// 捕获按钮的ActionEvent事件
                public void actionPerformed(ActionEvent e) {
                    System.out.println("ActionEvent！");
                }
            });
        button.addChangeListener(new ChangeListener() {// 捕获按钮的ChangeEvent事件
                public void stateChanged(ChangeEvent e) {
                    System.out.println("ChangeEvent！");
                }
            });
        frame.add(button);
        frame.getRootPane().setDefaultButton(button);// 设置按钮为其所在顶层容器组件的默认按钮
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("利用JFrame创建窗口");// 创建指定标题的JFrame窗口对象
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭按钮的动作为退出窗口
        frame.setSize(400, 300);// 设置窗口大小
        Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize();// 获得显示器大小对象
        Dimension frameSize = frame.getSize();// 获得窗口大小对象
        if (frameSize.width > displaySize.width)
            frameSize.width = displaySize.width;// 窗口的宽度不能大于显示器的宽度
        if (frameSize.height > displaySize.height)
            frameSize.height = displaySize.height;// 窗口的高度不能大于显示器的高度
        frame.setLocation((displaySize.width - frameSize.width) / 2,
            (displaySize.height - frameSize.height) / 2);// 设置窗口居中显示器显示
        Index index = new Index();
        index.add(frame);// 向JFrame窗口添加标签
        frame.setVisible(true);// 设置窗口为可见的，默认为不可见
    }
}