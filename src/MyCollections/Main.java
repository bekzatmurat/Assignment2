package MyCollections;

public class Main {
    public static void main(String[] args) {
        // MyArrayList Test
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("MyArrayList: ");
        for (int val : arrayList) {
            System.out.print(val + " ");
        }
        System.out.println("\nRemoved: " + arrayList.remove(1));
        System.out.println("After remove: " + arrayList.get(1));

        //MyLinkedList Test
        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.addFirst("zero");
        linkedList.addLast("three");
        System.out.println("\nMyLinkedList:");
        for (String s : linkedList) {
            System.out.print(s + " ");
        }

        //MyStack Test
        MyStack<String> stack = new MyStack<>();
        stack.push("A");
        stack.push("B");
        System.out.println("\n\nMyStack:");
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek after pop: " + stack.peek());

        //MyQueue Test
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("\nMyQueue:");
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());

        //MyMinHeap Test
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(42);
        heap.insert(17);
        heap.insert(8);
        heap.insert(99);
        System.out.println("\nMyMinHeap:");
        System.out.println("ExtractMin: " + heap.extractMin());
        System.out.println("Min after extract: " + heap.getMin());
    }
}
