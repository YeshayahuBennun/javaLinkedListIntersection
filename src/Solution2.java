public class Solution2 {
    public static void main(String[] args) {
        ListNode nodeC = new ListNode(8);
        nodeC.next = new ListNode(4);
        nodeC.next.next = new ListNode(5);

        ListNode nodeA = new ListNode(4);
        nodeA.next = new ListNode(1);

        ListNode nodeB = new ListNode(5);
        nodeB.next = new ListNode(6);
        nodeB.next.next = new ListNode(1);
        nodeB.next.next.next = nodeC;


        nodeA.next.next = nodeC;
        traversal(nodeA);
        traversal(nodeB);
    }

    private static ListNode getIntersectionNode(ListNode nodeA, ListNode nodeB) {
        //TODO
        return null;
    }

    public static void traversal(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println('\n');
    }
}

