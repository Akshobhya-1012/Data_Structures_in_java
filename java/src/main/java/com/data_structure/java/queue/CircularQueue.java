package com.data_structure.java.queue;
 
/**
 * Circular Queue implementation using an array.
 *
 * Uses front, rear, and size to achieve:
 *  - enqueue: O(1)
 *  - dequeue: O(1)
 *
 * This avoids shifting elements like the basic QueueUsingArray.
 */
public class CircularQueue<T> {
 
    private T[] data;
    private int front; // index of front element
    private int rear;  // index where next element will be inserted
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
 
    @SuppressWarnings("unchecked")
    public CircularQueue() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }
 
    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        data = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }
 
    public boolean isEmpty() {
        return size == 0;
    }
 
    public boolean isFull() {
        return size == data.length;
    }
 
    public int size() {
        return size;
    }
 
    public void enqueue(T value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        data[rear] = value;
        rear = (rear + 1) % data.length;
        size++;
    }
 
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot dequeue from empty queue");
        }
        T value = data[front];
        data[front] = null; // optional: help GC
        front = (front + 1) % data.length;
        size--;
        return value;
    }
 
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data[front];
    }
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[Front -> ");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % data.length;
            sb.append(data[idx]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append(" <- Rear]");
        return sb.toString();
    }
 
    public static void main(String[] args) {
        CircularQueue<Integer> q = new CircularQueue<>(5);
 
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
 
        System.out.println("Queue: " + q);
        System.out.println("Peek : " + q.peek());
 
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("After dequeue: " + q);
 
        q.enqueue(40);
        q.enqueue(50);
        System.out.println("After enqueue 40, 50: " + q);
 
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("After dequeue: " + q);
    }
}
 