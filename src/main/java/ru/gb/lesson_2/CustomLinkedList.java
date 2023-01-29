package ru.gb.lesson_2;


import java.util.Objects;

public class CustomLinkedList<E> {

    private Node<E> firstElement;
    private Node<E> lastElement;
    private int size = 0;

    public CustomLinkedList() {
    }

    public void add(E e) {
        if (firstElement == null && lastElement == null) {
            Node<E> node = new Node<>(e);
            node.setPrevAndNext(node, node);
            firstElement = node;
            size++;
            return;
        }
        if (lastElement == null) {
            Node<E> nextNode = new Node<>(e);
            Objects.requireNonNull(firstElement).next = nextNode;
            nextNode.setPrevAndNext(firstElement, nextNode);
            lastElement = nextNode;
            size++;
            return;
        }
        Node<E> regularNode = new Node<>(e);
        this.lastElement.setNext(regularNode);
        setLinks(regularNode);
        this.size++;
    }

    public boolean contains(E e) {
        Node<E> iterableElement = firstElement;
        while (hasNext(iterableElement)) {
            if (iterableElement.data.equals(e)) {
                return true;
            }
            iterableElement = iterableElement.next;
        }
        return false;
    }

    public Node<E> findElement(E e){
        Node<E> iterableElement = firstElement;
        while (hasNext(iterableElement)) {
            if (iterableElement.data.equals(e)) {
                return iterableElement;
            }
            iterableElement = iterableElement.next;
        }
        return null;
    }

    public void removeFirst() {
        if (size == 2) {
            firstElement = lastElement;
            firstElement.setPrevAndNext(firstElement, firstElement);
            lastElement = null;
            size--;
            return;
        }
        if (size == 1) {
            firstElement = null;
            size = 0;
            return;
        }
        Node<E> afterFirstNode = firstElement.next;
        afterFirstNode.setPrev(afterFirstNode);
        firstElement = afterFirstNode;
        size--;
    }

    public void removeLast() {
        if (size == 2) {
            lastElement = null;
            firstElement.setPrevAndNext(firstElement, firstElement);
            size--;
            return;
        }
        if (size == 1) {
            firstElement = null;
            size = 0;
            return;
        }
        Node<E> prevNode = lastElement.prev;
        prevNode.setNext(prevNode);
        lastElement = prevNode;
        size--;
    }

    public void showAll() {
        if (size == 0) {
            System.out.println("В колллеции нет элементов!");
            return;
        }
        Node<E> iterableElement = firstElement;
        while (hasNext(iterableElement)) {
            System.out.print(iterableElement + " ");
            iterableElement = iterableElement.next;
        }
        System.out.println(iterableElement + " ");

    }

    private boolean hasNext(Node<E> node) {
        return !node.next.equals(node);
    }

    private void setLinks(Node<E> node) {
        node.prev = lastElement;
        node.next = node;
        lastElement = node;
    }

    public int getSize() {
        return size;
    }

    public Node<E> getFirstElement() {
        return firstElement;
    }

    public Node<E> getLastElement() {
        return lastElement;
    }

    private static class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public void setPrevAndNext(Node<E> prev, Node<E> next) {
            this.prev = prev;
            this.next = next;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
        public E getData() {
            return data;
        }
        public void setData(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

}