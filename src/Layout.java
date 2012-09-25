import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
public class Layout extends JFrame {
	public Layout(){
		/*this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		String spaces="";
		for(int i=0; i<10; i++){
			this.add(new JButton("Button"+i+spaces));
			spaces+=" ";
		}*/
		
		/*this.setLayout(new BorderLayout(10, 10));
		String[] borders = {"North", "South", "West", "East", "Center"};
		for(int i=0; i<borders.length; i++){
			this.add(borders[i], new JButton(borders[i]));
		}*/
		this.setLayout(new GridLayout(3, 4, 10, 10));
		for(int i=0; i<10; i++){
			this.add(new JButton("Button"+i));
		}
		
		this.setSize(300, 300);
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Layout la = new Layout();

	}

}
