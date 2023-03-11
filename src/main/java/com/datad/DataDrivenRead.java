package com.datad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenRead {

	public static void main(String[] args) throws Exception {
		
		File f = new File("C:\\Users\\LENOVO\\workspace\\DataDrivenTask\\excel\\1234.xlsx");
		
		
		FileInputStream fi = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fi);
		
		Sheet sheet1 = w.getSheet("Sheet1");
		
	    
	    	Row row = sheet1.getRow(0);
	    	
	    	
	    		Cell ce= row.getCell(1);
	    		
	    		int cellType = ce.getCellType();
	    		
	    		if (cellType==1) {
	    			ce.getStringCellValue();
	    			
					
				} else if (DateUtil.isCellDateFormatted(ce)) {
					Date dd = ce.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd/mm/yyyy");
					String format = s.format(dd);
					
					
					
					
				} else {
					double numericCellValue = ce.getNumericCellValue();
					
					long l = (long) numericCellValue;
					String.valueOf(l);
				}
	    		
				
			
			
		
		
		
		
		
		
		
			
	}

}
