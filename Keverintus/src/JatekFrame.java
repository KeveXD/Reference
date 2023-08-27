import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class JatekFrame extends JFrame implements KeyListener
{

	private Palya palya;
	
	private JatekPanel jp;
	private StatuszPanel sp;
	
	JOptionPane vege;

	
	JatekFrame( Palya palya)
	{
		this.setTitle("Keverintus");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		this.palya=palya;
		
		jp=new JatekPanel(palya);
		sp=new StatuszPanel(palya);
		
		this.add(jp, BorderLayout.SOUTH);
		this.add(sp, BorderLayout.NORTH);
		

		this.addKeyListener(this);

		this.pack();
		this.setVisible(true);

	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		if (!(palya.getBabuY()==-1 ||palya.getBabuX()==-1))
		switch (e.getKeyChar()) {
		case 'w':
			palya.szornyetLeptet();
			palya.leptet(Irany.Fel);
			break;
		case 's':
			palya.szornyetLeptet();
			palya.leptet(Irany.Le);
			break;
		case 'a':
			palya.szornyetLeptet();
			palya.leptet(Irany.Balra);
		break;
		case 'd':
			palya.szornyetLeptet();
			palya.leptet(Irany.Jobbra);
			break;
		case 'f':
			try {
				FileOutputStream fo=new FileOutputStream("regiJatek");
				ObjectOutputStream out=new ObjectOutputStream(fo);
				out.writeObject(palya);
				out.close();
				vege.showMessageDialog(null, "Elmentetted a játékot xd", "cim", JOptionPane.PLAIN_MESSAGE);
				palya.setBabuX(-1);
				palya.setBabuY(-1);
			}
			catch (IOException i)
			{
				i.printStackTrace();
			}
			break;
		}
		
		sp=new StatuszPanel(palya);
		jp=new JatekPanel(palya);
		
		this.add(sp, BorderLayout.NORTH);
		this.add(jp, BorderLayout.SOUTH);
		this.pack();
	//	palya.palyatKiir();
		
	//	System.out.println("Kapu "+ palya.getKapuY()+" "+palya.getKapuX());
		//System.out.println("Babu "+ palya.getBabuY()+" "+palya.getBabuX());
		if ((palya.getBabuY()==palya.getKapuY() && palya.getBabuX()==palya.getKapuX()) || palya.getBabuY()==-1 ||palya.getBabuX()==-1)
		{
			vege.showMessageDialog(null, "Vége a játéknak", "cim", JOptionPane.PLAIN_MESSAGE);
			palya.setBabuX(-1);
			palya.setBabuY(-1);
			this.dispose();
			//System.out.println("lefut");
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
