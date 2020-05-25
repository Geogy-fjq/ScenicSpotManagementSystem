package Experiment;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class A_Main extends JFrame {

	private JPanel contentPane;
	static B_InitialScienSpotSystem i=new B_InitialScienSpotSystem();
	static B_InitialParkingLotSystem v=new B_InitialParkingLotSystem();
	
	public static B_InitialScienSpotSystem getInitialScienSpotSystem() {
		return i;
	}
	public static B_InitialParkingLotSystem getInitialParkingLotSystem() {
		return v;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A_Main frame = new A_Main();
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
	public A_Main() {
		setTitle("欢迎使用景区信息管理系统！");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 615);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("景区信息管理系统");
		label.setBounds(215, 25, 343, 50);
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		contentPane.add(label);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(7, 328, 685, 4);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\代码\\2019年寒假实验课\\timp.jpg"));
		lblNewLabel.setBounds(120, 10, 76, 70);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("用户登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A_Tourists tourists=new A_Tourists();
				tourists.setVisible(true);
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("华文楷体", Font.PLAIN, 27));
		button.setBackground(new Color(255, 255, 224));
		button.setBounds(20, 95, 170, 45);
		contentPane.add(button);
		
		JButton button_2 = new JButton("管理员登录");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A_Administrators administrators=new A_Administrators();
				administrators.setVisible(true);
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("华文楷体", Font.PLAIN, 27));
		button_2.setBackground(new Color(255, 255, 224));
		button_2.setBounds(20, 338, 170, 45);
		contentPane.add(button_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(7, 85, 685, 4);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("1、查看景点分布图");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		label_1.setBounds(215, 98, 450, 39);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("2、查看导游线路图");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("宋体", Font.PLAIN, 25));
		label_2.setBounds(215, 134, 450, 39);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("3、查看道路修建规划图\r\n");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("宋体", Font.PLAIN, 25));
		label_3.setBounds(215, 170, 450, 39);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("4、景点的查找与排序");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("宋体", Font.PLAIN, 25));
		label_4.setBounds(215, 206, 450, 39);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("5、查询两个景点间的最短路径和最短距离\r\n");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("宋体", Font.PLAIN, 25));
		label_5.setBounds(215, 242, 463, 39);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("6、查看停车场车辆进出记录信息");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("宋体", Font.PLAIN, 25));
		label_6.setBounds(215, 278, 450, 39);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("1、景点的增添和删除");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("宋体", Font.PLAIN, 25));
		label_7.setBounds(215, 341, 450, 39);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("2、线路的增添和删除");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("宋体", Font.PLAIN, 25));
		label_8.setBounds(215, 375, 450, 39);
		contentPane.add(label_8);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(7, 455, 685, 4);
		contentPane.add(separator_2);
		
		JButton button_1 = new JButton("停车场记录");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A_ParkingLot parkingLot=new A_ParkingLot();
				parkingLot.setVisible(true);
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("华文楷体", Font.PLAIN, 27));
		button_1.setBackground(new Color(255, 255, 224));
		button_1.setBounds(20, 465, 170, 45);
		contentPane.add(button_1);
		
		JLabel label_9 = new JLabel("1、车辆到达记录");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("宋体", Font.PLAIN, 25));
		label_9.setBounds(215, 470, 450, 39);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("2、车辆离开记录");
		label_10.setHorizontalAlignment(SwingConstants.LEFT);
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("宋体", Font.PLAIN, 25));
		label_10.setBounds(215, 505, 450, 39);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("3、发布公告\r\n");
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("宋体", Font.PLAIN, 25));
		label_11.setBounds(215, 410, 450, 39);
		contentPane.add(label_11);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
