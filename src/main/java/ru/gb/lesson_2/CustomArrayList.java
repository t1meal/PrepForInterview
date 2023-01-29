package ru.gb.lesson_2;

import java.util.Arrays;

public class CustomArrayList<E> {
    private static final int DEFAULT_SIZE = 10;
    protected int size;
    private E[] data;

    public CustomArrayList() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public CustomArrayList(int size) {
        this.data = (E[]) new Comparable[size];
    }

    public void add(E object) {
        checkAndGrow();
        data[size++] = object;
    }

    public E get(int index) {
        if (checkIndex(index))
            throw new IndexOutOfBoundsException(
                    String.format("Incorrect index value: %d. Array size: %d", index, size));
        return data[index];
    }

    public int indexOf(E object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        System.arraycopy(data, index + 1, data, index, size - 1 - index);
        data[--size] = null;
    }

    public void remove(E object) {
        remove(indexOf(object));
    }

    public boolean contains(E object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    public void showAll() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]).append(", ");
        }
        sb.append(data[size - 1]).append("]");
        System.out.println(sb);
    }
    private void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, recallSize());
        }
    }

    private int recallSize() {
        return size == 0 ? 1 : size * 2;
    }

    private boolean checkIndex(int index) {
        return index < 0 || index >= size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }
}
