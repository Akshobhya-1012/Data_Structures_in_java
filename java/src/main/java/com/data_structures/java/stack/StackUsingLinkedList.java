package com.data_structures.java.stack;
 
/**
* Stack implementation using a singly linked list.
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
public class StackUsingLinkedList<T> {
 
    private static class Node<U> {
        U data;
        Node<U> next;
 
        Node(U data) {
            this.data = data;
        }
    }
 
    private Node<T> top;
    private int size;
 
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }
 
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot pop from empty stack");
        }
        T value = top.data;
        top = top.next;
        size--;
        return value;
    }
 
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }
 
    public boolean isEmpty() {
        return top == null;
    }
 
    public int size() {
        return size;
    }
 
    public void printStack() {
        Node<T> curr = top;
        StringBuilder sb = new StringBuilder("[Top -> ");
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) sb.append(" -> ");
            curr = curr.next;
        }
        sb.append("]");
        System.out.println(sb);
    }
 
    public static void main(String[] args) {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
 
        System.out.print("Stack: ");
        stack.printStack();
 
        System.out.println("Peek: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
 
        System.out.print("After pop: ");
        stack.printStack();
 
        System.out.println("Size: " + stack.size());
        System.out.println("Is empty? " + stack.isEmpty());
    }
}