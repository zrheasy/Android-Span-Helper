package com.zrh.span.decorator;

import android.text.style.AbsoluteSizeSpan;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class SizeDecoration extends Decoration{
    private final int size;
    public SizeDecoration(@NonNull int[] range, int size) {
        super(range);
        this.size = size;
    }

    @NonNull
    @Override
    protected Object getSpan() {
        AbsoluteSizeSpan span = new AbsoluteSizeSpan(size);
        return span;
    }
}
