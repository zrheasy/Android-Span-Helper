package com.zrh.span.decorator;

import android.text.style.StrikethroughSpan;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class StrikethroughDecoration extends Decoration {
    public StrikethroughDecoration(@NonNull int[] range) {
        super(range);
    }

    @NonNull
    @Override
    protected Object getSpan() {
        return new StrikethroughSpan();
    }
}
