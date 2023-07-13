package com.zrh.span.decorator;

import android.text.style.SuperscriptSpan;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class SuperscriptDecoration extends Decoration{
    public SuperscriptDecoration(@NonNull int[] range) {
        super(range);
    }

    @NonNull
    @Override
    protected Object getSpan() {
        return new SuperscriptSpan();
    }
}
