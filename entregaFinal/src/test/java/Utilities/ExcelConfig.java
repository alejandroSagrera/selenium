package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;

	public ExcelConfig(String sourcePath) {
		try {
			File pathSrc = new File(sourcePath);
			fis = new FileInputStream(pathSrc);
			wb = new XSSFWorkbook(fis);
			sh = wb.getSheetAt(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Object[][] readExcel() {
		int rows = sh.getLastRowNum();
		XSSFRow Row = sh.getRow(0);
		int RowNum = sh.getPhysicalNumberOfRows();// count my number of Rows
		int ColNum = Row.getLastCellNum(); // get last ColNum
		Object data[][] = new Object[RowNum - 1][ColNum];
		DataFormatter format = new DataFormatter();
		try {
			for (int i = 0; i < RowNum - 1; i++) // Loop work for filas
			{
				XSSFRow row = sh.getRow(i + 1);

				for (int j = 0; j < ColNum; j++) // Loop work for columnas
				{
					if (row == null)
						data[i][j] = "";
					else {
						XSSFCell cell = row.getCell(j);
						if (cell == null)
							data[i][j] = "";
						else {
							String value = format.formatCellValue(cell);
							data[i][j] = value;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return data;
	}
}
