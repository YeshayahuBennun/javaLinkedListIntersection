public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        //Empty
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void createLinkedList(int nodeValue) {
        Node newNode = new Node();
        newNode.setValue(nodeValue);
        head = newNode;
        tail = newNode;
        tail.setNext(null);
        size = 1;
    }

    public void insertNode(int nodeValue) {
        if (head == null) {
            createLinkedList(nodeValue);
        } else {
            Node newNode = new Node();
            newNode.setValue(nodeValue);
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
    }

    public void traversalLinkedList() {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode.getValue());
            if (i < size - 1) {
                System.out.print(" -> ");
            }
            currentNode = currentNode.getNext();
        }
        System.out.println("\n");
    }


}
