public class Solution {
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
        System.out.println(getIntersectionNode(nodeA, nodeB).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode shorter = findShorter(headA, headB);
        ListNode longest = findLongest(headA, headB);
        int shorterSize = findNodeSize(shorter);
        int longestSize = findNodeSize(longest);
        int diff = longestSize - shorterSize;

        if (shorterSize == 1 && longestSize == 1) {
            if (shorter.hashCode() == longest.hashCode()) {
                return shorter;
            } else {
                return null;
            }
        }


        if (longestSize == shorterSize) {
            for (int i = 0; i < longestSize - 1; i++) {

                if (longest.hashCode() == shorter.hashCode()) {
                    return longest;
                }
                shorter = shorter.next;
                longest = longest.next;
            }

        } else {
            for (int i = 0; i < longestSize - 1; i++) {

                if (i >= diff) {
                    if (longest.hashCode() == shorter.hashCode()) {
                        return longest;
                    }
                    shorter = shorter.next;
                }
                longest = longest.next;
            }
        }

        return null;
    }

    private static int findNodeSize(ListNode head) {
        int count = 0;
        ListNode currentNode = head;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    private static ListNode findLongest(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode currentA = headA;
        ListNode currentB = headB;

        while (currentA != null) {
            countA++;
            currentA = currentA.next;
        }

        while (currentB != null) {
            countB++;
            currentB = currentB.next;
        }

        return countA > countB ? headA : headB;
    }

    private static ListNode findShorter(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode currentA = headA;
        ListNode currentB = headB;

        while (currentA != null) {
            countA++;
            currentA = currentA.next;
        }

        while (currentB != null) {
            countB++;
            currentB = currentB.next;
        }
        return countA > countB ? headB : headA;
    }

    public static void traversal(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
    }
}