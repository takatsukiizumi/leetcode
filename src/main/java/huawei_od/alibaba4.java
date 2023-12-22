package huawei_od;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/7/28
 */
public class alibaba4 {
    //一贫如洗的椎夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0-N的子，每个箱子上面有一个数字，
    //箱了排列成一个环，编号最大的箱子的下一个是编号为0的箱子。请输出每个箱了贴的数字之后的第一个比它大的数，如果不存在则输出-1。
    //输入：2，5，2
    //输出：5，-1，5
    //输入：3，4，5，6，3
    //输出：4，5，6，-1，4

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strs = scanner.nextLine();
        String[] splitStrs = strs.split(",");
        int[] intStrs = new int[splitStrs.length];
        for (int i = 0; i <splitStrs.length ; i++) {
            intStrs[i] = Integer.parseInt(splitStrs[i]);
        }
        int[] answer = getAnswer(intStrs);
        StringBuilder build = new StringBuilder();

        for (int i = 0; i <answer.length ; i++) {
            build.append(answer[i]);
            if(i != answer.length-1){
                build.append(",");
            }
        }
        System.out.println(build.toString());
    }
    private static int[] getAnswer(int[] intStrs){
        int[] ints = new int[intStrs.length];
        for (int i = 0; i <intStrs.length ; i++) {
            for (int j = i; j <intStrs.length-1 ; j++) {

                if(intStrs[j+1]>intStrs[i]){
                    ints[i] = intStrs[j+1];
                    break;
                }
            }
            if(ints[i] == 0){
                ints[i] =-1;
            }
            ints[intStrs.length-1] = ints[0];

        }
        return  ints;

    }

}
