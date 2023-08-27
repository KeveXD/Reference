import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatuszPanel extends JPanel{

	private JLabel kincsek;
	private JLabel x;
	private JLabel y;


	private Palya palya;

	StatuszPanel(Palya palya){
		this.palya=palya;
		
		kincsek=new JLabel(palya.kincsekSzama()+" Kincs hi�nyzik");
		x=new JLabel("Az X kordin�t�d: "+ palya.getBabuX());
		y=new JLabel("Az Y kordin�t�d: "+ palya.getBabuY());
		
		this.add(kincsek);
		this.add(x);
		this.add(y);

		
		this.setLayout(new FlowLayout());

		this.setVisible(true);		
	}
}
