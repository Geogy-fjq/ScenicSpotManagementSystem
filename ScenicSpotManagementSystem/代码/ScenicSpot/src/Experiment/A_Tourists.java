package Experiment;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class A_Tourists extends JFrame {

	private JPanel contentPane1;
	private JTextField textField51;
	private JTextField textField55;
	private JTextField textField52;
	private JTextField textField56;
	private JTextField textField57;
	private JTextField textField43;
	private JTextField textField44;
	private JTextField textField46;
	private JTextField textField1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_Tourists frame = new A_Tourists();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public A_Tourists() {
		B_InitialScienSpotSystem i=A_Main.getInitialScienSpotSystem();;
		setResizable(false);
		setTitle("欢迎使用景区信息用户系统！");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1463, 1007);
		contentPane1 = new JPanel();
		contentPane1.setBackground(new Color(245, 255, 250));
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(8, 70, 1445, 2);
		contentPane1.add(separator);
		
		/*
         * 改变提示弹窗的文本和按钮的字体大小
         */
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
		
		JLabel label_1 = new JLabel("查看景区信息图");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label_1.setBounds(8, 280, 187, 37);
		contentPane1.add(label_1);
		
		JButton button1 = new JButton("景点分布图");
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("微软雅黑", Font.PLAIN,20));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(275, 70,1173, 434);
		contentPane1.add(scrollPane);
		scrollPane.setViewportView(textArea);
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button1)
				{
					AdjacencyMatrix matrix=i.getScienSpotSystem().listToMatrix();
					textArea.setText("\t");
					for(int i=0;i<matrix.numOfVertices();i++) {
						textArea.append(matrix.getSqlList().get(i)+"\t");
					}
					textArea.append("\r\n");
					for(int i=0;i<matrix.numOfVertices();i++) {
						textArea.append(matrix.getSqlList().get(i)+"\t");
						for(int j=0;j<matrix.numOfVertices();j++) {
							textArea.append(matrix.getWeight(i,j)+"\t");
						}
						textArea.append("\r\n");
					}
				} 
			}
		});
		button1.setForeground(Color.BLACK);
		button1.setFont(new Font("华文楷体", Font.PLAIN, 30));
		button1.setBackground(new Color(245, 245, 245));
		button1.setBounds(15, 330, 245, 46);
		contentPane1.add(button1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(8, 510, 1445, 2);
		contentPane1.add(separator_1);
		
		JLabel label_2 = new JLabel("景点排行");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label_2.setBounds(15, 513, 107, 37);
		contentPane1.add(label_2);
		
		JComboBox comboBox23 = new JComboBox();
		comboBox23.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox23.setModel(new DefaultComboBoxModel(new String[] {"景点欢迎度", "岔路数" ,"有无休息区", "有无厕所"}));
		comboBox23.setMaximumRowCount(4);
		comboBox23.setBackground(Color.WHITE);
		comboBox23.setBounds(115, 555, 145, 28);
		contentPane1.add(comboBox23);
		
		JButton button2 = new JButton("确定");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button2)
				{
					String s=comboBox23.getSelectedItem().toString();
					String a=null;
					if(s.equals("景点欢迎度")||s.equals("岔路数")) {
						a=i.getScienSpotSystem().quickSort(s);
					}
					else if(s.equals("有无休息区")||s.equals("有无厕所")) {
						a=i.getScienSpotSystem().insertSort(s);
					}
					textField43.setText(a);
				}
			}
		});
		button2.setForeground(Color.BLACK);
		button2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button2.setBackground(new Color(245, 245, 245));
		button2.setBounds(310, 550, 91, 37);
		contentPane1.add(button2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(8, 630, 1445, 1);
		contentPane1.add(separator_2);
		
		JLabel label_11 = new JLabel("查询两个景点间的最短路径和最短距离");
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label_11.setBounds(14, 753, 442, 37);
		contentPane1.add(label_11);
		
		JLabel lblSh = new JLabel("景点排行：");
		lblSh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSh.setFont(new Font("宋体", Font.PLAIN, 22));
		lblSh.setBounds(15, 595, 112, 28);
		contentPane1.add(lblSh);
		
		JButton button3 = new JButton("确定");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button3)
				{
					String s=textField44.getText();
					String k=i.getScienSpotSystem().serach(s);
					textField46.setText(k);
				}
			}
		});
		button3.setForeground(Color.BLACK);
		button3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button3.setBackground(new Color(245, 245, 245));
		button3.setBounds(310, 670, 91, 37);
		contentPane1.add(button3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(6, 750, 1445, 1);
		contentPane1.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(8, 910, 1445, 1);
		contentPane1.add(separator_5);
		
		JLabel label_27 = new JLabel("起始景点：");
		label_27.setHorizontalAlignment(SwingConstants.LEFT);
		label_27.setFont(new Font("宋体", Font.PLAIN, 22));
		label_27.setBounds(15, 795, 112, 28);
		contentPane1.add(label_27);
		
		textField51 = new JTextField();
		textField51.setBackground(new Color(255, 255, 255));
		textField51.setFont(new Font("宋体", Font.PLAIN, 20));
		textField51.setColumns(10);
		textField51.setBounds(115, 795, 145, 30);
		contentPane1.add(textField51);
		
		textField55 = new JTextField();
		textField55.setBackground(new Color(255, 255, 255));
		textField55.setFont(new Font("宋体", Font.PLAIN, 20));
		textField55.setColumns(10);
		textField55.setBounds(115, 835, 145, 30);
		contentPane1.add(textField55);
		
		textField52 = new JTextField();
		textField52.setBackground(new Color(255, 255, 255));
		textField52.setFont(new Font("宋体", Font.PLAIN, 20));
		textField52.setColumns(10);
		textField52.setBounds(415, 795, 145, 30);
		contentPane1.add(textField52);
		
		textField56 = new JTextField();
		textField56.setBackground(new Color(255, 255, 255));
		textField56.setFont(new Font("宋体", Font.PLAIN, 20));
		textField56.setColumns(10);
		textField56.setBounds(415, 835, 145, 30);
		contentPane1.add(textField56);
		
		textField57 = new JTextField();
		textField57.setBackground(new Color(255, 255, 255));
		textField57.setFont(new Font("宋体", Font.PLAIN, 20));
		textField57.setColumns(10);
		textField57.setBounds(115, 875, 1333, 30);
		contentPane1.add(textField57);
		
		JLabel label_4 = new JLabel("最短距离：");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(15, 835, 112, 28);
		contentPane1.add(label_4);
		
		JLabel label_26 = new JLabel("到达景点：");
		label_26.setHorizontalAlignment(SwingConstants.LEFT);
		label_26.setFont(new Font("宋体", Font.PLAIN, 22));
		label_26.setBounds(310, 795, 112, 28);
		contentPane1.add(label_26);
		
		JLabel label_28 = new JLabel("所需时间：");
		label_28.setHorizontalAlignment(SwingConstants.RIGHT);
		label_28.setFont(new Font("宋体", Font.PLAIN, 22));
		label_28.setBounds(310, 835, 112, 28);
		contentPane1.add(label_28);
		
		JLabel label_29 = new JLabel("最短路径：");
		label_29.setHorizontalAlignment(SwingConstants.RIGHT);
		label_29.setFont(new Font("宋体", Font.PLAIN, 22));
		label_29.setBounds(15, 875, 112, 28);
		contentPane1.add(label_29);
		
		textField43 = new JTextField();
		textField43.setBackground(new Color(255, 255, 255));
		textField43.setFont(new Font("宋体", Font.PLAIN, 20));
		textField43.setColumns(10);
		textField43.setBounds(115, 595, 1333, 30);
		contentPane1.add(textField43);
		
		textField44 = new JTextField();
		textField44.setBackground(new Color(255, 255, 255));
		textField44.setFont(new Font("宋体", Font.PLAIN, 20));
		textField44.setColumns(10);
		textField44.setBounds(115, 675, 145, 30);
		contentPane1.add(textField44);
		
		JLabel label_37 = new JLabel("景点介绍：");
		label_37.setHorizontalAlignment(SwingConstants.LEFT);
		label_37.setFont(new Font("宋体", Font.PLAIN, 22));
		label_37.setBounds(15, 715, 115, 28);
		contentPane1.add(label_37);
		
		textField46 = new JTextField();
		textField46.setBackground(new Color(255, 255, 255));
		textField46.setFont(new Font("宋体", Font.PLAIN, 20));
		textField46.setColumns(10);
		textField46.setBounds(115, 715, 1333, 30);
		contentPane1.add(textField46);
		
		JLabel label_40 = new JLabel("景点名称：");
		label_40.setHorizontalAlignment(SwingConstants.LEFT);
		label_40.setFont(new Font("宋体", Font.PLAIN, 22));
		label_40.setBounds(15, 675, 112, 28);
		contentPane1.add(label_40);
		
		JLabel lblid = new JLabel("排行选项：");
		lblid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblid.setFont(new Font("宋体", Font.PLAIN, 22));
		lblid.setBounds(15, 555, 112, 28);
		contentPane1.add(lblid);
		
		JLabel label_50 = new JLabel("");
		label_50.setIcon(new ImageIcon("D:\\代码\\2019年寒假实验课\\timp.jpg"));
		label_50.setBounds(486, 0, 76, 70);
		contentPane1.add(label_50);
		
		JLabel label_51 = new JLabel("景区信息用户系统");
		label_51.setForeground(Color.RED);
		label_51.setFont(new Font("宋体", Font.BOLD, 38));
		label_51.setBackground(Color.WHITE);
		label_51.setBounds(570, 15, 334, 50);
		contentPane1.add(label_51);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A_Main main=new A_Main();
				main.setVisible(true);
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button.setBackground(new Color(245, 245, 245));
		button.setBounds(1357, 915, 91, 37);
		contentPane1.add(button);
		
		
		JLabel label = new JLabel("查看导游线路图");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label.setBounds(8, 385, 187, 37);
		contentPane1.add(label);
		
		JButton button_2 = new JButton("确定");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=textField1.getText();
				AdjacencyMatrix c=i.getScienSpotSystem().shortLoop(i.getScienSpotSystem().listToMatrix());
				String str=c.travel(c.getVertexPos(s));
		    	textArea.setText(str);
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button_2.setBackground(new Color(245, 245, 245));
		button_2.setBounds(169, 467, 91, 37);
		contentPane1.add(button_2);
		
		JLabel label_3 = new JLabel("起始景点：");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(8, 432, 112, 28);
		contentPane1.add(label_3);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField1.setColumns(10);
		textField1.setBackground(Color.WHITE);
		textField1.setBounds(115, 432, 145, 30);
		contentPane1.add(textField1);
		
		JLabel label_7 = new JLabel("景点查找");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label_7.setBounds(15, 633, 107, 37);
		contentPane1.add(label_7);
		
		JButton button_3 = new JButton("确定");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c=textField51.getText();
				String fc=textField52.getText();
				String str=i.getScienSpotSystem().OutPutShortestPath(c,fc);
				String[] a=str.split(",");
				textField55.setText(a[1]);
		  		textField56.setText(a[2]);
		  		textField57.setText(a[0]);
			}
		});
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button_3.setBackground(new Color(245, 245, 245));
		button_3.setBounds(610, 790, 91, 37);
		contentPane1.add(button_3);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(15, 108, 245, 160);
		contentPane1.add(textField);
		String notice=i.getScienSpotSystem().getNotice();
		textField.setText(notice);
		
		JLabel label_5 = new JLabel("公告栏");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(255, 69, 0));
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label_5.setBounds(15, 70, 242, 37);
		contentPane1.add(label_5);
	}
}
