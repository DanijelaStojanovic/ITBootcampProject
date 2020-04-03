package utils;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import org.apache.poi.hssf.usermodel.HSSFCell;
	import org.apache.poi.hssf.usermodel.HSSFRow;
	import org.apache.poi.hssf.usermodel.HSSFSheet;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.hssf.usermodel.*;
	
	public class ExcelUtils {
		
		//Class with methods for writing and reading Excel file with test data 
		
		private static HSSFWorkbook wb;
		private static HSSFSheet sheet;
		private static FileInputStream fi;
		private static String excelPath;
		
		
		public static void findExcelSheet() {
			try {
				fi = new FileInputStream("RegistrationData.xls");
				wb = new HSSFWorkbook(fi);
				sheet = wb.getSheetAt(0);
			} catch (IOException e) {
				System.out.print("Excel file cannot be found!");
				e.printStackTrace();
			}
		}

		public static boolean setExcel(String path) {
			if (wb != null) {
				try {
					wb.close();
				} catch (Exception e) {
					System.out.println(e.toString());
					return false;
				}
			}
			File f = new File(path);
			try {
				FileInputStream fis = new FileInputStream(f);
				wb = new HSSFWorkbook(fis);
				excelPath = path;
				return true;
			} catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("Failed to Open File!");
				return false;
			}
		}
		public static boolean setWorkSheet(int index) {
			try {
				sheet = wb.getSheetAt(index);
				return true;
			} catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("Failed to Open Worksheet!");
				return false;
			}
		}
		public static String getDataAt(int row, int column) {
			try {
				HSSFRow r = sheet.getRow(row);
				HSSFCell cell = r.getCell(column);
				if(cell.getCellType()==CellType.STRING) {
					return cell.toString();
				}else if(cell.getCellType()==CellType.NUMERIC) {
				return NumberToTextConverter.toText(cell.getNumericCellValue());	
				}
				return cell.toString();
			} catch (NullPointerException e) {
				System.out.println(e.toString());
				System.out.println("Value is NULL!");
			} catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("There is an error!");
			}
			return "";
		}
		public static boolean setDataAt(int row, int column, String data) {
			try {
				HSSFRow r = sheet.getRow(row);
				if (r == null) {
					r = sheet.createRow(row);
				}
				HSSFCell cell = r.getCell(column);
				if (cell == null) {
					cell = r.createCell(column);
				}
				cell.setCellValue(data);
				FileOutputStream fos = new FileOutputStream(excelPath);
				wb.write(fos);
				return true;
			} catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("There is an error!");
				return false;
			}
		}
		public static int getRowNumber() {
			try {
				return sheet.getLastRowNum() + 1;
			} catch (Exception e) {
				System.out.println(e.toString());
				System.out.println("There is an error!");
				return -1;
			}
		}
		public static boolean closeExcel() {
			if (wb != null) {
				try {
					wb.close();
					wb = null;
					return true;
				} catch (IOException e) {
					e.printStackTrace();
					wb = null;
					return false;
				}
			}
			return true;
		}
	}

