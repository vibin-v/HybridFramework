package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtility {
	

	public static Object[][] readExcelData(String filePath,String sheetName) throws IOException
	{
		File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook excelWorkBook = new XSSFWorkbook(fis);
		XSSFSheet excelSheet = excelWorkBook.getSheet(sheetName);
		
		int rowCount = excelSheet.getPhysicalNumberOfRows();
		int colCount = excelSheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] cellData = new Object[rowCount][colCount];
		
		for(int i=0;i<rowCount;i++)
		{
			Row row = excelSheet.getRow(i);
					for(int j=0;j<colCount;j++)
					{
						Cell cell = excelSheet.getRow(i).getCell(j);

						switch (cell.getCellType())
						{
							case STRING:
								cellData[i][j] = cell.getStringCellValue();
								break;
							case NUMERIC:
								cellData[i][j] =  cell.getNumericCellValue();
								break;
							case BOOLEAN:
								cellData[i][j] = cell.getBooleanCellValue();
								break;
							default:
								break;
						}
					}
		}
				
				return cellData;
	}
}
