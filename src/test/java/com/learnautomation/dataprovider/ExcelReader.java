package com.learnautomation.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	XSSFWorkbook wb;
	
	public static Object[][] getDataFromExcel(String sheetName){
		
		System.out.println("LOG-INFO- Generating Test data");
		
		ExcelReader excel =new ExcelReader();
		
		int row =excel.getRows("sheetName");
		int column=excel.getColumns("sheetName");
		Object[][] arr =new Object[row][column];
		for(int i=0;i<row;i++)
		{
			for (int j=0;j<column;j++) {
				arr[i][j]=excel.getData("sheetName", i, j);
				
			}
		}
		System.out.println("LOG-INFO- Test data Generated");
		return arr;
		
	}

	public ExcelReader() {
		
		System.out.println("Loading excel for test data");
		try {
			wb = new XSSFWorkbook(
					new FileInputStream(new File(System.getProperty("user.dir") + "/TestData/Data.xlsx")));
		} catch (FileNotFoundException e) {

			System.out.println("File Not found " + e.getMessage());
			;
		} catch (IOException e) {

			System.out.println("Conld not Load the file " + e.getMessage());
		}
		
		System.out.println("Loaded excel for test data");

	}

	public int getRows(String sheetName) {

		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}

	public int getColumns(String sheetName) {

		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	}

	public int getColumns(String sheetName, int rownumber) {

		return wb.getSheet(sheetName).getRow(rownumber).getPhysicalNumberOfCells();
	}
	
	public String getData(String sheetName,int row,int column) {
		
		String data ="";
		XSSFCell cell =wb.getSheet(sheetName).getRow(row).getCell(column);
		if(cell.getCellType()==CellType.STRING) {
			data= cell.getStringCellValue();
		}
		else if (cell.getCellType()==CellType.NUMERIC) 
		{
			data=String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==CellType.BLANK){
			data=" ";
			
		}
		
		
		return data;
		
	}

}
