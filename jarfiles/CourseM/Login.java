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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Login extends JFrame{

	private JPanel contentPane;
	private JTextField unameL;
	private JPasswordField pwl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 680, 367);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Username: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(108, 54, 110, 26);
		contentPane.add(lblNewLabel_2);
		
		unameL = new JTextField();
		unameL.setBounds(260, 55, 196, 31);
		contentPane.add(unameL);
		unameL.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(108, 106, 92, 26);
		contentPane.add(lblNewLabel_3);
		
		
		String role[] = {"Student","Teacher","Admin"}; 
		JComboBox rolesL = new JComboBox(role);
		rolesL.setBounds(260, 167, 92, 26);
		contentPane.add(rolesL);
		
		JLabel lblNewLabel_4 = new JLabel("Select your role:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(108, 162, 144, 31);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Login>>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = getConnection();
	        	    Statement st=con.createStatement(); 
				
					
					String query = "SELECT * FROM Usersinfo";
					ResultSet rs = st.executeQuery(query);
					int count =0;
					while(rs.next()) {
						String unameeS = rs.getString(6);
						String passS = rs.getString(7);
						String roleS = rs.getString(8);
						
						//System.out.println(unameeS+" "+passS+" "+roleS);
						
						String unameeL = unameL.getText();
						String passL = String.valueOf(pwl.getPassword()); 
						String roleL = rolesL.getSelectedItem().toString();
						
						//System.out.println(unameeL+" "+ passL+ " "+roleL);
						
						//if((unameL.getText() == rs.getString(6))&&(pwl.getText() == rs.getString(7))&&(rolesL.getSelectedItem()==rs.getString(8))) {
						if(unameeS.equals(unameeL) && passS.equals(passL) && roleS.equals(roleL)) {
							count =1;
							
							if(roleL.equals("Admin")) {
								Admin a = new Admin();
								a.show();
								dispose();
							}
							else if(roleL.equals("Student")) {
								int id1 = 0;
							    Statement st1=con.createStatement();
								String selectQuery = "SELECT * from Usersinfo WHERE username = '"+unameeL+"'";
								ResultSet rs1 = st1.executeQuery(selectQuery);
								while(rs1.next()) {
									 id1 = rs1.getInt("id");
								}
								Students x = new Students(id1);
								x.show();
								dispose();
							}
							else if(roleL.equals("Teacher")) {
								int id1 = 0;
							    Statement st1=con.createStatement();
								String selectQuery = "SELECT * from Usersinfo WHERE username = '"+unameeL+"'";
								ResultSet rs1 = st1.executeQuery(selectQuery);
								while(rs1.next()) {
									 id1 = rs1.getInt("id");
								}
								Teachers t = new Teachers(id1);
								t.show();
								dispose();
							}
						} }
					if (count ==0) {
						JOptionPane.showMessageDialog(contentPane, "Please enter valid information");
						
					}
				
				}catch(Exception e1) {
					System.out.print("error");
					e1.printStackTrace();
			       }
				}
			});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(260, 220, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("If you do not have an account, please contact your college ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(108, 265, 450, 23);
		contentPane.add(lblNewLabel_5);
		
		pwl = new JPasswordField();
		pwl.setBounds(260, 107, 196, 31);
		contentPane.add(pwl);
		
		
	}
}
