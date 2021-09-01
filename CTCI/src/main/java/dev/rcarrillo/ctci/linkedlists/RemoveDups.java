package dev.rcarrillo.ctci.linkedlists;

import dev.rcarrillo.ctci.linkedlists.util.LinkedList;

/**
 * Write the code to remove the duplicate entries in an unsorted linkedList without relying on a temporary buffer
 */
public class RemoveDups {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAll(3,3,4,3,4);
        list.removeDups();
        System.out.println(list); //expected : 3,4

        LinkedList list2 = new LinkedList();
        list2.addAll(1,2,3,4); // expected 1,2,3,4
        list2.removeDups();
        System.out.println(list2);

        LinkedList list3 = new LinkedList();
        list3.addAll(1,1,2,2,3,3,4,4,5,5,6,6,1,1,8,9);
        list3.removeDups();
        System.out.println(list3); // expected 1,2,3,4,5,6,8,9
    }


}
