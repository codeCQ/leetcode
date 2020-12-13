package simple.linkedlist.code_21;

import simple.linkedlist.Utils.ListNode;

public class Demo01 {
    public static void main(String[] args) {

        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(4,null)));
        ListNode l2=new ListNode(1,new ListNode(3,new ListNode(4,null)));
        System.out.println(mergeTwoLists(l1,l2));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    //输入：1->2->4, 1->3->4
    //输出：1->1->2->3->4->4
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)return l2;
        if(l2 == null)return l1;

        //一定要从大的往小的中插入
        if(l2.val < l1.val){
            ListNode temp=l1;
            l1=l2;
            l2=temp;
        }
        ListNode l2ToL1=l2;
        ListNode insertBit=l1;
        do{
            while(insertBit.next!=null && l2ToL1.val>=insertBit.next.val ){
                insertBit=insertBit.next;
            }
            ListNode insertBitNext=insertBit.next;
            //插入
            insertBit.next=l2ToL1;
            ListNode l2temp=l2ToL1.next;
            l2ToL1.next=insertBitNext;
            l2ToL1= l2temp;

        }while(l2ToL1 != null);
        return l1;
    }
}
