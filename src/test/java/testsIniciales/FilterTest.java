package testsIniciales;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import entities.ConfigEntity;
import entities.LibraryEntity;
import entities.TitleEntity;
import imp.LibraryImp;
import interfaces.Filter;
import interfaces.Label;

public class FilterTest
{

	@Test
	public void testGetLabels()
	{
		SetOfData sod = new SetOfData();
		List<TitleEntity> tel = sod.getTitles_sod1();
		LibraryEntity le = new LibraryEntity(new ConfigEntity(), tel);
		
		LibraryImp library = new LibraryImp(le, new ConfigEntity());
		
		Filter fGenero = library.getFilter("Genero");
		
		List<Label> labels = fGenero.getLabels();
		
		Assert.assertEquals("Rock",labels.get(0).getName());
		Assert.assertEquals("Pop",labels.get(1).getName());
		Assert.assertEquals("Alternativo",labels.get(2).getName());
	}

}
