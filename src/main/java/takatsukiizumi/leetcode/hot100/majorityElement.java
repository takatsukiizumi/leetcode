package takatsukiizumi.leetcode.hot100;

import java.util.*;

/**
 * @Description: 多数元素
 * @author: takatsukiizumi
 * @date: 2022年09月29日 9:46
 */

//给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于[ n/2 ]的元素。

//你可以假设数组是非空的，并且给定的数组总是存在多数元素。


public class majorityElement {

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int numb :  nums){
            if( null == map.get(numb)){
                map.put(numb,1);
            }
            else{
                map.put(numb,map.get(numb)+1);
            }
        }
        int length =map.size();
        Collection<Integer> c = map.values();
        Object[] obj = c.toArray();
        Arrays.sort(obj);
        Integer trueKey = null;
        int trueValue = (int) obj[length-1];
        for(Map.Entry<Integer, Integer> vo : map.entrySet()){
            if(vo.getValue() == trueValue){
                 trueKey = vo.getKey();
            }

        }
        return (int)trueKey;
    }


    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    //随机化
    public int majorityElement3(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }
}
