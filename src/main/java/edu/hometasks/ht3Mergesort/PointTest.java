package edu.hometasks.ht3Mergesort;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Maksym Pavlov on 4/10/17.
 */
public class PointTest {

    @Test
    public void slopeToPositive() {
        assertEquals(0.5, new Point(1, 2).slopeTo(new Point(3, 3)));
    }

    @Test
    public void slopeToNegative() {
        assertEquals(-0.5, new Point(1, 2).slopeTo(new Point(3, 1)));
    }

    @Test
    public void slopeToPositiveZero() {
        assertEquals(+0.0, new Point(0, 0).slopeTo(new Point(3, 0)));
    }

    @Test
    public void slopeToNegativeInfIfPointsEqual() {
        assertEquals(Double.NEGATIVE_INFINITY, new Point(0, 0).slopeTo(new Point(0, 0)));
    }

    @Test
    public void slopeToPositiveInfIfVertical() {
        assertEquals(Double.POSITIVE_INFINITY, new Point(0, 0).slopeTo(new Point(0, 5)));
    }

    @Test
    public void firstSlopeBiggerThanSecondAfterSort() {
        Point p0 = new Point(1, 2);

        Point p1 = new Point(3, 3);
        Point p2 = new Point(3, 1);

        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);

        assertEquals(p1, points.get(0));
        points.sort(p0.slopeOrder());
        assertEquals(p1, points.get(1));
    }
}