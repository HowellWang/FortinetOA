package reversenode;

/**
 * Created by yuhaowang on 9/14/17.
 */
public class ReverseLinkedList {
    /**
     * @param head
     * @return
     */
    //time complexity: O(n), space complexity: O(1)
    public Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

class Node {
    Node next;
    int value;
}
