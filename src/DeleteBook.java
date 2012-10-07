import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        button1 = new JButton("Check");
        button2 = new JButton("Delete");

        jnumber.setBounds(55, 20, 90, 26);
        jbookname.setBounds(55, 100, 90, 26);
        jpublish.setBounds(30, 130, 115, 26);
        jauthor.setBounds(55, 160, 90, 26);
        jisbn.setBounds(55, 190, 90, 26);
        jprice.setBounds(55, 220, 90, 26);
        number.setBounds(160, 20, 160, 26);
        bookname.setBounds(160, 100, 160, 26);
        publish.setBounds(160, 130, 160, 26);
        author.setBounds(160, 160, 160, 26);
        isbn.setBounds(160, 190, 160, 26);
        price.setBounds(160, 220, 160, 26);
        button1.setBounds(150, 55, 100, 26);
        button2.setBounds(150, 255, 100, 26);

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
        		try{
        			if(number.getText().toString().equals(""))
        				JOptionPane.showMessageDialog(null, "Book ID cannot be Empty!","Edit",JOptionPane.WARNING_MESSAGE);
        			String sqlstr1;
					JdbcFiles conn = new JdbcFiles();
					sqlstr1 = "select number,bookname,publish,author,isbn,price from books where number='"+number.getText()+"'";
					ResultSet result = conn.executeQuery(sqlstr1);							
					   if(result.next()){
						   {
							   bookname.setText(result.getString("bookname"));
							   publish.setText(result.getString("publish"));
							   author.setText(result.getString("author"));
							   isbn.setText(result.getString("isbn"));
							   price.setText(result.getString("price"));
						   }
					}else
						JOptionPane.showMessageDialog(null, "Book Information Not Found.", "Delete",JOptionPane.WARNING_MESSAGE);
					   }catch (ClassNotFoundException ce) {
						   System.out.println("SQLException:" + ce.getMessage());
						   }catch (SQLException ex) {
							   System.out.println(ex);
							   } catch (Exception s) {
								   s.printStackTrace();
							   }
        		}
        	});

		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					String sqlstr2 = "delete from books where number='"+number.getText()+"'";
					int k = -1;
					JdbcFiles conn1 = new JdbcFiles();
					k=conn1.insert(sqlstr2);
					if(number.getText().toString().equals(""))
						JOptionPane.showMessageDialog(null, "Book ID cannot be Empty!", "Edit", JOptionPane.WARNING_MESSAGE);
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
					else if (k > -1){
						JOptionPane.showMessageDialog(null, "Delete Successful!", "Delete",JOptionPane.WARNING_MESSAGE);
						conn1.close();
						} else
							JOptionPane.showMessageDialog(null, "Delete Failed!", "Delete",JOptionPane.WARNING_MESSAGE);									
					}catch(ClassNotFoundException ce){
						System.out.println("SQLException:"+ce.getMessage());
						
					}catch(SQLException ex){
						System.out.println(ex);
						
					}catch(Exception s){
						s.printStackTrace();
						}
				}
			});
		setSize(250, 380);
		this.setVisible(true);
		}
	public static void main(String[] args){
		DeleteBook app1 = new DeleteBook();
		}		
}

		
		
		
	
