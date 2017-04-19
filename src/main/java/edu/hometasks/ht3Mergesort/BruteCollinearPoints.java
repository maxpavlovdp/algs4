package edu.hometasks.ht3Mergesort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;

/**
 * Created by Maksym Pavlov on 4/10/17.
 */
public class BruteCollinearPoints {
    private List<LineSegment> segments = new ArrayList<>();

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        performValidation(points);

        for (int p = 0; p < points.length; p++) {
            for (int q = 0; q < points.length; q++) {
                for (int r = 0; r < points.length; r++) {
                    for (int s = 0; s < points.length; s++) {
                        double slopePQ = points[p].slopeTo(points[q]);
                        double slopePR = points[p].slopeTo(points[r]);
                        double slopePS = points[p].slopeTo(points[s]);
                        if (
                            // Different points and p < q < r < s
                                points[p].compareTo(points[q]) == -1
                                        && points[q].compareTo(points[r]) == -1
                                        && points[r].compareTo(points[s]) == -1

                                        // collinear
                                        && (slopePQ == slopePR && slopePQ == slopePS)
                                ) {

                            segments.add(new LineSegment(points[p], points[s]));
                        }
                    }
                }
            }
        }
    }

    private void performValidation(Point[] points) {
        if (points == null) throw new NullPointerException();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                if (points[j].compareTo(points[i]) == 0) throw new IllegalArgumentException();
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
    }

    public static void main(String[] args) throws IllegalAccessException {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
