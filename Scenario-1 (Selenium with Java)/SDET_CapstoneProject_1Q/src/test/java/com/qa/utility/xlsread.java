package com.qa.utility;

import java.io.FileInputStream; 
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsread { 
	// will using 6 variables
public FileInputStream fi;
public XSSFWorkbook workbook;
public XSSFSheet sheet;
public XSSFRow row;
public XSSFCell cell;
String path;

//take the path in the constructer

public xlsread(String path1)
{
	this.path=path1;
}
public int getRowCount (String sheetname) throws IOException
{
	fi =new FileInputStream(path);
    workbook =new XSSFWorkbook (fi);
    sheet =workbook.getSheet (sheetname);
    int rowcount=sheet.getLastRowNum(); 
    workbook.close();
    fi.close(); 
    return rowcount;
}

    public int getColCount (String sheetname, int rownumber) throws IOException
    {
    fi=new FileInputStream(path);
    workbook =new XSSFWorkbook (fi);
    sheet =workbook.getSheet (sheetname);
    row=sheet.getRow(rownumber);
    int colcount=row.getLastCellNum();
    workbook.close();
    fi.close(); 
    return colcount;
    }
    
    public String getCellData(String sheetname, int rownumber, int colnumber) throws IOException
    {
    fi=new FileInputStream(path); 
    workbook =new XSSFWorkbook (fi);
    sheet =workbook.getSheet (sheetname);
    row =sheet.getRow(rownumber); 
    cell=row.getCell(colnumber);
    //what to check this particular contains which type of value so use dataformatter
    DataFormatter df=new DataFormatter();
    String data;

    try {
    	data=df.formatCellValue(cell); ////whataever the value i have reacievd fro cell sheet that it will be formatted on top that particular value and it will store in string format data attribute not data variable
    	} catch (Exception e) {
    	data="";  //where thetre is exception, data=empty
    	}

    	return data;
    }
}