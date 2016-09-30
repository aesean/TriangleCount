package com.aesean.math.triangle;

/**
 * Point
 *
 * @author xl
 * @version V1.0
 * @since 28/09/2016
 */
public class Point {
    private String name;
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            return this == obj || this.x == ((Point) obj).x && this.y == ((Point) obj).y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Point{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
