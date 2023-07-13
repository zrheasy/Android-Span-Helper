package com.zrh.span.decorator;

import android.text.style.ForegroundColorSpan;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class ColorDecoration extends Decoration {
    private final int color;

    public ColorDecoration(int[] range, int color) {
        super(range);
        this.color = color;
    }

    @NonNull
    @Override
    protected Object getSpan() {
        ForegroundColorSpan span = new ForegroundColorSpan(color);
        return span;
    }
}
