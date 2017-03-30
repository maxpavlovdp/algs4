
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {
    private class Node<ItemN> {
        Node next;
        Node prev;
        ItemN content;

        Node(ItemN content) {
            this.content = content;
        }
    }

    private class DItr implements Iterator<Item> {
        Node<Item> current;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();

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
            f.prev = newFirst;
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
            newLast.prev = l;
            l.next = newLast;
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
        } else {
            f = l = null;
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
            l = l.prev;
        } else {
            l = f = null;
        }
        size--;
        return result;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        DItr itr = new DItr();
        itr.current = f;
        return itr;
    }

    // unit testing (optional)
    public static void main(String[] args) {

    }
}

