import java.io.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;

public class LendBook extends JPanel{
	private JTextField bnumber,unumber;
	private JLabel jbnumber,junumber;
	private JButton button1,button2;
	PrintStream output;
	DataInputStream input;
	String message = "";
	
	public LendBook(){
		this.setLayout(null);
		jbnumber = new JLabel("Book ID:", SwingConstants.RIGHT);
		bnumber = new JTextField();
		junumber = new JLabel("User ID:", SwingConstants.RIGHT);
		unumber = new JTextField();
		button1 = new JButton("Lend");
		button2 = new JButton("Cancel");
		jbnumber.setBounds(55, 80, 90, 26);
		junumber.setBounds(55, 120, 90, 26);
		bnumber.setBounds(160, 80, 160, 26);
		unumber.setBounds(160, 120, 160, 26);
		button1.setBounds(115, 165, 80, 26);
		button2.setBounds(210, 165, 80, 26);
		this.add(jbnumber);
		this.add(bnumber);
		this.add(junumber);
		this.add(unumber);
		this.add(button1);
		this.add(button2);
		
		//add ActionListener for button1
	    button1.addActionListener(new ActionListener(){
	       	public void actionPerformed(ActionEvent e){
	       		if(bnumber.getText().toString().equals(""))
	        		JOptionPane.showMessageDialog(null, "Book ID cannot be Empty!", "Lend", JOptionPane.WARNING_MESSAGE);
	        	else if(unumber.getText().toString().equals(""))
	            	JOptionPane.showMessageDialog(null, "User ID cannot be Empty!", "Lend", JOptionPane.WARNING_MESSAGE);
	       		}
	       	});
	    
	    //add ActionListener for button1
	    button2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		bnumber.setText("");
	    		unumber.setText("");
	    		}
	    	});
	    setSize(250, 300);
	    this.setVisible(true);
	    }
	
	//connect method
	public static void main(String[] args){
		LendBook app = new LendBook();
	}
}
