import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Teszt1 {
	
	Palya palya;

	@Before
	public void mindenekelott()
	{
		palya=new Palya(15,15,0,0,0,3);
	}
	
	@Test
	public void elso()
	{
		palya.setPalyaErtek(2,2,Mezo.Ures);
		palya.setPalyaErtek(2,5,Mezo.Ures);
		palya.setPalyaErtek(5,5,Mezo.Ures);

		assertEquals("elso", palya.hanyUresMezoVan(),3);

	}
	
	@Test
	public void masodik()
	{
		palya.setPalyaErtek(3,2,Mezo.Ures);
		palya.setPalyaErtek(3,4,Mezo.Ures);
		palya.setPalyaErtek(2,3,Mezo.Ures);

		assertEquals("masodik", palya.vajhate(3, 4, 0),0);
	}
	
	@Test
	public void harmadik()
	{
		palya.setPalyaErtek(5,5,Mezo.Kincs);
		palya.setPalyaErtek(10,3,Mezo.Ures);
		palya.setPalyaErtek(2,3,Mezo.Kincs);

		assertEquals("harmadik", palya.kincsekSzama(),2);
	}
	
	@Test
	public void negyedik()
	{
		palya.setPalyaErtek(5,5,Mezo.Kincs);
		palya.setPalyaErtek(10,3,Mezo.Ures);
		palya.setPalyaErtek(2,3,Mezo.Szorny);
		palya.babutElhelyez();
		//System.out.println(palya.getPalyaErtek(3, 10));
		assertEquals("negyedik", palya.getPalyaErtek(3, 10),Mezo.Babu);
	}
	
	@Test
	public void otodik()
	{
		palya.setPalyaErtek(2,3,Mezo.Ures);
		palya.babutElhelyez();
		palya.setPalyaErtek(10,3,Mezo.Kapu);

		assertEquals("otodik", palya.minAllok(10, 3),Mezo.Kapu);
	}
	
	@Test
	public void hatodik()
	{
		
		palya.setPalyaErtek(2,3,Mezo.Szorny);
		palya.setPalyaErtek(10,3,Mezo.Kapu);
		palya.szornyeketBeallit();
		palya.setPalyaErtek(5,5,Mezo.Szorny);

		assertEquals("hatodik", palya.getSzornyekSzama(),1);
	}
	
	@Test
	public void hetedik()
	{
		
		palya.setPalyaErtek(2,3,Mezo.Szorny);
		palya.setPalyaErtek(2,4,Mezo.Ures);
		palya.setPalyaErtek(2,5,Mezo.Babu);
		palya.setBabuX(2);
		palya.setBabuY(5);
		palya.leptetSegit(0, -1);

		assertEquals("hetedik", palya.getPalyaErtek(4, 2),Mezo.Babu);
	}
	
	@Test
	public void nyolcadik()
	{
		PalyatCsinal pcs=new PalyatCsinal(15,15);
		pcs.getPalya().setPalyaErtek(0,3,Mezo.Szorny);
		pcs.getPalya().setPalyaErtek(0,4,Mezo.Ures);
		pcs.getPalya().setPalyaErtek(0,5,Mezo.Babu);
		pcs.getPalya().setBabuX(0);
		pcs.getPalya().setBabuY(5);
		pcs.kapuKeszE();

		assertEquals("nyolcadik", pcs.getPalya().getPalyaErtek(5, 0),Mezo.Fal);
	}
	
	@Test
	public void kilencedik()
	{
		PalyatCsinal pcs=new PalyatCsinal(15,15);
		pcs.getPalya2().setPalyaErtek(3,3,Mezo.Szorny);
		pcs.getPalya2().setPalyaErtek(3,4,Mezo.Ures);
		pcs.getPalya2().setPalyaErtek(3,5,Mezo.Babu);
		pcs.getPalya2().setBabuX(3);
		pcs.getPalya2().setBabuY(5);
		pcs.beallit2(Mezo.Ures, 0, -1);

		assertEquals("kilencedik", pcs.getPalya().getPalyaErtek(5, 3),Mezo.Ures);
	}
	
	@Test
	public void tizedik()
	{
		KezdoPanel kp=new KezdoPanel();

		assertEquals("tizedik", kp.szazalekBeallitas(15),50);
	}
	
}




