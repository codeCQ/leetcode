package simple.code_876;

import simple.Utils.ListNode;

public class Demo01 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

        public ListNode middleNode(ListNode head) {
            //定义2个指针,一个快(每次2步),一个慢(每次1步)
            ListNode fast = head;
            ListNode slow = head;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
}
