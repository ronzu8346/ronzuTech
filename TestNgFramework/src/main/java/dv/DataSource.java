package dv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataSource {


	  @DataProvider(name= "somthing")
	  public Object[][] dp() {
		  //return new Object[][] {new Object[] { "userid1", "password1" },new Object[] { "userid2", "password2" }, };
		
		  
		  //Object [][]object= {{"userid","password"},{"userid","password"}};
		  //return object;
	    
		  
			
			  Object [][]obj=new Object[2][2]; 
			  obj[0][0]="userid1"; 
			  obj[0][1]="password1";
			  
			  obj[1][0]="userid2"; 
			  obj[1][1]="password2"; return obj;
			 
		
	  }
	  
	  @DataProvider(name="nrs")
	  public Object[][] nameAndRollNumber() {
			/*
			 * Object[][]ob=new Object[4][3]; ob[0][0]="rupa"; ob[0][1]="1";
			 * ob[0][2]="bittech";
			 * 
			 * 
			 * ob[1][0]="ronzu"; ob[1][1]="2"; ob[1][2]="qtech";
			 * 
			 * 
			 * ob[2][0]="moin";//name ob[2][1]="3";//roll number
			 * ob[2][2]="dilrubatech";//school name
			 * 
			 * 
			 * ob[3][0]="fahameda"; ob[3][1]="4"; ob[3][2]="banglatech"; return ob;
			 */
		  Object[][]ob= {{"name","phone","date of birth"},{"name","phone","date of birth"},{"name","phone","date of birth"},{"name","phone","date of birth"}};
		  return ob;
		  
	  }
	  @DataProvider(name="xldata")
	  public Object[][] getDtaFromxl() throws IOException  {
		  
		  FileInputStream file=new FileInputStream(new File("/Users/ronzu/eclipse-workspace/TestNgFramework/data.xlsx"));
		  XSSFWorkbook book=new XSSFWorkbook(file);
		  XSSFSheet sheet=book.getSheetAt(0);
		 // sheet.getRow(5).getCell(0).getStringCellValue();
		 int rs= sheet.getLastRowNum();
		 int cs= sheet.getRow(0).getLastCellNum();
		 
		 Object [][]object=new Object[rs][cs];
		 
		 for(int i=1;i<=rs; i++) {
			 for(int j=0;j<=cs;j++) {
				 
			XSSFCell cell= sheet.getRow(i).getCell(j);
			switch (cell.getCellType()) {
			case XSSFCell.CELL_TYPE_NUMERIC: object[i-1][j]=cell.getNumericCellValue();
			case XSSFCell.CELL_TYPE_STRING:  object[i-1][j]=cell.getStringCellValue();
			
			}
			 }
			 
		 }
		 
		 return object;
		  
	  }
	  
	  
	  
	  
	  
	  @DataProvider (name = "RONZU XLsx")
		public Object[][] getDatafromExcel()  {
			XSSFWorkbook book = null;
			FileInputStream file = null;
			try {
				file = new FileInputStream(
				new File("/Users/ronzu/eclipse-workspace/TestNgFramework/data.xlsx"));
				book = new XSSFWorkbook(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("File not found");
			}
			
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} if(book != null) {
				try {
					book.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
			XSSFSheet sheet = book.getSheetAt(0);
			
			//sheet.getRow(5).getCell(0).getStringCellValue();
			int rs = sheet.getLastRowNum();
			int cs = sheet.getRow(0).getLastCellNum();
			
			Object [][]object = new Object[rs][cs];
			
			for(int i = 1; i<=rs; i++) {
				
				for(int j = 0; j<=cs; j++) {
				
					XSSFCell cell  = sheet.getRow(i).getCell(j);
					switch (cell.getCellType()) {
					case XSSFCell.CELL_TYPE_NUMERIC:
						object[i-1][j] = cell.getNumericCellValue();
						
					case XSSFCell.CELL_TYPE_STRING:
						object[i-1][j] = cell.getStringCellValue();
					}	
				}
			}
			
			return object;
		}

	}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

