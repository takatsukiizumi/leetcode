package takatsukiizumi.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import takatsukiizumi.leetcode.hot100.findMedianSortedArrays;
import takatsukiizumi.leetcode.hot100.letterCombinations;

import java.util.List;

/**
 * @Description: TODO
 * @author: takatsukiizumi
 * @date: 2022年09月20日 16:10
 */

@Component
@Slf4j
public class run  {
    @Scheduled(cron = "*/5 * * * * ?")
    public void run()  {
        letterCombinations letter = new letterCombinations();
        List<String> answer = letter.letterCombinations("23");
        System.out.println(answer);
    }
}
