package simple.linkedlist.code_19;

import simple.linkedlist.Utils.ListNode;

public class Demo01 {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1,new ListNode(2,null));
        removeNthFromEnd(listNode,1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null){
            return null;
        }
//        if(n==1){
//            n=n+1;
//        }
        ListNode no1=head;
        ListNode no2=head;
        int y=0;
        while(y<=n && no2!=null){
            y++;
            no2=no2.next;
        }
        int i=0;
        while(no2 != null){
            no1=no1.next;
            no2=no2.next;
            i++;
        }
        if(i==0){
            return head.next;
        }
        no1.next=no1.next.next;
        return head;
    }
}
