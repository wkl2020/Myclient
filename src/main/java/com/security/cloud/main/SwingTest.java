//package com.security.cloud.main;
//
//import javax.swing.*;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.tree.*;
//import javax.swing.event.*;
//import javax.swing.border.*;
//import javax.swing.table.*;
//
///** 
// * Swing ������Գ���
// * ����Swing�������������Ӧ���¼�
// * @author ����.�� 2003.4.17 ��23:14
// * @link  http://www.robochina.org
// * @link robococde@etang.com
// */
//public class SwingTest extends JFrame
//{
//    /**
//     * ��ģ�飬��ʼ��������ģ�飬����������ܵ��������
//     */
//    public SwingTest()
//    {
//        // ��ʼ������ģ��
//        MenuTest menuTest = new MenuTest();
//        LeftPanel leftPanel = new LeftPanel();
//        RightPanel rightPanel = new RightPanel();
//        BottomPanel bottomPanel = new BottomPanel();
//        CenterPanel centerPanel = new CenterPanel();
//        
//        // ��������ܵĲ���
//        Container c = this.getContentPane();
//        // c.setLayout(new BorderLayout())
//        this.setJMenuBar(menuTest);
//        
//        c.add(leftPanel,BorderLayout.WEST);
//        c.add(rightPanel,BorderLayout.EAST);
//        c.add(centerPanel,BorderLayout.CENTER);
//        c.add(bottomPanel,BorderLayout.SOUTH);
//        
//        // �������������࣬���Ӵ����¼�
//        this.addWindowListener(new WindowAdapter()
//            {
//                public void WindowClosing(WindowEvent e)
//                {   
//                    // �ͷ���Դ���˳�����
//                    dispose();
//                    System.exit(0);
//                }
//            });
//            
//        
//        
//        setSize(700,500);
//        setTitle("Swing �����ȫ�����");
//        // ����frame�ı�����,�˹���ʱ�رգ��Է���ʹ��window�¼�
//        // setUndecorated(true);
//        setLocation(200,150);
//        show();        
//    }
//
//    ////////////////////////////////////////////////////////////////////////////
//    /**
//     * �˵�������ģ��
//     * JMenuBar --+
//     *            --JMenu--+
//     *                       --JMenuItem  --ActionListener 
//     *              
//     */
//    class MenuTest extends JMenuBar
//    {
//        private JDialog aboutDialog;
//            
//        /**
//         * �˵���ʼ������
//         */    
//        public MenuTest()
//        {
//            JMenu fileMenu = new JMenu("�ļ�");
//            JMenuItem exitMenuItem = new JMenuItem("�˳�",KeyEvent.VK_E);
//            JMenuItem aboutMenuItem = new JMenuItem("����...",KeyEvent.VK_A);            
//                                                
//            fileMenu.add(exitMenuItem);
//            fileMenu.add(aboutMenuItem);
//            
//            this.add(fileMenu);        
//            
//                    
//            aboutDialog = new JDialog();
//            initAboutDialog();
//                        
//            // �˵��¼�
//            exitMenuItem.addActionListener(new ActionListener()
//            {
//                public void actionPerformed(ActionEvent e)
//                {
//                    dispose();
//                    System.exit(0);
//                }
//            });
//            
//            aboutMenuItem.addActionListener(new ActionListener()
//            {
//                public void actionPerformed(ActionEvent e)
//                {
//                    // "����"�Ի���Ĵ���
//                    aboutDialog.show();
//                }
//            });            
//                        
//        }
//        
//        /**
//         * ���ع��ڶԻ���
//         */
//        public JDialog getAboutDialog()
//        {
//            return aboutDialog;
//        }
//        
//        /**
//         * ����"����"�Ի������ۼ���Ӧ�¼�,������JFrameһ������������
//         * ����Ͻ��е�
//         */
//        public void initAboutDialog()
//        {
//            aboutDialog.setTitle("����");
//            
//            Container con =aboutDialog.getContentPane();
//             
//            // Swing ��ʹ��html���
//            Icon icon = new ImageIcon("smile.gif");
//            JLabel aboutLabel = new JLabel("<html><b><font size=5>"+
//            "<center>Swing �����ȫ����棡"+"<br>����.��",icon,JLabel.CENTER);
//                        
//            //JLabel aboutLabel = new JLabel("Swing �����ȫ����棡",icon,JLabel.CENTER);
//            con.add(aboutLabel,BorderLayout.CENTER);
//            
//            aboutDialog.setSize(450,225);
//            aboutDialog.setLocation(300,300);                        
//            aboutDialog.addWindowListener(new WindowAdapter()
//            {
//                public void WindowClosing(WindowEvent e)
//                {
//                    dispose();
//                }                    
//            });            
//        }
//    }
//    
//    ////////////////////////////////////////////////////////////////////////////
//    /**
//     * �����ģ�飬�̳�JPanel,��ʼ������ΪJTree
//     * JPanel--+
//     *         --JTree
//     */
//    class LeftPanel extends JPanel
//    {
//        private int i = 0;
//        public LeftPanel()
//        {
//            
//            DefaultMutableTreeNode    root = new DefaultMutableTreeNode("Root");
//            DefaultMutableTreeNode child = new DefaultMutableTreeNode("Child");
//            DefaultMutableTreeNode select = new DefaultMutableTreeNode("select");
//            
//            DefaultMutableTreeNode child1 = new DefaultMutableTreeNode(""+i);
//            
//            root.add(child);        
//            root.add(select);
//            child.add(child1);    
//            
//            JTree tree = new JTree(root);
//            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
//            
//            // ÿ���ڵ���и�
//            tree.setRowHeight(20);            
//            tree.addTreeSelectionListener(new TreeSelectionListener ()
//            {
//                public void valueChanged(TreeSelectionEvent e)
//                {
//                    // �����಻��ֱ�������ⲿ��tree��1.�ⲿ����������Ϊfinal 2.�½��ⲿ��Ķ���
//                    JTree tree =(JTree)e.getSource();
//                    DefaultMutableTreeNode selectNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
//                    i++;
//                    selectNode.add(new DefaultMutableTreeNode(""+i));
//                }
//            });            
//            
//            tree.setPreferredSize(new Dimension(100,300));
//        //    tree.setEnabled(true);
//            JScrollPane scrollPane = new JScrollPane(tree);
//            //scrollPane.setSize(100,350);
//            this.add(scrollPane);
//        }
//    }
//    
//    ////////////////////////////////////////////////////////////////////////////
//    /**
//     * �������ģ�飬�̳�JPanel,��ʼ������Ϊ�����������ɶ�ʱ������
//     * JPanel--+
//     *         --JProcessBar  --Timer
//     */
//    class BottomPanel extends JPanel
//    {
//        private JProgressBar pb;
//        ////////////////////////////////////////
//        //public class 
//        //////////////////////////////
//        public BottomPanel()
//        {
//            pb = new JProgressBar();
//            pb.setPreferredSize(new Dimension(680,20));
//            
//            // ���ö�ʱ�����������ƽ������Ĵ���
//            Timer time = new Timer(1,new ActionListener()
//            { 
//                int counter = 0;
//                public void actionPerformed(ActionEvent e)
//                {
//                    counter++;
//                    pb.setValue(counter);
//                    Timer t = (Timer)e.getSource();
//                    
//                    // ����������ﵽ���ֵ���¿�������
//                    if (counter == pb.getMaximum())
//                    {
//                        t.stop();
//                        counter =0;
//                        t.start();
//                    }                    
//                }
//            });
//            time.start();
//            
//            pb.setStringPainted(true);
//            pb.setMinimum(0);
//            pb.setMaximum(1000);
//            pb.setBackground(Color.white);
//            pb.setForeground(Color.red);
//                        
//            this.add(pb);                
//        }
//        
//        /**
//         * ���ý�����������ģ��
//         */
//        public void setProcessBar(BoundedRangeModel rangeModel)
//        {
//            pb.setModel(rangeModel);
//        }
//    }
//    
//    ////////////////////////////////////////////////////////////////////////////
//    /**
//     * ���ұ�ģ�飬�̳�JPanel,��ʼ�����ְ�ť
//     * JPanel--+
//     *         --JButton  --JToggleButton -- JList -- JCombox --JCheckBox ....
//     */
//    class RightPanel extends JPanel
//    {
//        public RightPanel()
//        {
//            this.setLayout(new GridLayout(8,1));        
//            
//            
//            // ��ʼ�����ְ�ť
//            JCheckBox checkBox = new JCheckBox("��ѡ��ť");            
//            JButton button = new JButton("���ļ�");
//            button.addActionListener(new ActionListener()
//            {
//                public void actionPerformed(ActionEvent e)
//                {
//                    JFileChooser file = new JFileChooser();
//                    int result = file.showOpenDialog(new JPanel());
//                    if (result ==file.APPROVE_OPTION) 
//                    {
//                        String fileName = file.getSelectedFile().getName();                    
//                        String dir = file.getCurrentDirectory().toString();
//                          JOptionPane.showConfirmDialog(null,dir+"\\"+fileName,"ѡ����ļ�",JOptionPane.YES_OPTION);
//                     }
//                }
//            });
//            ////////////////////////////////////////
//            //public
//            //////////////////////////////////////////
//                    
//            JToggleButton toggleButton = new JToggleButton("˫̬��ť");
//            
//            ButtonGroup    buttonGroup = new ButtonGroup();
//            JRadioButton radioButton1 = new JRadioButton("��ѡ��ť1",false);
//            JRadioButton radioButton2 = new JRadioButton("��ѡ��ť2",false);
//            
//            // ��Ͽ�Ĵ���
//            JComboBox comboBox = new JComboBox();
//            comboBox.setToolTipText("��������б�����ѡ��");
//            comboBox.addActionListener(new ActionListener() 
//            {
//                public void actionPerformed(ActionEvent e)
//                {
//                    JComboBox comboBox =(JComboBox)e.getSource();
//                    comboBox.addItem("����Ա");
//                    comboBox.addItem("����Ա");
//                }
//            });
//            
//            // �б��Ĵ���
//            DefaultListModel litem = new DefaultListModel();
//            litem.addElement("�㽶");
//            litem.addElement("ˮ��");
//            JList list = new JList(litem);
//            
//            
//            list.addListSelectionListener(new ListSelectionListener ()
//            {
//                public void valueChanged(ListSelectionEvent e)
//                {
//                    JList l = (JList)e.getSource();
//                    Object s= l.getSelectedValue();
//                    JOptionPane.showMessageDialog(null,s,"��Ϣ��",JOptionPane.YES_OPTION);
//                }
//            });
//            
//            // ���Ӱ�ť��
//            buttonGroup.add(radioButton1);
//            buttonGroup.add(radioButton2);
//            
//            // ���Ӹ��ְ�ť��JPanel����ʾ
//            add(button);
//            add(toggleButton);
//            add(checkBox);
//            add(radioButton1);            
//            add(radioButton2);
//            add(comboBox);
//            
//            add(list);
//            
//            this.setBorder(new EtchedBorder(EtchedBorder.LOWERED,Color.LIGHT_GRAY,Color.blue));
//        }        
//    }
//    
//    ////////////////////////////////////////////////////////////////////////////
//    /**
//     * �м��ģ�飬�̳�JPanel,��ʼ��ҳǩ,����ҳǩ�������ı��������,
//     * �ı��������÷ָ����ָ�
//     * JPanel--+
//     *         -JTabbedPane--+
//     *                          --Draw    --JTable  -JTextAreas -JText --JPopupMenu
//     */
//    class CenterPanel extends JPanel
//    {
//        public CenterPanel()
//        {
//            JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
//            
//            JTextField textField = new JTextField("�ı���,�����<�ļ���ť>��ѡ���ļ�");
//            textField.setActionCommand("textField");
//            
//            JTextPane textPane = new JTextPane();
//            textPane.setCursor(new Cursor(Cursor.TEXT_CURSOR));
//            textPane.setText("�༭��,���ŵ���ı��������������ָ�����");
//                        
//            textPane.addMouseListener(new MouseAdapter () 
//            {
//                public void mousePressed (MouseEvent e)
//                {
//                    JTextPane textPane = (JTextPane)e.getSource();
//                    textPane.setText("�༭���������ɹ�");
//                //    textField.setText(""+textPane.getText());
//                }
//            });
//            
//            /*
//            UpperCaseDocument doc = new Document(); 
//            textField.setDocumentsetDocument(doc);
//            doc.addDocumentListener(new DocumentListener()
//            {
//                public void changedUpdate(DocumentEvent e){}
//                public void removeUpdate(DocumentEvent e){}
//                public void insertUpdate(DocumentEvent e)
//                {
//                    Document text = (Document)e.getDocument();
//                    text.setText("���Ƴɹ�");
//                }                
//            });
//            */
//            
//            JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,textField,textPane);
//            
//                
//            JTable table = new JTable(10,10);
//            //table.showHorizontalLines(true);
//            //table.showVerticalLines(true);
//            //table.gridColor(Color.blue);
//            
//            JPanel pane  = new JPanel();
//            pane.add(table.getTableHeader(),BorderLayout.NORTH);
//            pane.add(table);
//                        
//            tab.addTab("�ı���ʾ",splitPane);
//            //tab.addTab(table.getTableHeader());
//            tab.addTab("�����ʾ",pane);
//            tab.setPreferredSize(new Dimension(500,600));
//            this.add(tab);
//            this.setEnabled(true);            
//        }
//    }
//    
//    
//    public static void main(String args[])
//    {
//        // �������������,�˴�û��ʹ�ã��ɴ򿪿���Ч��
//        //try
//        //{
//        //    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        //}
//        //catch  (Exception e){}
//        new SwingTest();                        
//    }
//} 
