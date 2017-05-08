package edu.practice.sort;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

/**

 */
public class Kata {
    /*
    Sort an array by value and index

Your task is to sort an array of integer numbers by the product of the value and the index of the positions.

For sorting the index starts at 1, NOT at 0!
The sorting has to be ascending.
The array will never be null and will always contain numbers.
Example:

Input: 23, 2, 3, 4, 5
Product of value and index:
23 => 23 * 1 = 23  -> Output-Pos 4
 2 =>  2 * 2 = 4   -> Output-Pos 1
 3 =>  3 * 3 = 9   -> Output-Pos 2
 4 =>  4 * 4 = 16  -> Output-Pos 3
 5 =>  5 * 5 = 25  -> Output-Pos 5

Output: 2, 3, 4, 23, 5
     */
    private static class ValueIndexNode implements Comparable {
        int index;
        int value;

        ValueIndexNode(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            ValueIndexNode other = (ValueIndexNode) o;
            if ((other.index + 1) * other.value == (this.index + 1) * this.value) return 0;
            return (other.index + 1) * other.value > (this.index + 1) * this.value ? -1 : 0;
        }
    }

    public static int[] sortByValueAndIndex(int[] array) {
//        ValueIndexNode[] toSort = new ValueIndexNode[array.length];
//        for (int i = 0; i < array.length; i++) {
//            toSort[i] = new ValueIndexNode(i, array[i]);
//        }
//
//        Arrays.sort(toSort);

//        return Arrays.stream(toSort).map((el) -> el.value).mapToInt(Integer::intValue).toArray();

        return IntStream.range(0, array.length).boxed().sorted(Comparator.comparingInt(i -> array[i] * (i + 1))).mapToInt(i -> array[i]).toArray();


//        return IntStream.range(0, array.length).mapToObj(i -> new ValueIndexNode(i, array[i])).sorted().mapToInt((item) -> item.value).toArray();
    }

    /**
     * /**
     * Write a function that takes an (unsigned) integer as input, and returns the number of bits that are equal to one in the binary representation of that number.
     * <p>
     * Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
     */
    public static int countBits(int n) {
        int result = 0;
        long l = n;
        while (l > 0) {
            if (l % 2 != 0) result++;
            l = (int) l / 2;
        }

        // Show me the code!
        return result;
    }

    /**
     * Suzuki needs help lining up his students!
     * <p>
     * Today Suzuki will be interviewing his students to ensure they are progressing in their training. He decided to schedule the interviews based on the length of the students name in descending order. The students will line up and wait for their turn.
     * <p>
     * You will be given a string of student names. Sort them and return a list of names in descending order.
     * <p>
     * Here is an example input:
     * <p>
     * string = 'Tadashi Takahiro Takao Takashi Takayuki Takehiko Takeo Takeshi Takeshi'
     * Here is an example return from your function:
     * <p>
     * lst = ['Takehiko',
     * 'Takayuki',
     * 'Takahiro',
     * 'Takeshi',
     * 'Takeshi',
     * 'Takashi',
     * 'Tadashi',
     * 'Takeo',
     * 'Takao']
     */
    private static class Tuple {
        private int count;
        String name;

        Tuple(int count, String name) {
            this.count = count;
            this.name = name;
        }

        public int getCount() {
            return count;
        }
    }

    private static class Comp implements Comparator<Tuple> {

        @Override
        public int compare(Tuple o1, Tuple o2) {
            if (o1.count == o2.count) {
                return o1.name.compareTo(o2.name) * -1;
            }

            return o1.count < o2.count ? 1 : -1;
        }
    }

    public static String[] lineupStudents(String students) {
        String[] result = students.split(" ");

        Arrays.sort(result, (a, b) -> a.length() == b.length() ? b.compareTo(a) : Integer.compare(b.length(), a.length()));

        return result;
    }
}
