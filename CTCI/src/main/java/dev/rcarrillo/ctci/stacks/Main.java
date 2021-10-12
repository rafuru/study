package dev.rcarrillo.ctci.stacks;

import dev.rcarrillo.ctci.stacks.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<>();
        test.push(1);
        test.push(4);
        System.out.println(test.pop()); // expected 4
        System.out.println(test.peek()); // expected 1
        System.out.println(test.pop());
        System.out.println(test.peek());
    }
}
