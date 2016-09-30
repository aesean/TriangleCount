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
    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
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
