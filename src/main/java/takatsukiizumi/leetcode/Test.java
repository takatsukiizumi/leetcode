package takatsukiizumi.leetcode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jodd.util.StringUtil;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        String apiURL = "https://tgdcepc.ctg.com.cn:8443/datacenter/gateway/datamanage/services/v1.0.0/EPC_Model/GetProject_infolist";
        String token = "84121fe912ce4af8aed131ad41b38e74";
        URL url = null;
        List<Map<String, String>> ruleList = new ArrayList<>();
        Map<String, String> rule = new HashMap();
        try {
            url = new URL(apiURL);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // 设置POST请求
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("token", token);
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
            JSONObject jsonObject = JSON.parseObject(jsonResponse);
            JSONObject resultJson = jsonObject.getJSONObject("result");
            JSONArray data = resultJson.getJSONArray("data");
            for (int i = 0; i < data.size(); i++) {
                JSONObject js = data.getJSONObject(i);
                Map<String, String> map = new HashMap<>();
                for (String key : js.keySet()) {
                    map.put(key, js.getString(key));
                }
                ruleList.add(map);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (Map<String, String> ruleMap : ruleList) {
            String projectId = ruleMap.get("project_safe_id");
            String projectCode = ruleMap.get("project_parent_code");
            if(!StringUtil.isEmpty(projectId) && !StringUtil.isEmpty(projectCode)){
                rule.put(projectId, projectCode);
            }
        }
        System.out.println(rule.toString());

    }



}


//        bestTimeToSellStock stock = new bestTimeToSellStock();
//        int [] prices = {7,1,5,3,6,4};
//        int max = stock.maxProfit(prices);
//        System.out.println(max);
//        moveZeroes move = new moveZeroes();
//        int []nums = {0,1,0,3,12};
//        move.moveZeroes(nums);
//        System.out.println(Arrays.toString(nums));

//        generateParenthesis gen = new generateParenthesis();
//        List<String> ans2 = gen.generateParenthesis(2);
//        List<String> ans3 = gen.generateParenthesis(3);
//        List<String> ans4 = gen.generateParenthesis(4);
//        System.out.println(ans2+"\n"+ans3+"\n"+ans4+"\n");

//          majorityElement maj = new majorityElement();
//          int []nums = new int[]{3,2,3};
//          int i = maj.majorityElement1(nums);
//          System.out.println(i);

//            reverseList rev = new reverseList();
//            ListNode node1 = new ListNode(1);
//            ListNode node2 = new ListNode(2);
//            ListNode node3 = new ListNode(3);
//            ListNode node4 = new ListNode(4);
//            node1.next=node2;
//            node2.next=node3;
//            node3.next=node4;
//            rev.reverseList1(node1);
//            System.out.println(node3.next.val);
//              String str = "AB";
//              System.out.println(str.hashCode());
//        chopsticks  c1 = new chopsticks(1);
//        chopsticks  c2 = new chopsticks(2);
//        chopsticks  c3 = new chopsticks(3);
//        chopsticks  c4 = new chopsticks(4);
//        chopsticks  c5 = new chopsticks(5);
//
//        philosopher p1 = new philosopher("1号哲学家",1,c1,c2);
//        philosopher p2 = new philosopher("2号哲学家",2,c2,c3);
//        philosopher p3 = new philosopher("3号哲学家",3,c3,c4);
//        philosopher p4 = new philosopher("4号哲学家",4,c4,c5);
//        philosopher p5 = new philosopher("5号哲学家",5,c5,c1);
//
//        p1.start();
//        p2.start();
//        p3.start();
//        p4.start();
//        p5.start();

//        Integer i1 = 100;
//        Integer i2 = 100;
//        Integer i3 = 200;
//        Integer i4 = 200;
//        System.out.println(i1 == i2);
//        System.out.println(i3 == i4);

//        findAllNumbersDisappearedInAnArray find = new findAllNumbersDisappearedInAnArray();
//        int[] nums = {4,3,2,7,8,2,3,1};
//        List<Integer> disappearedNumbers = find.findDisappearedNumbersBest(nums);
//        for(Integer i : disappearedNumbers){
//            System.out.println(i);
//        }

//        hammingDistance han = new hammingDistance();
//        int i = han.hammingDistance(1, 4);
//        System.out.println(i);

//        List<String> list = Arrays.asList("apple", "banana", "orange", "pear");
//        List<String> result = list.stream().filter(str -> str.length() == 5).collect(Collectors.toList());

//        String account = "13100000016";
//        String password = "Cjhb@13100000016";
//        String encryptedAccount = null;
//        String encryptedPassword = null;
//        String decryptedAccount = null;
//        String decryptedPassword = null;
//        try {
//            encryptedAccount = CryptoUtils.encrypt(account);
//            encryptedPassword = CryptoUtils.encrypt(password);
//            decryptedAccount = CryptoUtils.decrypt(encryptedAccount);
//            decryptedPassword= CryptoUtils.decrypt(encryptedPassword);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(account);
//        System.out.println(password);
//        System.out.println(encryptedAccount);
//        System.out.println(encryptedPassword);
//        System.out.println(decryptedAccount);
//        System.out.println(decryptedPassword);



