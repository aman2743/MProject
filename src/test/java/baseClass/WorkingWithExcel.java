package baseClass;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

import io.github.bonigarcia.wdm.WebDriverManager;
public class WorkingWithExcel {
@Test (dataProvider="dataSupplier")
public void LoginTest(String uname, String pwd) throws InterruptedException {
//	public void LoginTest(String[] s) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.get("https://demo.testfire.net/login.jsp");
	Thread.sleep(2000);
	driver.findElement(By.id("uid")).sendKeys(uname);
	driver.findElement(By.id("passw")).sendKeys(pwd);
//	driver.findElement(By.id("uid")).sendKeys(s[0]);
//	driver.findElement(By.id("passw")).sendKeys(s[1]);
	driver.findElement(By.name("btnSubmit")).click();

	Thread.sleep(2000);
	driver.quit();
}


	@DataProvider(name="dataSupplier")
	public Object[][] ExcelUtil() throws IOException {
		File file = new File("C:\\Users\\Aman\\eclipse-workspace2\\MProject\\TestData\\TestDataFile.xlsx");
		System.out.println(file.exists());
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Sheet1");
		int rowcount = ws.getLastRowNum();
//    	int rowcount1=ws.getPhysicalNumberOfRows();
		
		System.out.println("Total Row=" + rowcount);
		int colcount = ws.getRow(0).getLastCellNum();
		System.out.println("Total Column=" + colcount);
		Object[][] obj=new Object[rowcount][colcount];

		for (int r = 0; r < rowcount; r++) {
			XSSFRow row = ws.getRow(r + 1);
			for (int c = 0; c < colcount; c++) {
				XSSFCell cell = row.getCell(c);
				System.out.print(cell);
				//Cell type - enum
		        org.apache.poi.ss.usermodel.CellType celltype = cell.getCellType();
				switch (celltype) {
				case STRING:
				obj[r][c]=cell.getStringCellValue();
					break;

				case BOOLEAN:
					obj[r][c]=cell.getBooleanCellValue();
					break;

				case NUMERIC:
					obj[r][c]=Integer.toString((int)cell.getNumericCellValue());
					break;
					
				default:
					System.out.println();
				}

			}
//			System.out.println();
			wb.close();
			fis.close();
		}
		return obj;
	}
}
