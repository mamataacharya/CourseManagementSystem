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
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Students extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static int id1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Students frame = new Students(id1);
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
	public Students(int id1) {
		this.id1 = id1;
		//System.out.print(id1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1206, 695);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(272, 121, 845, 459);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		Panel panel_4 = new Panel();
		panel_4.setLayout(null);
		panel.add(panel_4, "name_1505192590938300");
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\CourseManagementSystem\\herald-college.png"));
		lblNewLabel_10.setBounds(238, 117, 311, 149);
		panel_4.add(lblNewLabel_10);
		
		Panel panel_6 = new Panel();
		panel_6.setBackground(SystemColor.window);
		panel.add(panel_6, "name_77319125544100");
		panel_6.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("Instructors:");
		btnNewButton_5.setBackground(new Color(192, 192, 192));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JScrollPane sscrollPane = new JScrollPane();
				sscrollPane.setBounds(44, 160, 600, 100);
				panel_6.add(sscrollPane);
				table = new JTable();
				
				try {
					Connection con = getConnection();
	        	    Statement st=con.createStatement(); 
					
					String queryy = "SELECT  tutors.Tutor_ID, tutors.Tutor, tutors.ModuleName FROM tutors JOIN students ON (students.Module1= tutors.ModuleName OR students.Module2= tutors.ModuleName OR students.Module3= tutors.ModuleName ) where stu_id = '"+id1+"'";
	        	    ResultSet rss = st.executeQuery(queryy);
	        	   // JScrollPane sscrollPane = new JScrollPane();
			        //sscrollPane.setBounds(44, 120, 381, 70);
		           	//panel_6.add(sscrollPane);
			        
			        DefaultTableModel tableModell = new DefaultTableModel();
			        table = new JTable(tableModell);
			        tableModell.addColumn("TutorID");
			        tableModell.addColumn("Tutor");
			        tableModell.addColumn("Module");
			       // tableModel1.addColumn("Module3");
	        	    while(rss.next()) {
	        	    	
	        	    	tableModell.addRow(new Object[]{rss.getString(1), rss.getString(2), rss.getString(3)});
					}
					sscrollPane.setViewportView(table);
        	    
    		
			}catch(Exception a) {
			}
				
				
					
				
			}
		});
		btnNewButton_5.setBounds(51, 96, 105, 23);
		panel_6.add(btnNewButton_5);
		
		Panel panel_5 = new Panel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel.add(panel_5, "name_1505137079568800");
		
		JButton btnNewButton_6 = new JButton("View");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
