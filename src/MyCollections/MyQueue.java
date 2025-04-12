package MyCollections;

public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T value) {
        list.addLast(value);
    }

    public T dequeue() {
        if (list.isEmpty()) throw new RuntimeException("Queue is empty");
        return list.removeFirst();
    }

    public T peek() {
        if (list.isEmpty()) throw new RuntimeException("Queue is empty");
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
