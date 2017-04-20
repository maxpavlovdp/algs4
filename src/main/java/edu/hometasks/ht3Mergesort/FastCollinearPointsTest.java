package edu.hometasks.ht3Mergesort;

import edu.princeton.cs.algs4.In;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Maksym Pavlov on 4/14/17.
 */
public class FastCollinearPointsTest {
    @Test
    public void twoLinesFrom8Points() {
        Point[] points = new Point[8];
        points[0] = new Point(10000, 0);
        points[1] = new Point(0, 10000);
        points[2] = new Point(3000, 7000);
        points[3] = new Point(7000, 3000);
        points[4] = new Point(20000, 21000);
        points[5] = new Point(3000, 4000);
        points[6] = new Point(14000, 15000);
        points[7] = new Point(6000, 7000);

        assertEquals(2, new FastCollinearPoints(points).numberOfSegments());
    }

    @Test
    public void oneVerticalLineFrom4Points() {
        Point[] points = new Point[4];
        points[0] = new Point(0, 1);
        points[1] = new Point(0, 2);
        points[2] = new Point(0, 3);
        points[3] = new Point(0, 4);

        assertEquals(1, new FastCollinearPoints(points).numberOfSegments());
    }

    @Test
    public void oneVerticalLineFrom5Points() {
        Point[] points = new Point[5];
        points[0] = new Point(0, -1);
        points[1] = new Point(0, 2);
        points[2] = new Point(0, 3);
        points[3] = new Point(0, 4);
        points[4] = new Point(0, 5);

        assertEquals(1, new FastCollinearPoints(points).numberOfSegments());
    }

    @Test
    public void oneVerticalLineFrom6Points() {
        Point[] points = new Point[6];
        points[0] = new Point(-1, -1);
        points[1] = new Point(0, 2);
        points[2] = new Point(0, 3);
        points[3] = new Point(0, 4);
        points[4] = new Point(0, 5);
        points[5] = new Point(-2, 5);

        assertEquals(1, new FastCollinearPoints(points).numberOfSegments());
    }

    @Test
    public void oneHorizontalLineFrom4Points() {
        Point[] points = new Point[4];
        points[0] = new Point(1, 0);
        points[1] = new Point(2, 0);
        points[2] = new Point(3, 0);
        points[3] = new Point(4, 0);

        assertEquals(1, new FastCollinearPoints(points).numberOfSegments());
    }

    @Test
    public void twoHorizontalLinesAndVertical() {
        Point[] points = new Point[12];
        points[0] = new Point(10, 0);
        points[1] = new Point(9, 0);
        points[2] = new Point(8, 0);
        points[3] = new Point(7, 0);

        points[4] = new Point(10, 1);
        points[5] = new Point(9, 1);
        points[6] = new Point(8, 1);
        points[7] = new Point(7, 1);

        points[8] = new Point(0, 1);
        points[9] = new Point(0, 2);
        points[10] = new Point(0, 3);
        points[11] = new Point(0, 4);

        assertEquals(3, new FastCollinearPoints(points).numberOfSegments());
    }

    @Test
    public void twoHorizontalAndTwoPerpendicular() {
        Point[] points = new Point[15];
        points[0] = new Point(10, 3);
        points[1] = new Point(9, 3);
        points[2] = new Point(8, 3);
        points[3] = new Point(7, 3);

        points[4] = new Point(10, 1);
        points[5] = new Point(9, 1);
        points[6] = new Point(8, 1);

        points[7] = new Point(0, 1);
        points[8] = new Point(0, 2);
        points[9] = new Point(0, 3);
        points[10] = new Point(0, 4);

        points[11] = new Point(10, 4);
        points[12] = new Point(9, 4);
        points[13] = new Point(8, 4);
        points[14] = new Point(7, 4);

        assertEquals(4, new FastCollinearPoints(points).numberOfSegments());
    }

    @Test
    public void oneLineFrom6Points() {
        Point[] points = new Point[6];
        points[0] = new Point(19000, 10000);
        points[1] = new Point(18000, 10000);
        points[2] = new Point(32000, 10000);
        points[3] = new Point(21000, 10000);
        points[4] = new Point(1234, 5678);
        points[5] = new Point(14000, 10000);

        assertEquals(1, new FastCollinearPoints(points).numberOfSegments());
    }

    @Test
    public void oneLine45Degree() {
        Point[] points = new Point[4];
        points[0] = new Point(10000, 0);
        points[1] = new Point(7000, 3000);
        points[2] = new Point(3000, 7000);
        points[3] = new Point(0, 10000);

        assertEquals(1, new FastCollinearPoints(points).numberOfSegments());
    }

    @Test
    public void equidistant() {
        Point[] points = new Point[15];
        points[0] = new Point(10000, 0);
        points[1] = new Point(8000, 2000);
        points[2] = new Point(2000, 8000);
        points[3] = new Point(0, 10000);
        points[4] = new Point(20000, 0);
        points[5] = new Point(18000, 2000);
        points[6] = new Point(2000, 18000);
        points[7] = new Point(10000, 20000);
        points[8] = new Point(30000, 0);
        points[9] = new Point(0, 30000);
        points[10] = new Point(20000, 10000);
        points[11] = new Point(13000, 0);
        points[12] = new Point(11000, 3000);
        points[13] = new Point(5000, 12000);
        points[14] = new Point(9000, 6000);

        assertEquals(4, new FastCollinearPoints(points).numberOfSegments());
    }

    @Test
    public void checkinput40() {
        In in = new In("/Users/Max_account/IdeaProjects/edu/algs4/src/main/java/edu/hometasks/ht3Mergesort/testCollinear/input40.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }


        assertEquals(4, new FastCollinearPoints(points).numberOfSegments());
    }

//    @Test
//    public void checkinput40() {
//        In in = new In("/Users/Max_account/IdeaProjects/edu/algs4/src/main/java/edu/hometasks/ht3Mergesort/testCollinear/equidistant.txt");
//        int n = in.readInt();
//        Point[] points = new Point[n];
//        for (int i = 0; i < n; i++) {
//            int x = in.readInt();
//            int y = in.readInt();
//            points[i] = new Point(x, y);
//        }
//
//
//        assertEquals(4, new FastCollinearPoints(points).numberOfSegments());
//    }
}