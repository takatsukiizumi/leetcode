package takatsukiizumi.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class moveZeroes {

    public void moveZeroes(int[] nums) {
        int n1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0 ){
                nums[n1] = nums[i];
                n1++;
            }
        }
        for (int i=n1; i<nums.length ; i++) {
            nums[i] =0;
        }
    }

}
