package com.infi.acemoney.basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	//FileInputStream, XSSFWorkbook, XSSFSheet
	//getSheet, getRow, getCell, getLastRowNum, getLastCellNum

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\DDF.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sh=wb.getSheet("Sheet2");
		
		int rowsize=sh.getLastRowNum();
		
		System.out.println(rowsize+1);
		
		
		int colsize=sh.getRow(7).getLastCellNum(); 
		
		System.out.println(colsize);
		
		
		String data=sh.getRow(4).getCell(1).getStringCellValue();
		
		System.out.println(data);
		
		String data1=sh.getRow(7).getCell(0).getStringCellValue();
		
		System.out.println(data1);
		}
	
}
