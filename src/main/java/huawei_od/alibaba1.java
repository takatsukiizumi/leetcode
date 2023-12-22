package huawei_od;

import java.util.Scanner;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/7/27
 */
public class alibaba1 {
    //一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0~N的箱子，每个箱子上面贴有一个数字，箱子中可能有一个黄金宝箱。
    //
    //黄金宝箱满足排在它之前的所有箱子数字和等于排在它之后的所有箱子数字和;第一个箱子左边部分的数字和定义为0;最后一个宝箱右边部分的数字和定义为0。
    //
    //请帮阿里巴巴找到黄金宝箱，输出第一个满足条件的黄金宝箱编号，如果不存在黄金宝箱，请返回-1.
    //输入
    //2,5,-1,8,6
    //输出
    //3
    //输入
    //8,9
    //输出
    //-1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //将字符解析为整数数组
        String[] strs = str.split(",");
        int[] intStrs = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            intStrs[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(getTruth(intStrs));


    }
    private static Integer getTruth(int[] intStrs){
        for (int i = 0; i <intStrs.length ; i++) {
            //获取指针左边的范围：0~i
            int num1 = 0;
            int num2 =0;
            for(int j=0;j<i;j++){
                num1 = num1 + intStrs[j];
            }
            //获取指针右边的范围：i+1~intStrs.length
            for(int k=i+1;k<intStrs.length;k++){
                num2 = num2 + intStrs[k];
            }

            if(num1 == num2 ){
                return i;
            }
        }
        return -1;

    }


}
