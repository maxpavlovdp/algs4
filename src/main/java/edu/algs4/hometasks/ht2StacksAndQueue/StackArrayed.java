package edu.algs4.hometasks.ht2StacksAndQueue;

/**
 * Created by Maksym Pavlov on 3/17/17.
 */
public class StackArrayed {
    private String[] array;
    private int pointer = 0;

    StackArrayed(int initSize) {
        this.array = new String[initSize];
    }

    public void push(String e) {
        if (pointer >= array.length) {
            increaseContainer();
        }

        array[pointer++] = e;
    }

    private void increaseContainer() {
        String[] newCont = new String[array.length * 2];
        int i = 0;
        while (i < array.length) {
            newCont[i] = array[i];
            i++;
        }

        array = newCont;
    }

    public String poll() {
        if (pointer > 0) {
            String result = array[--pointer];

            if (pointer == array.length / 4) {
                String[] shrinkedArray = new String[array.length/2];
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
