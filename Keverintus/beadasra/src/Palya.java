import java.io.Serializable;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Random;

enum Mezo{Kincs, Fal, Szorny, Ures, Babu, Kapu};

public class Palya implements Serializable{

	private int szornyekSzama;
	private double uresMezok;
	private int kincsekSzama;
	private int labirintusSuruseg;
	
	private int[][] szornyek;//x, y
	
	private int oszlop;
	private int sor;
	private ArrayList<ArrayList<Mezo>> palya;
	
	private int kapuX;
	private int kapuY;
	private int babuX;
	private int babuY;
	
	
	Palya (int i, int j, int szornyekSzama, int uresMezok, int kincsekSzama, int labirintusSuruseg)
	{
		palya=new ArrayList<>();
		oszlop=i;
		sor=j;
		
		for(int k=0;k<oszlop;k++)
		{
			ArrayList<Mezo> uj=new ArrayList<>();
			for (int kk=0;kk<sor;kk++)
			{
				uj.add(Mezo.Fal);
			}
			palya.add(uj);
		}
		babuX=-1;
		babuY=-1;

		this.szornyekSzama=szornyekSzama;
		szornyek=new int[szornyekSzama][2];
		
		this.uresMezok=((((double)uresMezok)/100))*oszlop*sor;
		this.kincsekSzama=kincsekSzama;
		this.labirintusSuruseg=labirintusSuruseg;
	}
	
	public Mezo getPalyaErtek(int y, int x)
	{
		return palya.get(y).get(x);
	}
		
	public int kaputAllit()
	{
		Random random=new Random();
		int r=-1;
		while (r<0)
		r=random.nextInt((2*(oszlop+sor)-8));//negativ szamokat is megenged
		//r=24;
		
		if (r<oszlop-2)
		{
			kapuX=r+1;
			kapuY=0;
			palya.get(kapuY).set(kapuX, Mezo.Kapu);
			return 1;
		}
		if (oszlop-2<=r && r<(sor+oszlop-4))
		{
			kapuX=0;
			kapuY=r-oszlop+2+1;//+1 ofset
			palya.get(kapuY).set(kapuX, Mezo.Kapu);
			return 2;
		}
		if (sor+oszlop-4<=r && r<(sor+sor+oszlop-6))
		{
			kapuX=oszlop-1;
			kapuY=r-sor-oszlop+5;
			palya.get(kapuY).set(kapuX, Mezo.Kapu);
			return 3;
		}
		if (sor+sor+oszlop-6<=r)
		{
			kapuX=r-2*sor-oszlop+7;
			kapuY=sor-1;
			palya.get(kapuY).set(kapuX, Mezo.Kapu);
			return 0;
		}
		return 66;
	}
	
	public int getKapuX()
	{
		return kapuX;
	}
	
	public int getKapuY()
	{
		return kapuY;
	}

	public void setKapuX(int x)
	{
		kapuX=x;
	}
	
	public void setKapuY(int x)
	{
		kapuY=x;
	}
	
	public int vajhate(int x, int y, int c)
	{
		int suruseg=labirintusSuruseg;
			if (c==0)//w
			{
				if (x!=oszlop-1 && x!=0 && y-1!=0)
				{
					if(hanyUresSzomszedVan(x,y-1)<suruseg || palya.get(y-1).get(x).equals(Mezo.Ures))
						return 1;
				}
			}
			if (c==1)//s
			{
				if (x!=oszlop-1 && x!=0 && y+1!=sor-1)
				{
					if(hanyUresSzomszedVan(x,y+1)<suruseg || palya.get(y+1).get(x).equals(Mezo.Ures))
						return 1;
				}
			}
			if (c==3)//a
			{
				if (x-1!=0 && y!=sor-1 && y!=0)
				{
					if(hanyUresSzomszedVan(x-1,y)<suruseg || palya.get(y).get(x-1).equals(Mezo.Ures))
						return 1;
				}
			}
			if (c==2)//d
			{
				if (x+1!=oszlop-1 && y!=sor-1 && y!=0)
				{
					if(hanyUresSzomszedVan(x+1,y)<suruseg || palya.get(y).get(x+1).equals(Mezo.Ures))
						return 1;
				}
			}
			return 0;//nem mehet arra
	}
	
	public int hanyUresSzomszedVan(int x, int y)
	{
		int szamlalo=0;
		if (palya.get(y+1).get(x).equals(Mezo.Ures))
			szamlalo++;
		if (palya.get(y-1).get(x)==Mezo.Ures)
			szamlalo++;
		if (palya.get(y).get(x+1)==Mezo.Ures)
			szamlalo++;
		if (palya.get(y).get(x-1)==Mezo.Ures)
			szamlalo++;
		
		return szamlalo;
	}
	
