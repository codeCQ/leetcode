package simple.code_141;

/**
 * author ChenQian
 * leetcode题目编码 141
 * date 2020.11.15
 */
public class Demo01 {
    public static void main(String[] args) {

    }
    //给定一个链表，判断链表中是否有环。

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //这里我们就不列举 暴力的 hashmap方法：从头遍历先每个存入到hashmap，再拿到下一个
    //去判断hashmap里有没有相同的 有就是回环
    //这里我们采用 快慢双指针
    //一个每次跳2格 一个每次进一格
    //如果有环 那么这两个指针 最后一定会指向同一个节点
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow != fast){
            if(fast==null || fast.next==null)return false;
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
