public class RemoveNthNode {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public static ListNode attempt1(ListNode head, int n) {
         ListNode currNode = head;
         int size = 0;
         while (currNode != null) {
             currNode = currNode.next;
             size++;
         }
         currNode = head;
         n = size - n;
         System.out.println(n);
         if (currNode == null) {
             return currNode;
         } else if (n == 0) {
             return currNode.next;
         } else {
             for (int i = 0; i < n - 1; i++) {
                 if (currNode == null)
                     return head;
                 currNode = currNode.next;
             }
             if (currNode != null && currNode.next != null)
                 currNode.next = currNode.next.next;
             return head;
         }
     }
}
