package CourseM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;

public class Users extends JFrame {

	private JPanel AddUsers;
	private JTextField fname;
	private JTextField lname;
	private JTextField phoneno;
	private JTextField usernamee;
	private JPasswordField passw;
	private JTextField email;
	private JComboBox role; 
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Users frame = new Users();
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
	public Users() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 513);
		AddUsers = new JPanel();
		AddUsers.setBackground(SystemColor.controlShadow);
		AddUsers.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(AddUsers);
		AddUsers.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Users");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(359, 11, 102, 34);
		AddUsers.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter the following informations correctly to add users of this system");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(153, 56, 508, 34);
		AddUsers.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(61, 119, 82, 26);
		AddUsers.add(lblNewLabel_2);
		
		fname = new JTextField();
		fname.setBounds(153, 117, 117, 34);
		AddUsers.add(fname);
		fname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(61, 177, 82, 26);
		AddUsers.add(lblNewLabel_3);
		
		lname = new JTextField();
		lname.setBounds(153, 175, 117, 34);
		AddUsers.add(lname);
		lname.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone no:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(61, 223, 82, 26);
		AddUsers.add(lblNewLabel_4);
		
		phoneno = new JTextField();
		phoneno.setBounds(153, 221, 156, 34);
		AddUsers.add(phoneno);
		phoneno.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Username:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(441, 181, 102, 18);
		AddUsers.add(lblNewLabel_5);
		
		usernamee = new JTextField();
		usernamee.setBounds(536, 175, 136, 27);
		AddUsers.add(usernamee);
		usernamee.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Password:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(441, 227, 88, 18);
		AddUsers.add(lblNewLabel_6);
		
		passw = new JPasswordField();
		passw.setBounds(536, 225, 133, 27);
		AddUsers.add(passw);
		
		JLabel lblNewLabel_7 = new JLabel("Email id:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(441, 119, 71, 26);
		AddUsers.add(lblNewLabel_7);
		
		email = new JTextField();
		email.setBounds(536, 118, 261, 32);
		AddUsers.add(email);
		email.setColumns(10);
		
		String role[] = {"Student","Teacher"}; 
		JComboBox rolesS = new JComboBox(role);
		rolesS.setBounds(153, 284, 102, 22);
		AddUsers.add(rolesS);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				        
					Connection con = getConnection();
	        	    Statement st=con.createStatement(); 
		
				        
					int signup = st.executeUpdate ("insert into Usersinfo(first_name,last_name,phone_no,email,username,password_,roles_) values('"+fname.getText()+"','"+lname.getText()+"','"+phoneno.getText()+"','"+email.getText()+"','"+usernamee.getText()+"','"+String.valueOf(passw.getPassword())+"','"+rolesS.getSelectedItem().toString()+"')");
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
		btnNewButton.setBounds(548, 362, 111, 23);
		AddUsers.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("Select role:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(61, 282, 82, 23);
		AddUsers.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("<<Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin s= new Admin();
				s.show();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(112, 363, 111, 23);
		AddUsers.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                 Connection con = getConnection();
				
				Statement st;
				try {
					st = con.createStatement();
					st = con.createStatement();
					int si = st.executeUpdate ("update Usersinfo set Phone_no = '"+phoneno.getText()+"',email = '"+email.getText()+"'where username = '"+usernamee.getText()+"'");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				JOptionPane.showMessageDialog(AddUsers, "Information Edited Sucesfully");
				

				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(340, 362, 89, 23);
		AddUsers.add(btnNewButton_2);
		
		JLabel lblNewLabel_9 = new JLabel("You can only update phone number and email of any user by using their correct username");
		lblNewLabel_9.setBounds(112, 424, 549, 14);
		AddUsers.add(lblNewLabel_9);
		
	}
}