try {
					
					Connection con = getConnection();
		    	    Statement st=con.createStatement(); 

				String query = "SELECT  marks  FROM result where stu_id = '"+id1+"' ";
				ResultSet rs = st.executeQuery(query);

				
				int fail=0;
				while (rs.next()) {
					
					if(rs.getInt(1) < 40) {
						fail = fail +1;
					}
				} if (fail > 0) {
					//System.out.println("fail");
					JOptionPane.showMessageDialog(contentPane, "You have failed " + fail+" subjects ");
					
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "You have passed all subjects");
				}
				}
					catch(Exception e1) {
						 e1.printStackTrace();
						}
				
				
			}
		});
		btnNewButton_6.setBounds(319, 261, 89, 23);
		panel_5.add(btnNewButton_6);
		
		JLabel lblNewLabel_4 = new JLabel("View Status>>>");
		lblNewLabel_4.setBounds(174, 265, 112, 14);
		panel_5.add(lblNewLabel_4);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(SystemColor.textHighlightText);
		panel_3.setBounds(75, 124, 10, 10);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Contact Us");
		lblNewLabel_1.setBounds(148, 11, 115, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact us using the our following informations");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(26, 57, 328, 19);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(26, 107, 63, 19);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_11 = new JLabel("info@heraldcollege.edu.np");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(80, 109, 208, 15);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_5 = new JLabel("Phone. no:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(26, 154, 76, 19);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_12 = new JLabel("01-5970120");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(112, 156, 89, 15);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("9801022637");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_13.setBounds(112, 182, 96, 14);
		panel_3.add(lblNewLabel_13);
		
		JLabel lblNewLabel_3 = new JLabel("Address:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(26, 228, 76, 19);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_6 = new JLabel("Naxal, Kathmandu");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(112, 224, 176, 27);
		panel_3.add(lblNewLabel_6);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(SystemColor.textHighlightText);
		panel_1.setBounds(36, 201, 140, 288);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnConatctUs = new JButton("Conatct us");
		btnConatctUs.setBackground(new Color(192, 192, 192));
		btnConatctUs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConatctUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(panel_3);
				panel.repaint();
				panel.revalidate();
			}
		});
		btnConatctUs.setBounds(10, 136, 114, 32);
		panel_1.add(btnConatctUs);
		
		JButton btnAboutUs = new JButton("About us");
		btnAboutUs.setBackground(new Color(192, 192, 192));
		btnAboutUs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(panel_4);
				panel.repaint();
				panel.revalidate();
			}
		});
		btnAboutUs.setBounds(10, 190, 114, 32);
		panel_1.add(btnAboutUs);
		
		JButton btnNewButton_2 = new JButton("Result");
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.add(panel_5);
				panel.repaint();
				panel.revalidate();
				
				
				try {
					Connection con = getConnection();
	        	    Statement st=con.createStatement(); 
				
					
					
					String queryy = "SELECT  result.Module_code,Modules.Namee, result.marks  FROM result JOIN Modules ON result.Module_code=Modules.Codee where result.stu_id= '"+id1+"' ";
					ResultSet rss = st.executeQuery(queryy);
					        JScrollPane scrollPane = new JScrollPane();
					        scrollPane.setBounds(44, 50, 450, 150);
				           	panel_5.add(scrollPane);
					        table = new JTable();
					        DefaultTableModel tableModel = new DefaultTableModel();
					        table = new JTable(tableModel);
					        tableModel.addColumn("Module Code");
					        tableModel.addColumn("Module");
					        tableModel.addColumn("Marks"); 
					
					while (rss.next()) {
						tableModel.addRow(new Object[]{rss.getString(1), rss.getString(2),rss.getString(3)});
					}	
					scrollPane.setViewportView(table);
					
			} catch(Exception a){
				
			}
				
			
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(10, 86, 114, 32);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("<<Logout");
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(10, 245, 114, 32);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Login a = new Login();
			a.show();
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		
		
		
		JButton btnNewButton = new JButton("Modules");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.removeAll();
				panel.add(panel_6);
				panel.repaint();
				panel.revalidate();
				
				try {
					Connection con = getConnection();
	        	    Statement st=con.createStatement();
	        	    
	        	    String query = "SELECT Module1, Module2, Module3 from students where stu_id = '"+id1+"'";
	        	    ResultSet rs = st.executeQuery(query);
	        	    JScrollPane scrollPane = new JScrollPane();
			        scrollPane.setBounds(44, 30, 600, 50);
		           	panel_6.add(scrollPane);
			        table = new JTable();
			        DefaultTableModel tableModel = new DefaultTableModel();
			        table = new JTable(tableModel);
			        tableModel.addColumn("Module1");
			        tableModel.addColumn("Module2");
			        tableModel.addColumn("Module3");
	        	    while(rs.next()) {
	        	    	
	        	    	tableModel.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3)});
					}
					scrollPane.setViewportView(table);    
	    		
				}catch(Exception a) {
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 27, 114, 32);
		panel_1.add(btnNewButton);
		
		
		try {
			Connection con = getConnection();
    	    Statement st=con.createStatement();
    	    String l = null;
    	    String query = "SELECT * from students where stu_id = '"+id1+"'";
    	    ResultSet rs = st.executeQuery(query);
    	    while(rs.next()) {
				 l = rs.getString("Levell");
				 }
    	    
			if(l.equals ("6")) {
    	    
		    JPanel panel_2 = new JPanel();
			panel_2.setBounds(44, 300 , 600, 50);
			panel_6.add(panel_2);
			
			String course[] = {"Deep Learning","Machine Learning"}; 
		    panel_2.setLayout(null);
		    JComboBox cL = new JComboBox(course);
		    cL.setBounds(214, 11, 90, 20);
		    panel_2.add(cL);
		    
		    
		    JLabel lblNewLabel = new JLabel("Choose your optional module:");
		    lblNewLabel.setBounds(10, 14, 195, 14);
		    panel_2.add(lblNewLabel);
		    
		    JButton btnNewButton_3 = new JButton("save");
		    btnNewButton_3.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		
		 
		    		Connection con = getConnection();
	        	    
						try {
							int si = st.executeUpdate ("update students set Module3 = '"+cL.getSelectedItem().toString()+"' where stu_id = '"+id1+"' ");
							JOptionPane.showMessageDialog(contentPane, "Optional Module update");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    		
		    	}
		    });
		    btnNewButton_3.setBounds(350, 10, 68, 23);
		    panel_2.add(btnNewButton_3);
		    
				}}
		catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 

		
		JLabel lblNewLabel_8 = new JLabel("<<Dashboard>>");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(418, 11, 122, 32);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Welcome to the home page of Student Panel");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(355, 50, 280, 43);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton_4 = new JButton("↻");
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Students r= new Students(id1);
				r.show();
				dispose();
			}
		});
		btnNewButton_4.setBounds(1047, 32, 59, 32);
		contentPane.add(btnNewButton_4);
	}
}