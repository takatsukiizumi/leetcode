package redis.redission;

import org.redisson.api.RedissonClient;

import java.util.Set;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/3/16
 */
public class RSet {


    public static void main(String[] args) {
        RedissionUtil redissionUtil = new RedissionUtil();
        RedissonClient redissionClient = redissionUtil.getRedissionObject();
        org.redisson.api.RSet<String> set = redissionClient.getSet("mySet");
        set.add("this is a test");
        set.add("repeat");
        set.add("this is just a test");
        // 从 Set 中获取所有元素
        Set<String> allElements = set.readAll();
        //遍历
        for (String element : allElements) {
            System.out.println("Element: " + element);
        }
        //删除
        set.remove("repeat");
        redissionClient.shutdown();
    }








}
