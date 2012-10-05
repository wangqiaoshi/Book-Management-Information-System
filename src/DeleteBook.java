import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteBook extends JPanel{
	private JTextField number, bookname, publish, author, isbn, price;
	private JLabel jnumber, jbookname, jpublish, jauthor, jisbn, jprice;
	private JButton button1, button2;
	PrintStream output;
	DataInputStream input;
	String message = "";
	String bookinfor[];

	public DeleteBook(){
		this.setLayout(null);
		jnumber = new JLabel("Seial Number");
        number = new JTextField();
        jbookname = new JLabel("Book Name");
        bookname = new JTextField();
        jpublish = new JLabel("Publishing House");
        publish = new JTextField();
        jauthor = new JLabel("Author");
        author = new JTextField();
        jisbn = new JLabel("ISBN");
        isbn = new JTextField();
        jprice = new JLabel("Price");
        price = new JTextField();
        button1 = new JButton("Check");
        button2 = new JButton("Cancel");

        jnumber.setBounds(30, 20, 60, 26);
        jbookname.setBounds(30, 100, 60, 26);
        jpublish.setBounds(30, 130, 60, 26);
        jauthor.setBounds(30, 160, 60, 26);
        jisbn.setBounds(30, 190, 60, 26);
        jprice.setBounds(30, 220, 60, 26);
        number.setBounds(110, 20, 120, 26);
        bookname.setBounds(110, 100, 120, 26);
        publish.setBounds(110, 130, 120, 26);
        author.setBounds(110, 170, 120, 26);
        isbn.setBounds(110, 190, 120, 26);
        price.setBounds(110, 220, 120, 26);
        button1.setBounds(60, 60, 60, 30);
        button2.setBounds(60, 250, 60, 26);

        bookname.setEnabled(false);
        publish.setEnabled(false);
        author.setEnabled(false);
        isbn.setEnabled(false);
        price.setEnabled(false);

        this.add(jnumber);
        this.add(number);
        this.add(button1);
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
        this.add(button2);

        button1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(number.getText().toString().equals(""))
        			JOptionPane.showMessageDialog(null, "Seial Number cannot be Empty!","Edit",JOptionPane.WARNING_MESSAGE);
        		}
        	});

		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(number.getText().toString().equals(""))
        			JOptionPane.showMessageDialog(null, "Seial Number cannot be Empty!", "Edit", JOptionPane.WARNING_MESSAGE);
        		else if(bookname.getText().toString().equals(""))
            		JOptionPane.showMessageDialog(null, "Book Name cannot be Empty!", "Edit", JOptionPane.WARNING_MESSAGE);
            	else if(publish.getText().toString().equals(""))
                	JOptionPane.showMessageDialog(null, "Publishing House cannot be Empty!", "Edit", JOptionPane.WARNING_MESSAGE);
                else if(author.getText().toString().equals(""))
                    JOptionPane.showMessageDialog(null, "Author cannot be Empty!", "Edit", JOptionPane.WARNING_MESSAGE);
                else if(isbn.getText().toString().equals(""))
                    JOptionPane.showMessageDialog(null, "ISBN cannot be Empty!", "Edit", JOptionPane.WARNING_MESSAGE);
                else if(price.getText().toString().equals(""))
                    JOptionPane.showMessageDialog(null, "Price cannot be Empty!", "Edit", JOptionPane.WARNING_MESSAGE);
				}
			});
		setSize(250,380);
		this.setVisible(true);
		}
	public static void main(String[] args){
		DeleteBook app1 = new DeleteBook();
		}		
}

		
		
		
	
