package com.vyasa.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DataFromXls {
	static String  filepath=".\\TestData\\TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	static  DataFormatter formatter=new DataFormatter() ;
	 @Test
	  public static Object[][] getDataFromXls(String sheetName) throws EncryptedDocumentException, InvalidFormatException {
		  FileInputStream file=null;
		  try
		  {
			  file=new FileInputStream(filepath);
			  
		  }catch(FileNotFoundException e)
		  {
	    e.printStackTrace();		  
		 }
	try {
	  book=WorkbookFactory.create(file);	
	}catch(IOException e) {
			e.printStackTrace();
	}
	sheet =book.getSheet(sheetName);
	int rows=sheet.getLastRowNum();
	int cols=sheet.getRow(0).getLastCellNum();
	Object[][] data=new Object[rows][cols];
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<cols;j++)
		{
			Cell cell=sheet.getRow(i+1).getCell(j);
			data[i][j]=formatter.formatCellValue(cell);
		}
	}	
	return data;
 } 
}
