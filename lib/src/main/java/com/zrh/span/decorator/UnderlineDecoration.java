package com.zrh.span.decorator;

import android.text.style.UnderlineSpan;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class UnderlineDecoration extends Decoration {

    public UnderlineDecoration(int[] range) {
        super(range);
    }

    @NonNull
    @Override
    protected Object getSpan() {
        UnderlineSpan span = new UnderlineSpan();
        return span;
    }
}
