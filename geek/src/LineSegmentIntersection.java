import java.util.Scanner;

public class LineSegmentIntersection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int x = 0; x < T; x++) {
            // 1st line : points
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            Point a = new Point(x1, y1);  // point a

            int x2 = in.nextInt();
            int y2 = in.nextInt();
            Point b = new Point(x2, y2); // point b

            Line line1 = new Line(a, b);    // LIine 1

            // 2nd line : points
            x1 = in.nextInt();
            y1 = in.nextInt();
            a = new Point(x1, y1);  // point a

            x2 = in.nextInt();
            y2 = in.nextInt();
            b = new Point(x2, y2); // point b

            Line line2 = new Line(a, b);

            boolean res = checkIntersection(line1, line2);

            if (res)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    // The main function that returns true if line segment 'line1'  and 'line2' intersect.
    public static boolean checkIntersection(Line line1, Line line2) {
        // Find the four orientations needed for general and  special cases
        int o1 = orientation(line1.a, line1.b, line2.a);  // orientation of line2.a  wrt line1
        int o2 = orientation(line1.a, line1.b, line2.b);  // orientation of line2.b  wrt line1
        int o3 = orientation(line2.a, line2.b, line1.a);
        int o4 = orientation(line2.a, line2.b, line1.b);


        // -------  General case  -------
        if (o1 != o2 && o3 != o4)
            return true;


        // -------  Special Cases  -------

        // line1 (as points on a line are colinear) and   line2.a   are colinear        and  line2.a .   lies on segment line1
        // OR  line1.a, line1.b  and  line2.a are colinear .   and  line2.a   lies on segment . "line1.a line1.b"
        if (o1 == 0 && onSegment(line1.a, line1.b, line2.a)) return true;


        // line1  and  line2.b   are colinear        and  line2.b    lies on segment line1
        if (o2 == 0 && onSegment(line1.a, line1.b, line2.b)) return true;

        // line2.a, line2.b  and line1.a  are colinear   and   line1.a  lies on segment line2
        if (o3 == 0 && onSegment(line2.a, line2.b, line1.a)) return true;

        // line2.a, line2.b  and line1.b  are colinear   and   line1.b  lies on segment line2
        if (o4 == 0 && onSegment(line2.a, line2.b, line1.b)) return true;

        return false; // Doesn't fall in any of the above cases
    }


    // Given three colinear points P, Q, R, the function checks if
    // point R lies on line segment 'PQ'
    public static boolean onSegment(Point P, Point Q, Point R) {
        if (R.x <= Math.max(P.x, Q.x) && R.x >= Math.min(P.x, Q.x) &&   // checking if x coordinate is in range
                R.y <= Math.max(P.y, Q.y) && R.y >= Math.min(P.y, Q.y))      // checking for y coordinate
            return true;
        return false;
    }


    // To find orientation of ordered triplet (P, Q, R).
    // The function returns following values
    // 0 --> P, Q and R are colinear
    // 1 --> Clockwise
    // 2 --> Counterclockwise
    static int orientation(Point P, Point Q, Point R) {   // P & Q  are of one line segment  && R is of another line segment
        int val = ((R.y - P.y) * (Q.x - R.x)) - ((R.x - P.x) * (Q.y - R.y));  // PQ x PR  (cross product of PQ & PR vectors)

        //int val = (q.y - p.y) * (r.x - q.x) -  (q.x - p.x) * (r.y - q.y
        if (val == 0) return 0; // colinear
        return (val > 0) ? 1 : -1; // clock or counterclock wise
    }

}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Line {
    Point a, b;

    Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }
}