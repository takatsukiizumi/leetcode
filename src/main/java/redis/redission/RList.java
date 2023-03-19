package redis.redission;

import org.redisson.api.RedissonClient;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/3/16
 */
public class RList {

    public static void main(String[] args) {
        RedissionUtil redissionUtil = new RedissionUtil();
        RedissonClient redissionClient = redissionUtil.getRedissionObject();
        org.redisson.api.RList<String> rList = redissionClient.getList("myList");
        rList.add("今天是2023年三月十六日");
        rList.add("此时此刻的时间为是10:36:15");
        rList.add("这是一个有关Redission的RList数据结构的测试，我知道由于它序列化了，所以我不能在Redis客户端获取");
        //遍历列表元素：
        rList.forEach(System.out::println);
        //输出列表的长度
        System.out.println("ListSize="+rList.size());
        //获取列表中指定下标的元素
        String valueAtIndex2 = rList.get(2);
        System.out.println("Value at index 2: " + valueAtIndex2);
    }

}
