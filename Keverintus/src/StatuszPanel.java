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
		
		kincsek=new JLabel(palya.kincsekSzama()+" Kincs hiányzik");
		x=new JLabel("Az X kordinátád: "+ palya.getBabuX());
		y=new JLabel("Az Y kordinátád: "+ palya.getBabuY());
		
		this.add(kincsek);
		this.add(x);
		this.add(y);

		
		this.setLayout(new FlowLayout());

		this.setVisible(true);		
	}
}
