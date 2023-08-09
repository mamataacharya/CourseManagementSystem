package CourseM;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 859, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		Image img = null;
		try {
		    img = ImageIO.read(new File("C:\\Users\\ASUS\\Desktop\\New folder (2)\\yyyy.png")).getScaledInstance(800, 500, 50);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		contentPane.setLayout(null);
			
		JLabel hiii = new JLabel(new ImageIcon(img));
		hiii.setText("hii");
		hiii.setForeground(UIManager.getColor("Button.background"));
		hiii.setBounds(10, 21, 812, 472);
		getContentPane().add(hiii);
		
		JButton button = new JButton("Start");
		hiii.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login a = new Login();
				a.show();
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 24));
		button.setForeground(new Color(255, 255, 255));
		button.setBounds(320, 385, 127, 40);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		}
}


