/**
 * Lab 4: Generics <br />
 * The {@code GenericHeap} class
 */
import java.util.*;
class node<K extends Comparable<K>,V> implements Comparable<node<K,V>>{
	private K key;
	private V value;
	public node(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K get_key() {
		return key;
	}
	public V get_value() {
		return value;
	}
	@Override
	public int compareTo(node<K, V> o) {
		// TODO Auto-generated method stub
		return this.get_key().compareTo(o.get_key());
	}
}

public class GenericHeap<K extends Comparable<K>, V> extends PriorityQueue<node<K,V>>{

    /**
     * Insert an new element to the heap
     * @param key       {@code K} the comparable key of the new element
     * @param value     {@code V} the actual value of the new element
     */
    public void insert(K key, V value) {
        // TODO: Lab 4 Part 2-1 -- GenericHeap, add new element
    	this.add(new node<>(key,value));
    }

    /**
     * The heap sort procedure
     * @param array     {@code <E extends Comparable<E>>[]} the array to be sorted
     * @return          {@code <E extends Comparable<E>>[]} the sorted array
     */
    public static <E extends Comparable<E>> E[] heapSort(E[] array) {
        // TODO: Lab 4 Part 2-4 -- GenericHeap, return a sorted array
        GenericHeap<E,E> arr = new GenericHeap<>();
        for (E item: array) {
        	arr.insert(item, item);
        }
        for (int i = 0; i<array.length;i++) {
        	node<E,E> top = arr.poll();
        	array[i] = top.get_key();
        }
        return array;
    }

    /**
     * Main entry: test the HeapSort
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        // Sort an array of integers
        Integer[] numbers = new Integer[10];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = (int) (Math.random() * 200);
        heapSort(numbers);
        for (int n: numbers)
            System.out.print(n + " ");
        System.out.println();

        // Sort an array of strings
        String[] strs = new String[10];
        for (int i = 0; i < strs.length; i++)
            strs[i] = String.format("%c", (int) (Math.random() * 26 + 65));
        heapSort(strs);
        for (String s: strs)
            System.out.print(s + " ");
        System.out.println();
    }

}
