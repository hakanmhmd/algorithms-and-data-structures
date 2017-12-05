package Geometry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a set of points in the plane. the convex hull of the set is the
 * smallest convex polygon that contains all the points of it.
 *
 * Jarvis’s Algorithm or Wrapping
 * O(n^2)
 */
public class ConvexHull {
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[ " + this.x + ", " + this.y + " ]";
        }
    }

    public static void main(String[] args) {
        Point points[] = {
                new Point(0, 3),
                new Point(2, 2),
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 0),
                new Point(0, 0),
                new Point(3, 3)
        };

        ArrayList<Point> convexPoints = convexHull(points);
        System.out.println(convexPoints);

    }

    private static ArrayList<Point> convexHull(Point[] points) {
        Point start = points[0];
        for (int i = 1; i < points.length; i++) {
            if(points[i].x < start.x){
                start = points[i];
            }
        }
        Point current = start;
        Set<Point> result = new HashSet<>();
        result.add(current);
        ArrayList<Point> collinear = new ArrayList<>();

        while(true){
            Point nextPoint = points[0];
            // find the leftmost point from the currents perspective
            for (int i = 1; i < points.length; i++) {
                if(points[i] == current) continue;
                int val = crossProduct(current, nextPoint, points[i]);

                if(val > 0) { // points[i] is on the left of current -> nextPoint, make it nextPoint
                    nextPoint = points[i];
                    collinear = new ArrayList<>();
                } else if (val == 0){
                    // three points are collinear
                    // which is closer to current
                    if(distance(current, nextPoint, points[i]) < 0){ // nextPoint is closer
                        collinear.add(nextPoint);
                        nextPoint = points[i];
                    } else { // points[i] is closer
                        collinear.add(points[i]);
                    }
                } else {
                    // points[i] is on the right - nothing to do
                }
            }

            for(Point p: collinear){
                result.add(p);
            }

            if(nextPoint == start) break;

            result.add(nextPoint);
            current = nextPoint;

        }
        return new ArrayList<>(result);
    }

    private static int distance(Point a, Point b, Point c) {
        int y1 = a.y-b.y;
        int y2 = a.y-c.y;
        int x1 = a.x-b.x;
        int x2 = a.x-c.x;
        return Integer.compare(y1*y1 + x1*x1, y2*y2 + x2*x2);
    }

    private static int crossProduct(Point a, Point b, Point c) {
        int x1 = a.x - b.x;
        int x2 = a.x - c.x;
        int y1 = a.y - b.y;
        int y2 = a.y - c.y;

        return y2 * x1 - y1 * x2;
    }


}
