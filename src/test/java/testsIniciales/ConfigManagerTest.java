package testsIniciales;

import core.ConfigManager;
import junit.framework.TestCase;

public class ConfigManagerTest extends TestCase
{
	public void testGetValue(){
		
		ConfigManager config=new ConfigManager();
		config.setDocument("/testResources/test-config.xml");
		assertEquals("testValor", config.getValue("test"));
	}
}
