package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")

	public String [][] getData() throws IOException
	{
		String path = ".\\testData\\LumaMagento_LoginData.xlsx";

		ExcelUtility xlutil = new ExcelUtility(path);

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[totalrows][totalcols];

		for(int i=1; i<totalrows; i++)			// 1 // Read the data from xl
		{
			for(int j=0; j<totalrows; j++)		// 0 // i is row j is col
			{
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);	// 1, 0
			}
		}

		return logindata;		// returning two dimension array

	}

	// DataProvider 2
	// DataProvider 3

}
