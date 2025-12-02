package com.data_structures.java.linkedlist;
 
/**
* Singly Linked List implementation.
*
* Operations:
*  - insertAtHead
*  - insertAtTail
*  - deleteByValue
*  - search
*  - size
*  - printList
*
* Time Complexity:
*  - insertAtHead: O(1)
*  - insertAtTail: O(1) with tail pointer
*  - deleteByValue: O(n)
*  - search: O(n)
*/
public class SinglyLinkedList<T> {
 
    private static class Node<U> {
        U data;
        Node<U> next;
 
        Node(U data) {
            this.data = data;
        }
    }
 
    private Node<T> head;
    private Node<T> tail;
    private int size;
 
    public void insertAtHead(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
 
        if (tail == null) {
            tail = newNode;
        }
 
        size++;
    }
 
    public void insertAtTail(T value) {
        Node<T> newNode = new Node<>(value);
        if (tail == null) {
            // empty list
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
 
    public boolean deleteByValue(T value) {
        if (head == null) return false;
 
        // if head needs to be deleted
        if (head.data.equals(value)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return true;
        }
 
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;
        }
 
        if (current.next == null) {
            return false; // value not found
        }
 
        // delete node
        current.next = current.next.next;
        if (current.next == null) {
            tail = current;
        }
        size--;
        return true;
    }
 
    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
 
    public int size() {
        return size;
    }
 
    public void printList() {
        Node<T> current = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
 
    // Simple demo
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertAtHead(10);
        list.insertAtHead(5);
        list.insertAtTail(20);
        list.insertAtTail(30);
 
        System.out.print("List: ");
        list.printList(); // [5 -> 10 -> 20 -> 30]
 
        System.out.println("Contains 20? " + list.contains(20)); // true
        System.out.println("Contains 40? " + list.contains(40)); // false
 
        list.deleteByValue(10);
        System.out.print("After delete 10: ");
        list.printList(); // [5 -> 20 -> 30]
 
        System.out.println("Size: " + list.size());
    }
}