package testsIniciales;

import entities.LabelEntity;
import entities.LibraryEntity;
import imp.LabelImp;
import interfaces.Label;
import junit.framework.TestCase;

public class LabelTest extends TestCase
{

	public void test(){
		String labelName = "Rock";
		LibraryEntity lie = new LibraryEntity();
		LabelEntity le = new LabelEntity(labelName);
		Label l = new LabelImp(lie, le);
		assertEquals(labelName, l.getName());
	}
}
