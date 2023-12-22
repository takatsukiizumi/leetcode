package takatsukiizumi.leetcode.entity;

import org.springframework.stereotype.Component;

/**
 * @author WUBOTONG
 * @description:
 * @date 2023/12/12 18:05
 */

@Component
public class ParentBImpl implements ParentB {
    public void methodX() {
        System.out.println("ParentBImpl");
    }
}
