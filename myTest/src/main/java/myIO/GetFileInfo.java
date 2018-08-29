package myIO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 用户数据文件后缀，系统列出某个文件夹下的所有文件的信息
 */
public class GetFileInfo {
    private static List<File> files = new ArrayList<File>();
    private static String fatherPath="D:\\学习\\Java";


    /**
     * 使用递归获取当前文件下所有的文件
     * @param file
     * @return
     */
    public static List<File> getAllFile(String file){
        File fatherFile = new File(file);

        File[] fatherFiles = fatherFile.listFiles();
        for (File sonFile:fatherFiles){
            if(sonFile.isFile()){
                files.add(sonFile);
            }else {
                getAllFile(sonFile.getAbsolutePath());
            }
        }

        return files;
    }

    /**
     * 判断文件是否以指定的后缀结尾，如果是就保留
     * 缺少对时间戳的解析
     * @param files
     * @param suffix
     * @return
     */
    private static List<StringBuffer> getFilesInfo(List<File> files,String suffix){
        List<StringBuffer> fileInfos = new ArrayList<>();
        for(File file:files) {
            StringBuffer fileInfo = new StringBuffer();
            if (file.getName().endsWith(suffix)) {
                // TODO 需要对日期格式进行解析，但是这里没有办法进行
                fileInfo = fileInfo.append(file.lastModified()).append(file.getName());
                fileInfos.add(fileInfo);
            }
        }


        return fileInfos;
    }


    public static void main(String[] args){
        System.out.println("请输入你要查询的文件后缀：");
        Scanner scanner = new Scanner(System.in);
        String suffix = scanner.nextLine();

        getAllFile(fatherPath);
        List<StringBuffer> fileInfos = getFilesInfo(files,suffix);

        for(StringBuffer sb:fileInfos){
            System.out.println(sb);
        }
    }
}
