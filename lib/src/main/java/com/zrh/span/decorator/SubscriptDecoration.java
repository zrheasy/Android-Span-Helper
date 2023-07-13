package com.zrh.span.decorator;

import android.text.style.SubscriptSpan;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class SubscriptDecoration extends Decoration{
    public SubscriptDecoration(@NonNull int[] range) {
        super(range);
    }

    @NonNull
    @Override
    protected Object getSpan() {
        return new SubscriptSpan();
    }
}
