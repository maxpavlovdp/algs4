package edu.hometasks.ht3Mergesort;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Maksym Pavlov on 4/10/17.
 */
public class PointTest {
    @Test
    public void slopeToHorizontal() {
        assertEquals(0.0, new Point(0, 0).slopeTo(new Point(1,0)));
    }

    @Test
    public void slopeToPositive() {
        assertEquals(0.5, new Point(1, 2).slopeTo(new Point(3,3)));
    }

    @Test
    public void slopeToNegative() {
        assertEquals(-0.5, new Point(1, 2).slopeTo(new Point(3,1)));
    }

}