package CourseM;

import java.awt.EventQueue;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Panel;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Teachers extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField mcode;
	private JTextField st_id;
	private JTextField marks;
	private static int id1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teachers frame = new Teachers(id1);
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
	
	public Teachers(int id1) {
		this.id1 = id1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 964, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(187, 187, 187));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(272, 121, 638, 349);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(187, 187, 187));
		panel.add(panel_2, "name_77319125544100");
		panel_2.setLayout(null);
		
		Panel panel_6 = new Panel();
		panel_6.setBackground(new Color(187, 187, 187));
		panel.add(panel_6, "name_77319125544100");
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("View your courses");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(241, 34, 169, 27);
		panel_2.add(lblNewLabel_6);
		
		Panel panel_5 = new Panel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel.add(panel_5, "name_77319125544100");
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Enter module code:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(90, 60, 132, 24);
		panel_5.add(lblNewLabel_3);
		
		mcode = new JTextField();
		mcode.setBounds(263, 64, 96, 20);
		panel_5.add(mcode);
		mcode.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Enter student's id:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(90, 104, 132, 24);
		panel_5.add(lblNewLabel_4);
		
		st_id = new JTextField();
		st_id.setBounds(263, 108, 96, 20);
		panel_5.add(st_id);
		st_id.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Enter marks:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(90, 152, 86, 24);
		panel_5.add(lblNewLabel_5);
		
		marks = new JTextField();
		marks.setBounds(263, 156, 96, 20);
		panel_5.add(marks);
		marks.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = getConnection();
		    	    Statement st=con.createStatement();
		    	    
		    	    int signup = st.executeUpdate ("insert into result (Stu_id, teacher_id,Module_code,marks) values('"+st_id.getText()+"','"+id1+"','"+mcode.getText()+"','"+marks.getText()+"')");
		    	    
		    	    JOptionPane.showMessageDialog(contentPane, "Marks added Sucesfully");
		    	    
				}catch(Exception a) {
				}
				st_id.setText("");
				mcode.setText("");
				marks.setText("");
			}
		});
		btnNewButton_4.setBounds(270, 210, 89, 23);
		panel_5.add(btnNewButton_4);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(SystemColor.textHighlightText);
		panel_3.setBounds(75, 124, 10, 10);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("View Students");
		lblNewLabel_1.setBounds(204, 57, 61, 29);
		panel_3.add(lblNewLabel_1);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(SystemColor.textHighlightText);
		panel_1.setBounds(37, 186, 140, 232);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(29, 92, 500, 90);
		panel_2.add(scrollPane3);
		//table = new JTable();
		try {
			
			Connection con = getConnection();
    	    Statement st=con.createStatement(); 

		String query = "SELECT ModuleCode, ModuleName FROM tutors where Tutor_ID = '"+id1+"' ";
		ResultSet rs = st.executeQuery(query);
		DefaultTableModel tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		 tableModel.addColumn("Module Code");
		 tableModel.addColumn("Module Name");
		
		while (rs.next()) {
			tableModel.addRow(new Object[]{rs.getString(1), rs.getString(2)});
		}}
			catch(Exception e1) {
				 e1.printStackTrace();
			}
		
				scrollPane3.setViewportView(table);
	
		
		
		JButton btnNewButton = new JButton("Courses");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.removeAll();
				panel.add(panel_2);
				panel.repaint();
				panel.revalidate();
				
			}
		});
		btnNewButton.setBounds(10, 25, 114, 32);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Add Marks");
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(panel_5);
				panel.repaint();
				panel.revalidate();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(10, 129, 114, 32);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("<<Logout");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(10, 172, 114, 32);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Login a = new Login();
			a.show();
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_3 = new JButton("Students");
		btnNewButton_3.setBackground(new Color(187, 187, 187));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(panel_6);
				panel.repaint();
				panel.revalidate();
				
				
				try {
					Connection con = getConnection();
	        	    Statement st=con.createStatement(); 
					
	        	    String queryy= "SELECT  stu_id, usersinfo.first_name,usersinfo.last_name,students.Levell,tutors.ModuleName FROM tutors JOIN students ON (students.Module1= tutors.ModuleName OR students.Module2= tutors.ModuleName OR students.Module3= tutors.ModuleName ) join usersinfo on (students.stu_id = usersinfo.id)where Tutor_ID ='"+id1+"'";
	        	    ResultSet rss = st.executeQuery(queryy);
	        	    JScrollPane sscrollPane = new JScrollPane();
			        sscrollPane.setBounds(10, 60, 500, 200);
		           	panel_6.add(sscrollPane);
			        table = new JTable();
			        DefaultTableModel tableModell = new DefaultTableModel();
			        table = new JTable(tableModell);
			        tableModell.addColumn("Student ID");
			        tableModell.addColumn("First name");
			        tableModell.addColumn("Last name");
			        tableModell.addColumn("Levell");
			        tableModell.addColumn("Module");
			       // tableModel1.addColumn("Module3");
	        	    while(rss.next()) {
	        	    	
	        	    	tableModell.addRow(new Object[]{rss.getString(1), rss.getString(2), rss.getString(3), rss.getString(4),rss.getString(5)});
					}
					sscrollPane.setViewportView(table);
        	    
    		
			}catch(Exception a) {
			}
				
				
				
			}
		});
		btnNewButton_3.setBounds(10, 78, 114, 32);
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_8 = new JLabel("<<Dashboard>>");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(418, 11, 122, 32);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Welcome to the home page of Teacher Panel");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(355, 50, 280, 43);
		contentPane.add(lblNewLabel_9);
	}
}