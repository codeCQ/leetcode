package simple.linkedlist.code_01;
        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.stream.Collectors;

/**
 * author ChenQian
 * leetcode题目编码 01
 * date 2020.11.14
 */
public class Demo01 {
    public static void main(String[] args) {
        int[] nums=new int[]{ 11, 15,2, 7};
        int[] ints = twoSum1(nums, 9);
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

    //示例:
    //给定 nums = [2, 7, 11, 15], target = 9
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]
    //2次循环暴力解法
    public static int[] twoSum(int[] nums, int target) {
        //从数组的角标0开始，到nums.length-1结束
        for (int i = 0; i < nums.length-1; i++) {
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target)return new int[]{i,j};
            }
        }
        return null;
    }
    //hash映射
    public static int[] twoSum1(int[] nums, int target) {
        //该题的主要难点在于,取得 补数 的时间上
        //我们把值作为key 数组角标作为value 存放在Map中,
        // 那么我们去获得补数就只需要直接使用 get() 就可以获得了
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i]))return new int[]{i,map.get(target-nums[i])};
            map.put(nums[i],i);
        }

        return null;
    }

}
