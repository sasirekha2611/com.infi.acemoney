package com.infi.acemoney.DDF;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	FileInputStream fis;
	
	XSSFWorkbook wb;
	
	XSSFSheet sh;
	
	public ReadExcel(String path)
	{
		try
		{
		fis=new FileInputStream(path);
		
		wb=new XSSFWorkbook(fis);
		
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public int totalrows(String sheet)
	{
		sh=wb.getSheet(sheet);
		
		int rows=sh.getLastRowNum()+1;
		
		return rows;
	}
	
	
	public int totalcolumns(String sheet)
	{
		int cols = 0;
		
		sh=wb.getSheet(sheet);
		
		for(int i=0 ;i<sh.getLastRowNum(); i++)
		{
			cols=sh.getRow(i).getLastCellNum();
			
		}
		
		return cols;
	}
	
	public String getData(String sheetName, int row, int col)
	{
	
		  sh= wb.getSheet(sheetName);
		  
		  String data=sh.getRow(row).getCell(col).getStringCellValue();
		  
		  return data;
		  
		  
	}

}
