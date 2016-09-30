package com.aesean.math.triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Triangle
 *
 * @author xl
 * @version V1.0
 * @since 30/09/2016
 */
public class Triangle {
    private Triangle() {
        throw new RuntimeException("禁止实例化");
    }

    public static List<Point[]> mathAllTriangle(List<Line> lines) throws Exception {
        List<Point> allIntersection = getAllIntersection(lines);
        if (allIntersection == null || allIntersection.size() == 0) {
            throw new Exception("图形错误，没有发现有任何交点");
        }
        System.out.println("交点个数:" + allIntersection.size());
        for (Point point : allIntersection) {
            System.out.println(point.toString());
        }
        List<Point[]> allCombines = getAllPoints(allIntersection);
        System.out.println("所有三点组合数：" + allCombines.size());
        List<Point[]> result = new ArrayList<>();
        int count = 0;
        // 检查所有组合中是三角形的组合
        for (Point[] points : allCombines) {
            int success = 0;
            // 两点分组
            List<Object[]> combine = Math.combine(points, 2);
            for (Object[] objects : combine) {
                Point[] points1 = new Point[2];
                points1[0] = (Point) objects[0];
                points1[1] = (Point) objects[1];
                for (Line line : lines) {
                    // 如果两点同时在某个线段上
                    if (line.contains(points1[0]) && line.contains(points1[1])) {
                        success++;
                        break;
                    }
                }
            }
            // 如果三组点都同时在某个线段上，同时这三个点不在一条线上，则肯定是三角形
            if (success == 3 && !Line.isOneLine(points[0], points[1], points[2])) {
                result.add(points);
                count++;
            }
        }
        System.out.println("其中是三角形的个数为：" + result.size());
        return result;
    }

    /**
     * 获取所有的交点
     *
     * @param lines 所有的线
     * @return 所有交点
     */
    public static List<Point> getAllIntersection(List<Line> lines) {
        List<Object[]> doubleLine = Math.combine(lines.toArray(), 2);
        List<Point> result = new ArrayList<>();
        for (char i = 0, name = 'a'; i < doubleLine.size(); i++) {
            Object[] objects = doubleLine.get(i);
            if (objects[0] instanceof Line && objects[1] instanceof Line) {
                Point point = Line.getIntersection((Line) objects[0], (Line) objects[1]);
                if (point != null) {
                    boolean have = false;
                    // 除重
                    for (Point check : result) {
                        boolean equals = check.equals(point);
                        if (equals) {
                            have = true;
                            break;
                        }
                    }
                    if (!have) {
                        point.setName(String.valueOf(name));
                        name++;
                        result.add(point);
                    }
                }
            }
        }
        return result;
    }

    public static List<Point[]> getAllPoints(List<Point> list) {
        List<Object[]> combine = Math.combine(list.toArray(), 3);
        List<Point[]> result = new ArrayList<>();
        for (Object[] objects : combine) {
            Point[] points = new Point[3];
            points[0] = (Point) objects[0];
            points[1] = (Point) objects[1];
            points[2] = (Point) objects[2];
            result.add(points);
        }
        return result;
    }

}
