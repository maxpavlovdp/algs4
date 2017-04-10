package edu.hometasks.ht3Mergesort;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksym Pavlov on 4/10/17.
 */
public class BruteCollinearPoints {
    private final Point[] points;
    private List<LineSegment> segments = new ArrayList<>();

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        this.points = points;
    }

    // the number of line segments
    public int numberOfSegments() {
        for (Point p : points) {
//            System.out.println(p);
        }

        for (int p = 0; p < points.length; p++) {
            for (int q = 0; q < points.length; q++) {
                for (int r = 0; r < points.length; r++) {
                    for (int s = 0; s < points.length; s++) {
                        double slopePQ = points[p].slopeTo(points[q]);
                        double slopePR = points[p].slopeTo(points[r]);
                        double slopePS = points[p].slopeTo(points[s]);

//                        double slopeQR = points[q].slopeTo(points[r]);
//                        double slopeRS = points[r].slopeTo(points[s]);
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
        System.out.println(segments);

        return segments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return null;
    }

    public static void main(String[] args) {
        String[] input = StdIn.readAllLines();
    }
}
