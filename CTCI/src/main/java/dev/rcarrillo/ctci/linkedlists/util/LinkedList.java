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

    public static LinkedList sumLists(LinkedList number1, LinkedList number2) {
        if (Objects.isNull(number1) || Objects.isNull(number2)) {
            throw new RuntimeException("Numbers can't be null");
        }
        Node currentl1 = number1.head;
        Node currentl2 = number2.head;
        int temporaryNumber = 0;
        LinkedList result = new LinkedList();
        while(Objects.nonNull(currentl1) || Objects.nonNull(currentl2)){
            int n1 = 0;
            int n2 = 0;
            if(Objects.nonNull(currentl1)){
                n1 = currentl1.value;
                currentl1 = currentl1.next;
            }
            if(Objects.nonNull(currentl2)){
                n2 = currentl2.value;
                currentl2 = currentl2.next;
            }
            int sum = n1+n2+temporaryNumber;
            result.add(sum%10);
            temporaryNumber = sum/10;
        }
        if(temporaryNumber>0){
            result.add(temporaryNumber);
        }
        return result;
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
