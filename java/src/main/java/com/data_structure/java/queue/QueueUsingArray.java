package com.data_structure.java.queue;
 
/**
* Simple Queue implementation using an array.
*
* This version shifts elements on dequeue, so:
*  - enqueue: O(1) (amortized)
*  - dequeue: O(n) (due to shifting)
*
* Useful to understand the inefficiency before using CircularQueue.
*/
public class QueueUsingArray<T> {
 
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
 
    @SuppressWarnings("unchecked")
    public QueueUsingArray() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
 
    @SuppressWarnings("unchecked")
    public QueueUsingArray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        data = (T[]) new Object[capacity];
        size = 0;
    }
 
    public boolean isEmpty() {
        return size == 0;
    }
 
    public int size() {
        return size;
    }
 
    public void enqueue(T value) {
        ensureCapacity();
        data[size++] = value;
    }
 
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot dequeue from empty queue");
        }
        T front = data[0];
        // shift left
        for (int i = 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size - 1] = null;
        size--;
        return front;
    }
 
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data[0];
    }
 
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        if (size == data.length) {
            int newCapacity = data.length * 2;
            T[] newData = (T[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[Front -> ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append(" <- Rear]");
        return sb.toString();
    }
 
    public static void main(String[] args) {
        QueueUsingArray<Integer> q = new QueueUsingArray<>();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
 
        System.out.println("Queue: " + q);
        System.out.println("Peek : " + q.peek());
 
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("After dequeue: " + q);
        System.out.println("Size: " + q.size());
    }
}