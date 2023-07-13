package com.zrh.span.decorator;

import android.text.style.BackgroundColorSpan;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class BackgroundDecoration extends Decoration {
    private final int color;

    public BackgroundDecoration(int[] range, int color) {
        super(range);
        this.color = color;
    }

    @NonNull
    @Override
    protected Object getSpan() {
        BackgroundColorSpan span = new BackgroundColorSpan(color);
        return span;
    }
}
