package com.data_structures.java.arrays;

/**
 * Dynamic Array implementation similar to ArrayList.
 *
 * Supports:
 *  - add(element)
 *  - get(index)
 *  - set(index, element)
 *  - removeAt(index)
 *  - size()
 *
 * Internal idea:
 *  - Use a fixed-size array internally.
 *  - When it becomes full, create a new array with 2x capacity and copy elements.
 *
 * Time Complexity (Amortized):
 *  - add: O(1)
 *  - get: O(1)
 *  - set: O(1)
 *  - removeAt: O(n) (due to shifting)
 */
public class DynamicArray<T> {
 
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
 
    @SuppressWarnings("unchecked")
    public DynamicArray() {
        this.data = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
 
    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }
 
    public int size() {
        return size;
    }
 
    public boolean isEmpty() {
        return size == 0;
    }
 
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }
 
    public void set(int index, T value) {
        checkIndex(index);
        data[index] = value;
    }
 
    public void add(T value) {
        ensureCapacity();
        data[size++] = value;
    }
 
    public T removeAt(int index) {
        checkIndex(index);
        T removed = data[index];
        // shift left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return removed;
    }
 
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
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
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
 
    // Simple demo
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        System.out.println("Array: " + arr);       // [10, 20, 30]
        System.out.println("Size: " + arr.size()); // 3
 
        arr.removeAt(1);
        System.out.println("After removeAt(1): " + arr); // [10, 30]
 
        arr.set(1, 40);
        System.out.println("After set(1, 40): " + arr); // [10, 40]
 
        System.out.println("Element at index 0: " + arr.get(0)); // 10
    }
}
 