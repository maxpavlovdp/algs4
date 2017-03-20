package edu.algs4.hometasks.ht2StacksAndQueue;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by Maksym Pavlov on 3/20/17.
 */
public class DequeTest {
    private Deque<Integer> deque;

    @Before
    public void setUp() throws Exception {
        this.deque = new Deque<Integer>();
    }

    @Test
    public void emptyAfterCreation() {
        assertTrue(this.deque.isEmpty());
    }

    @Test
    public void isNotEmptyAfterAddFirst() {
        this.deque.addFirst(new Integer(3));
        assertFalse(deque.isEmpty());
    }

    @Test
    public void sizeIsTwoAfterAddTwo() {
        deque.addFirst(new Integer(3));
        deque.addFirst(new Integer(4));

        assertEquals(2, deque.size());
    }

    @Test
    public void isNotEmptyAfterAddLast() {
        deque.addLast(new Integer(4));
        assertFalse(deque.isEmpty());
    }

    @Test
    public void addRemoveFirst() {
        deque.addFirst(new Integer(7));
        assertEquals(new Integer(7), deque.removeFirst());
    }

    @Test
    public void sizeDecreasedAfterRemoveFirst() {
        deque.addFirst(new Integer(4));
        deque.removeFirst();
        assertEquals(0, deque.size());
    }

    @Test
    public void addRemoveLast() {
        deque.addLast(new Integer(7));
        assertEquals(new Integer(7), deque.removeLast());
    }

    @Test
    public void addRemoveLastWhenTwo() {
        deque.addLast(new Integer(7));
        deque.addLast(new Integer(6));
        deque.removeLast();
        assertEquals(new Integer(7), deque.removeLast());
    }

    @Test
    public void addRemoveFirstWhenTwo() {
        deque.addFirst(new Integer(7));
        deque.addFirst(new Integer(6));
        deque.removeFirst();
        assertEquals(new Integer(7), deque.removeFirst());
    }

    @Test(expected = NoSuchElementException.class)
    public void removeFirstFromEmpty() {
        deque.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void removeLastFromEmpty() {
        deque.removeLast();
    }

    @Test
    public void canBeIterated() {
        assertEquals(false, deque.iterator().hasNext());
    }

    @Test
    public void canBeIteratedWithElements() {
        deque.addFirst(new Integer(5));
        Iterator<Integer> it = deque.iterator();

        assertEquals(new Integer(5), it.next());
    }

    @Test
    public void printValues() {
        deque.addFirst(new Integer(3));
        deque.addFirst(new Integer(4));

        for (Integer i : deque) {
            System.out.println(i);
        }
    }

    @Test
    public void twoIterationInARow() {
        deque.addFirst(new Integer(1));
        deque.addFirst(new Integer(5));
        deque.addFirst(new Integer(7));

        deque.iterator().next();

        assertEquals(new Integer(7), deque.iterator().next());
    }

    @Test
    public void twoIterationInARowWithRemove() {
        deque.addFirst(new Integer(1));
        deque.addFirst(new Integer(5));
        deque.addFirst(new Integer(7));

        deque.iterator().next();
        deque.removeFirst();

        assertEquals(new Integer(5), deque.iterator().next());
    }

    @Test
    public void addFirstAndRemoveLast() {
        deque.addFirst(new Integer(5));
        assertEquals(new Integer(5), deque.removeLast());
    }

    @Test
    public void addLastAndRemoveFirst() {
        deque.addLast(new Integer(5));
        assertEquals(new Integer(5), deque.removeFirst());
    }

    @Test
    public void addLastAndRemoveFirstWithTwo() {
        deque.addLast(new Integer(5));
        deque.addLast(new Integer(10));
        assertEquals(new Integer(5), deque.removeFirst());
    }
}