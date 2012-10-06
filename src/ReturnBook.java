import java.io.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;

public class ReturnBook extends JPanel{
	private JTextField bnumber;
	private JLabel jbnumber;
	private JButton button1, button2;
	PrintStream output;
	DataInputStream input;
	String message = "";
	public ReturnBook(){
		this.setLayout(null);
		jbnumber = new JLabel("Book ID:", SwingConstants.RIGHT);
		bnumber = new JTextField();
		button1 = new JButton("Return");
		button2 = new JButton("Cancel");
		jbnumber.setBounds(55, 100, 90, 26);
		bnumber.setBounds(160, 100, 160, 26);
		button1.setBounds(115, 145, 80, 26);
		button2.setBounds(210, 145, 80, 26);
		this.add(jbnumber);
		this.add(bnumber);
		this.add(button1);
		this.add(button2);
		
		//add ActionListener for button1
	    button1.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		if(bnumber.getText().toString().equals(""))
	    			JOptionPane.showMessageDialog(null, "Book ID cannot be Empty!", "Return", JOptionPane.WARNING_MESSAGE);
	    		}
	    	});
	    
	    //add ActionListener for button2
	    button2.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		bnumber.setText("");
	    		}
	        });
	    setSize(250, 300);
	    this.setVisible(true);
	    }
	
	//connect method
	public static void main(String[] args){
		ReturnBook app = new ReturnBook();
	}
}



