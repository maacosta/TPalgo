package testsIniciales;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import entities.ConfigEntity;
import entities.LabelEntity;
import entities.LibraryEntity;
import imp.LabelImp;
import interfaces.Label;
import interfaces.Title;

public class LabelTest
{
	@Test
	public void testGetName()
	{
		SetOfData sod = new SetOfData();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), sod.getTitles_sod1());
		
		Label la = new LabelImp(le, "Genero", "Rock", new ConfigEntity());

		Assert.assertEquals("Rock", la.getName());
	}
	
	@Test
	public void testGetTitles()
	{
		SetOfData sod = new SetOfData();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), sod.getTitles_sod1());
		
		Label la = new LabelImp(le, "Genero", "Rock", new ConfigEntity());

		List<Title> t = la.getTitles();
		
		Assert.assertEquals("Disco 1",t.get(0).getName());
		Assert.assertEquals("Disco 2",t.get(1).getName());
	}

}
