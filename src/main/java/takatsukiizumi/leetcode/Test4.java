package takatsukiizumi.leetcode;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test4 {

    public static void main(String[] args) {
        String encode1 = URLEncoder.encode("1028090$1$0$0");
        String encode2 = URLEncoder.encode("1028090$0");
        String decode = URLDecoder.decode("1028090$1$0$0");
        System.out.println(encode1);
        System.out.println(encode2);
    }
}
