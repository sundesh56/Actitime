package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseClass;
import generic.Utility;

public class Test1 extends BaseClass {
	@Test
	public void test1() throws Exception{
		
		String title = driver.getTitle();
		Reporter.log(title,true);
		
		
		String v = Utility.getXLData("./data/TestData.xlsx", "Test1", 0, 0);
		Reporter.log(v, true);
	}

}
