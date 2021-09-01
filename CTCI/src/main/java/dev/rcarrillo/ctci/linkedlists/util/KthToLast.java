package dev.rcarrillo.ctci.linkedlists.util;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 * Ej:
 * input: list = [1,2,3,4,5,6], k=3
 * Output: 3 (list length - k)
 */
public class KthToLast {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAll(1,2,3,4,5,6);
        int kthElement = list.findKthToLast(3);// expected 3
        System.out.println(kthElement);

        LinkedList list2 = new LinkedList();
        list2.addAll(1,2,3,4,5,6,7,8,9);
        int kth2 = list2.findKthToLast(8); // expected 1
        System.out.println(kth2);

        LinkedList list3 = new LinkedList();
        list3.addAll(1,2,3,4,5,6,7,8,9); // expected exception
        list.findKthToLast(20);
    }
}
