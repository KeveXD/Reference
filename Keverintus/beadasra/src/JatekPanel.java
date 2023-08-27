import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JatekPanel extends JPanel{

	private int palyaMezokSzamaX;
	private int palyaMezokSzamaY;
	private ImageIcon ko;
	private ImageIcon babu;
	
	private Palya palya;
	
	private int koz;
	
	JatekPanel(Palya palya)
	{
		this.setPreferredSize(new Dimension(750,750));
		this.setBackground(new Color(63, 50, 12));
		
		this.palyaMezokSzamaX=palya.getOszlop();//palyaMezokSzamaX;//15;
		this.palyaMezokSzamaY=palya.getSor();
		
		this.koz=750/palyaMezokSzamaX;
		
		ko=new ImageIcon("ko.png",null);
		babu=new ImageIcon("banyasz.png",null);
		


		
		this.palya=palya;
		
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		draw(g);		
	}

	
	public void draw(Graphics g)
	{

		
		 for (int i=0;i<palyaMezokSzamaY;i++)
			 for(int o=0;o<palyaMezokSzamaX;o++)
			 {
				 if (palya.getPalyaErtek(i,o).equals(Mezo.Fal))
				 {
					 g.setColor(Color.black);
					 g.drawRect(o*koz, i*koz, koz, koz);
					 g.fillRect(o*koz, i*koz, koz, koz);
					 
					/* Image b1=ko.getImage();
					 Image uj=b1.getScaledInstance(koz, koz, Image.SCALE_SMOOTH);
					 babu=new ImageIcon(uj);
					 
					 JLabel label=new JLabel(ko);
					 label.setBounds(o*koz, i*koz, koz, koz);
					 this.add(label);*/
				 }
				 if (palya.getPalyaErtek(i,o).equals(Mezo.Babu))
				 {
					 g.setColor(new Color(34, 253, 7));
					 g.drawRect(o*koz, i*koz, koz, koz);
					 g.fillRect(o*koz, i*koz, koz, koz);
					 
					/* Image b1=babu.getImage();
					 Image uj=b1.getScaledInstance(koz, koz, Image.SCALE_DEFAULT);
					 babu=new ImageIcon(uj);
					 
					 
					 JLabel label=new JLabel(babu);
					 label.setBounds(o*koz, i*koz, koz, koz);
					 this.add(label);*/
				 }
				 if (palya.getPalyaErtek(i,o).equals(Mezo.Szorny))
				 {
					 g.setColor(new Color(115, 113, 103));
					 g.drawRect(o*koz, i*koz, koz, koz);
					 g.fillRect(o*koz, i*koz, koz, koz);
				 }
				 if (palya.getPalyaErtek(i,o).equals(Mezo.Kincs))
				 {
					 g.setColor(new Color(255, 213, 103));
					 g.drawOval(o*koz, i*koz, koz, koz);
					 g.fillOval(o*koz, i*koz, koz, koz);
				 }
					 
			 }
	}
	
}








