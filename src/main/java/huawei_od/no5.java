package huawei_od;

import java.util.Scanner;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/7/26
 */
public class no5 {

    //给定字符串A、B和正整数V，A的长度与B的长度相等，请计算A中满足如下条件的最大连续子串的长度：
    //1、该连续子串在A和B中的位置和长度均相等。
    //2、该连续子串|A[i]-B[i]|之和小于等于V。其中|A[i]-B[i]|表示两个字母ASCII码之差的绝对值。输入描述：
    //第一行为字符串A，仅包含小写字母，长度是1到1000
    //第二行为字符串B，仅包含小写字母，长度是1到1000
    //第三行为正整数V，V取值在0到10000之间，包括10000。输出描述：
    //字符串最大连续子串的长度，要求该子串|A[i]-B[i]|之和小于等于V示例1
    //输入
    //xxcdefg
    //cdefghi
    //5
    //输出
    //2
    //说明
    //字符串A为xxcdefg，字符串B为cdefghi，V=5.它的最大连续子串可以是cd->ef,de->fg,ef->gh,fg->hi，所以最大连续子串是2.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine(); // 读取字符串A
        String B = scanner.nextLine(); // 读取字符串B
        int V = scanner.nextInt(); // 读取正整数V
        scanner.close();

        int maxLength = 0; // 初始化最大连续子串的长度为0
        int currentDiffSum = 0; // 初始化当前窗口内字符的ASCII码差的绝对值之和为0

        for (int i = 0; i < A.length(); i++) { // 遍历字符串A的每个字符
            int diff = Math.abs(A.charAt(i) - B.charAt(i)); // 计算当前字符的差值
            currentDiffSum += diff; // 将差值累加到当前差值和中

            // 缩小窗口：如果当前差值和超过V，移除窗口左侧的字符并更新currentDiffSum和maxLength
            while (currentDiffSum > V) {
                int diffToRemove = Math.abs(A.charAt(i - maxLength) - B.charAt(i - maxLength));
                currentDiffSum -= diffToRemove;
                maxLength--;
            }

            maxLength++; // 更新最大连续子串的长度，窗口右侧增加一个字符
        }

        System.out.println(maxLength); // 输出满足条件的最大连续子串的长度

        //在初始化时，窗口是空的，不包含任何字符。在滑动窗口算法中，我们通常通过维护两个指针来定义窗口的边界。在这个问题中，我们使用maxLength来表示窗口的右边界，并通过i - maxLength来表示窗口的左边界。
        //
        //初始时，maxLength和currentDiffSum都被设置为0，表示窗口是空的，因此长度为0。随着遍历字符串A的每个字符，我们将maxLength逐渐增加，相当于扩大窗口的右边界。窗口的左边界则通过缩小窗口的方式动态调整。
        //
        //这里要注意，滑动窗口算法的目的是在数组或字符串上通过滑动窗口来查找满足特定条件的子数组或子串。在初始状态下，窗口可以为空或包含一个或多个元素，具体根据问题要求来确定。在本问题中，初始窗口为空，因为我们要查找的是最大连续子串，所以初始窗口长度为0。
        //
        //随着遍历字符串A的过程中，滑动窗口的右边界逐渐增大，而左边界根据条件来动态缩小或保持不变，从而找到满足条件的最大连续子串。

    }
}




