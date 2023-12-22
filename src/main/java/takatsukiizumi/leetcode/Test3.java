package takatsukiizumi.leetcode;

import takatsukiizumi.leetcode.hot100.nextPermutation;

public class Test3 {


    public static void main(String[] args) {


        nextPermutation nextPermutation = new nextPermutation();
        int[]nums = new int[]{1,2,3,4};
        nextPermutation.nextPermutation(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]);
        }

    }
}
