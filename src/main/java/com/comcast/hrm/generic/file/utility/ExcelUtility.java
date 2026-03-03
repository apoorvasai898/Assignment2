package com.comcast.hrm.generic.file.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheet, int row_num, int col_num) throws EncryptedDocumentException, IOException
	{
		String result = "";
		FileInputStream fis = new FileInputStream(".\\testData\\Ninza_HRM.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(row_num);
		Cell cel = row.getCell(col_num);
		
		result = cel.getStringCellValue();
		return result;
	}

}
