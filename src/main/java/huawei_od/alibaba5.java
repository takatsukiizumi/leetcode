package huawei_od;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/7/28
 */
public class alibaba5 {
    //题目描述 一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从 0-N 的箱子，每个箱子上面贴有一个数字.
    //
    // 阿里巴巴念出一个咒语数字 k(k<N)，找出连续 k 个宝箱数字和的最大值，并输出该最大值。
    //
    //第一行输入一个数字字串，数字之间使用逗号分隔，例如: 2,10,-3,-8,40,5。
    //
    //1≤ 字串中数字的个数 ≤100000 -10000≤ 每个数字 ≤10000
    //
    //第二行输入咒语数字，例如: 4，咒语数字大小小于宝箱的个数
    //
    //输入
    //
    // 2,10,-3,-8,40,5
    // 4
    //
    //输出
    //
    // 39


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String strs = scanner.nextLine();
        String[] splitStrs = strs.split(",");
        int[] intStrs = new int[splitStrs.length];
        for (int i = 0; i <splitStrs.length ; i++) {
            intStrs[i] = Integer.parseInt(splitStrs[i]);
        }
        int num = scanner.nextInt();
        List list = new ArrayList<>();

        //构建一根两端距离固定的滑动双指针 左指针索引i,右指针索引i+num
        for (int i = 0; i <intStrs.length ; i++) {
            int total = 0;
            for (int j = i; j <i+num ; j++) {
                if(i+num> intStrs.length){
                    break;
                }
                total = total + intStrs[j];
            }
            list.add(total);
        }

        list.sort(Collections.reverseOrder());
        System.out.println(list.get(0));

    }




}
