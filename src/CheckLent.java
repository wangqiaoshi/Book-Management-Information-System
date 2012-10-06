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

public class CheckLent extends JPanel implements ActionListener{

	private JTextField searchfield;
	private JLabel searchlabel;
	private JComboBox searchcbo;
	private JButton button1;
	Vector vector1 = new Vector();
	Vector vector2 = new Vector();
	JScrollPane jspane;
	private JPanel jp = new JPanel();
	JTable table;
	PrintWriter output;
	BufferedReader input;
	String message = "";
	
	public CheckLent(){
		searchlabel = new JLabel("Check Lent Book");
		searchfield = new JTextField("Please Input Check Query");
		searchcbo = new JComboBox();
		button1 = new JButton("Check");
		searchcbo.addItem("Check with Book ID");
		searchcbo.addItem("Check with User ID");
		jp.setLayout(new FlowLayout());
		jp.add(searchlabel);
		jp.add(searchfield);
		jp.add(button1);
		jp.add(searchcbo);
		jp.add(button1);
		this.setLayout(new BorderLayout());
		this.add(jp,BorderLayout.NORTH);
		vector2.add("Book");
		vector2.add("User");
		vector2.add("Lent time");
		vector2.add("Time Should be Returned");
		vector2.add("Returned Time");
		vector2.add("Returned or Not");
		button1.addActionListener(this);
		this.setSize(500, 500);
	}

	 public void actionPerformed(ActionEvent e)
	 {
		 String numorname, searchf;
		 numorname = searchcbo.getSelectedItem().toString();
		 searchf = searchfield.getText().trim();
		 {
			 if(searchf.equals(""))
				 JOptionPane.showMessageDialog(null, "Check Query cannot be Empty!", "Check", JOptionPane.WARNING_MESSAGE);
			 else
				 if(numorname.equals(""))
					 JOptionPane.showMessageDialog(null, "Check Query cannot be Empty!", "Check", JOptionPane.WARNING_MESSAGE);
				 else
					 connect("searchbook" + "/" + searchf + "/" + numorname);
		 }
	 }
	 public void connect(String s){
		 Socket socket;
		 try{
			 socket = new Socket(InetAddress.getByName(""),4321);
			 output = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
			 input = new BufferedReader(new InputStreamReader(socket.getInputStream()));			 
			 output.println(s);
			 output.flush();
			 try{
				 while(!(message = input.readLine()).equals("end")){
					 String booklendinfor[];
					 booklendinfor = message.split("/");
					 Vector vector3 = new Vector();
					 vector3.add(booklendinfor[1]);
					 vector3.add(booklendinfor[2]);
					 vector3.add(booklendinfor[3]);
					 vector3.add(booklendinfor[4]);
					 vector3.add(booklendinfor[5]);
					 vector3.add(booklendinfor[6]);
					 
					 vector1.add(vector3);
					 }
				 table = new JTable(vector1, vector2);
				 jspane = new JScrollPane(table);
				 this.add(jspane,BorderLayout.CENTER);
				 }catch(IOException e){
					 System.out.println("Unable to Obtain Information");
					 }
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
		 CheckLent app1 = new CheckLent();
		}
}

