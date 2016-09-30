package com.aesean.math.triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Main
 *
 * @author xl
 * @version V1.0
 * @since 28/09/2016
 */
public class Main {

    private static List<Line> createSimple() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(0, 30f).setMinX(0).setMaxX(30f));
        lines.add(new Line(0, 0).setMinX(0).setMaxX(60f));
        lines.add(new Line(0).setMinY(0).setMaxY(60f));
        lines.add(new Line(-3f, 60f).setMinX(0).setMaxX(20f));
        lines.add(new Line(-1.5f, 60f).setMinX(0).setMaxX(40f));
        lines.add(new Line(-1f, 60f).setMinX(0).setMaxX(60f));
        lines.add(new Line(1f, 0f).setMinX(0).setMaxX(30f));
        return lines;
    }

    public static void main(String[] args) {
        try {
            List<Point[]> points = Triangle.mathAllTriangle(createSimple());
            for (Point[] point : points) {
                System.out.println("[" + point[0].getName() + ", "
                        + point[1].getName() + ", "
                        + point[2].getName() + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
