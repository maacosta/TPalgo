package test;

import imp.LabelImp;
import junit.framework.TestCase;

public class LabelTest extends TestCase
{

	public void test(){
		LabelImp l = new LabelImp("Rock");
		assertEquals("Rock",l.getName());
	}
}
