import java.io.*;
import java.net.*;
import java.awt.event.*;
import javax.swing.*;

public class AddBook extends JPanel{
	private JTextField number, bookname, publish, author, isbn, price;
	private JLabel jnumber, jbookname, jpublish, jauthor, jisbn, jprice;
	private JButton button1,button2;
	PrintStream output;
	DataInputStream input;
	String message = "";

	public AddBook(){
		this.setLayout(null);
        jnumber = new JLabel("Seial Number:", SwingConstants.RIGHT);
        number = new JTextField();
        jbookname = new JLabel("Book Name:", SwingConstants.RIGHT);
        bookname = new JTextField();
        jpublish = new JLabel("Publishing House:", SwingConstants.RIGHT);
        publish = new JTextField();
        jauthor = new JLabel("Author:", SwingConstants.RIGHT);
        author = new JTextField();
        jisbn = new JLabel("ISBN:", SwingConstants.RIGHT);
        isbn = new JTextField();
        jprice = new JLabel("Price:", SwingConstants.RIGHT);
        price = new JTextField();
        button1 = new JButton("Add");
        button2 = new JButton("Cancel");

        jnumber.setBounds(55, 20, 90, 26);
        jbookname.setBounds(55, 60, 90, 26);
        jpublish.setBounds(30, 100, 115, 26);
        jauthor.setBounds(55, 140, 90, 26);
        jisbn.setBounds(55, 180, 90, 26);
        jprice.setBounds(55, 220, 90, 26);
        number.setBounds(160, 20, 160, 26);
        bookname.setBounds(160, 60, 160, 26);
        publish.setBounds(160, 100, 160, 26);
        author.setBounds(160, 140, 160, 26);
        isbn.setBounds(160, 180, 160, 26);
        price.setBounds(160, 220, 160, 26);
        button1.setBounds(80, 255, 100, 26);
        button2.setBounds(200, 255, 100, 26);

        this.add(jnumber);
        this.add(number);
        this.add(jbookname);
        this.add(bookname);
        this.add(jpublish);
        this.add(publish);
        this.add(jauthor);
        this.add(author);
        this.add(jisbn);
        this.add(isbn);
        this.add(jprice);
        this.add(price);
        this.add(button1);
        this.add(button2);
        
        //add ActionListener for button1
        button1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(number.getText().toString().equals(""))
        			JOptionPane.showMessageDialog(null, "Seial Number cannot be Empty!", "Add", JOptionPane.WARNING_MESSAGE);
        		else if(bookname.getText().toString().equals(""))
            		JOptionPane.showMessageDialog(null, "Book Name cannot be Empty!", "Add", JOptionPane.WARNING_MESSAGE);
            	else if(publish.getText().toString().equals(""))
                	JOptionPane.showMessageDialog(null, "Publishing House cannot be Empty!", "Add", JOptionPane.WARNING_MESSAGE);
                else if(author.getText().toString().equals(""))
                    JOptionPane.showMessageDialog(null, "Author cannot be Empty!", "Add", JOptionPane.WARNING_MESSAGE);
                else if(isbn.getText().toString().equals(""))
                    JOptionPane.showMessageDialog(null, "ISBN cannot be Empty!", "Add", JOptionPane.WARNING_MESSAGE);
                else if(price.getText().toString().equals(""))
                    JOptionPane.showMessageDialog(null, "Price cannot be Empty!", "Add", JOptionPane.WARNING_MESSAGE);
                else
                	JOptionPane.showMessageDialog(null, "Add Successful!", "Add", JOptionPane.WARNING_MESSAGE);
        		}
        	});
        
		//add ActionListener for button12
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				number.setText("");
				bookname.setText("");
				publish.setText("");
				author.setText("");
				isbn.setText("");
				price.setText("");
				}
			});
		setSize(250, 400);
		this.setVisible(true);
		}
                                			
	//connect method
	public static void mian(String[] args){
		AddBook app = new AddBook();
		}
}

        		
        	


