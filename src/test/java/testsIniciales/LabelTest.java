package testsIniciales;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import entities.ConfigEntity;
import entities.LabelEntity;
import entities.LibraryEntity;
import imp.LabelImp;
import interfaces.Label;

public class LabelTest
{
	@Test
	public void testGetName()
	{
		SetOfData sod = new SetOfData();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), sod.getTitles_sod1());
		
		Label la = new LabelImp(le, "Genero", "Rock");

		Assert.assertEquals("Rock", la.getName());
	}
	
	@Test
	public void testGetTitles()
	{
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void testGetSublabels()
	{
		Assert.assertEquals(true, false);
	}
}
