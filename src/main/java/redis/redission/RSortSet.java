package redis.redission;
import org.redisson.api.RedissonClient;
import org.redisson.client.protocol.ScoredEntry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/3/16
 */
public class RSortSet {
    public static void main(String[] args) {

        RedissonClient redissonClient = new RedissionUtil().getRedissionObject();
        // 获取RSortedSet对象：
        org.redisson.api.RSortedSet<String> sortedSet = redissonClient.getSortedSet("order_rank");
        sortedSet.add("a");
        sortedSet.add("b");
        sortedSet.add("c");
        // 获取元素个数
        int size = sortedSet.size();
        // 获取第一个元素（默认升序排序）
        String firstElement = sortedSet.first();
        // 获取最后一个元素（默认升序排序）
        String lastElement = sortedSet.last();
    }
}
