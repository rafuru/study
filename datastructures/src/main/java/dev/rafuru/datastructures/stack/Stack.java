package dev.rafuru.datastructures.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<E> {
    
    private E[] stack ;
    private final int DEFAULT_SIZE = 100;
    private int top = -1;

    public Stack(Class<E> clazz){
        stack = (E[])Array.newInstance(clazz, DEFAULT_SIZE);
    }

    public Stack(Class<E> clazz, int size){
        stack = (E[])Array.newInstance(clazz, size);
    }

    public void push(E object){
        stack[++top] = object;
    }

    public int getSize(){
        return top+1;
    }

    public E pop(){
        if(top == -1){
            return null;
        }
        return stack[top--];
    }

    public E peek(){
        if(top == -1){
            return null;
        }
        return stack[top];
    }
    

}