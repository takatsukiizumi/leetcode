package huawei_od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/7/25
 */
public class no4 {
    private final static int BASE = 16;
    private static Map<Character, Integer> map = new HashMap<Character, Integer>()
    {{
        put('0', 0);
        put('1', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('A', 10);
        put('B', 11);
        put('C', 12);
        put('D', 13);
        put('E', 14);
        put('F', 15);
        put('a', 10);
        put('b', 11);
        put('c', 12);
        put('d', 13);
        put('e', 14);
        put('f', 15);
    }};

    public static int getDecimal(String number) {
        int res = 0;
        for (char ch : number.toCharArray()) {
            res = res * BASE + map.get(ch);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int a = 0;
        int n = 0;
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            n = in.nextInt();
            if(n == 0){
                return;
            }
            for(int i=0;i<n;i++){
                a = a + in.nextInt();
            }
            if(a == 0){
                return;
            }
            System.out.println(a);
        }

    }
        }


