
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Max_account on 3/21/17.
 * <p>
 * Randomized queue. A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random from items in the data structure. Create a generic data type RandomizedQueue that implements the following API:
 * Randomized queue. A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly at random from items in the data structure. Create a generic data type RandomizedQueue that implements the following API:
 * Corner cases. The order of two or more iterators to the same randomized queue must be mutually independent; each iterator must maintain its own random order. Throw a java.lang.NullPointerException if the client attempts to add a null item; throw a java.util.NoSuchElementException if the client attempts to sample or dequeue an item from an empty randomized queue; throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator; throw a java.util.NoSuchElementException if the client calls the next() method in the iterator and there are no more items to return.
 * <p>
 * Performance requirements. Your randomized queue implementation must support each randomized queue operation (besides creating an iterator) in constant amortized time. That is, any sequence of m randomized queue operations (starting from an empty queue) should take at most cm steps in the worst case, for some constant c. A randomized queue containing n items must use at most 48n + 192 bytes of memory. Additionally, your iterator implementation must support operations next() and hasNext() in constant worst-case time; and construction in linear time; you may (and will need to) use a linear amount of extra memory per iterator.
 */

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] arr;
    private int size = 0;

    private class Itr implements Iterator<Item> {
        private int current = 0;
        private Item[] arrCopy;

        Itr() {
            this.arrCopy = RandomizedQueue.this.arr;
            StdRandom.shuffle(this.arrCopy);
        }

        public boolean hasNext() {
            return this.current < RandomizedQueue.this.size;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return arrCopy[current++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.arr = (Item[]) new Object[1];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (arr.length == size) {
            doubleArraySize();
        }
        arr[size] = item;
        size++;
    }

    private void doubleArraySize() {
        Item[] newArr = (Item[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    private void shrimpArrayTwice() {
        Item[] newArr = (Item[]) new Object[arr.length / 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException();
        if (size == arr.length / 4) shrimpArrayTwice();

        int randomIndx = StdRandom.uniform(size);
        Item result = arr[randomIndx];

        arr[randomIndx] = arr[size - 1];
        arr[size - 1] = null;
        size--;

        return result;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (size == 0) throw new NoSuchElementException();
        return arr[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new Itr();
    }

    // unit testing (optional)
    public static void main(String[] args) {
    }
}
