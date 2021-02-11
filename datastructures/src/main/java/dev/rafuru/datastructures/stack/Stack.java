package dev.rafuru.datastructures.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Pseudo implementation of a stack
 * it stores data, it pops and it peeks
 * @author Rafael Carrillo
 */

public class Stack<E> {
    
    private Object[] stack ;
    private final int DEFAULT_SIZE = 100;
    private int top = -1;

    public Stack(Class<E> clazz){
        stack = new Object[DEFAULT_SIZE];
    }

    public Stack(Class<E> clazz, int size){
        stack = new Object[size];
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
        E tmp = elementData(top); 
        stack[top--] = null;
        return tmp;
    }

    public E peek(){
        if(top == -1){
            return null;
        }
        return elementData(top);
    }

    // I took this from the ArrayList Implementation to avoid compile warnings
    @SuppressWarnings("unchecked")
    private E elementData(int index){
        return (E) stack[index];
    }

}