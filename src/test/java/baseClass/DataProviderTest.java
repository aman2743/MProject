package baseClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider="Test")
	public void getData(String s1,String s2) {
    System.out.println(s1);
    System.out.println(s2);
	}

	@DataProvider(name = "Test")
	public Object[][] LoginTest() {
		Object[][] data = new Object[2][2];
		data[0][0] = "jsmith";
		data[0][1] = "demo1234";
		data[1][0] = "Test12";
		data[1][1] = "Test1234";
		return data;
	}
}
