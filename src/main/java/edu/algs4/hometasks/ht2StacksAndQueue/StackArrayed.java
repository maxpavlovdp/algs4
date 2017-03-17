package edu.algs4.hometasks.ht2StacksAndQueue;

/**
 * Created by Maksym Pavlov on 3/17/17.
 */
public class StackArrayed<T> {
    private T[] array;
    private int pointer = 0;

    StackArrayed(int initSize) {
        this.array = (T[]) new Object[initSize];
    }

    public void push(T e) {
        if (pointer >= array.length) {
            increaseContainer();
        }

        array[pointer++] = e;
    }

    private void increaseContainer() {
        T[] newCont = (T[]) new Object[array.length * 2];
        int i = 0;
        while (i < array.length) {
            newCont[i] = array[i];
            i++;
        }

        array = newCont;
    }

    public T poll() {
        if (pointer > 0) {
            T result = array[--pointer];

            if (pointer == array.length / 4) {
                T[] shrinkedArray = (T[]) new Object[array.length / 2];
                int i = 0;
                while (i < shrinkedArray.length) {
                    shrinkedArray[i] = array[i];
                    i++;
                }

                array = shrinkedArray;

            }
            return result;
        } else {
            return null;
        }
    }

    public int getInnerSize() {
        return array.length;
    }
}
