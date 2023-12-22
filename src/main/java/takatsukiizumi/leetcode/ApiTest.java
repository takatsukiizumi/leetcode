package takatsukiizumi.leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/5/23
 */
public class ApiTest {
    public static void main(String[] args) {
        try {
            // API的URL
            URL url = new URL("https://api.asilu.com/php/domain.php");

            // 创建HttpURLConnection对象并设置请求方法为POST
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // 设置请求体参数
            String requestBody = "domain=qq.com&ssl=1";
            byte[] postDataBytes = requestBody.getBytes("UTF-8");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.getOutputStream().write(postDataBytes);

            // 发送请求并获取响应
            int responseCode = conn.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // 打印响应结果
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Body: " + response.toString());

            // 关闭连接
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
