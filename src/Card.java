import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Card extends JFrame {
	JPanel pan = new JPanel();
	JButton btn = new JButton("Choose a Card");
	CardLayout cardlayout = new CardLayout();
	
	public Card(){
		this.setSize(300, 300);
		this.setVisible(true);
		pan.setLayout(cardlayout);
		for(int i=1; i<=5; i++){
			pan.add(String.valueOf(i), new JButton("Card No."+i));
		}
		cardlayout.show(pan, String.valueOf(1));
		Container cn = getContentPane();
		cn.add(pan, BorderLayout.CENTER);
		cn.add(btn, BorderLayout.SOUTH);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cardlayout.next(pan);
			}
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card ca = new Card();

	}

}
