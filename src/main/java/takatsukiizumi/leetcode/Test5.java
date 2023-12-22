package takatsukiizumi.leetcode;

import cn.hutool.http.Header;

import cn.hutool.http.HttpException;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import net.bytebuddy.description.annotation.AnnotationList;
import org.springframework.web.bind.annotation.GetMapping;
import takatsukiizumi.leetcode.hot100.entity.Cond;
import takatsukiizumi.leetcode.hot100.entity.QueryDataList;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class Test5 {
    public static void main(String[] args) {
        List<BigDecimal> list = new ArrayList();
        list.add(new BigDecimal(1));
        list.add(new BigDecimal(1));
        list.add(new BigDecimal(1));
        list.add(new BigDecimal(1));
        list.add(new BigDecimal(1));
        list.add(new BigDecimal(1));
        list.add(new BigDecimal(1));
        BigDecimal amount1 = new BigDecimal(0);
        BigDecimal amount2 = new BigDecimal(0);

        for(BigDecimal num : list){
            amount1 = amount1.add(num);
        }
        System.out.println(amount1);


        for(BigDecimal num : list){
        amount2.add(num);
        }
        System.out.println(amount2);


    }
}