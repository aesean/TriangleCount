package com.aesean.math.triangle;

import java.lang.*;

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
    private double x;
    private double k;
    private double b;

    private double maxX;
    private double maxY;
    private double minX;
    private double minY;

    public Line(double x) {
        this.x = x;
        type = TYPE_X;
    }

    public Line(double k, double b) {
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
        double k01 = (point1.getY() - point0.getY()) / (point1.getX() - point0.getX());
        double k12 = (point1.getY() - point2.getY()) / (point1.getX() - point2.getX());
//        return k01 == k12;
        // 这里加一个容错，主要是因为精度问题，导致明明是一条线，但是k差了0.000001之类的，导致判断出错。
        // 注意这个容错可能会引起过滤掉正确数值
        return java.lang.Math.abs(k01 - k12) < DIFF;
    }

    private static final float DIFF = 0.001f;

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
                        double x = (this.b - line.b) / (line.k - this.k);
                        double y = this.k * x + this.b;

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

    public double getMaxX() {
        return maxX;
    }

    public Line setMaxX(double maxX) {
        this.maxX = maxX;
        return this;
    }

    public double getMaxY() {
        return maxY;
    }

    public Line setMaxY(double maxY) {
        this.maxY = maxY;
        return this;
    }

    public double getMinX() {
        return minX;
    }

    public Line setMinX(double minX) {
        this.minX = minX;
        return this;
    }

    public double getMinY() {
        return minY;
    }

    public Line setMinY(double minY) {
        this.minY = minY;
        return this;
    }
}
