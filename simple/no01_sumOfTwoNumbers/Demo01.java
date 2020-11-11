package no01_sumOfTwoNumbers;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo01 {
    public static void main(String[] args) {
        int[] nums=new int[]{ 11, 15,2, 7};
        int[] ints = twoSum(nums, 9);
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

    //示例:
    //给定 nums = [2, 7, 11, 15], target = 9
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]

    public static int[] twoSum(int[] nums, int target) {
        //从数组的角标0开始，到nums.length-1结束
        for (int i = 0; i < nums.length-1; i++) {
            for (int j=i+1;j<nums.length;j++){
            if (nums[i]+nums[j]==target)return new int[]{i,j};
            }
        }
        return null;
    }


}
