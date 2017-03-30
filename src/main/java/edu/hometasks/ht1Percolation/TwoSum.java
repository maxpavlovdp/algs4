package edu.hometasks.ht1Percolation;

/**
 * Created by Maksym Pavlov on 3/13/17.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] a = {7, 5, -7, -5};

        for (int i = 0; i < a.length; i++) {
            System.out.println("outer");
            for (int j = i + 1; j < a.length; j++) {
                System.out.println("inner");
                if (a[i] + a[j] == 0) {
//                    System.out.println("access");
                }
            }
        }
    }
}
