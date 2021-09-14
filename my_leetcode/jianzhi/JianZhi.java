package jianzhi;

import simple.linkedlist.Utils.ListNode;

import java.util.*;

public class JianZhi {
    public static void main(String args) {
        int[] nums={2, 2, 1, 0, 2, 5, 3};
//        int number = findRepeatNumber(nums);
//        System.out.println(number);

        System.out.println(majorityElement2(nums));
    }

    /**
     *
     * 剑指 Offer 03. 数组中重复的数字
     找出数组中重复的数字。
     在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     请找出数组中任意一个重复的数字。
     示例 1：
     输入：
     [2, 3, 1, 0, 2, 5, 3]
     输出：2 或 3
     */
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        int re=-1;
        for (int num : nums) {
            if (!set.add(num)){
                re=num;
                return  re;
            }
        }
        return re;
    }


    /**
     *
     剑指 Offer 39. 数组中出现次数超过一半的数字 1
     数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     示例 1:

     输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     输出: 2
     排序解决
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    /**
     *
     剑指 Offer 39. 数组中出现次数超过一半的数字 2
     数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     示例 1:

     输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     输出: 2
     投票计数
     */
    public static int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> hashMap = countTime(nums);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {
            System.out.println(integerIntegerEntry);
        }
        int max=-1;
        int num=-1;
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) > max){
                max=hashMap.get(integer);
                num=integer;
            }
        }
        return num;
    }

    public static HashMap<Integer,Integer> countTime(int[] nums){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i]) ){
                hashMap.put(nums[i],1);
            }else {
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }
        }
        return hashMap;
    }

    /**
     *
     剑指 Offer 05. 替换空格
     请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

     示例 1：
     输入：s = "We are happy."
     输出："We%20are%20happy."
     */
    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }

    /**
     *
     剑指 Offer 06. 从尾到头打印链表
     输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

     示例 1：

     输入：head = [1,3,2]
     输出：[2,3,1]
     */
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        ListNode node=head;
        while (node!=null){
            stack.push(node);
            node=node.next;
        }

        int size = stack.size();
        int[] arr=new int[stack.size()];
        //注意点：这里如果 size换成 stack.size()，随着pop stack.size()会变化
        for (int i = 0; i < size; i++) {
            arr[i]=stack.pop().getVal();
        }
        return arr;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1,new ListNode(3,new ListNode(2,null)));
        int[] ints = reversePrint(listNode);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
