package operateExcel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

/**
 * 获取excel中的所有数据
 */
public class OperateExcelTest {
    public static void main(String[] args) {
        String excelPath = "C:\\Users\\huabingood\\Desktop\\增量图书数据\\20180718新.xlsx";

        Workbook wb = null;

        try {
            // 1.打开excel
            wb = WorkbookFactory.create(new File(excelPath));
            // 2.获取sheet
            Sheet sheet = wb.getSheetAt(0);
            int line = sheet.getFirstRowNum();   // 这里实际上是获取的是第一行的行号
            int lastline = sheet.getLastRowNum();
            sheet.getPhysicalNumberOfRows();
            // 循环遍历所有的行
            for (; line <= lastline; line++) {
                // 3.获取一行
                Row row = sheet.getRow(line);

                int cellNum = row.getFirstCellNum();
                int lastCellNum = row.getLastCellNum();
                for (; cellNum <= lastCellNum; cellNum++) {
                    // 防止该行的数据为空
                    if (null != row) {
                        // 4.获取一列
                        Cell cell = row.getCell(cellNum);
                        if (null != cell) {
                            // 如果单元格的数据不是string就会出错
                            String str = cell.getStringCellValue();
                            System.out.println(str);
                        }
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
