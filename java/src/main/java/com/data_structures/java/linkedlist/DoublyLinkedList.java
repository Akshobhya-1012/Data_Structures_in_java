package com.data_structures.java.linkedlist;
 
/**
* Doubly Linked List implementation.
*
* Operations:
*  - insertAtHead
*  - insertAtTail
*  - deleteByValue
*  - contains
*  - size
*  - printForward
*  - printBackward
*
* Time Complexity:
*  insertAtHead: O(1)
*  insertAtTail: O(1)
*  deleteByValue: O(n)
*  contains: O(n)
*/
public class DoublyLinkedList<T> {
 
    private static class Node<U> {
        U data;
        Node<U> prev;
        Node<U> next;
 
        Node(U d) {
            this.data = d;
        }
    }
 
    private Node<T> head;
    private Node<T> tail;
    private int size;
 
    public void insertAtHead(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
 
        if (head != null) {
            head.prev = newNode;
        }
 
        head = newNode;
 
        if (tail == null) {
            tail = newNode;
        }
 
        size++;
    }
 
    public void insertAtTail(T value) {
        Node<T> newNode = new Node<>(value);
 
        if (tail == null) {
            head = tail = newNode;
            size++;
            return;
        }
 
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
 
        size++;
    }
 
    public boolean contains(T value) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.data.equals(value)) return true;
            curr = curr.next;
        }
        return false;
    }
 
    public boolean deleteByValue(T value) {
        Node<T> curr = head;
 
        while (curr != null && !curr.data.equals(value)) {
            curr = curr.next;
        }
 
        if (curr == null) return false; // value not found
 
        // Case: deleting head
        if (curr == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        }
        // Case: deleting tail
        else if (curr == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // Case: middle node
        else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
 
        size--;
        return true;
    }
 
    public int size() {
        return size;
    }
 
    public void printForward() {
        Node<T> curr = head;
        StringBuilder sb = new StringBuilder("[");
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) sb.append(" <-> ");
            curr = curr.next;
        }
        sb.append("]");
        System.out.println(sb);
    }
 
    public void printBackward() {
        Node<T> curr = tail;
        StringBuilder sb = new StringBuilder("[");
        while (curr != null) {
            sb.append(curr.data);
            if (curr.prev != null) sb.append(" <-> ");
            curr = curr.prev;
        }
        sb.append("]");
        System.out.println(sb);
    }
 
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
 
        list.insertAtHead(10);
        list.insertAtHead(5);
        list.insertAtTail(20);
        list.insertAtTail(30);
 
        System.out.print("Forward : ");
        list.printForward();
 
        System.out.print("Backward: ");
        list.printBackward();
 
        System.out.println("Contains 20? " + list.contains(20));
        list.deleteByValue(10);
 
        System.out.print("After delete: ");
        list.printForward();
    }
}