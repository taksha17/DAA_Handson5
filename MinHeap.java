// Author : Taksha Sachin Thosani
// UTA ID# : 1002086312
// Net ID : txt6312
// Handson5


import java.util.ArrayList;
import java.util.Comparator;

public class MinHeap<T> {
    private ArrayList<T> heap;
    private Comparator<? super T> comparator;

    public MinHeap(Comparator<? super T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    private int txt6312_parent(int i) {
        return (i - 1) >> 1; // Bit manipulation for floor division by 2
    }

    private int txt6312_leftChild(int i) {
        return (i << 1) + 1;
    }

    private int txt6312_rightChild(int i) {
        return (i << 1) + 2;
    }

    private void txt6312_swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void txt6312_buildMinHeap(ArrayList<T> array) {
        this.heap = new ArrayList<>(array);
        for (int i = txt6312_parent(heap.size() - 1); i >= 0; i--) {
            txt6312_minHeapify(i);
        }
    }

    private void txt6312_minHeapify(int i) {
        int left = txt6312_leftChild(i);
        int right = txt6312_rightChild(i);
        int smallest = i;

        if (left < heap.size() && comparator.compare(heap.get(left), heap.get(i)) < 0) {
            smallest = left;
        }

        if (right < heap.size() && comparator.compare(heap.get(right), heap.get(smallest)) < 0) {
            smallest = right;
        }

        if (smallest != i) {
            txt6312_swap(i, smallest);
            txt6312_minHeapify(smallest);
        }
    }

    public T txt6312_pop() {
        if (heap.size() == 0) {
            return null;
        }

        T root = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            txt6312_minHeapify(0);
        }

        return root;
    }

    public void txt6312_insert(T element) {
        heap.add(element);
        int currentIndex = heap.size() - 1;

        while (currentIndex > 0 && comparator.compare(heap.get(currentIndex), heap.get(txt6312_parent(currentIndex))) < 0) {
            txt6312_swap(currentIndex, txt6312_parent(currentIndex));
            currentIndex = txt6312_parent(currentIndex);
        }
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    // Example usage
    public static void main(String[] args) {
        Comparator<Integer> comparator = Integer::compare;
        MinHeap<Integer> minHeap = new MinHeap<>(comparator);

        // Insert elements
        minHeap.txt6312_insert(3);
        minHeap.txt6312_insert(2);
        minHeap.txt6312_insert(15);
        minHeap.txt6312_insert(5);
        minHeap.txt6312_insert(4);
        minHeap.txt6312_insert(45);

        System.out.println("MinHeap: " + minHeap);

        // Pop elements
        System.out.println("Popped root: " + minHeap.txt6312_pop());
        System.out.println("MinHeap after popping root: " + minHeap);
    }
}
