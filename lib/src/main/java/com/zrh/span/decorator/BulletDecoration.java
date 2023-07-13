package com.zrh.span.decorator;

import android.text.style.BulletSpan;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class BulletDecoration extends Decoration {
    private final int gapWidth;
    private final int color;
    private final int radius;

    public BulletDecoration(@NonNull int[] range, int gapWidth, int color, int radius) {
        super(range);
        this.gapWidth = gapWidth;
        this.color = color;
        this.radius = radius;
    }

    @NonNull
    @Override
    protected Object getSpan() {
        BulletSpan span;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            span = new BulletSpan(gapWidth, color, radius);
        } else {
            span = new BulletSpan(gapWidth, color);
        }
        return span;
    }
}
