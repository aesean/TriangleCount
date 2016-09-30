package com.aesean.math.triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Math
 *
 * @author xl
 * @version V1.0
 * @since 28/09/2016
 */
public class Math {
    private Math() {
        throw new RuntimeException("禁止实例化");
    }

    /**
     * 这里的源码来自：http://blog.csdn.net/zmazon/article/details/8315418
     * 只是把int改为了Object
     */
    public static List<Object[]> combine(Object[] a, int n) {
        if (null == a || a.length == 0 || n <= 0 || n > a.length) {
            return null;
        }
        Object[] b = new Object[n];
        List<Object[]> result = new ArrayList<>();
        getCombination(result, a, n, 0, b, 0);
        return result;
    }

    private static void getCombination(List<Object[]> result, Object[] a, int n, int begin, Object[] b, int index) {
        if (n == 0) {
            result.add(b.clone());
            return;
        }
        for (int i = begin; i < a.length; i++) {
            b[index] = a[i];
            getCombination(result, a, n - 1, i + 1, b, index + 1);
        }
    }
}
