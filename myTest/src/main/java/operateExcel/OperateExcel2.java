package operateExcel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OperateExcel2 {
    public static void main(String[] args) {
        String excelPath = "C:\\Users\\huabingood\\Desktop\\增量图书数据\\20180718新.xlsx";
        OutputStream os = null;


        Workbook wb = null;

        try {
            // 1.获取excel
            wb = WorkbookFactory.create(new File(excelPath));
            // 2.创建sheet
            Sheet sheet = wb.createSheet("新建一个sheet");
            // 3.创建一个新行
            Row row = sheet.createRow(2);
            // 4.创建一个新的单元格
            Cell cell = row.createCell(3);
            // 5.往单元格中写入相应的数据
            cell.setCellValue("测试数据");

            // 6.打开一个写入流
            os = new FileOutputStream(new File(excelPath));
            // 7.写入
            wb.write(os);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    // 8.关闭写入流
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
