import java.util.Queue;
import java.util.PriorityQueue;

public class MergeKLists {
     public class ListNode implements Comparable<ListNode>{
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         @Override
         public int compareTo(ListNode node) {
             return Integer.compare(this.val, node.val);
         }
     }

     private class NodeAndInt implements Comparable<NodeAndInt>{
         public int val;
         public ListNode node;

         NodeAndInt(int val, ListNode node) {
             this.val = val;
             this.node = node;
         }

         @Override
         public int compareTo(NodeAndInt node) {
             return Integer.compare(this.val, node.val);
         }
     }

     public ListNode attempt1(ListNode[] lists) {
         if (lists.length == 0) {
             return new ListNode();
         } else if (lists.length == 1) {
             return lists[0];
         } else {
             ListNode rvalHead = new ListNode();
             ListNode currNode = rvalHead;
             Queue<NodeAndInt> currHeads = new PriorityQueue<>();
             for (int i = 0; i < lists.length; i++) {
                 if (lists[i] != null){
                     currHeads.add(new NodeAndInt(lists[i].val, lists[i]));
                 }
             }

             NodeAndInt nodeAndInt;
             while (!currHeads.isEmpty()) {
                 nodeAndInt = currHeads.poll();
                 currNode.next = nodeAndInt.node;
                 if (nodeAndInt.node.next != null) {
                    currHeads.add(new NodeAndInt(nodeAndInt.node.next.val, nodeAndInt.node.next));
                 }
                 currNode = currNode.next;
             }
             return rvalHead.next;
         }
     }
}
