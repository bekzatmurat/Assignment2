package MyCollections;

public class MyStack<T> {
    private MyArrayList<T> list = new MyArrayList<>();

    public void push(T value) {
        list.add(value);
    }

    public T pop() {
        if (list.isEmpty()) throw new RuntimeException("Stack is empty");
        return list.remove(list.size() - 1);
    }

    public T peek() {
        if (list.isEmpty()) throw new RuntimeException("Stack is empty");
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
