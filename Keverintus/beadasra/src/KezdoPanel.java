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

public class KezdoPanel implements ActionListener {

	private static final Exception Exception = null;
	JFrame jf;
	JPanel jp1;
	JButton keszGomb;
	JTextField szornyekSzamaText;
	JTextField kincsekSzamaText;
	JTextField palyaMeret=new JTextField();
	JTextField fileNev;
	JLabel valasz=new JLabel();
	JCheckBox cb;
	Palya palya;
	//Boolean mehetETovabb=false;

	
	
	KezdoPanel(){
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
		//jp.setPreferredSize(new Dimension(60,60));
		jp1.setBackground(new Color(67, 150, 112));
		jp1.setVisible(true);
		jp1.setLayout(null);
		jp1.setBounds(100,0,600,600);
		jf.add(jp1);
		
		//szornyekSzamaText
		JLabel l1=new JLabel("Add meg a szörnyek számát:");
		l1.setFont(new Font("Verdana", Font.PLAIN, 20));
		l1.setBounds(30,80,400,30);
		jp1.add(l1);
		szornyekSzamaText=new JTextField();
		szornyekSzamaText.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		szornyekSzamaText.setForeground(Color.red);
		szornyekSzamaText.setBackground(new Color(12, 45, 67));
		szornyekSzamaText.setBounds(410,75,60,40);
		jp1.add(szornyekSzamaText);
		
		//kincsekSzamaText
		JLabel l2=new JLabel("Add meg a kincsek számát:");
		l2.setFont(new Font("Verdana", Font.PLAIN, 20));
		l2.setBounds(30,130,400,30);
		jp1.add(l2);
		kincsekSzamaText=new JTextField();
		kincsekSzamaText.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		kincsekSzamaText.setForeground(Color.red);
		kincsekSzamaText.setBackground(new Color(12, 45, 67));
		kincsekSzamaText.setBounds(410,125,60,40);
		jp1.add(kincsekSzamaText);
		
		//palyaMeret
		JLabel l3=new JLabel("Add meg mekkora pályát szeretnél:");
		l3.setFont(new Font("Verdana", Font.PLAIN, 20));
		l3.setBounds(30,180,400,30);
		jp1.add(l3);
		palyaMeret=new JTextField();
		palyaMeret.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		palyaMeret.setForeground(Color.red);
		palyaMeret.setBackground(new Color(12, 45, 67));
		palyaMeret.setBounds(410,175,60,40);
		jp1.add(palyaMeret);
		
		
		//fileNev
		JLabel l5=new JLabel("Add meg a fájl nevét: ");
		l5.setFont(new Font("Verdana", Font.PLAIN, 20));
		l5.setBounds(30,230,400,30);
		jp1.add(l5);
		fileNev=new JTextField();
		fileNev.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		fileNev.setForeground(Color.red);
		fileNev.setBackground(new Color(12, 45, 67));
		fileNev.setBounds(310,225,160,40);
		jp1.add(fileNev);
		
		
		//cb (checkBox)
		JLabel l4=new JLabel("Egyedül szeretném megírni a labirintust.");
		l4.setFont(new Font("Verdana", Font.PLAIN, 20));
		l4.setBounds(30,280,420,30);
		jp1.add(l4);
		cb=new JCheckBox();
		jp1.add(cb);
		cb.setBounds(450,285,20,20);
		
		//keszGomb
		keszGomb=new JButton("Kész");
		keszGomb.addActionListener(this);
		keszGomb.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		keszGomb.setFocusable(false);
		keszGomb.setBounds(200, 350, 200,100);
		jp1.add(keszGomb);

		//valasz
		valasz.setText("");
		valasz.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		valasz.setBounds(30,450,550,100);
		valasz.setForeground(new Color(180,23,17));
		jp1.add(valasz);
		
		
	}
	
	/*public void setMehetETovabb(Boolean uj)
	{
		mehetETovabb=uj;
	}
	
	public void setPalya(Palya uj)
	{
		palya=uj;
	}*/
	
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
		if (e.getSource()==keszGomb)
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
