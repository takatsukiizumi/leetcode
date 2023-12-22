package takatsukiizumi.leetcode;

import takatsukiizumi.leetcode.hot100.entity.MyThread;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/5/22
 */
public class ThreadTest {


    public static void main(String[] args) {
        Map map = new HashMap<String,String>(10000);
        MyThread t1 = new MyThread(map,100000,"key1");
        MyThread t2 = new MyThread(map,100000,"key2");
        MyThread t3 = new MyThread(map,100000,"key3");
        MyThread t4 = new MyThread(map,100000,"key4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
