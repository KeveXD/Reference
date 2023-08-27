import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KezdoPanel2 implements ActionListener {

	private static final Exception Exception = null;
	JFrame jf;
	JPanel jp1;
	JButton mehet;
	JTextField szornyekSzamaText;
	JTextField kincsekSzamaText;
	JTextField palyaMeret=new JTextField();
	JTextField fileNev;
	JLabel valasz=new JLabel();
	JCheckBox cb;
	JCheckBox cb2;
	JCheckBox cb1;
	JCheckBox cb3;
	JCheckBox cb4;
	Palya palya;


	
	
	KezdoPanel2(){
		//jf
		jf=new JFrame("Keverintus");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(new Color(70,80,70));
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setBounds(400, 100, 700, 600);
		jf.setResizable(true);

						
		//jp1
		jp1=new JPanel();
		jp1.setBackground(new Color(67, 150, 112));
		jp1.setLayout(null);
		jp1.setBounds(100,0,600,600);
		jp1.setVisible(true);

		
		//Uj jatek
		JLabel l1=new JLabel("Új Játék");
		l1.setFont(new Font("Verdana", Font.PLAIN, 20));
		l1.setBounds(30,80,400,30);
		jp1.add(l1);
		
		//Egy jatekos mod cb1
		JLabel l2=new JLabel("Egy játékos mód");
		l2.setFont(new Font("Verdana", Font.PLAIN, 16));
		l2.setBounds(60,120,200,30);
		jp1.add(l2);

		cb1=new JCheckBox();
		jp1.add(cb1);
		cb1.setBounds(210,128,20,20);
		cb1.setSelected(true);
		cb1.addActionListener((ActionEvent e)->{
			if (cb1.isSelected())
			cb2.setSelected(false);
			if (!cb1.isSelected())
				cb2.setSelected(true);
				
		});

		//tobb jatekos mod cb2
		JLabel l3=new JLabel("Több játékos mód");
		l3.setFont(new Font("Verdana", Font.PLAIN, 16));
		l3.setBounds(300,120,200,30);
		jp1.add(l3);

		cb2=new JCheckBox();
		jp1.add(cb2);
		cb2.setBounds(455,128,20,20);
		cb2.setSelected(false);
		cb2.addActionListener((ActionEvent e)->{
			if (cb2.isSelected())
			cb1.setSelected(false);
			if (!cb2.isSelected())
				cb1.setSelected(true);		
		});
		
		//konnyu cb3
		JLabel l4=new JLabel("Könnyû");
		l4.setFont(new Font("Verdana", Font.PLAIN, 16));
		l4.setBounds(60,150,200,30);
		jp1.add(l4);

		cb3=new JCheckBox();
		jp1.add(cb3);
		cb3.setBounds(210,155,20,20);
		cb3.setSelected(true);
		cb3.addActionListener((ActionEvent e)->{
			if (cb3.isSelected())
			cb4.setSelected(false);
			if (!cb3.isSelected())
				cb4.setSelected(true);			
		});
		
		//nehez cb4
		JLabel l5=new JLabel("Nehéz");
		l5.setFont(new Font("Verdana", Font.PLAIN, 16));
		l5.setBounds(300,150,200,30);
		jp1.add(l5);

		cb4=new JCheckBox();
		jp1.add(cb4);
		cb4.setBounds(455,155,20,20);
		cb4.setSelected(false);
		cb4.addActionListener((ActionEvent e)->{
			if (cb4.isSelected())
			cb3.setSelected(false);
			if (!cb4.isSelected())
				cb3.setSelected(true);
				
		});

		//meret
		JLabel l6=new JLabel("Mekkora pályát szeretnél?");
		l6.setFont(new Font("Verdana", Font.PLAIN, 16));
		l6.setBounds(60,190,250,30);
		jp1.add(l6);
		
		JTextField meret=new JTextField();
		meret.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		meret.setForeground(Color.red);
		meret.setBounds(290,190,80,30);
		meret.setBackground(new Color(12, 45, 67));
		jp1.add(meret);
		
		
		//szornyek
		JLabel l7=new JLabel("Hány szörnyet szeretnél?");
		l7.setFont(new Font("Verdana", Font.PLAIN, 16));
		l7.setBounds(60,230,250,30);
		jp1.add(l7);
				
		JTextField szornyek=new JTextField();
		szornyek.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		szornyek.setForeground(Color.red);
		szornyek.setBounds(290,230,80,30);
		szornyek.setBackground(new Color(12, 45, 67));
		jp1.add(szornyek);
		
		//kincsek
		JLabel l8=new JLabel("Hány kincset szeretnél?");
		l8.setFont(new Font("Verdana", Font.PLAIN, 16));
		l8.setBounds(60,270,250,30);
		jp1.add(l8);
						
		JTextField kincsek=new JTextField();
		kincsek.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		kincsek.setForeground(Color.red);
		kincsek.setBounds(290,270,80,30);
		kincsek.setBackground(new Color(12, 45, 67));
		jp1.add(kincsek);
		
		//Regi Jatek
		JLabel l9=new JLabel("Régi játék folytatása");
		l9.setFont(new Font("Verdana", Font.PLAIN, 20));
		l9.setBounds(30,330,400,30);
		jp1.add(l9);
		
		//regifajl
		JLabel l10=new JLabel("Milyen néven van mentve a játék?");
		l10.setFont(new Font("Verdana", Font.PLAIN, 16));
		l10.setBounds(60,370,290,30);
		jp1.add(l10);
							
		JTextField regifajl=new JTextField();
		regifajl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		regifajl.setForeground(Color.red);
		regifajl.setBounds(360,370,130,30);
		regifajl.setBackground(new Color(12, 45, 67));
		jp1.add(regifajl);
		


		
		//mehet
		mehet=new JButton("Mehet");
		mehet.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		mehet.setFocusable(false);
		mehet.setBounds(460, 490, 100,50);
		jp1.add(mehet);

		//valasz
	/*	valasz.setText("");
		valasz.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		valasz.setBounds(30,450,550,100);
		valasz.setForeground(new Color(180,23,17));
		jp1.add(valasz);
		*/

		jf.add(jp1);

	}

	
	public int szazalekBeallitas(int x)
	{
		if(x>9 && x<15)
			return 40;
		if(x>14 && x<25)
			return 50;
		if(x>=25)
			return 60;
		return 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*if (cb1.isSelected()) {
			cb2.setSelected(false);}
		
		if (cb2.isSelected()) {
			cb1.setSelected(false);}
		*/
		if (e.getSource()==mehet)
		{
			try {
			
			String fNev=fileNev.getText();
			//valasz.setText("Király, minden rendben!");
			
			if (!fNev.equals(""))
			{
				try {
				FileInputStream io=new FileInputStream(fNev);
				ObjectInputStream oi=new ObjectInputStream(io);
				Palya palya=(Palya)oi.readObject();
				JatekFrame frame=new JatekFrame(palya);
				}
				catch (IOException i)
				{
					i.printStackTrace();
				}
			}else
			{
				String temp=szornyekSzamaText.getText();
				int szornyekSzama=Integer.parseInt(temp);
				temp=kincsekSzamaText.getText();
				int kincsekSzama=Integer.parseInt(temp);
				temp=palyaMeret.getText();
				int palyaM=Integer.parseInt(temp);
				int szazalek=szazalekBeallitas(palyaM);
				
				
				
				if(szazalek==0 || szornyekSzama>palyaM || kincsekSzama>palyaM || kincsekSzama<0 || szornyekSzama<0)
					throw Exception;
				
				
				if (!cb.isSelected())
				{
					palya=new Palya(palyaM,palyaM,szornyekSzama,50,kincsekSzama,3);//20,20,2,40,0,2        15,15,2,50,2,3
					palya.palyatIr();
					palya.babutElhelyez();
					palya.szornyeketLerak();
					palya.kincseketLerak();
					JatekFrame frame=new JatekFrame(palya);
				}else
				{				
					PalyatCsinal pcs;
					palya=new Palya(palyaM,palyaM,0,0,0,0);
					pcs=new PalyatCsinal(palyaM,palyaM);
				}
			}

		
			
			jf.dispose();
			}
			catch (Exception exception)
			{
				valasz.setText("Valamit nem jól adtál meg");
			}
		}
	}
}
