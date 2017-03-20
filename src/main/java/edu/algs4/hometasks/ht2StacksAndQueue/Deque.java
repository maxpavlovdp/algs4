package edu.algs4.hometasks.ht2StacksAndQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Maksym Pavlov on 3/20/17.
 * Dequeue. A double-ended queue or deque (pronounced "deck") is a generalization of a stack and a queue that supports adding and removing items from either the front or the back of the data structure. Create a generic data type Deque that implements the following API:
 * <p>
 * Corner cases. Throw a java.lang.NullPointerException if the client attempts to add a null item; throw a java.util.NoSuchElementException
 * if the client attempts to remove an item from an empty deque; throw a java.lang.UnsupportedOperationException
 * if the client calls the remove() method in the iterator; throw a java.util.NoSuchElementException if the client calls the next()
 * method in the iterator and there are no more items to return.
 */


public class Deque<Item> implements Iterable<Item> {
    private class Node<Item> {
        Node next;
        Node prev;
        Item content;

        Node(Item content) {
            this.content = content;
        }
    }

    private class DItr<Item> implements Iterator<Item> {
        Node<Item> current;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item result = current.content;
            current = current.next;

            return result;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private Node<Item> f;
    private Node<Item> l;
    private int size;

    // construct an empty deque
    public Deque() {
        this.f = null;
        this.l = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new NullPointerException();
        if (f == null) {
            putFirst(item);
        } else {
            Node newFirst = new Node(item);
            newFirst.next = f;
            f = newFirst;
        }

        size++;
    }

    private void putFirst(Item item) {
        f = new Node(item);
        l = f;
    }

    //add the item to the end
    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();
        if (l == null) {
            putFirst(item);
        } else {
            Node newLast = new Node(item);
            l.next = newLast;
            newLast.prev = l;
            l = newLast;
        }

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Item result = f.content;
        if (f.next != null) {
            f = f.next;
        }
        size--;
        return result;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Item result = l.content;
        if (l.prev != null) {
            l.prev.next = null;
        }
        size--;
        l = l.prev;
        return result;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        DItr<Item> itr = new DItr<Item>();
        itr.current = f;
        return itr;
    }

    // unit testing (optional)
    public static void main(String[] args) {

    }
}

