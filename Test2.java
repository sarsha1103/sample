package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test2 {
	public static void main(String[] args) throws IOException {
		//mention the excel file location
		File f = new File("C:\\Users\\PC\\eclipse-workspace\\FrameWork\\Excel\\ExcelRead.xlsx");
		
		//Read the file 
		FileInputStream fis = new FileInputStream(f);
		
		//workbook---> sheet --->rows ---> cells --->data
		
		//read the workbook (.xlxs excel)
		Workbook w = new XSSFWorkbook(fis);
		
		//get the sheet from workbook
		Sheet s = w.getSheet("testdata");
		
		//get the row from sheet
		//Row r = s.getRow(1);
		
		//get the cell from row 
		//Cell c = r.getCell(0);
		//System.out.println(c);
		
		//get total no of rows
		int noofRow = s.getPhysicalNumberOfRows();
		System.out.println(noofRow);
		
		//iterate all row
		for (int i = 0; i < noofRow; i++) {
			//get the row from sheet
			Row r = s.getRow(i);
			//iterate all cell in a particular row
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				//get the cell from row
				Cell c = r.getCell(j);
				
				//identify the cell type
				int cellType = c.getCellType();
				
				//cellType = 1 ---> String cell
				//cellType = 0 ---> numeric/date cell
				
				//get String cell value
				if (cellType==1) {
					String stringCellValue = c.getStringCellValue();
					System.out.println(stringCellValue);
				}
				//get Date cell value
				else if (DateUtil.isCellDateFormatted(c)) {
					Date d = c.getDateCellValue();
					//convert date from system format to user format
				    SimpleDateFormat dd = new SimpleDateFormat("dd-MMM-yyyy");
				    String value = dd.format(d);
					System.out.println(value);
				}
				//get Numeric cell value 
				else {
					double dec = c.getNumericCellValue();
					//excel  double  long  string
					//123 -->123.0--> 123 --> 123
					//double(parent)--->long(child)--->Downcasting
					
					
				}
				
			}
		}
}			

}



