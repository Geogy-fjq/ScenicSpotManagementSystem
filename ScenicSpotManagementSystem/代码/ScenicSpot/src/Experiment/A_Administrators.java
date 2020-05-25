package Experiment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class A_Administrators extends JFrame {

	private JPanel contentPane;
	private JTextField textField11;
	private JTextField textField15;
	private JTextField textField21;
	private JTextField textField12;
	private JTextField textField31;
	private JTextField textField41;
	private JTextField textField32;
	private JTextField textField33;
	private JTextField textField34;
	private JTextField textField42;
	private JTextField textField13;
	private JTextField textField14;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_Administrators frame = new A_Administrators();
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
	public A_Administrators() {
		B_InitialScienSpotSystem i=A_Main.getInitialScienSpotSystem();
		setResizable(false);
		setTitle("欢迎使用景区信息管理员系统！");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 635);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("景区信息管理员系统");
		label.setBounds(370, 15, 369, 42);
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("宋体", Font.BOLD, 38));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(7, 65, 1052, 2);
		
		/*
         * 改变提示弹窗的文本和按钮的字体大小
         */
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
		
		JButton button = new JButton("确定");
		/*
		 * 增添景点
		 */
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button)
				{
					String s1=textField11.getText();
					String s2=textField12.getText();
					String s3=textField13.getText();
					String s4=textField14.getText();
					String s5=textField15.getText();
					String str=s1+"+"+s5+"+"+s2+"+"+s3+"+"+s4;
					boolean k=i.getScienSpotSystem().insertScenicSpot(str);
					if(k==true) {
						JOptionPane.showMessageDialog(null, "   增添成功！");//弹出提示框
						i.getScienSpotSystem().setNotice("新增添"+s1+"景点，欢迎游玩！");
					}
					else {
						JOptionPane.showMessageDialog(null, "   增添失败！");//弹出提示框
					}
				}
			}
		});
		button.setBounds(959, 152, 91, 37);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button.setBackground(new Color(245, 245, 245));
		
		JLabel label_1 = new JLabel("增添景点");
		label_1.setBounds(15, 68, 117, 37);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		
		textField11 = new JTextField();
		textField11.setFont(new Font("宋体", Font.PLAIN, 20));
		textField11.setBounds(110, 113, 145, 30);
		textField11.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("景点名称");
		lblNewLabel.setBounds(20, 113, 106, 28);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		
		JLabel label_5 = new JLabel("景点介绍");
		label_5.setBounds(20, 156, 106, 28);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("宋体", Font.PLAIN, 22));
		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(separator);
		contentPane.add(button);
		contentPane.add(label_1);
		contentPane.add(textField11);
		contentPane.add(lblNewLabel);
		contentPane.add(label_5);
		
		textField15 = new JTextField();
		textField15.setFont(new Font("宋体", Font.PLAIN, 20));
		textField15.setColumns(10);
		textField15.setBounds(110, 156, 675, 30);
		contentPane.add(textField15);
		
		JLabel label_6 = new JLabel("景点欢迎度");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("宋体", Font.PLAIN, 22));
		label_6.setBounds(263, 113, 122, 28);
		contentPane.add(label_6);
		
		textField21 = new JTextField();
		textField21.setFont(new Font("宋体", Font.PLAIN, 20));
		textField21.setColumns(10);
		textField21.setBounds(110, 248, 145, 30);
		contentPane.add(textField21);
		
		textField12 = new JTextField();
		textField12.setFont(new Font("宋体", Font.PLAIN, 20));
		textField12.setColumns(10);
		textField12.setBounds(375, 113, 145, 30);
		contentPane.add(textField12);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(7, 200, 1052, 1);
		contentPane.add(separator_1);
		
		JLabel label_3 = new JLabel("景点名称");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(20, 248, 106, 28);
		contentPane.add(label_3);
		
		JButton button_1 = new JButton("确定");
		/*
		 * 删除景点
		 */
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_1)
				{
					String name=textField21.getText();
					boolean k=i.getScienSpotSystem().deleteScenicSpot(name);
					if(k==true) {
						JOptionPane.showMessageDialog(null, "   删除成功！");//弹出提示框
						i.getScienSpotSystem().setNotice(name+"景点已关闭！");
					}
					else {
						JOptionPane.showMessageDialog(null, " 删除失败！该景点不存在！");//弹出提示框
					}
				}
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button_1.setBackground(new Color(245, 245, 245));
		button_1.setBounds(959, 244, 91, 37);
		contentPane.add(button_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(7, 292, 1052, 1);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(7, 427, 1052, 1);
		contentPane.add(separator_3);
		
		JLabel label_21 = new JLabel("起始景点");
		label_21.setHorizontalAlignment(SwingConstants.LEFT);
		label_21.setFont(new Font("宋体", Font.PLAIN, 22));
		label_21.setBounds(20, 340, 106, 28);
		contentPane.add(label_21);
		
		textField31 = new JTextField();
		textField31.setFont(new Font("宋体", Font.PLAIN, 20));
		textField31.setColumns(10);
		textField31.setBounds(110, 340, 145, 30);
		contentPane.add(textField31);
		
		JButton button_2 = new JButton("确定");
		/*
		 * 增添路线
		 */
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_2)
				{
					String s1=textField31.getText();
					String s2=textField32.getText();
					String s3=textField33.getText();
					String s4=textField34.getText();
					String str=s1+","+s2+","+s3+","+s4;
					boolean k=i.getScienSpotSystem().insertRelationship(str);
					if(k==true) {
						JOptionPane.showMessageDialog(null, "   增添成功！");//弹出提示框
						i.getScienSpotSystem().setNotice("新增添"+s1+"——"+s2+"线路！");
					}
					else {
						JOptionPane.showMessageDialog(null, "   增添失败！");//弹出提示框
					}
				}
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button_2.setBackground(new Color(245, 245, 245));
		button_2.setBounds(959, 379, 91, 37);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("确定");
		/*
		 * 删除路线
		 */
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_3)
				{
					String s1=textField41.getText();
					String s2=textField42.getText();
					boolean k=i.getScienSpotSystem().deleteRelationship(s1,s2);
					if(k==true) {
						JOptionPane.showMessageDialog(null, "   删除成功！");//弹出提示框
						i.getScienSpotSystem().setNotice(s1+"——"+s2+"线路已关闭！");
					}
					else {
						JOptionPane.showMessageDialog(null, " 删除失败！该线路不存在！");//弹出提示框
					}
				}
			}
		});
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button_3.setBackground(new Color(245, 245, 245));
		button_3.setBounds(959, 472, 91, 37);
		contentPane.add(button_3);
		
		JLabel label_23 = new JLabel("起始景点");
		label_23.setHorizontalAlignment(SwingConstants.LEFT);
		label_23.setFont(new Font("宋体", Font.PLAIN, 22));
		label_23.setBounds(20, 475, 106, 28);
		contentPane.add(label_23);
		
		textField41 = new JTextField();
		textField41.setFont(new Font("宋体", Font.PLAIN, 20));
		textField41.setColumns(10);
		textField41.setBounds(110, 475, 145, 30);
		contentPane.add(textField41);
		
		JLabel label_19 = new JLabel("终止景点");
		label_19.setHorizontalAlignment(SwingConstants.LEFT);
		label_19.setFont(new Font("宋体", Font.PLAIN, 22));
		label_19.setBounds(285, 340, 106, 28);
		contentPane.add(label_19);
		
		textField32 = new JTextField();
		textField32.setFont(new Font("宋体", Font.PLAIN, 20));
		textField32.setColumns(10);
		textField32.setBounds(375, 340, 145, 30);
		contentPane.add(textField32);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(7, 520, 1052, 1);
		contentPane.add(separator_4);
		
		JLabel label_10 = new JLabel("两地距离");
		label_10.setHorizontalAlignment(SwingConstants.LEFT);
		label_10.setFont(new Font("宋体", Font.PLAIN, 22));
		label_10.setBounds(550, 340, 106, 28);
		contentPane.add(label_10);
		
		textField33 = new JTextField();
		textField33.setFont(new Font("宋体", Font.PLAIN, 20));
		textField33.setBackground(Color.WHITE);
		textField33.setColumns(10);
		textField33.setBounds(640, 340, 145, 30);
		contentPane.add(textField33);
		
		JLabel label_17 = new JLabel("所需时间");
		label_17.setHorizontalAlignment(SwingConstants.LEFT);
		label_17.setFont(new Font("宋体", Font.PLAIN, 22));
		label_17.setBounds(815, 340, 106, 28);
		contentPane.add(label_17);
		
		textField34 = new JTextField();
		textField34.setFont(new Font("宋体", Font.PLAIN, 20));
		textField34.setBackground(Color.WHITE);
		textField34.setColumns(10);
		textField34.setBounds(905, 340, 145, 30);
		contentPane.add(textField34);
		
		textField42 = new JTextField();
		textField42.setFont(new Font("宋体", Font.PLAIN, 20));
		textField42.setBackground(Color.WHITE);
		textField42.setColumns(10);
		textField42.setBounds(376, 475, 145, 30);
		contentPane.add(textField42);
		
		JLabel label_24 = new JLabel("删除景点");
		label_24.setHorizontalAlignment(SwingConstants.LEFT);
		label_24.setForeground(Color.BLACK);
		label_24.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label_24.setBounds(15, 203, 117, 37);
		contentPane.add(label_24);
		
		JLabel label_2 = new JLabel("增添路线");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label_2.setBounds(15, 295, 117, 37);
		contentPane.add(label_2);
		
		JLabel label_20 = new JLabel("删除路线");
		label_20.setHorizontalAlignment(SwingConstants.LEFT);
		label_20.setForeground(Color.BLACK);
		label_20.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label_20.setBounds(15, 430, 117, 37);
		contentPane.add(label_20);
		
		JLabel label_4 = new JLabel("终止景点");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(285, 475, 106, 28);
		contentPane.add(label_4);
		
		JLabel label_8 = new JLabel("有无休息区");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("宋体", Font.PLAIN, 22));
		label_8.setBounds(528, 113, 123, 28);
		contentPane.add(label_8);
		
		textField13 = new JTextField();
		textField13.setFont(new Font("宋体", Font.PLAIN, 20));
		textField13.setColumns(10);
		textField13.setBounds(640, 113, 145, 30);
		contentPane.add(textField13);
		
		JLabel label_7 = new JLabel("有无厕所");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("宋体", Font.PLAIN, 22));
		label_7.setBounds(815, 113, 106, 28);
		contentPane.add(label_7);
		
		textField14 = new JTextField();
		textField14.setFont(new Font("宋体", Font.PLAIN, 20));
		textField14.setColumns(10);
		textField14.setBounds(905, 113, 145, 30);
		contentPane.add(textField14);
		
		JButton button_4 = new JButton("返回");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A_Main main=new A_Main();
				main.setVisible(true);
			}
		});
		button_4.setForeground(Color.BLACK);
		button_4.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button_4.setBackground(new Color(245, 245, 245));
		button_4.setBounds(959, 530, 91, 37);
		contentPane.add(button_4);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("D:\\代码\\2019年寒假实验课\\timp.jpg"));
		label_9.setBounds(280, 3, 76, 70);
		contentPane.add(label_9);
	}
}
