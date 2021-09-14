package simple.linkedlist.code_206_reverseList;

import simple.linkedlist.Utils.ListNode;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode()))));
        System.out.println(head);
        ListNode node = reverseList(head);
        System.out.println(node);

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre=null;
        ListNode next=null;
        while( head != null ){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
