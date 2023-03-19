package redis.redission;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/3/16
 */
@Component
public class RedissionUtil {

    public RedissonClient getRedissionObject(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379")
                .setPassword("yZ@sUmvLB53zw6Ed")
                .setDatabase(0);
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }



}
