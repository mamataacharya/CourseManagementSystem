package CourseM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Course extends JFrame {

	private JPanel contentPane;
	private JTextField ccode;
	private JTextField cname;
	private JTextField year;
	private JTextField modules;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course frame = new Course();
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
	
	public static Connection getConnection() {
		connection c = new connection();
		Connection con = c.connection();
		return con;
	}
	
	public Course() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ccode = new JTextField();
		ccode.setBounds(223, 80, 96, 20);
		contentPane.add(ccode);
		ccode.setColumns(10);
		
		cname = new JTextField();
		cname.setBounds(223, 127, 96, 20);
		contentPane.add(cname);
		cname.setColumns(10);
		
		year = new JTextField();
		year.setBounds(223, 235, 96, 20);
		contentPane.add(year);
		year.setColumns(10);
		
		modules = new JTextField();
		modules.setBounds(223, 189, 96, 20);
		contentPane.add(modules);
		modules.setColumns(10);
		
		JLabel cou = new JLabel("Course code:");
		cou.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cou.setBounds(62, 83, 114, 14);
		contentPane.add(cou);
		
		JLabel lblNewLabel = new JLabel("Course name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(62, 130, 101, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number of Modules:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(62, 190, 149, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("years");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(62, 241, 49, 20);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = getConnection();
        	    try {
					Statement st=con.createStatement();
					int signup = st.executeUpdate ("insert into course (CourseID, CourseName,Modules,years) values('"+ccode.getText()+"','"+cname.getText()+"','"+modules.getText()+"','"+year.getText()+"')");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
        	    Admin a= new Admin();
        	    a.show();
        	    dispose();
				
				
			}
		});
		btnNewButton.setBounds(344, 284, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = getConnection();
        	    try {
					Statement st=con.createStatement();
					
					int si = st.executeUpdate ("update course set Modules = '"+modules.getText().toString()+"', years ='"+year.getText()+"' where CourseID = '"+ccode.getText()+"' ");
					
        	    }catch(Exception e1) {
        	    	
        	    }
        	    Admin x = new Admin();
        	    x.show();
        	    dispose();
			}
		});
		btnNewButton_1.setBounds(223, 284, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.setBounds(62, 284, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = getConnection();
        	    try {
					Statement st=con.createStatement();
					int s = st.executeUpdate("DELETE FROM course where CourseID = '"+ccode.getText()+"'");
        	    }catch(Exception a) {
        	    	
        	    }
        	    Admin s = new Admin();
        	    s.show();
        	    dispose();
				
			}
		});
		btnNewButton_3.setBounds(344, 83, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
