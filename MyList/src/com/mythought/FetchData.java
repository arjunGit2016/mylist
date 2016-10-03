package com.mythought;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FetchData  {

	 public static void main(String[] args) throws IOException {
	 
	String excelFilePath = "C:\\Users\\miracle\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\urldatabase.xlsx";
    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
    
    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
    Sheet firstSheet = workbook.getSheetAt(0);
    Iterator<Row> iterator = firstSheet.iterator();
    int update =0;
    
    while (iterator.hasNext()) {
        Row nextRow = iterator.next();
        Iterator<Cell> cellIterator = nextRow.cellIterator();
         
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
             
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                	//System.out.println(cell.getStringCellValue());
                   if(cell.getStringCellValue().equalsIgnoreCase("Java")){
                	   
                	   Iterator<Cell> cellItr = nextRow.iterator();
                	    while(cellItr.hasNext()){
                	        System.out.println(cellItr.next().toString());
                	    }
                	    
                	   update=1;
                	   
                   }
                    
                    break;
               
            }
            /*if(update==1){
            System.out.print(" - ");
            }*/
        }
         //if(update==1){
        System.out.println();
         //}
    }
     
    workbook.close();
    inputStream.close();
}
    
    
	 
	
}
