package huawei_od;

import java.util.*;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/7/26
 */
public class test {

    public static void main(String[] args) {


        Map <Integer,Integer> map = new HashMap();
        map.put(1,1);
        map.put(2,3);
        map.put(4,5);
        map.put(6,7);
        map.put(8,9);
        map.put(9,9);

       List<Integer> list = new ArrayList<>();
       for( Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        TreeSet set  = new TreeSet(Collections.reverseOrder());
        for(Integer i : list){
            set.add(i);
        }
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(set);


    }

}
