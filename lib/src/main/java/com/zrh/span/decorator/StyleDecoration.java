package com.zrh.span.decorator;

import android.text.style.StyleSpan;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class StyleDecoration extends Decoration {
    private final int style;

    public StyleDecoration(int[] range, int style) {
        super(range);
        this.style = style;
    }

    @NonNull
    @Override
    protected Object getSpan() {
        StyleSpan span = new StyleSpan(style);
        return span;
    }
}
