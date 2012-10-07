import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame{
	private JLabel JLb1;
	private JLabel JLb2;
	private JButton Ok_btn;
	private JButton Cancel_btn;
	private JTextField jtflduser;
	private JPasswordField jtpwdfld;
	//Field Declaration
	private JFrame frame;
	//Constructor
	public Login(){
		
		frame = new JFrame("Login");
		Container content = frame.getContentPane();
		//Content Pane Layout
		content.setLayout(new GridLayout(3, 2, 20, 20));
		JLb1 = new JLabel("Username");
		JLb2 = new JLabel("Password");
		//Label Layout
		JLb1.setHorizontalAlignment(SwingConstants.CENTER);
		JLb2.setHorizontalAlignment(SwingConstants.CENTER);
		jtflduser = new JTextField();
		jtpwdfld = new JPasswordField();
		//Button Declaration
		Ok_btn = new JButton("OK");
		Cancel_btn = new JButton("Cancel");
		//Add Action Listener for Button
		Ok_btn.addActionListener(new ActionHandler());
		Cancel_btn.addActionListener(new ActionHandler());
		//Add Controls to Content Pane
		content.add(JLb1);
		content.add(jtflduser);
		content.add(JLb2);
		content.add(jtpwdfld);
		content.add(Ok_btn);
		content.add(Cancel_btn);
		frame.pack();
		//Set Login Panel at the Center of the Screen
		frame.setLocationRelativeTo(null);
		frame.setSize(300, 150);
		frame.setVisible(true);
	}
	//Process Action Listener Class: ActionHandler
	class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String str1,str2,sqlStr;
			Object obj = e.getSource();
			//Get Username & Password from *Field
			str1 = jtflduser.getText().trim();
			str2 = new String(jtpwdfld.getPassword()).trim();
			
			java.sql.Connection conn = null;
			
			try{
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://210.30.108.66:3306/booksystem";
				
				//get a connection to the database for a user named booksystem
				conn = DriverManager.getConnection(url, "booksystem", "booksystem");
					
				if(obj.equals(Ok_btn)){
					if(str1.equals("")){
						JOptionPane.showMessageDialog(frame, "Username cannot be Empty!");
					}

					//create database connection
					//JdbcFiles conn = new JdbcFiles();
					//sqlStr="select * from admin where num='"+str1+"'and password='"+str2+"'";
					//ResultSet result = conn.executeQuery(sqlStr);
					
					Statement stmt = conn.createStatement();
					ResultSet result = stmt.executeQuery("select * from admin where name='"+str1+"'and password='"+str2+"'");
					
					if(result.next()){
					//if(str1.equals("elilien")&&str2.equals("test")){
						JOptionPane.showMessageDialog(frame,"Login Successful!");
						//Open Book Management Information System Main Window
						BookMain bk = new BookMain();
						bk.go();
						frame.dispose();
										
					}else{
						JOptionPane.showMessageDialog(frame,"Invalid Username or Password ;-(");						
					}					
				}else if(obj.equals(Cancel_btn)){
					System.exit(0);					
				}
			}catch(ClassNotFoundException ce){
				System.out.println("SQLException:" + ce.getMessage());
				
			}catch(SQLException ex){
				System.out.println(ex);
				
			}catch(Exception s){
				s.printStackTrace();				
			}
		}		
	}
	public static void main(String args[]){
		Login login = new Login();
		}	
}
