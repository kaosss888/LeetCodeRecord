package com.sweartooffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 复制带随机指针的链表
 */
public class CopyRandomList {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node old = head;
        Node target = new Node();
        target.val = old.val;

        map.put(old, target);

        while (old != null) {

            target.next = getTargetNode(old.next);
            target.random = getTargetNode(old.random);

            old = old.next;
            target = target.next;
        }

        return map.get(head);
    }

    public Node getTargetNode(Node node) {
        if (node == null) {
            return null;
        } else {
            if (map.containsKey(node)) {
                return map.get(node);
            } else {
                map.put(node, new Node(node.val, null, null));
                return map.get(node);
            }
        }
    }
}
