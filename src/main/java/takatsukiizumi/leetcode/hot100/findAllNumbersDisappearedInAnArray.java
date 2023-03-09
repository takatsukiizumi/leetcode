package takatsukiizumi.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class findAllNumbersDisappearedInAnArray {

    //给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。

    //这个方法太慢
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List list = new ArrayList();
        int length = nums.length;
        for (int i = 1; i <= length; i++) {
            if(!exit(nums,i)){
                list.add(i);
            };
        }
        return list;
    }

    public boolean exit(int[]nums,int i){
        for(int n : nums){
            if(i == n){
              return  true;
            }
        }
        return false;
    }

    public List<Integer> findDisappearedNumbersBest(int[] nums) {
        List list = new ArrayList();
        for (int i = 0; i <nums.length ; ++i) {
            int index = Math.abs(nums[i])-1;
                nums[index] = -1 * Math.abs(nums[index]);
        }
        for (int i = 0; i <nums.length ; ++i) {
            if(nums[i]>0){
                int num = i+1;
                list.add(num);
            }
        }
        return  list;
    }


}
