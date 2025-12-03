package com.data_structures.java.stack;
 
/**
* Stack implementation using an array.
*
* Operations:
*  - push
*  - pop
*  - peek
*  - isEmpty
*  - size
*
* Time Complexity:
*  push: O(1)
*  pop: O(1)
*  peek: O(1)
*/
public class StackUsingArray<T> {
 
    private T[] data;
    private int top; // index of top element
    private static final int DEFAULT_CAPACITY = 10;
 
    @SuppressWarnings("unchecked")
    public StackUsingArray() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }
 
    @SuppressWarnings("unchecked")
    public StackUsingArray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        data = (T[]) new Object[capacity];
        top = -1;
    }
 
    public boolean isEmpty() {
        return top == -1;
    }
 
    public int size() {
        return top + 1;
    }
 
    public void push(T value) {
        if (top == data.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        data[++top] = value;
    }
 
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot pop from empty stack");
        }
        return data[top--];
    }
 
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data[top];
    }
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[Bottom -> ");
        for (int i = 0; i <= top; i++) {
            sb.append(data[i]);
            if (i < top) sb.append(", ");
        }
        sb.append(" <- Top]");
        return sb.toString();
    }
 
    public static void main(String[] args) {
        StackUsingArray<Integer> st = new StackUsingArray<>();
 
        st.push(10);
        st.push(20);
        st.push(30);
 
        System.out.println("Stack: " + st);
        System.out.println("Top : " + st.peek());
 
        System.out.println("Popped: " + st.pop());
        System.out.println("After pop: " + st);
    }
}