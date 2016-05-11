package testsIniciales;

import entities.ConfigEntity;
import entities.LabelEntity;
import entities.LibraryEntity;
import imp.LabelImp;
import interfaces.Label;
import junit.framework.TestCase;

public class LabelTest extends TestCase
{

	public void test(){
		String labelName = "Rock";
		LibraryEntity lie = new LibraryEntity(new ConfigEntity(), null);
		LabelEntity le = new LabelEntity(labelName);
		Label l = new LabelImp(lie, le.Nombre);
		assertEquals(labelName, l.getName());
	}
}
