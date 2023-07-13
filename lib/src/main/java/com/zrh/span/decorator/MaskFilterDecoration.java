package com.zrh.span.decorator;

import android.graphics.MaskFilter;
import android.text.style.MaskFilterSpan;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class MaskFilterDecoration extends Decoration {
    private final MaskFilter filter;

    public MaskFilterDecoration(@NonNull int[] range, MaskFilter filter) {
        super(range);
        this.filter = filter;
    }

    @NonNull
    @Override
    protected Object getSpan() {
        return new MaskFilterSpan(filter);
    }
}
