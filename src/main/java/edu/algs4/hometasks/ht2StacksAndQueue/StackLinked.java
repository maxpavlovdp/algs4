package edu.algs4.hometasks.ht2StacksAndQueue;

/**
 * Created by Maksym Pavlov on 3/14/17.
 */
public class StackLinked<T> {
    private Node current = null;

    class Node {
        T element;
        Node next;
    }

    public void push(T s) {
        Node newNode = new Node();
        newNode.element = s;
        newNode.next = current;

        current = newNode;
    }

    public T pull() {
        T result = current.element;

        current = current.next;

        return result;
    }

    public static void main(String[] args) {
        StackLinked stack = new StackLinked();

        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        System.out.println(stack.pull());
        stack.push("3");
        System.out.println(stack.pull());

        int n = 2;
        String[] arr = {"one", "two", "three" , "four"};
        System.out.println(arr[n]);
        System.out.println(arr[++n]);

        int n1 = 0;
        System.out.println(n1+1);
        System.out.println(n1);

    }
}
