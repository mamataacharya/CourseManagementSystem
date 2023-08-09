package CourseM;

import javax.swing.*;

import javax.swing.border.EmptyBorder;


import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Admin extends JFrame {

	//private static final Frame Jframe = null;
	private JPanel contentPane;
	private JTable table;
	private JTextField iddel;
	private JTextField idss;
	private JTextField codee;
	private JTextField titlee;
	private JTextField tname;
	private JTextField tid;
	private JTextField sid;
	private JTextField modc;
	private Panel resullt;
	private JTextField sres;
	private JTextField sidd;
	private JTextField semm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1188, 699);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(187, 187, 187));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		//Jframe.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//Jframe.setUndecorated(true);
		//Jframe.setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		Panel panel = new Panel();
		panel.setBounds(261, 101, 888, 533);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(187, 187, 187));
		panel.add(panel_2, "name_77319125544102");
		panel_2.setLayout(null);
		
		
		Panel course = new Panel();
		course.setBackground(new Color(187, 187, 187));
		panel.add(course, "name_77319125544102");
		course.setLayout(null);
		
		JButton btnNewButton_20 = new JButton("Edit");
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course a = new Course();
				a.show();
				dispose();
				
			}
		});
		btnNewButton_20.setBounds(632, 254, 89, 23);
		course.add(btnNewButton_20);
		
		Panel student = new Panel();
		student.setBackground(new Color(255, 255, 255));
		panel.add(student, "name_77319125544102");
		student.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Student ID:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(39, 47, 88, 22);
		student.add(lblNewLabel_7);
		
		sidd = new JTextField();
		sidd.setBounds(137, 50, 96, 20);
		student.add(sidd);
		sidd.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Level:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(39, 94, 49, 22);
		student.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Semester:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(39, 141, 75, 22);
		student.add(lblNewLabel_12);
		
		semm = new JTextField();
		semm.setBounds(137, 144, 49, 20);
		student.add(semm);
		semm.setColumns(10);
		
		
		String level[] = {"4","5","6"}; 
		JComboBox levell = new JComboBox(level);
		levell.setBounds(137, 96, 43, 22);
		student.add(levell);
		
		JButton btnNewButton_15 = new JButton("Add");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = getConnection();
	    	    try {
					Statement st=con.createStatement();
					
					if((levell.getSelectedItem().toString()).equals("4")) {
						if(semm.getText().equals("1")) {
					        int i = st.executeUpdate ("insert into students (stu_id,sem,Levell,Module1, Module2, Module3) values('"+sidd.getText()+"','"+semm.getText()+"','"+levell.getSelectedItem().toString()+"','Fundamentals of Computing','Introductory Programming','Academics Skills and Team based learning')");
						}
						if(semm.getText().equals("2")) {
					        int i = st.executeUpdate ("insert into students (stu_id,sem,Levell,Module1, Module2, Module3) values('"+sidd.getText()+"','"+semm.getText()+"','"+levell.getSelectedItem().toString()+"','Internet Software Architecture','Computational Mathematics','Embedded System Programming')");
					    }
					}
					if((levell.getSelectedItem().toString()).equals("5")) {
						if(semm.getText().equals("3")) {
					        int i = st.executeUpdate ("insert into students (stu_id,sem,Levell,Module1, Module2, Module3) values('"+sidd.getText()+"','"+semm.getText()+"','"+levell.getSelectedItem().toString()+"','Concepts and Technologies of AI','Object oriented design and programming','Numerical methods and Concurrency')");
						}
						if(semm.getText().equals("4")) {
					        int i = st.executeUpdate ("insert into students (stu_id,sem,Levell,Module1, Module2, Module3) values('"+sidd.getText()+"','"+semm.getText()+"','"+levell.getSelectedItem().toString()+"','Human Computer Interaction','Cloud Computing','Collaborative Development')");
					    }
					}
					if((levell.getSelectedItem().toString()).equals("6")) {
						if(semm.getText().equals("5")) {
					        int i = st.executeUpdate ("insert into students (stu_id,sem,Levell,Module1, Module2) values('"+sidd.getText()+"','"+semm.getText()+"','"+levell.getSelectedItem().toString()+"','Big Data','High Performance Computing')");
						}
						if(semm.getText().equals("6")) {
					        int i = st.executeUpdate ("insert into students (stu_id,sem,Levell,Module1, Module2) values('"+sidd.getText()+"','"+semm.getText()+"','"+levell.getSelectedItem().toString()+"','Complex System','Project and Professionalism')");
					    }
					}
					
					sidd.setText(" ");
					semm.setText("");
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
			}
		});
		btnNewButton_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_15.setBounds(247, 205, 67, 23);
		student.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("Update");
		btnNewButton_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_16.setBounds(95, 205, 89, 23);
		student.add(btnNewButton_16);
		

			
		
		resullt = new Panel();
		resullt.setBackground(new Color(187, 187, 187));
		panel.add(resullt, "name_77319125544102");
		resullt.setLayout(null);
		
		sres = new JTextField();
		sres.setBounds(209, 112, 59, 20);
		resullt.add(sres);
		sres.setColumns(10);
		
		JButton btnNewButton_14 = new JButton("Search");
		btnNewButton_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 JScrollPane scrollPane3 = new JScrollPane();
				scrollPane3.setBounds(28, 150, 450, 150); //(40, 279, 420, 54);
				resullt.add(scrollPane3);
				//table = new JTable();
				try {
					
					Connection con = getConnection();
		    	    Statement st=con.createStatement(); 

				String query = "SELECT  result.Module_code,Modules.Namee, result.marks  FROM result JOIN Modules ON result.Module_code=Modules.Codee where result.stu_id = '"+sres.getText()+"' ";
				ResultSet rs = st.executeQuery(query);
				DefaultTableModel tableModel = new DefaultTableModel();
				table = new JTable(tableModel);
				 tableModel.addColumn("Module Code");
				 tableModel.addColumn("Module");
				 tableModel.addColumn("Marks");
				 
				
				 
				while (rs.next()) {
					tableModel.addRow(new Object[]{rs.getString(1),rs.getString(2), rs.getInt(3)});
				}}
					catch(Exception e1) {
						 e1.printStackTrace();
						}
				
						scrollPane3.setViewportView(table); 
				
				
			}
		});
		btnNewButton_14.setBounds(294, 109, 90, 23);
		resullt.add(btnNewButton_14);
		
		JLabel lblNewLabel_5 = new JLabel("View Result");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_5.setBounds(174, 11, 115, 30);
		resullt.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Enter student's id:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(38, 109, 157, 23);
		resullt.add(lblNewLabel_6);
		
		JButton btnNewButton_18 = new JButton("View");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                    try {
					
					Connection con = getConnection();
		    	    Statement st=con.createStatement(); 

				String query = "SELECT  marks  FROM result where stu_id = '"+sres.getText()+"' ";
				ResultSet rs = st.executeQuery(query);

				
				int fail=0;
				while (rs.next()) {
					
					if(rs.getInt(1) < 40) {
						fail = fail +1;
					}
				} if (fail > 0) {
					//System.out.println("fail");
					JOptionPane.showMessageDialog(contentPane, "Student id '"+sres.getText()+"' has failed " + fail+" subjects ");
					
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Student id '"+sres.getText()+"' has passed all subjects");
				}
				}
					catch(Exception e1) {
						 e1.printStackTrace();
						}
				
			}
		});
		btnNewButton_18.setBounds(559, 111, 89, 23);
		resullt.add(btnNewButton_18);
		
		JLabel lblNewLabel_10 = new JLabel("View status>>>");
		lblNewLabel_10.setBounds(440, 115, 115, 14);
		resullt.add(lblNewLabel_10);
		
		Panel elm= new Panel();
		elm.setBackground(new Color(187, 187, 187));
		panel.add(elm, "name_773191255442");
		elm.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Enter the code of mudule you want to delete:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(33, 42, 331, 27);
		elm.add(lblNewLabel_4);
		
		Panel panel_4 = new Panel();
		panel_4.setBackground(new Color(187, 187, 187));
		panel.add(panel_4, "name_77319125544100");
		panel_4.setLayout(null);
		
		
		modc = new JTextField();
		modc.setBounds(33, 80, 96, 27);
		elm.add(modc);
		modc.setColumns(10);
		
		JButton btnNewButton_13 = new JButton("Delete");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = getConnection();
	    	    try {
					Statement st=con.createStatement();
					String m= modc.getText();
					
					 String query = "delete from Modules where Codee ='"+m+"' ";
				      PreparedStatement preparedStmt = con.prepareStatement(query);
				  
				      preparedStmt.execute();
				      
				      JOptionPane.showMessageDialog(contentPane, "Module with code '"+m +"' deleted sucessfully!!");
				      
				      

				  					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
	    	    panel.removeAll();
				panel.add(panel_4);
				panel.repaint();
				panel.revalidate();
				
			
				
				
			}
		});
		btnNewButton_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_13.setBounds(33, 118, 89, 23);
		elm.add(btnNewButton_13);
		
		Panel panel_6 = new Panel();
		panel_6.setBackground(new Color(240, 240, 240));
		panel.add(panel_6, "name_77319125544102");
		panel_6.setLayout(null);
		
		Panel tutor = new Panel();
		tutor.setBackground(new Color(187, 187, 187));
		panel.add(tutor, "name_77319125544102");
		tutor.setLayout(null);
		
		JLabel asa = new JLabel("Module Code:");
		asa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		asa.setBounds(21, 25, 93, 29);
		tutor.add(asa);
		
		JLabel lblNewLabel = new JLabel("Module Title:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 80, 93, 29);
		tutor.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Tutors name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(356, 85, 93, 19);
		tutor.add(lblNewLabel_2);
		
		codee = new JTextField();
		codee.setBounds(18, 54, 96, 20);
		tutor.add(codee);
		codee.setColumns(10);
		
		titlee = new JTextField();
		titlee.setBounds(18, 120, 96, 20);
		tutor.add(titlee);
		titlee.setColumns(10);
		
		tname = new JTextField();
		tname.setBounds(366, 111, 142, 20);
		tutor.add(tname);
		tname.setColumns(10);
		
		
		JButton btnNewButton_10 = new JButton("Add>>");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = getConnection();
	        	    Statement st=con.createStatement(); 
					int signup = st.executeUpdate ("insert into tutors(ModuleCode,ModuleName,Tutor_ID,Tutor) values('"+codee.getText()+"','"+titlee.getText()+"','"+tid.getText()+"','"+tname.getText()+"')");
					codee.setText("");
					titlee.setText("");
					tname.setText("");
					tid.setText("");
				} catch(Exception e1) {
					System.out.print("error");
					e1.printStackTrace();
				}
				panel.removeAll();
				panel.add(tutor);
				panel.repaint();
				panel.revalidate();
					
			}
		});
		btnNewButton_10.setBounds(21, 158, 74, 23);
		tutor.add(btnNewButton_10);
		
		JLabel lblNewLabel_3 = new JLabel("Tutors ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(366, 25, 83, 29);
		tutor.add(lblNewLabel_3);
		
		tid = new JTextField();
		tid.setBounds(366, 54, 96, 20);
		tutor.add(tid);
		tid.setColumns(10);
		
		sid = new JTextField();
		sid.setBounds(21, 203, 96, 20);
		tutor.add(sid);
		sid.setColumns(10);
		
		JButton btnNewButton_12 = new JButton("Search");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JScrollPane scrollPane3 = new JScrollPane();
				scrollPane3.setBounds(28, 251, 436, 86); //(40, 279, 420, 54);
				tutor.add(scrollPane3);
				//table = new JTable();
				try {
					
					Connection con = getConnection();
		    	    Statement st=con.createStatement(); 

				String query = "SELECT ModuleCode, ModuleName FROM tutors where Tutor_ID = '"+sid.getText()+"' ";
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
				sid.setText("");
				
						scrollPane3.setViewportView(table);
				
			}
		});
		btnNewButton_12.setBounds(127, 202, 89, 23);
		tutor.add(btnNewButton_12);
		
		
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(168, 99, 553, 134);
		course.add(scrollPane3);
		//table = new JTable();
		try {
			
			Connection con = getConnection();
    	    Statement st=con.createStatement(); 

		String query = "SELECT * FROM course";
		ResultSet rs = st.executeQuery(query);
		DefaultTableModel tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		 tableModel.addColumn("Code");
		 tableModel.addColumn("Name");
		 tableModel.addColumn("Modules");
		 tableModel.addColumn("Years");
		
		while (rs.next()) {
			tableModel.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
		}}
			catch(Exception e1) {
				 e1.printStackTrace();
				}
		
				scrollPane3.setViewportView(table);
		
		

		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(29, 50, 855, 346);
		panel_4.add(scrollPane1);
		table = new JTable();
		try {
			
			Connection con = getConnection();
    	    Statement st=con.createStatement(); 

		String query = "SELECT Course,Codee,Namee,Levell FROM Modules";
		ResultSet rs = st.executeQuery(query);
		DefaultTableModel tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		tableModel.addColumn("Course");
		 tableModel.addColumn("Code");
		 tableModel.addColumn("Name");
		 tableModel.addColumn("Level");
		
		while (rs.next()) {
			tableModel.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)});
		}}
			catch(Exception e1) {
				 e1.printStackTrace();
				}
				scrollPane1.setViewportView(table);
				
				JButton btnNewButton_2 = new JButton("Add/Update");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Modules a = new Modules();
						a.show();
						dispose();
					}
				});
				btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnNewButton_2.setBounds(34, 443, 135, 25);
				panel_4.add(btnNewButton_2);
				
				JButton btnNewButton_9 = new JButton("Delete");
				btnNewButton_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel.removeAll();
						panel.add(elm);
						panel.repaint();
						panel.revalidate();
						
					}
				});
				btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnNewButton_9.setBounds(328, 444, 89, 23);
				panel_4.add(btnNewButton_9);
				
				JButton btnNewButton_11 = new JButton("Tutors");
				btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnNewButton_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel.removeAll();
						panel.add(tutor);
						panel.repaint();
						panel.revalidate();
						
						
					}
				});
				btnNewButton_11.setBounds(199, 444, 89, 23);
				panel_4.add(btnNewButton_11);
			
			
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(26, 130, 203, 410);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Users");
		btnNewButton.setBackground(new Color(187, 187, 187));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.removeAll();
				panel.add(panel_2);
				panel.repaint();
				panel.revalidate();
			}
		});
		btnNewButton.setBounds(43, 23, 114, 38);
		panel_1.add(btnNewButton);
		
		JButton btnConatctUs = new JButton("Modules");
		btnConatctUs.setForeground(new Color(0, 0, 0));
		btnConatctUs.setBackground(new Color(187, 187, 187));
		btnConatctUs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConatctUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(panel_4);
				panel.repaint();
				panel.revalidate();
			}
		});
		btnConatctUs.setBounds(43, 89, 114, 38);
		panel_1.add(btnConatctUs);
		
		JButton btnNewButton_1 = new JButton("<<Logout");
		btnNewButton_1.setBackground(new Color(187, 187, 187));
		btnNewButton_1.setBounds(43, 343, 114, 32);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Login a = new Login();
			a.show();
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton_6 = new JButton("Result");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(resullt);
				panel.repaint();
				panel.revalidate();	
				
				
			}
		});
		btnNewButton_6.setBackground(new Color(187, 187, 187));
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_6.setBounds(43, 280, 114, 38);
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_4 = new JButton("Students");
		btnNewButton_4.setBackground(new Color(187, 187, 187));
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.removeAll();
				panel.add(student);
				panel.repaint();
				panel.revalidate();
				
				
				
				
				
			}
		});
		btnNewButton_4.setBounds(43, 216, 114, 38);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_19 = new JButton("Course");
		btnNewButton_19.setBackground(new Color(192, 192, 192));
		btnNewButton_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.removeAll();
				panel.add(course);
				panel.repaint();
				panel.revalidate();
			}
		});
		btnNewButton_19.setBounds(43, 152, 114, 38);
		panel_1.add(btnNewButton_19);
		
		
		JLabel lblNewLabel_8 = new JLabel("<<Dashboard>>");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(660, 11, 140, 32);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Welcome to the home page of Admin Panel");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(592, 41, 280, 43);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton_3 = new JButton("Add/Update");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(240,240,240));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users a = new Users();
				a.show();
				dispose();
			}
		});
		btnNewButton_3.setBounds(195, 489, 135, 33);
		panel_2.add(btnNewButton_3);
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(32, 26, 827, 417);
		panel_2.add(panel_7);
		panel_7.setLayout(new CardLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_7.add(panel_8, "name_635235343536600");
		panel_8.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 24, 793, 297);
		panel_8.add(scrollPane);
		table = new JTable();
		try {
			
			Connection con = getConnection();
    	    Statement st=con.createStatement(); 

		String query = "SELECT id,first_name,last_name,roles_ FROM Usersinfo";
		ResultSet rs = st.executeQuery(query);
		DefaultTableModel tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		 tableModel.addColumn("Id");
		 tableModel.addColumn("Firstname");
		 tableModel.addColumn("Lastname");
		 tableModel.addColumn("Role");
		while (rs.next()) {
			tableModel.addRow(new Object[]{rs.getString("id"), rs.getString("first_name"),rs.getString("last_name"),rs.getString("roles_")});
		}}
			catch(Exception e1) {
				 e1.printStackTrace();
				}

		
		
				scrollPane.setViewportView(table);
				
				idss = new JTextField();
				idss.setBounds(29, 367, 73, 20);
				panel_8.add(idss);
				idss.setColumns(10);
				
				JButton btnNewButton_5 = new JButton("Search>");
				btnNewButton_5.setBackground(new Color(192, 192, 192));
				btnNewButton_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel.removeAll();
						panel.add(panel_6);
						panel.repaint();
						panel.revalidate();
						
						JScrollPane scrollPane2 = new JScrollPane();
						scrollPane2.setBounds(20, 50, 850, 75);
						panel_6.add(scrollPane2);
						table = new JTable();
						try {
							
							Connection con = getConnection();
				    	    Statement st=con.createStatement(); 
				    	    
				    	    String id = idss.getText();

						String query = "SELECT id, first_name, last_name, phone_no, email, username, password_, roles_ FROM Usersinfo where id = '"+idss.getText()+"' ";
						ResultSet rs = st.executeQuery(query);
						DefaultTableModel tableModel = new DefaultTableModel();
						table = new JTable(tableModel);
						 tableModel.addColumn("ID");
						 tableModel.addColumn("FirstName");
						 tableModel.addColumn("LastName");
						 tableModel.addColumn("Phone.no");
						 tableModel.addColumn("email");
						 tableModel.addColumn("username");
						 tableModel.addColumn("password");
						 tableModel.addColumn("role");
						 
						
						while (rs.next()) {
							tableModel.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8)});
						idss.setText("");
						}}
							catch(Exception e1) {
								 e1.printStackTrace();
								}
						
						
								scrollPane2.setViewportView(table);
								

					}
				});
				btnNewButton_5.setBounds(133, 366, 89, 23);
				panel_8.add(btnNewButton_5);
		
		
		JPanel panel_10 = new JPanel();
		panel_7.add(panel_10, "name_635235343536600");
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the id user you want to delete");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 23, 343, 25);
		panel_10.add(lblNewLabel_1);
		
		iddel = new JTextField();
		iddel.setBounds(28, 63, 138, 32);
		panel_10.add(iddel);
		iddel.setColumns(10);
		
		JButton btnNewButton_8 = new JButton("Delete");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con = getConnection();
	    	    try {
					Statement st=con.createStatement();
					String delid= iddel.getText();
					
					 String query = "delete from Usersinfo where id ='"+delid+"' ";
				      PreparedStatement preparedStmt = con.prepareStatement(query);
				  
				      preparedStmt.execute();
				      
				      JOptionPane.showMessageDialog(contentPane, "User with id '"+delid +"' deleted sucessfully!!");
				      
				      
				        Admin a = new Admin();
				        a.show();
				        dispose();
				      
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				
				
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_8.setBounds(28, 119, 89, 23);
		panel_10.add(btnNewButton_8);
		
		JButton btnNewButton_7 = new JButton("Delete Users");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						panel.removeAll();
						panel.add(panel_10);
						panel.repaint();
						panel.revalidate();
						
					}
			
		});
		btnNewButton_7.setBackground(new Color(240,240,240));
		btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_7.setBounds(582, 489, 125, 33);
		panel_2.add(btnNewButton_7);
		
		JButton btnNewButton_17 = new JButton("↻");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin a = new Admin();
				a.show();
				dispose();
				
			}
		});
		btnNewButton_17.setBounds(1093, 41, 48, 23);
		contentPane.add(btnNewButton_17);
			
		
	}
}