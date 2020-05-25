package Experiment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class A_ParkingLot extends JFrame {

	private JPanel contentPane;
	private JTextField textField11;
	private JTextField textField13;
	private JTextField textField12;
	private JTextField textField23;
	private JTextField textField21;
	private JTextField textField22;
	private JTextField textField24;

	B_InitialParkingLotSystem i=A_Main.getInitialParkingLotSystem();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_ParkingLot frame = new A_ParkingLot();
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
	public A_ParkingLot() {
		setResizable(false);
		setTitle("欢迎使用停车场信息管理系统！");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("停车场信息管理系统");
		label.setBounds(370, 15, 369, 42);
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("宋体", Font.BOLD, 38));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(7, 70, 1052, 2);
		
		/*
         * 改变提示弹窗的文本和按钮的字体大小
         */
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("宋体", Font.PLAIN, 20)));
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button){
					String s1=textField11.getText();
					String s2=textField12.getText();
					String str=i.getParkingLotSystem().arrive(s1,s2);
					textField13.setText(str);
				}
			}
		});
		button.setBounds(699, 114, 91, 37);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button.setBackground(new Color(245, 245, 245));
		
		
		JLabel label_1 = new JLabel("车辆到达");
		label_1.setBounds(15, 73, 117, 37);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		
		textField11 = new JTextField();
		textField11.setFont(new Font("宋体", Font.PLAIN, 20));
		textField11.setBounds(115, 118, 145, 30);
		textField11.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("车牌号：");
		lblNewLabel.setBounds(15, 118, 109, 28);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(separator);
		contentPane.add(button);
		contentPane.add(label_1);
		contentPane.add(textField11);
		contentPane.add(lblNewLabel);
		
		JLabel label_6 = new JLabel("达到时间：");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("宋体", Font.PLAIN, 22));
		label_6.setBounds(300, 118, 122, 28);
		contentPane.add(label_6);
		
		textField13 = new JTextField();
		textField13.setFont(new Font("宋体", Font.PLAIN, 20));
		textField13.setColumns(10);
		textField13.setBounds(115, 158, 675, 30);
		contentPane.add(textField13);
		
		textField12 = new JTextField();
		textField12.setFont(new Font("宋体", Font.PLAIN, 20));
		textField12.setColumns(10);
		textField12.setBounds(400, 118, 145, 30);
		contentPane.add(textField12);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(7, 200, 1052, 1);
		contentPane.add(separator_1);
		
		JLabel label_3 = new JLabel("通知信息：");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("宋体", Font.PLAIN, 22));
		label_3.setBounds(15, 158, 118, 28);
		contentPane.add(label_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(7, 370, 1052, 1);
		contentPane.add(separator_2);
		
		JLabel label_21 = new JLabel("通知信息：");
		label_21.setHorizontalAlignment(SwingConstants.LEFT);
		label_21.setFont(new Font("宋体", Font.PLAIN, 22));
		label_21.setBounds(15, 288, 117, 28);
		contentPane.add(label_21);
		
		textField23 = new JTextField();
		textField23.setFont(new Font("宋体", Font.PLAIN, 20));
		textField23.setColumns(10);
		textField23.setBounds(115, 288, 675, 30);
		contentPane.add(textField23);
		
		JLabel label_24 = new JLabel("车辆离开");
		label_24.setHorizontalAlignment(SwingConstants.LEFT);
		label_24.setForeground(Color.BLACK);
		label_24.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		label_24.setBounds(15, 203, 117, 37);
		contentPane.add(label_24);
		
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
		button_4.setBounds(967, 380, 91, 37);
		contentPane.add(button_4);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("D:\\代码\\2019年寒假实验课\\timp.jpg"));
		label_9.setBounds(280, 3, 76, 70);
		contentPane.add(label_9);
		
		JLabel label_2 = new JLabel("车牌号：");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("宋体", Font.PLAIN, 22));
		label_2.setBounds(15, 248, 109, 28);
		contentPane.add(label_2);
		
		textField21 = new JTextField();
		textField21.setFont(new Font("宋体", Font.PLAIN, 20));
		textField21.setColumns(10);
		textField21.setBounds(115, 248, 145, 30);
		contentPane.add(textField21);
		
		JLabel label_4 = new JLabel("离开时间：");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("宋体", Font.PLAIN, 22));
		label_4.setBounds(300, 248, 122, 28);
		contentPane.add(label_4);
		
		textField22 = new JTextField();
		textField22.setFont(new Font("宋体", Font.PLAIN, 20));
		textField22.setColumns(10);
		textField22.setBounds(400, 248, 145, 30);
		contentPane.add(textField22);
		
		JButton button_1 = new JButton("确定");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1=textField21.getText();
				String s2=textField22.getText();
				String str=i.getParkingLotSystem().leave(s1,s2);
				String[] a=str.split("\\+");
				textField23.setText(a[0]);
				textField24.setText(a[1]);
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		button_1.setBackground(new Color(245, 245, 245));
		button_1.setBounds(699, 244, 91, 37);
		contentPane.add(button_1);
		
		JLabel label_5 = new JLabel("附加信息：");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("宋体", Font.PLAIN, 22));
		label_5.setBounds(15, 328, 117, 28);
		contentPane.add(label_5);
		
		textField24 = new JTextField();
		textField24.setFont(new Font("宋体", Font.PLAIN, 20));
		textField24.setColumns(10);
		textField24.setBounds(115, 328, 675, 30);
		contentPane.add(textField24);
	}
}
