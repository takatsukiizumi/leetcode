package huawei_od;

import java.util.*;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/7/27
 */
public class alibaba2 {
    //阿里巴巴找黄金箱子2
    //一贫如洗的樵夫阿里巴巴在去砍柴的路上，无意中发现了强盗集团的藏宝地，藏宝地有编号从0-N的箱子，每个箱子上面贴有藏有金币数量的一个数字。
    //从金币中选出一个数字集合，并销毁贴有这些数字的每个箱子，如果能销毁一半及以上的箱子，则返回这个数字集合的最小大小
    //输入
    //1，1，1，1，3，3，3，6，6，8
    //输出
    //2 (选的1，8)
    //输入2，2，2，2
    //输出
    //1


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //将字符解析为整数数组
        String[] strs = str.split(",");
        int[] intStrs = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            intStrs[i] = Integer.parseInt(strs[i]);
        }
        //获取这个整数数组每一个数字出现的次数map：
        Map<Integer, Integer> numMap = getNum(intStrs);
        //将map去重降序
        Map<Integer, Integer> sortedAndDistinctMap = numMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder()))
                .collect(LinkedHashMap::new, (result, entry) -> result.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);
        //设这个数字集合的大小为n
        int n = 0;
        Integer total = 0;
        for(Map.Entry<Integer, Integer> entry : sortedAndDistinctMap.entrySet()){
            n++;
            total = total + entry.getValue();
            int l = (strs.length+1) / 2;
            if(total>=l){
                System.out.println(n);
                break;
            }

        }
    }
    //设计一个方法统计数组里每一个整数出现的次数
    private static Map<Integer,Integer> getNum(int[] intStrs) {
        Map <Integer,Integer> map = new HashMap();
        for(int num : intStrs){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return map;
    }


}
