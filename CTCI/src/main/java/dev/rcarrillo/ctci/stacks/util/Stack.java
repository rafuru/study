package dev.rcarrillo.ctci.stacks.util;

import java.util.Objects;

public class Stack <T>{
    private StackNode<T> top;

    public Stack(){
    }

    public void push(T value){
        if(Objects.isNull(top)){
            top = new StackNode<>(value);
            return;
        }
        StackNode<T> newNode = new StackNode<>(value);
        newNode.next = top;
        top = newNode;
    }

    public T pop(){
        if(Objects.isNull(top)){
            throw new RuntimeException("pop operation on empty stack");
        }
        T value = top.value;
        top = top.next;
        return value;
    }

    public T peek(){
        if(Objects.isNull(top)){
            throw new RuntimeException("peek operation on empty stack");
        }
        return top.value;
    }
}
