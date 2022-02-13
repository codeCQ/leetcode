package medium;

import java.util.Arrays;

public class code0504 {
    public static void main(String[] args) {
        int i =2;
        System.out.println( i ^= (1<<(0+1)));
        System.out.println( Integer.toBinaryString(124) );
        System.out.println( Integer.toBinaryString(143) );
        Arrays.stream(findClosedNumbers(124)).forEach(System.out::println);
    }

    /**
     * 位运算
     * ‘~’按位取反  01 -> 11111111111111111111111111111101
     * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
     * 示例1:
     *  输入：num = 2（或者0b10）
     *  输出：[4, 1] 或者（[0b100, 0b1]）
     * 示例2:
     *
     *  输入：num = 1
     *  输出：[2, -1]
     */
    public static int[] findClosedNumbers(int num) {
        int size = 0; // 1的个数
        int bigNum = -1;
        int smallNum = -1;
        int numTemp=num;
        for (int i = 0; i < 30; i++) {
            //找到bigNum 先找到01 -> 10,再把10后所有的1移动至最右
            if ( (num & (1<<(i+1))) == 0 //前一位不等于1
                    && (num & (1<<i)) != 0 //后一位不等0
            ){
                numTemp ^= (1<<(i+1));
                numTemp ^= (1<<(i));
                //从末位开始从0->1
                for (int x = 0; x < size; x++) {
                    numTemp ^= (1<<x);
                }
                bigNum = numTemp;
                break;
            }
            //如果当前位是1，则记录
            if ( (num & (1<<(i))) != 0){
                size++;
                //清空当前位 =0
                numTemp ^=  (1<<(i));
            }

        }
        //重置
        numTemp=num;
        size = 0;
        for (int i = 0; i < 30; i++) {
            //找到smallNum 先找到10 -> 01,再把01后所有的1移动至最左
            if ( (num & (1<<(i+1))) != 0 //前一位不等于1
                    && (num & (1<<i)) == 0 //后一位不等0
            ){
                numTemp ^= (1<<(i+1));
                numTemp ^= (1<<(i));
                //从i-1位向后开始从0->1
                for (int x = i-1,y = size; y > 0; x--,y--) {
                    numTemp ^= (1<<x);
                }smallNum = numTemp;
                break;
            }
            //如果当前位是1，则记录
            if ( (num & (1<<(i))) != 0){
                size++;
                //清空当前位 =0
                numTemp ^=  (1<<(i));
            }

        }

        return new int[]{bigNum,smallNum};
    }



}
