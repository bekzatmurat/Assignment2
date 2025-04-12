package MyCollections;

public interface MyList<T> extends Iterable<T> {
    void add(T element);
    void add(int index, T element);
    T get(int index);
    T remove(int index);
    void clear();
    int size();
    boolean isEmpty();

    default void addFirst(T element) {}
    default void addLast(T element) {}
    default T getFirst() { return null; }
    default T getLast() { return null; }
    default T removeFirst() { return null; }
    default T removeLast() { return null; }
}
