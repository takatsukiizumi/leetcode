package huawei_od;

import java.util.Scanner;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/7/26
 */
public class no5_self {

    // //给定字符串A、B和正整数V，A的长度与B的长度相等，请计算A中满足如下条件的最大连续子串的长度：
    //    //1、该连续子串在A和B中的位置和长度均相等。
    //    //2、该连续子串|A[i]-B[i]|之和小于等于V。其中|A[i]-B[i]|表示两个字母ASCII码之差的绝对值。输入描述：
    //    //第一行为字符串A，仅包含小写字母，长度是1到1000
    //    //第二行为字符串B，仅包含小写字母，长度是1到1000
    //    //第三行为正整数V，V取值在0到10000之间，包括10000。输出描述：
    //    //字符串最大连续子串的长度，要求该子串|A[i]-B[i]|之和小于等于V示例1
    //    //输入
    //    //xxcdefg
    //    //cdefghi
    //    //5
    //    //输出
    //    //2
    //    //说明
    //    //字符串A为xxcdefg，字符串B为cdefghi，V=5.它的最大连续子串可以是cd->ef,de->fg,ef->gh,fg->hi，所以最大连续子串是2.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strA = scanner.nextLine();
        String strB = scanner.nextLine();
        int maxNum = scanner.nextInt();
        scanner.close();

        int abNum = 0;
        int maxLength =0;
        int totalNum = 0;
        int baNum =0;
        int alength = strA.length();

        for (int i = 0; i <alength ; i++) {

            abNum = Math.abs(strA.charAt(i)-strB.charAt(i));
            totalNum = totalNum + abNum;
            while(totalNum > maxNum){
                baNum = Math.abs(strA.charAt(i-maxLength)-strB.charAt(i-maxLength));
                totalNum = totalNum - baNum;
                maxLength--;
            }

            maxLength++;



        }
        System.out.println(maxLength);


    }


}
