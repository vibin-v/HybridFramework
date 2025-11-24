package dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviders {
	
	@DataProvider(name="loginCredential")
	public Object[][] getDataFromExcel() throws IOException
	{
		System.out.println("Log Info:- Data Provider Getting ready for Test Data");
		Object[][] excelData = ExcelUtility.readExcelData("C:\\Users\\VibinVijayakumar\\eclipse-workspace\\Selenium\\com.orangeHRM\\TestData\\Userdetails.xlsx","credentials");
		return excelData;
	}
}
