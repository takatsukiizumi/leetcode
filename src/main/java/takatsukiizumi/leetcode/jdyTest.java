package takatsukiizumi.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jodd.util.StringUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/6/20
 */
public class jdyTest {
    public static void main(String[] args) {
        String apiURL = "https://yeepms.yeec.com.cn/jdyapi/jdyapi/project";
        URL url = null;
        String dataId = "";
        int count = 0 ;
        try {
            while (true) {
                url = new URL(apiURL);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                // 设置POST请求
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Authorization", "C6Ew9lhseyvbhQLsVFousDzhnFag12o0");
                con.setDoOutput(true);

                // 构建fields数组
                JSONArray fields = new JSONArray();
                fields.add("tyshxydm");
                fields.add("dwmc");
                fields.add("dwjc");
                fields.add("dwlxzh");
                fields.add("dwdz");
                fields.add("sfhmd");

                // 构建filter对象
                JSONObject filter = new JSONObject();
                filter.put("rel", "and");

                JSONArray cond = new JSONArray();
                JSONObject condObj1 = new JSONObject();
                JSONObject condObj2 = new JSONObject();
                JSONObject condObj3 = new JSONObject();
                JSONObject condObj4 = new JSONObject();
                JSONObject condObj5 = new JSONObject();
                JSONObject condObj6 = new JSONObject();
                condObj1.put("field", "tyshxydm");
                condObj1.put("method", "not_empty");
                condObj2.put("field", "dwmc");
                condObj2.put("method", "not_empty");
                condObj3.put("field", "dwjc");
                condObj3.put("method", "not_empty");
                condObj4.put("field", "dwlxzh");
                condObj4.put("method", "not_empty");
                condObj5.put("field", "dwdz");
                condObj5.put("method", "not_empty");
                condObj6.put("field", "sfhmd");
                condObj6.put("method", "not_empty");
                cond.add(condObj1);
                cond.add(condObj2);
                cond.add(condObj3);
                cond.add(condObj4);
                cond.add(condObj5);
                cond.add(condObj6);

                filter.put("cond", cond);

                // 构建最终的JSON对象
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("type", "company");
                jsonObject.put("data_id", dataId);
                jsonObject.put("limit", 100);
                jsonObject.put("fields", fields);
                jsonObject.put("filter", filter.toString());
                System.out.println(jsonObject);

                String requestBody = jsonObject.toString();
                OutputStream outputStream = con.getOutputStream();
                outputStream.write(requestBody.getBytes());
                outputStream.flush();
                outputStream.close();

                // 读取响应
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 解析响应
                String jsonResponse = response.toString();
                JSONObject jsonObjects = JSON.parseObject(jsonResponse);
                JSONObject resultJson = jsonObjects.getJSONObject("data");
                JSONArray data = resultJson.getJSONArray("data");
                if (data.isEmpty()) {
                    // 没有获取到数据，退出循环
                    break;
                }

                for (int i = 0; i < data.size(); i++) {
                    JSONObject jobject = data.getJSONObject(i);
                    System.out.println("tyshxydm: " + jobject.getString("tyshxydm"));
                    System.out.println("dwmc: " + jobject.getString("dwmc"));
                    System.out.println("dwjc: " + jobject.getString("dwjc"));
                    System.out.println("dwlxzh: " + jobject.getString("dwlxzh"));
                    System.out.println("dwdz: " + jobject.getString("dwdz"));
                    System.out.println("sfhmd: " + jobject.getString("sfhmd"));
                    dataId = jobject.getString("_id");
                    System.out.println("data_id:" + dataId);
                    System.out.println(count++);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        }

}
