import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GetInfoFromWeb {

    public static void main(String[] args) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("https://www.zhihu.com/api/v3/books/categories/147?version=v2&limit=5&sort_by=read_count_7days&offset=55");
        CloseableHttpResponse response = null;

        try {
            response = httpclient.execute(httpGet);
            if(response.getStatusLine().getStatusCode()==200){
                System.out.println("连接正常");
                // 获取响应实体
                HttpEntity httpEntity = response.getEntity();
                if(null!=httpEntity){
                    String responseText = EntityUtils.toString(httpEntity,"GB2312");
                    System.out.println(responseText);
                }

            }else{
                System.out.println("连接异常");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!=response) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String parseJson(String line){
        String s = null;
        return s;
    }
}