package com.datad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenWrite {

	public static void main(String[] args) throws Exception {
		
		
		File f = new File("C:\\Users\\LENOVO\\workspace\\DataDrivenTask\\excel\\ssr.xlsx");
		
		Workbook w = new XSSFWorkbook();
		
		Sheet s1 = w.createSheet("s1");
		
		Row row0 = s1.createRow(0);
		
		Cell cell01 = row0.createCell(1);
		cell01.setCellValue("data driven");
		
		FileOutputStream fo = new FileOutputStream(f);
		
		w.write(fo);
		
		

	}

}
