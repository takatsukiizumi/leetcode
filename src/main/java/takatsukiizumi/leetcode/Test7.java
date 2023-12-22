package takatsukiizumi.leetcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import takatsukiizumi.leetcode.entity.ParentA;
import takatsukiizumi.leetcode.entity.ParentB;

import javax.annotation.PostConstruct;

/**
 * @author WUBOTONG
 * @description: test7
 * @date 2023/11/17 19:13
 */

@Component
public class Test7 {

    @Autowired
    ParentB parentB;

    @PostConstruct
    public void test() {
        parentB.methodX();
    }


}
