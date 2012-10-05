import java.awt.*;
import java.awt.event.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.*;
import java.util.*;

public class CheckUser extends JPanel implements ActionListener{
	private JTextField checkfield;
	private JLabel checklabel;
	private JComboBox checkcbo;
	private JButton button1;

	Vector vector1 = new Vector();
	Vector vector2 = new Vector();

	JScrollPane jspane;
	private JPanel jp = new JPanel();

	JTable table;

	PrintWriter output;
	BufferedReader input;

	String message = "";

	public CheckUser(){
		checklabel = new JLabel("Check User Information");
		checkfield = new JTextField("Please Input the Query");
		checkcbo = new JComboBox();
		button1 = new JButton("Check");
		checkcbo.addItem("Check with User ID");
		checkcbo.addItem("Check with User Name");
		
		//set JPanel Layout
		jp.setLayout(new FlowLayout());

		jp.add(checklabel);
		jp.add(checkfield);
		jp.add(button1);
		jp.add(checkcbo);
		jp.add(button1);

		this.setLayout(new BorderLayout());
		this.add(jp, BorderLayout.NORTH);

		vector2.add("User ID");
		vector2.add("Name");
		vector2.add("Password");
		vector2.add("College");
		vector2.add("Subject");
		vector2.add("Grade");
		
		//add ActionListener for button1
		button1.addActionListener(this);
		this.setSize(500, 500);		
	}
	
	//add ActionEvent
	public void actionPerformed(ActionEvent e){
		String numorname, searchf, sql;
		numorname = checkcbo.getSelectedItem().toString();
		searchf = checkfield.getText().trim();
		{
			if(searchf.equals(""))
				JOptionPane.showMessageDialog(null, "Check Query cannot be Empty!", "Check", JOptionPane.WARNING_MESSAGE);
			else if(numorname.equals(""))
				JOptionPane.showMessageDialog(null, "Check Query cannot be Empty!", "Check", JOptionPane.WARNING_MESSAGE);
			else
				connect("searchuser" + "/" + searchf + "/" + numorname);
		}		
	}
	
	//connect method
	public void connect(String s){
		Socket socket;
		try{
			//create a Socket class object, specify the port number 4321
			socket = new Socket(InetAddress.getByName(""), 4321);
			//create data input and output streams object
			output = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//output data stream
			output.println(s);
			output.flush();
			try{
				//read data stream
				while(!(message=input.readLine()).equals("end")){
					String userinfor[];
					//transmission the string into arrays
					userinfor = message.split("/");
					Vector vector3 = new Vector();
					vector3.add(userinfor[1]);
					vector3.add(userinfor[2]);
					vector3.add(userinfor[3]);
					vector3.add(userinfor[4]);
					vector3.add(userinfor[5]);
					vector3.add(userinfor[6]);
					
					vector1.add(vector3);						
				}
				table = new JTable(vector1, vector2);
				jspane = new JScrollPane(table);
				this.add(jspane, BorderLayout.CENTER);
			}catch(IOException e){
				System.out.println("Unable to Obtain Information");					
				}
			//close data stream and Socket object
			output.close();
			input.close();
			socket.close();
			}catch(EOFException eof){
				System.out.println("Server Outages");
				}catch(IOException e){
					e.printStackTrace();
					}
		}
	public static void main(String[] args){
		CheckUser app1 = new CheckUser();			
	}
}

