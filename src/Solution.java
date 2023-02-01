public class Solution {
    public static void main(String[] args) {
        int[] arrayA = {1};
        int[] arrayB = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50};
        int[] arrayC = {51};


        ListNode nodeA = createListNode(arrayA);
        ListNode nodeB = createListNode(arrayB);
        ListNode nodeC = createListNode(arrayB);

        traversal(nodeA);
        ListNode headA = mergeTwoLinkedLists(nodeB, nodeC);

        traversal(headA);

    }

    private static ListNode mergeTwoLinkedLists(ListNode nodeA, ListNode nodeC) {
        ListNode newNode = null;
        while (nodeA != null) {
            newNode = nodeA;
            nodeA = nodeA.next;
            newNode = newNode.next;
        }
        return null;

    }

    private static ListNode createListNode(int[] array) {
        ListNode newNode = null;
        ListNode currentNode = null;
        for (int a : array) {
            if (newNode == null) {
                newNode = new ListNode(a);
                currentNode = newNode;
            } else {
                currentNode.next = new ListNode(a);
                currentNode = currentNode.next;
            }
        }
        return newNode;
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

        if (shorterSize == 1 && longestSize == 2) {
            if (shorter.hashCode() == longest.next.hashCode()) {
                return shorter;
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
        System.out.println('\n');
    }
}
