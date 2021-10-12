package dev.rcarrillo.ctci.linkedlists;

import dev.rcarrillo.ctci.linkedlists.util.LinkedList;

/**
 * You have two numbers represented by a linked list where each node is a digit, the digits are stored in reverse order so the first node is the last digit.
 * Write a function that returns the sum of both numbers as a Linked List (in the same reverse order as the inputs)
 * Ej: sumLists([981],[638]) -> sum 189+836
 * Expected Output : List[5,2,0,1] => 1025
 */
public class SumLists {
    public static void main(String[] args) {
        LinkedList number1 = new LinkedList();
        number1.addAll(1); // 189
        LinkedList number2 = new LinkedList();
        number2.addAll(3,0,0); // 836

        LinkedList result = LinkedList.sumLists(number1,number2);
        System.out.println(result);
    }


}
