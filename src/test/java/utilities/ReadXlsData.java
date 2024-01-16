package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXlsData {

	@DataProvider(name="sauceDemoTestData")
	public String[][] getData(Method m)
	{
		
		try {
			String exclSheetName = m.getName();
			System.out.println(exclSheetName);
			
			//Get the file from its location.
			File workbook = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\sauceDemoLoginTestData.xlsx");
			System.out.println(workbook.getName());
						
			FileInputStream inputStream = new FileInputStream(workbook);
			
			Workbook wb = WorkbookFactory.create(inputStream);
			
			Sheet sheetName = wb.getSheet(exclSheetName);
			
			int totalRows = sheetName.getLastRowNum();
			Row rowCells = sheetName.getRow(0);
			int totalCols = rowCells.getLastCellNum();
			
			DataFormatter format = new DataFormatter();
			
			String testData[][] = new String[totalRows][totalCols];
			for(int i=1; i<=totalRows;i++)
			{
				for(int j=0;j<totalCols;j++)
				{
					testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
					
				}
			}
			
			return testData;
					
		} catch (IOException | EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
