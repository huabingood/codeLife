package operateExcel;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class OperateExcel {
    public static void main(String[] args) throws  Exception{
        String excelPath = "C:\\Users\\huabingood\\Desktop\\增量图书数据\\20180718新.xlsx";
        InputStream is = new FileInputStream(excelPath);

        // 1.打开excel文件，两种方式
        // Workbook wb = WorkbookFactory.create(new File(excelPath));
        Workbook wb = WorkbookFactory.create(is);

        // 2.获取sheet
        // Sheet sheet = wb.getSheet("Sheet1");  // 根据sheet名获取
        Sheet sheet = wb.getSheetAt(0);    // 根据sheet的下标获取

        // 3.获取sheet中的行
        Row row = sheet.getRow(0);    // 获取一行，通常是从0开始的

        // 4.获取行中的一个单元格
        Cell cell = row.getCell(0);  // 索引是从0开始的

        // 5.获取cell中的值
        String str = cell.getStringCellValue();    // 获取String类型cell的值

        System.out.println(str);

        is.close();

    }
    
}