	public void palyatIr() 
	{
		int irany=kaputAllit();
		int x=kapuX;//x, y futo valtozok
		int y=kapuY;
		int uresekSzama=0;
		while (uresekSzama<uresMezok)
		{
			if (vajhate(x,y,irany)==1)
			{
				if (irany==0)
					y=y-1;
				if (irany==1)
					y=y+1;
				if (irany==3)
					x=x-1;
				if (irany==2)
					x=x+1;
				if (palya.get(y).get(x).equals(Mezo.Fal))
					uresekSzama++;
				palya.get(y).set(x,Mezo.Ures);
				
			}
			

			Random random=new Random();
			//while (irany<0)
			irany=random.nextInt(10000)%4;//nem optimalis		
			//System.out.println(x +" " + y + " " + irany);
		}
	}
	
	public void palyatKiir()
	{
		for (int i=0;i<oszlop;i++)
		{
			System.out.println(palya.get(i));
		}
	}

	public int hanyUresMezoVan()
	{
		int szamlalo=0;
		for (int i=0;i<oszlop;i++)
			for (int o=0;o<sor;o++)
				if (palya.get(o).get(i).equals(Mezo.Ures))
					szamlalo++;
			
		return szamlalo;
	}
	
	public void babutElhelyez()
	{
		Random r=new Random();
		int hely=hanyUresMezoVan();
		if (hely==0)
			throw new EmptyStackException();
		hely=r.nextInt()%(hely);
		//System.out.println(hely);
		if (hely<0)
			hely=hely*-1;
		//hely=hely-1;
		//System.out.println(hely);
		
		
		int szamlalo=0;
		for (int i=0;i<oszlop;i++)
			for (int o=0;o<sor;o++)
				if (palya.get(o).get(i).equals(Mezo.Ures))
					{
						if (szamlalo==hely)
						{
							palya.get(o).set(i, Mezo.Babu);
							babuX=i;
							babuY=o;
						}
						szamlalo++;
					}
		
	}
	
	public void leptetSegit(int x, int y)
	{
		if (palya.get(babuY+y).get(babuX+x).equals(Mezo.Ures))
		{
			palya.get(babuY).set(babuX, Mezo.Ures);
			babuY=babuY+y;
			babuX=babuX+x;
			palya.get(babuY).set(babuX, Mezo.Babu);
		}else
		if (palya.get(babuY+y).get(babuX+x).equals(Mezo.Kincs))
		{
			palya.get(babuY).set(babuX, Mezo.Ures);
			babuY=babuY+y;
			babuX=babuX+x;
			palya.get(babuY).set(babuX, Mezo.Babu);
		}else
		if (palya.get(babuY+y).get(babuX+x).equals(Mezo.Kapu))
		{
			palya.get(babuY).set(babuX, Mezo.Ures);
			babuY=babuY+y;
			babuX=babuX+x;
			palya.get(babuY).set(babuX, Mezo.Babu);
		}else
		if (palya.get(babuY+y).get(babuX+x).equals(Mezo.Szorny))
		{
			palya.get(babuY).set(babuX, Mezo.Ures);
			babuY=babuY+y;
			babuX=babuX+x;
			palya.get(babuY).set(babuX, Mezo.Szorny);
		
			babuX=-1;
			babuY=-1;
			System.out.println("Szornyel talalkozott a babu");
		}
	}
	
	public void leptet(Irany irany)
	{
		switch (irany) {
		case Fel:
			leptetSegit(0, -1);
			
			break;
		case Le:
			leptetSegit(0, 1);
			break;
		case Jobbra:
			leptetSegit(1,0);
			break;
		case Balra:
			leptetSegit(-1,0);
			break;
		}
		//palyatKiir();
	}

	public void szornyeketLerak()
	{
		Random r=new Random();
		for (int i=0;i<szornyekSzama;i++)
		{
			int szamlalo=0;
			int szam=r.nextInt()%hanyUresMezoVan();
			if (szam<0)
				szam=szam*(-1);
			
			for (int j=0;j<sor;j++)
				for (int o=0;o<oszlop;o++)
					if (palya.get(j).get(o).equals(Mezo.Ures))
					{
						if (szamlalo==szam)
						{
							palya.get(j).set(o, Mezo.Szorny);
							szornyek[i][0]=j;
							szornyek[i][1]=o;
						}
						szamlalo++;		
					}
		}
	}
	
