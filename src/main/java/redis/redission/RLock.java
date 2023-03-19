package redis.redission;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/3/15
 */
@Component
public class RLock {


    //在这个demo里，我们使用Redisson获取了一个名称为"myLock"的锁对象，然后在try块中通过调用lock方法获取了该锁。
    // 在try块内部，我们可以执行一些保证原子性的代码操作。然后，我们必须在finally块中调用unlock方法释放锁，以确保其他进程可以获得该锁。
    // 我们使用了tryLock方法并传入了超时时间，这将会让线程在等待一定时间后自动放弃获取锁。


    public static void main(String[] args) {

            RedissionUtil redissionUtil = new RedissionUtil();
            RedissonClient redisson = redissionUtil.getRedissionObject();  // 初始化Redisson客户端
            org.redisson.api.RLock lock = redisson.getLock("myLock");  // 获取锁对象

            try {
                boolean isLocked = lock.tryLock(2, 10, TimeUnit.SECONDS);  // 获得锁
                if (isLocked) {
                    // 执行需要保证原子性的代码块
                    System.out.println("Locked!");
                    RMap<String,String> map  = redisson.getMap("myMap");
                    map.put("name","xiaowu");
                    map.put("birth","1996");
                    System.out.println("name:"+map.get("name"));
                    System.out.println("birth:"+map.get("birth"));
                    System.out.println("Done!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (RedisConnectionException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();  // 释放锁
            }

            redisson.shutdown();  // 关闭Redisson客户端
        }

    }


