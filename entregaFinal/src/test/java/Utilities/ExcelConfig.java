package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
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

	@SuppressWarnings("incomplete-switch")
	public Object[][] readExcel() {
		XSSFRow Row = sh.getRow(0);
		int RowNum = sh.getPhysicalNumberOfRows();// cuento mi número de filas
		int ColNum = Row.getLastCellNum(); // obtengo la última columna
		Object data[][] = new Object[RowNum - 1][ColNum];
		DataFormatter format = new DataFormatter();
		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
		evaluator.evaluateAll();
		try {
			for (int i = 0; i < RowNum - 1; i++) // loop filas
			{
				XSSFRow row = sh.getRow(i + 1);

				for (int j = 0; j < ColNum; j++) // loop columnas
				{
					if (row == null)
						data[i][j] = "";
					else {
						Cell cell = row.getCell(j);
						if (cell == null)
							data[i][j] = "";
						else {
							CellValue cellValue = evaluator.evaluate(cell);
							CellType cellType = cell.getCellType();
							switch (cellType) {
							case NUMERIC:
								data[i][j] = String.valueOf((int)cell.getNumericCellValue());
								break;
							case STRING:
								data[i][j] = cell.getStringCellValue();
								break;
							case BLANK:
								break;
							case ERROR:
								break;
							case FORMULA:
								data[i][j] = cellValue.getStringValue();
								break;
							default:
								data[i][j] = cell.getStringCellValue();
								break;
							}
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
