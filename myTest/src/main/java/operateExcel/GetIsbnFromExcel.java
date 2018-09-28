package operateExcel;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GetIsbnFromExcel {
    public static void main(String[] args) throws Exception{
        String fatherPath = "C:\\Users\\huabingood\\Desktop\\增量图书数据";
        String excelName = "20180718新.xlsx";
        // String excelName = "sh20180805.xlsx";
        String imgPath = "20180813";
        //HashMap<String,Integer> hashMap = new HashMap<String, int>();
        Map<String ,Integer> map = new HashMap<String ,Integer>();

        Workbook wb = null;

        wb = WorkbookFactory.create(new File(fatherPath+File.separator+excelName));

        Sheet sheet = wb.getSheetAt(0);

        int line = sheet.getFirstRowNum();
        int lastline = sheet.getLastRowNum();

        for(;line<=lastline;line++){
            Row row = sheet.getRow(line);
            Cell cell = row.getCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            String isbn = cell.getStringCellValue();

            if(null!=map){
                if(map.containsKey(isbn)){
                    int value = map.get(isbn);
                    map.put(isbn,value+1);
                }else{
                    map.put(isbn,1);
                }
            }
        }

        Set<Map.Entry<String,Integer>> es = map.entrySet();

        for(Map.Entry<String,Integer> e:es){
            Integer v = e.getValue();
            String k = e.getKey();
            if(v>1){
                String img = imgPath+File.separator+k+".jpg";

                File f = new File(img);
                if(f.exists()){
                    System.out.println(f.getAbsolutePath());
                }else{
                    System.out.println("找不到文件："+f.getAbsolutePath());
                }
            }

        }

    }
}
