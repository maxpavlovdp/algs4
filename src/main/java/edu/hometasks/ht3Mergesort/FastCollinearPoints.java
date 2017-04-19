package edu.hometasks.ht3Mergesort;

import java.lang.reflect.Array;
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
        Arrays.sort(points);

        Point[] sortedAgainstPoint = Arrays.copyOf(points, points.length);

        for (int i = 0; i < points.length; i++) {
            Point basePoint = points[i];
            Arrays.sort(sortedAgainstPoint, basePoint.slopeOrder());

            List<Point> line = new ArrayList<Point>();
            for (int j = 0; j < sortedAgainstPoint.length; j++) {
                Point addToLineCandidate = sortedAgainstPoint[j];

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
                } else if (line.size() == 1) {
                    line.set(0, addToLineCandidate);
                } else if (line.size() >= 3) {
                    Collections.sort(line);

                    Point firstPointInLine = line.get(0);
                    if (basePoint.compareTo(firstPointInLine) == -1) {
                        segments.add(new LineSegment(basePoint, line.get(line.size() - 1)));
                    }

                    line = new ArrayList<>();
                }
            }
        }

        System.out.println(segments);
    }

    private void printContent(Point[] list) {
        System.out.println("======");
        for (Point p : list) {
            System.out.println(p);
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return segments();
    }

    public static void main(String[] args) {
    }
}
