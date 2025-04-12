package MyCollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T value;
        MyNode next, prev;
        MyNode(T value) { this.value = value; }
    }

    private MyNode head, tail;
    private int size;

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(element);
        else if (index == size) addLast(element);
        else {
            MyNode current = getNode(index);
            MyNode newNode = new MyNode(element);
            MyNode prevNode = current.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = current;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T element) {
        MyNode newNode = new MyNode(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        MyNode newNode = new MyNode(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return head.value;
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return tail.value;
    }

    @Override
    public T remove(int index) {
        MyNode node = getNode(index);
        return removeNode(node);
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return removeNode(head);
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        return removeNode(tail);
    }

    private T removeNode(MyNode node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
        return node.value;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode current = head;
            public boolean hasNext() { return current != null; }
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T val = current.value;
                current = current.next;
                return val;
            }
        };
    }
}

