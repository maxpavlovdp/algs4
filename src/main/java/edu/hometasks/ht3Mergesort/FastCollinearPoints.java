package edu.hometasks.ht3Mergesort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Maksym Pavlov on 4/13/17.
 */
public class FastCollinearPoints {
    private List<LineSegment> segments = new ArrayList<LineSegment>();

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        performValidation(points);

        Arrays.sort(points);

        Point[] sortedAgainstPoint = Arrays.copyOf(points, points.length);

        for (int i = 0; i < points.length; i++) {
            Point basePoint = points[i];
            Arrays.sort(sortedAgainstPoint, basePoint.slopeOrder());

            List<Point> line = new ArrayList<Point>();
            for (int j = 0; j < sortedAgainstPoint.length; j++) {
                Point addToLineCandidate = sortedAgainstPoint[j];
//                - 4 missing entries in student solution, including: (2000, 29000) -> (4000, 29000) -> (22000, 29000) -> (28000, 29000)

                if (
                        (line.size() == 0 && basePoint.compareTo(addToLineCandidate) != 0)
                                || (line.size() != 0 && basePoint.slopeTo(line.get(line.size() - 1)) == basePoint.slopeTo(addToLineCandidate))
                        ) {
                    line.add(addToLineCandidate);

                    if (j == sortedAgainstPoint.length - 1 && line.size() >= 3) {
                        Collections.sort(line);

                        Point firstPointInLine = line.get(0);
                        if (basePoint.compareTo(firstPointInLine) == -1) {
                            segments.add(new LineSegment(basePoint, line.get(line.size() - 1)));
                        }
                    }
                } else if (line.size() < 3 && line.size() > 0) {
                    line = new ArrayList<>();
                    line.add(0, addToLineCandidate);
                } else if (line.size() >= 3) {
                    Collections.sort(line);

                    Point firstPointInLine = line.get(0);
                    if (basePoint.compareTo(firstPointInLine) == -1) {
                        segments.add(new LineSegment(basePoint, line.get(line.size() - 1)));
                    }

                    line = new ArrayList<>();
                    line.add(addToLineCandidate);
                }
            }
        }

//        System.out.println(segments);
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

    public static void main(String[] args) {
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
