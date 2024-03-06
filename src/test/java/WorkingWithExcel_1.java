import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WorkingWithExcel_1 {
	@Test
	public void ExcelUtil() throws IOException {
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

		for (int r = 0; r < rowcount; r++) {
			XSSFRow row = ws.getRow(r + 1);
			for (int c = 0; c < colcount; c++) {
				XSSFCell cell = row.getCell(c);
				System.out.print(cell);
				//Cell type - enum
				CellType celltype = cell.getCellType();
				switch (celltype) {
				case STRING:
					cell.getStringCellValue();
					break;

				case BOOLEAN:
					cell.getBooleanCellValue();
					break;

				case NUMERIC:
					Integer.toString((int)cell.getNumericCellValue());
					break;
					
				default:
					System.out.println();
				}

			}
			System.out.println();
			wb.close();
			fis.close();
		}
	}
}
