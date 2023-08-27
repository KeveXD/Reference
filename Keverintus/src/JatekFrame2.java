import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class JatekFrame2 extends JFrame implements KeyListener
{

	private Palya palya1;
	private Palya palya2;
	
	private JatekPanel2 jp;
	//private StatuszPanel sp;
	
	JOptionPane vege;

	
	JatekFrame2( Palya palya1, Palya palya2)
	{
		this.setTitle("Keverintus");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.palya1=palya1;
		this.palya2=palya2;
		
		jp=new JatekPanel2(palya1,palya2);
		//sp=new StatuszPanel(palya);
		
		this.add(jp, BorderLayout.SOUTH);
		//this.add(sp, BorderLayout.NORTH);
		

		this.addKeyListener(this);

		this.pack();
		this.setVisible(true);

	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		if (!(palya1.getBabuY()==-1 ||palya1.getBabuX()==-1))
		switch (e.getKeyChar()) {
		case 'w':
			palya1.szornyetLeptet();
			palya1.leptet(Irany.Fel);
			break;
		case 's':
			palya1.szornyetLeptet();
			palya1.leptet(Irany.Le);
			break;
		case 'a':
			palya1.szornyetLeptet();
			palya1.leptet(Irany.Balra);
		break;
		case 'd':
			palya1.szornyetLeptet();
			palya1.leptet(Irany.Jobbra);
			break;
		/*case 'f':
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
			break;*/
		}

		if ((palya1.getBabuY()==palya1.getKapuY() && palya1.getBabuX()==palya1.getKapuX()) || palya1.getBabuY()==-1 ||palya1.getBabuX()==-1)
		{
			vege.showMessageDialog(null, "Vége a játéknak", "cim", JOptionPane.PLAIN_MESSAGE);
			palya1.setBabuX(-1);
			palya1.setBabuY(-1);
			this.dispose();
		}
		
		if (!(palya2.getBabuY()==-1 ||palya2.getBabuX()==-1)) {
			int kod = e.getKeyCode();
			
			

			switch (e.getKeyChar()) {
			case 'u':
				palya2.szornyetLeptet();
				palya2.leptet(Irany.Fel);
				break;
			case 'j':
				palya2.szornyetLeptet();
				palya2.leptet(Irany.Le);
				break;
			case 'h':
				palya2.szornyetLeptet();
				palya2.leptet(Irany.Balra);
			break;
			case 'k':
				palya2.szornyetLeptet();
				palya2.leptet(Irany.Jobbra);
				break;
			}
			
			}
			
			//sp=new StatuszPanel(palya);
			jp=new JatekPanel2(palya1,palya2);
			
			//this.add(sp, BorderLayout.NORTH);
			this.add(jp, BorderLayout.SOUTH);
			this.pack();

			if ((palya2.getBabuY()==palya2.getKapuY() && palya2.getBabuX()==palya2.getKapuX()) || palya2.getBabuY()==-1 ||palya2.getBabuX()==-1)
			{
				vege.showMessageDialog(null, "Vége a játéknak", "cim", JOptionPane.PLAIN_MESSAGE);
				palya2.setBabuX(-1);
				palya2.setBabuY(-1);
				this.dispose();
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
