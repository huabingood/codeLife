package operateExcel;

import org.apache.poi.ss.usermodel.*;

import java.io.File;

public class GetIsbnFromExcel {
    public static void main(String[] args) throws Exception{
        String fatherPath = "C:\\Users\\huabingood\\Desktop\\增量图书数据";
        String excelName = "20180718新.xlsx";
        String imgPath = "20170719";

        Workbook wb = null;

        wb = WorkbookFactory.create(new File(fatherPath+File.separator+excelName));

        Sheet sheet = wb.getSheetAt(0);

        int line = sheet.getFirstRowNum();

        for(;line<=1032;line++){
            Row row = sheet.getRow(line);
            Cell cell = row.getCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            String isbn = cell.getStringCellValue();

            String img = imgPath+File.separator+isbn+".jpg";

            File f = new File(img);
            if(f.exists()){
                System.out.println(f.getAbsolutePath());
            }else{
                System.out.println("找不到文件："+f.getAbsolutePath());
            }
        }
    }
}
