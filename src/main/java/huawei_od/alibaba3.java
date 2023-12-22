package huawei_od;

import java.util.Scanner;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/7/27
 */
public class alibaba3 {
    //阿里巴巴找黄金宝箱3
    //一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0-N的箱子，每个箱子上面贴有一个数字。
    //阿里巴巴念出一个咒语数字，查看宝箱是否存在两个不同箱子，这两个箱子上贴的数字相同，同时这两个箱子的编号之差的绝对值小于等于咒语数字，
    //如果存在这样的一对宝箱，请返回最先找到的那对宝箱左边箱子的编号，如果不存在则返回-1
    //输入描述
    //第一行输入一个数字字串，数字之间使用逗号分隔，例如: 1,2,3,1
    // 1 < 字串中数字个数 < 100000
    // -100000<=每个数字值<= 100000
    //第二行输入咒语数字，例如: 3
    //1<=咒语数字<=100000
    //存在这样的一对宝箱，请返回最先找到的那对宝箱左边箱子的编号，如果不存在则返回-1
    //输入
    //6,3,1,6
    //3
    //输出
    //0
    //输入
    //5，6，7，5，6，7
    //26
    //输出
    //0
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //获取String类型的数字串
        String numStr = scanner.nextLine();
        //获取诅咒数字：
        int num = scanner.nextInt();
        //将String类型的数字解析为整数数组
        String[] splitnumStr = numStr.split(",");
        int[] intStr = new int[splitnumStr.length];
        for (int i = 0; i <splitnumStr.length ; i++) {
            intStr[i] = Integer.parseInt(splitnumStr[i]);
        }
        //采用双指针进行遍历，左侧的指针索引为i，右侧的指针索引为i+1
        int length = intStr.length;
        System.out.println(findNumb(length, num, intStr));
    }
    private static int findNumb(int length ,int num ,int[] intStr){
        for (int i = 0; i < length ; i++) {
            for (int j = i+1 ; j < length ; j++) {
                //移动条件：这两个箱子的编号之差的绝对值小于等于咒语数字
                if(Math.abs(j-i)<=num && (intStr[j] == intStr[i])){
                    return i;
                }
            }
        }
        return -1;
    }

}
