package Math;

/**
 * Find intersection of two rectangles
 */
public class RectangleIntersection {
    static class Rectangle {
        int left_x;
        int bottom_y;
        int width;
        int height;

        public Rectangle(int left_x, int bottom_y, int width, int height) {
            this.left_x = left_x;
            this.bottom_y = bottom_y;
            this.width = width;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "left_x=" + left_x +
                    ", bottom_y=" + bottom_y +
                    ", width=" + width +
                    ", height=" + height +
                    '}';
        }
    }

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(1, 1, 6, 3);
        Rectangle rectangle2 = new Rectangle(5, 2, 3, 6);

        System.out.println(findIntersection(rectangle1, rectangle2));
    }

    private static Rectangle findIntersection(Rectangle rectangle1, Rectangle rectangle2) {
        Rectangle r1 = rectangle1.left_x <= rectangle2.left_x ? rectangle1 : rectangle2;
        Rectangle r2 = r1 == rectangle1 ? rectangle2 : rectangle1;

        if(r1.left_x + r1.width <= r2.left_x) return null; //no intersection

        int left_x = Math.max(r1.left_x, r2.left_x);
        int right_x = Math.min(r1.left_x + r1.width, r2.left_x + r2.width);
        int width = right_x - left_x;

        r1 = rectangle1.bottom_y <= rectangle2.bottom_y ? rectangle1 : rectangle2;
        r2 = r1 == rectangle1 ? rectangle2 : rectangle1;

        if(r1.bottom_y + r1.height <= r2.bottom_y) return null;

        int bottom_y = Math.max(r1.bottom_y, r2.bottom_y);
        int top_y = Math.min(r1.bottom_y + r1.height, r2.bottom_y + r2.height);
        int height = top_y - bottom_y;

        return new Rectangle(left_x, bottom_y, width, height);
    }

}
