package dev.rcarrillo.ctci.linkedlists.util;

import java.util.Objects;
import java.util.Optional;

/**
 * Custom linkedlist implementation, this class WON'T implement the List or Collection interface
 */
public class LinkedList {
    private Node head;

    /**
     * Utility method to add a set of values
     *
     * @param values
     */
    public void addAll(int... values) {
        for (int v : values) {
            add(v);
        }
    }

    public void add(int value) {
        if (Objects.isNull(head)) {
            head = new Node(value);
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node(value);
    }

    public void removeDups() {
        Node current = head;
        while (Objects.nonNull(current)) {
            Node runner = current;
            while (Objects.nonNull(runner.next)) { // this turns the algorithm into an O(N^2), not sure if I can improve it without using a buffer
                if (runner.next.value == current.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    public Optional<Node> getNode(int value) {
        Node current = head;
        while (Objects.nonNull(current)) {
            if (current.value == value) {
                return Optional.of(current);
            }
            current = current.next;
        }
        return Optional.empty();
    }

    //WIP
    public static LinkedList sumLists(LinkedList number1, LinkedList number2) {
        if (Objects.isNull(number1) || Objects.isNull(number2)) {
            throw new RuntimeException("Numbers can't be null");
        }
        Node current = number1.head;
        return null;
    }
    //WIP
    private static int parseNumberFromList(LinkedList list) {
        StringBuilder sb = new StringBuilder();
        Node current = list.head;
        while (Objects.nonNull(current)) {
            sb.append(current.value);
            current = current.next;
        }
        return Integer.parseInt(sb.toString());

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = head;
        while (Objects.nonNull(currentNode)) {
            sb.append(currentNode.value);
            currentNode = currentNode.next;
            if (Objects.nonNull(currentNode)) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * non recursive solution / complexity o(n*2) -> o(n)
     *
     * @param k
     * @return
     */
    public int findKthToLast(int k) {
        Node currentNode = head;
        Node runnerNode = head;
        int length = 0;
        while (Objects.nonNull(runnerNode)) {
            length++;
            runnerNode = runnerNode.next;
        }
        if (k > length) {
            throw new RuntimeException("k out of bounds");
        }
        int targetPosition = length - k;
        int currentPosition = 1;
        while (Objects.nonNull(currentNode)) {
            if (currentPosition == targetPosition) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
            currentPosition++;
        }
        throw new RuntimeException("value not found");
    }

    public void removeMiddleNode(Node node) {
        if (Objects.isNull(node.next)) {
            throw new RuntimeException("You can't remove the last node");
        }
        node.value = node.next.value;
        node.next = node.next.next;
    }


    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
