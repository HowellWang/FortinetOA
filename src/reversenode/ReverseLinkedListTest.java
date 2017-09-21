package reversenode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yuhaowang on 9/20/17.
 */
public class ReverseLinkedListTest {

    ReverseLinkedList rl;

    @Before
    public void setUp() throws Exception {
        rl = new ReverseLinkedList();
    }

    @Test
    public void test1() throws Exception {
        assertNull(rl.reverse(null));
    }

    @Test
    public void test2() throws Exception {
        Node head = new Node();
        assert head == rl.reverse(head);
    }

    @Test
    public void test3() throws Exception {
        Node head = new Node();
        head.value = 1;
        Node next = new Node();
        next.value = 2;
        head.next = next;
        assert rl.reverse(head) == next;
        assert next.next == head;
    }


    @Test
    public void test4() throws Exception {
        Node node1 = new Node();
        node1.value = 1;
        Node node2 = new Node();
        node2.value = 2;
        node1.next = node2;
        Node node3 = new Node();
        node3.value = 3;
        node2.next = node3;

        assert rl.reverse(node1) == node3;
        assert node3.next == node2;

    }

    @After
    public void tearDown() throws Exception {
        rl = null;
        assertNull(rl);
    }



}