	public void kincseketLerak()
	{
		Random r=new Random();
		for (int i=0;i<kincsekSzama;i++)
		{
			int szamlalo=0;
			int szam=r.nextInt()%hanyUresMezoVan();
			if (szam<0)
				szam=szam*(-1);

			for (int j=0;j<sor;j++)
				for (int o=0;o<oszlop;o++)
					if (palya.get(j).get(o).equals(Mezo.Ures))
					{
						if (szamlalo==szam)
							palya.get(j).set(o, Mezo.Kincs);						
						szamlalo++;
					}
		}
	}

	public void szornyetLeptet()
	{
		for (int i=0;i<szornyekSzama;i++)
		{
			Random r=new Random();
			int irany=r.nextInt()%4;
			if (irany<0)
				irany=irany*(-1);

			switch (irany) {
			case 0:
				if (//palya.get(szornyek[i][0]+1).get(szornyek[i][1]).equals(Mezo.Babu) ||
						palya.get(szornyek[i][0]+1).get(szornyek[i][1]).equals(Mezo.Ures)) {
					palya.get(szornyek[i][0]+1).set(szornyek[i][1], Mezo.Szorny);
				palya.get(szornyek[i][0]).set(szornyek[i][1], Mezo.Ures);
				szornyek[i][0]++;
				//System.out.println("Le");
				}
				break;
			case 1:
				if (//palya.get(szornyek[i][0]-1).get(szornyek[i][1]).equals(Mezo.Babu) ||
						palya.get(szornyek[i][0]-1).get(szornyek[i][1]).equals(Mezo.Ures)) {
					palya.get(szornyek[i][0]-1).set(szornyek[i][1], Mezo.Szorny);
				palya.get(szornyek[i][0]).set(szornyek[i][1], Mezo.Ures);
				szornyek[i][0]--;
				//System.out.println("Fel");

				}
				break;
			case 2:
				if (//palya.get(szornyek[i][0]).get(szornyek[i][1]+1).equals(Mezo.Babu) ||
						palya.get(szornyek[i][0]).get(szornyek[i][1]+1).equals(Mezo.Ures)) {
					palya.get(szornyek[i][0]).set(szornyek[i][1]+1, Mezo.Szorny);
				palya.get(szornyek[i][0]).set(szornyek[i][1], Mezo.Ures);
				szornyek[i][1]++;
				//System.out.println("Jobbra");

				}
				break;
			case 3:
				if (//palya.get(szornyek[i][0]).get(szornyek[i][1]-1).equals(Mezo.Babu) ||
						palya.get(szornyek[i][0]).get(szornyek[i][1]-1).equals(Mezo.Ures)) {
					palya.get(szornyek[i][0]).set(szornyek[i][1]-1, Mezo.Szorny);
				palya.get(szornyek[i][0]).set(szornyek[i][1], Mezo.Ures);
				szornyek[i][1]--;
				//System.out.println("Balra");

				}
				break;			
			}		
		}
	}
	
	public int kincsekSzama()
	{
		int szamlalo=0;
		for (int i=0;i<sor;i++)
		{
			for (int o=0;o<oszlop;o++)
			{
				if (palya.get(i).get(o).equals(Mezo.Kincs))
					szamlalo++;
			}
		}
		return szamlalo;
	}

	public int getBabuX()
	{
		return babuX;
	}
	
	public int getBabuY()
	{
		return babuY;
	}

	public int getSor()
	{
		return sor;
	}
	
	public int getOszlop()
	{
		return  oszlop;
	}
	
	public int getSzornyekSzama()
	{
		return szornyekSzama;
	}
	
	public int getKincsekSzama()
	{
		return kincsekSzama;
	}
	
	public void setBabuX(int x)
	{
		babuX=x;
	}
	
	public void setBabuY(int y)
	{
		babuY=y;
	}
	
	public void setPalyaErtek(int x, int y, Mezo m)
	{
		palya.get(y).set(x, m);
	}
	
	public Mezo minAllok(int x, int y)
	{
		return palya.get(y).get(x);
	}

	public void szornyeketBeallit()
	{
		szornyekSzama=0;
		for (int i=0;i<sor;i++)
			for (int j=0;j<oszlop;j++)
			{
				if (palya.get(i).get(j).equals(Mezo.Szorny))
					szornyekSzama++;

			}
		szornyek=new int[szornyekSzama][2];
		
		szornyekSzama=0;
		for (int i=0;i<sor;i++)
			for (int j=0;j<oszlop;j++)
			{
				if (palya.get(i).get(j).equals(Mezo.Szorny))
				{
					szornyek[szornyekSzama][0]=i;
					szornyek[szornyekSzama][1]=j;
					szornyekSzama++;
				}
			}	
	}
	
	
	
	
	
}










