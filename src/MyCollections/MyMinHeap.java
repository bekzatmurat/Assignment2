package MyCollections;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    public void insert(T value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public T getMin() {
        if (heap.isEmpty()) throw new RuntimeException("Heap is empty");
        return heap.get(0);
    }

    public T extractMin() {
        if (heap.isEmpty()) throw new RuntimeException("Heap is empty");
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.add(0, last);
            heapifyDown(0);
        }
        return min;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1, right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest == index) break;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.add(i, heap.get(j));
        heap.add(j, temp);
        heap.remove(i + 1);
        heap.remove(j + 1);
    }
}
