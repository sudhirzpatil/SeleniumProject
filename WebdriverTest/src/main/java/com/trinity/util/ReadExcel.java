package com.trinity.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.util.impl.constants;


public class ReadExcel implements constants{
	
	@SuppressWarnings("deprecation")
	public static Object[][] fileDataProvider(String testCaseName) {

		try {
			System.out.println("Path: "+System.getProperty("user.dir"));
			System.out.println("testCaseName: "+testCaseName);
			XSSFWorkbook workbook = new XSSFWorkbook(System.getProperty("user.dir") +"\\OIM_CertData1.xlsx");
			System.out.println("Path: "+workbook.toString());
			//XSSFWorkbook workbook = new XSSFWorkbook("D://Intuit_UI_Project//OIM_CreateCertFlow//OIM_CreateCert//OIM_CertData.xlsx");
			XSSFSheet sheet;
			if(null!=testCaseName && !testCaseName.isEmpty() && testCaseName.equals(loadUserData)){
				sheet = workbook.getSheet(userSheetName);
			}else if (null!=testCaseName && !testCaseName.isEmpty() && testCaseName.equals(loadTestSpecificUserData)){
				sheet = workbook.getSheet(testSpecificUserSheetName);
			}else {
				sheet = workbook.getSheet(dataSheetName);
			}

			Iterator<Row> rowIterator = sheet.iterator();
			ArrayList<ArrayList<String>> rowdata = new ArrayList<ArrayList<String>>();

			boolean isHeader = true;

			while (rowIterator.hasNext()) {
				ArrayList<String> columndata = new ArrayList<String>();
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (row.getRowNum() > 0) { // To filter column headings

						isHeader = false;
						
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
							columndata.add(cell.getStringCellValue());
						} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
							columndata.add(cell.getBooleanCellValue() + "");
						}else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
							if(HSSFDateUtil.isCellDateFormatted(cell)){
								SimpleDateFormat formatter;
								if(testCaseName.equals("ITG_WEBUI_OIM_TrackRequests005")){
									formatter = new SimpleDateFormat(Setup.prop.getProperty("dateFormatTrackRequests005"));
								}
								else{
								 formatter = new SimpleDateFormat(Setup.prop.getProperty("dateFormat"));
								}
								String formattedDate = formatter.format(cell.getDateCellValue());
								columndata.add(formattedDate);
							}else{
								columndata.add(cell.getNumericCellValue() + "");
							}
						}
					}
				}

				if (isHeader == false) {
					rowdata.add(columndata); // to make sure we don't add an
												// empty array for header row
				}
			}

			workbook.close();

			String[][] return_array = new String[rowdata.size()][];
			for (int i = 0; i < rowdata.size(); i++) {
				ArrayList<String> row = rowdata.get(i);
				if(!row.isEmpty() && row.size()>0 && row.get(0).equals(testCaseName) && !testCaseName.equals(loadUserData)){
					row.remove(0);
					return_array[i] = row.toArray(new String[row.size()]);
					//System.out.println("testcase name: "+testCaseName);
				}else if(testCaseName.equals(loadUserData)){
					System.out.println("row.toArray(new String[row.size()])"+row.toArray(new String[row.size()]));
					return_array[i] = row.toArray(new String[row.size()]);
				}else if(testCaseName.equals(loadTestSpecificUserData)){
					System.out.println("row.toArray(new String[row.size()])"+row.toArray(new String[row.size()]));
					return_array[i] = row.toArray(new String[row.size()]);
				}
			}
			
			return return_array;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}
