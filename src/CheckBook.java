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

public class CheckBook extends JPanel implements ActionListener{
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
	
	public CheckBook(){
		searchlabel = new JLabel("Check Book Information");
		searchfield = new JTextField("Please Input the Query");
		searchcbo = new JComboBox();
		button1 = new JButton("Check");
		searchcbo.addItem("Check with Book ID");
		searchcbo.addItem("Check with Book Name");

		jp.setLayout(new FlowLayout());

		jp.add(searchlabel);
		jp.add(searchfield);
		jp.add(button1);
		jp.add(searchcbo);
		jp.add(button1);
		this.setLayout(new BorderLayout());
		this.add(jp,BorderLayout.NORTH);
		 
		vector2.add("Seial Number");
		vector2.add("Book Name");
		vector2.add("Author");
		vector2.add("Publishing House");
		vector2.add("ISBN");
		vector2.add("Price");
		vector2.add("Lent or Not");
		 
		button1.addActionListener(this);
		this.setSize(500, 500);		
	}
	
	public void actionPerformed(ActionEvent e){
		String numorname, searchf, sql;
		numorname = searchcbo.getSelectedItem().toString();
		searchf = searchfield.getText().trim();{
			if(searchf.equals(""))
				JOptionPane.showMessageDialog(null, "Check Query cannot be Empty!", "Check", JOptionPane.WARNING_MESSAGE);
			else if(numorname.equals(""))
				JOptionPane.showMessageDialog(null, "Check Query cannot be Empty!", "Check", JOptionPane.WARNING_MESSAGE);
			}
		}
	public static void main(String[] args){
		CheckBook app1 = new CheckBook();
		}
}

			 
			 
			 
		