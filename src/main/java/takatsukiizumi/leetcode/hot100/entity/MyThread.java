package takatsukiizumi.leetcode.hot100.entity;

import javafx.scene.input.DataFormat;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/5/22
 */

@Data
public class MyThread extends java.lang.Thread {

    private Map<String,String> map;
    private int i;
    private String key;

    public MyThread(Map map, int i, String key) {
        this.map = map;
        this.i = i;
        this.key = key;
    }

    @Override
    public void run() {
        for (int j = 0; j < i ; j++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (map){
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                String formattedDate = dateFormat.format(date);
                map.put(Integer.toString(j),key+":"+formattedDate);
                System.out.println(key+":"+map.get(Integer.toString(j)));
            }
        }
        }
    }

