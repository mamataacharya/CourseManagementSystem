package CourseM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Modules extends JFrame {

	private JPanel contentPane;
	private JTextField mcode;
	private JTextField mname;
	private JTextField msem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modules frame = new Modules();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Connection getConnection() {
		connection c = new connection();
		Connection con = c.connection();
		return con;
	}


	/**
	 * Create the frame.
	 */
	public Modules() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 769, 514);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MODULES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(346, 11, 95, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the following informations:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(276, 53, 225, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Module code:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(43, 163, 103, 31);
		contentPane.add(lblNewLabel_2);
		
		mcode = new JTextField();
		mcode.setBounds(181, 171, 95, 20);
		contentPane.add(mcode);
		mcode.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Module title:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(540, 122, 103, 20);
		contentPane.add(lblNewLabel_3);
		
		mname = new JTextField();
		mname.setBounds(454, 166, 273, 31);
		contentPane.add(mname);
		mname.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Level:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(43, 218, 69, 20);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Semester:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(40, 269, 85, 31);
		contentPane.add(lblNewLabel_7);
		
		String course[] = {"Bcs","Bibm"}; 
		JComboBox courses = new JComboBox(course);
		courses.setBounds(181, 124, 52, 22);
		contentPane.add(courses);
		
		String level[] = {"4","5","6"}; 
		JComboBox mlevels = new JComboBox(level);
		mlevels.setBounds(181, 220, 52, 22);
		contentPane.add(mlevels);
		
		msem = new JTextField();
		msem.setBounds(181, 277, 69, 20);
		contentPane.add(msem);
		msem.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = getConnection();
	        	    Statement st=con.createStatement(); 
					int signup = st.executeUpdate ("insert into Modules(Course,Codee,Namee,Levell,Sem) values('"+courses.getSelectedItem().toString()+"','"+mcode.getText()+"','"+mname.getText()+"','"+mlevels.getSelectedItem().toString()+"','"+msem.getText()+"')");
				} catch(Exception e1) {
					System.out.print("error");
					e1.printStackTrace();
				}
				Admin p= new Admin();
				p.show();
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(507, 357, 95, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin o = new Admin();
				o.show();
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(84, 357, 107, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("Course:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_8.setBounds(43, 121, 66, 22);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_10 = new JButton("Update");
		btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_10.setBounds(286, 357, 115, 23);
		contentPane.add(btnNewButton_10);
		
		JLabel lblNewLabel_4 = new JLabel("You can only update level and semester by using existing course and modulecode");
		lblNewLabel_4.setBounds(97, 418, 595, 14);
		contentPane.add(lblNewLabel_4);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = getConnection();
				
				Statement st;
				try {
					st = con.createStatement();
					st = con.createStatement();
					int si = st.executeUpdate ("update Modules set Levell = '"+mlevels.getSelectedItem().toString()+"', Sem='"+msem.getText()+"' where Codee = '"+mcode.getText()+"' and Course= '"+courses.getSelectedItem().toString()+"' ");
					mname.setText("");
					mcode.setText("");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				JOptionPane.showMessageDialog(contentPane, "Information Edited Sucesfully");
				
			}
		});
		
	}
}
