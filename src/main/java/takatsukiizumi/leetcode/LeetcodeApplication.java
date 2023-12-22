package takatsukiizumi.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import takatsukiizumi.leetcode.hot100.lengthOfLongestSubstring;

@SpringBootApplication
@ComponentScan("takatsukiizumi.leetcode")
public class LeetcodeApplication  {

    public static void main(String[] args) {
        SpringApplication.run(LeetcodeApplication.class, args);
    }





}
