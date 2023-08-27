import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class PalyatCsinal extends JFrame implements KeyListener {

	private Palya palya1;
	private Palya palya2;
	//private Palya uj;
	private JatekPanel jp;
	private Boolean kapu;
	private int elozo;
	
	PalyatCsinal(int x, int y)
	{
		this.setTitle("Keverintus");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		
		palya1=new Palya(x,y,0,0,0,0);
		palya2=new Palya(x,y,0,0,0,0);
		
		kapu=true;
		elozo=0;
		palya2.setBabuX(1);
		palya2.setBabuY(0);
		palya2.setPalyaErtek(palya2.getBabuX(), palya2.getBabuY(), Mezo.Babu);
		
		jp=new JatekPanel(palya2);
		this.add(jp);
		
		this.addKeyListener(this);
		this.pack();
		this.setVisible(true);
		
	}
	
	public Palya getPalya()
	{
		return palya1;
	}
	public Palya getPalya2()
	{
		return palya2;
	}
	
	public void kapuKeszE()
	{
		kapu=true;
		for (int i=0;i<palya1.getSor();i++)
			for (int o=0;o<palya1.getOszlop();o++)
			{
				if (o==0 || i==0 || o==palya1.getOszlop()-1 || i==palya1.getSor()-1)
				{
					if((palya1.getPalyaErtek(i, o).equals(Mezo.Ures)||palya1.getPalyaErtek(i, o).equals(Mezo.Kapu)) && kapu==true)
					{
						palya1.setPalyaErtek(o, i, Mezo.Kapu);
						palya1.setKapuX(o);
						palya1.setKapuY(i);
						if(o!=palya2.getBabuX() || i!=palya2.getBabuY())
							palya2.setPalyaErtek(o, i, Mezo.Kapu);
						kapu=false;
					}
					else 
					{					
						if(o!=palya2.getBabuX() || i!=palya2.getBabuY())
							palya2.setPalyaErtek(o, i, Mezo.Fal);
						palya1.setPalyaErtek(o, i, Mezo.Fal);
					}
				}
			}
	}

	
	public void beallit2(Mezo mezo, int x, int y)//beallit fuggveny hasznalja
	{
		palya2.setPalyaErtek(palya2.getBabuX(), palya2.getBabuY(), mezo);
		palya1.setPalyaErtek(palya2.getBabuX(), palya2.getBabuY(), mezo);
		palya2.setBabuY(palya2.getBabuY()+y);
		palya2.setBabuX(palya2.getBabuX()+x);
		palya2.setPalyaErtek(palya2.getBabuX(), palya2.getBabuY(), Mezo.Babu);
	}
	
	public void beallit( int x, int y)
	{
		if (elozo==0)
		{
			palya2.setPalyaErtek(palya2.getBabuX(), palya2.getBabuY(), palya1.minAllok(palya2.getBabuX(), palya2.getBabuY()));
			palya2.setBabuY(palya2.getBabuY()+y);
			palya2.setBabuX(palya2.getBabuX()+x);
			palya2.setPalyaErtek(palya2.getBabuX(), palya2.getBabuY(), Mezo.Babu);		
		}
		if (elozo==1)
			beallit2(Mezo.Ures,x,y);

		if (elozo==2)
			beallit2(Mezo.Kincs,x,y);
		
		if (elozo==3)
			beallit2(Mezo.Fal,x,y);
		
		if (elozo==4)
			beallit2(Mezo.Szorny,x,y);
		
		elozo=0;
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'w':
			if (palya2.getBabuY()-1>-1)
			{
				beallit(0,-1);
			}
			break;
		case 's':
			if (palya2.getBabuY()+1<palya2.getSor())
			{
				beallit(0,1);
			}
			break;
		case 'a':
			if (palya2.getBabuX()-1>-1)
			{
				beallit(-1,0);
			}
		break;
		case 'd':
			if (palya2.getBabuX()+1<palya2.getOszlop())
			{
				beallit(1,0);
			}
			break;
		case 'v':
			elozo=1;
			break;
		case 'b':
			elozo=2;
			break;
		case 'n':
			elozo=3;
			break;
		case 'm':
			elozo=4;
			break;
		case 'k':
			
			this.setVisible(false);
			palya1.szornyeketBeallit();
			//palya1.palyatKiir();
			palya1.babutElhelyez();
			//System.out.println("Kesz");
			JatekFrame frame=new JatekFrame(palya1);
			
			break;
		}
		
		kapuKeszE();
		this.invalidate();
		this.validate();
		this.repaint();
		

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
