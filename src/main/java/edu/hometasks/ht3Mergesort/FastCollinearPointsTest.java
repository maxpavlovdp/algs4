package edu.hometasks.ht3Mergesort;

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
    public void oneHorizontalLineFrom4Points() {
        Point[] points = new Point[4];
        points[0] = new Point(1, 0);
        points[1] = new Point(2, 0);
        points[2] = new Point(3, 0);
        points[3] = new Point(4, 0);

        assertEquals(1, new FastCollinearPoints(points).numberOfSegments());
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
}