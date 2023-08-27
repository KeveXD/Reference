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


public class JatekPanel2 extends JPanel{

	private int palyaMezokSzamaX;
	private int palyaMezokSzamaY;
	private ImageIcon ko;
	private ImageIcon babu;
	
	private Palya palya1;
	private Palya palya2;
	
	private int koz;
	
	JatekPanel2(Palya palya1, Palya palya2)
	{
		this.setPreferredSize(new Dimension(1550,750));
		this.setBackground(new Color(63, 50, 12));
		
		this.palyaMezokSzamaX=palya1.getOszlop();//palyaMezokSzamaX;//15;
		this.palyaMezokSzamaY=palya1.getSor();
		this.setLayout(null);
		
		this.koz=750/palyaMezokSzamaX;
		
		ko=new ImageIcon("ko.png",null);
		babu=new ImageIcon("banyasz.png",null);
		
		Image b1=ko.getImage();
		Image uj=b1.getScaledInstance(koz, koz, java.awt.Image.SCALE_SMOOTH);
		ko= new ImageIcon(uj); 

		Image b2=babu.getImage();
		Image uj2=b2.getScaledInstance(koz, koz, java.awt.Image.SCALE_SMOOTH);
		babu= new ImageIcon(uj2);
		
		this.palya1=palya1;
		this.palya2=palya2;

		
		System.out.println("lool");
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		draw1(g);
		draw2(g);
	}

	
	public void draw1(Graphics g)
	{
		 for (int i=0;i<palyaMezokSzamaY;i++)
			 for(int o=0;o<palyaMezokSzamaX;o++)
			 {
				 if (palya1.getPalyaErtek(i,o).equals(Mezo.Fal))
				 {
					 g.setColor(Color.black);
					 g.drawRect(o*koz, i*koz, koz, koz);
					 g.fillRect(o*koz, i*koz, koz, koz);
					 
					 JLabel label=new JLabel(ko);
					 label.setBounds(o*koz, i*koz, koz, koz);
					 this.add(label);
				 }
				 if (palya1.getPalyaErtek(i,o).equals(Mezo.Babu))
				 {
					
					 JLabel label=new JLabel(babu, JLabel.CENTER);
					 label.setBounds(o*koz, i*koz, koz, koz);
					 this.add(label);
					
				 }
				 if (palya1.getPalyaErtek(i,o).equals(Mezo.Szorny))
				 {
					 g.setColor(new Color(115, 113, 103));
					 g.drawRect(o*koz, i*koz, koz, koz);
					 g.fillRect(o*koz, i*koz, koz, koz);
				 }
				 if (palya1.getPalyaErtek(i,o).equals(Mezo.Kincs))
				 {
					 g.setColor(new Color(255, 213, 103));
					 g.drawOval(o*koz, i*koz, koz, koz);
					 g.fillOval(o*koz, i*koz, koz, koz);
				 }
					 
			 }
	}
	
	public void draw2(Graphics g)
	{
		 for (int i=0;i<palyaMezokSzamaY;i++)
			 for(int o=0;o<palyaMezokSzamaX;o++)
			 {
				 if (palya2.getPalyaErtek(i,o).equals(Mezo.Fal))
				 {
					 g.setColor(Color.black);
					 g.drawRect(800+o*koz, i*koz, koz, koz);
					 g.fillRect(800+o*koz, i*koz, koz, koz);
					 
					 JLabel label=new JLabel(ko);
					 label.setBounds(800+o*koz, i*koz, koz, koz);
					 this.add(label);
				 }
				 if (palya2.getPalyaErtek(i,o).equals(Mezo.Babu))
				 {
					
					 JLabel label=new JLabel(babu, JLabel.CENTER);
					 label.setBounds(800+o*koz, i*koz, koz, koz);
					 this.add(label);
					
				 }
				 if (palya2.getPalyaErtek(i,o).equals(Mezo.Szorny))
				 {
					 g.setColor(new Color(115, 113, 103));
					 g.drawRect(800+o*koz, i*koz, koz, koz);
					 g.fillRect(800+o*koz, i*koz, koz, koz);
				 }
				 if (palya2.getPalyaErtek(i,o).equals(Mezo.Kincs))
				 {
					 g.setColor(new Color(255, 213, 103));
					 g.drawOval(800+o*koz, i*koz, koz, koz);
					 g.fillOval(800+o*koz, i*koz, koz, koz);
				 }
					 
			 }
	}
	
}








