package com.aesean.math.triangle;

/**
 * Line
 *
 * @author xl
 * @version V1.0
 * @since 28/09/2016
 */
public class Line {
    /**
     * 直线用方程表示的时候分两种一种是:kx+b=y
     */
    private static final int TYPE_K_B = 1;
    /**
     * 另一种是垂直与x轴这时候k无限大，无法用kx+b表示，所以用y=b表示
     */
    private static final int TYPE_X = 2;

    private int type;
    private float x;
    private float k;
    private float b;

    private float maxX;
    private float maxY;
    private float minX;
    private float minY;

    public Line(float x) {
        this.x = x;
        type = TYPE_X;
    }

    public Line(float k, float b) {
        this.k = k;
        this.b = b;
        type = TYPE_K_B;
    }

    public boolean contains(Point point) {
        switch (type) {
            case TYPE_X:
                return (!(point.getY() < minY || point.getY() > maxY)) && point.getX() == x;
            case TYPE_K_B:
                if ((point.getX() > minX || point.getX() == minX) && (point.getX() < maxX || point.getX() == maxX)) {
                    if ((k * point.getX() + b) == point.getY()) {
                        return true;
                    }
                }
                break;
            default:
                throw new RuntimeException("Unknown type: " + type);
        }
        return false;
    }

    public static boolean isOneLine(Point point0, Point point1, Point point2) {
        if (point0.getX() == point1.getX() && point2.getX() == point1.getX()) {
            return true;
        }

        float k01 = (point1.getY() - point0.getY()) / (point1.getX() - point0.getX());
        float k12 = (point1.getY() - point2.getY()) / (point1.getX() - point2.getX());
        return k01 == k12;
    }

    /**
     * 求交点
     *
     * @param line 线
     * @return 没有交点或者两条线重合时候返回null，其他时候返回交点
     */
    public Point getIntersection(Line line) {
        if (line == null) {
            return null;
        }
        switch (type) {
            case TYPE_X:
//                if (line.type == TYPE_X) {
//                    return null;
//                }

                if (line.type == TYPE_K_B) {
                    Point point = new Point(this.x, line.k * this.x + line.b);
                    // 交点必须在线段的范围内
                    if (this.contains(point) && line.contains(point)) {
                        return point;
                    }
                }

                break;
            case TYPE_K_B:
                if (line.type == TYPE_X) {
//                    Point point = new Point((line.b - this.b) / this.k, line.b);
                    Point point = new Point(line.x, line.x * this.k + this.b);
                    // 交点必须在线段的范围内
                    if (this.contains(point) && line.contains(point)) {
                        return point;
                    }
                }

                if (line.type == TYPE_K_B) {
//                    if (this.k == line.k) {
//                        return null;
//                    }
                    if (this.k != line.k) {
                        float x = (this.b - line.b) / (line.k - this.k);
                        float y = this.k * x + this.b;

                        Point point = new Point(x, y);
                        // 交点必须在线段的范围内
                        if (this.contains(point) && line.contains(point)) {
                            return point;
                        }
                    }
                }
                break;
            default:
                break;
        }
        return null;
    }

    public static Point getIntersection(Line lineA, Line lineB) {
        return lineA == null ? null : lineA.getIntersection(lineB);
    }

    public float getMaxX() {
        return maxX;
    }

    public Line setMaxX(float maxX) {
        this.maxX = maxX;
        return this;
    }

    public float getMaxY() {
        return maxY;
    }

    public Line setMaxY(float maxY) {
        this.maxY = maxY;
        return this;
    }

    public float getMinX() {
        return minX;
    }

    public Line setMinX(float minX) {
        this.minX = minX;
        return this;
    }

    public float getMinY() {
        return minY;
    }

    public Line setMinY(float minY) {
        this.minY = minY;
        return this;
    }
}
