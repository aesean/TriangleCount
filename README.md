# TriangleCount
计算三角形数量
<pre><code>
    private static List<Line> createSimple() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(0, 40f).setMinX(0).setMaxX(20f));
        lines.add(new Line(0, 0).setMinX(0).setMaxX(60f));
        lines.add(new Line(0).setMinY(0).setMaxY(60f));
        lines.add(new Line(-3f, 60f).setMinX(0).setMaxX(20f));
        lines.add(new Line(-1.5f, 60f).setMinX(0).setMaxX(40f));
        lines.add(new Line(-1f, 60f).setMinX(0).setMaxX(60f));
        lines.add(new Line(2f, 0f).setMinX(0).setMaxX(20f));
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
</code></pre>
输出结果
<pre><code>
交点个数:11
Point{name='a', x=0.0, y=40.0}
Point{name='b', x=6.666666666666667, y=40.0}
Point{name='c', x=13.333333333333334, y=40.0}
Point{name='d', x=20.0, y=40.0}
Point{name='e', x=0.0, y=0.0}
Point{name='f', x=20.0, y=0.0}
Point{name='g', x=40.0, y=0.0}
Point{name='h', x=60.0, y=0.0}
Point{name='i', x=0.0, y=60.0}
Point{name='j', x=12.0, y=24.0}
Point{name='k', x=17.142857142857142, y=34.285714285714285}
所有三点组合数：165
其中是三角形的个数为：24
[a, b, i]
[a, c, i]
[a, d, e]
[a, d, i]
[b, c, i]
[b, d, i]
[b, d, j]
[c, d, i]
[c, d, k]
[d, e, h]
[d, e, i]
[d, i, j]
[d, i, k]
[e, f, i]
[e, f, j]
[e, g, i]
[e, g, k]
[e, h, i]
[e, i, j]
[e, i, k]
[f, g, i]
[f, h, i]
[g, h, i]
[i, j, k]
</code></pre>
