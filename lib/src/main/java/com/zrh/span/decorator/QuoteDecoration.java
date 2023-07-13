package com.zrh.span.decorator;

import android.text.style.QuoteSpan;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class QuoteDecoration extends Decoration {
    private final int color;
    private final int stripWidth;
    private final int gapWidth;

    public QuoteDecoration(@NonNull int[] range, int color, int stripWidth, int gapWidth) {
        super(range);
        this.color = color;
        this.stripWidth = stripWidth;
        this.gapWidth = gapWidth;
    }

    @NonNull
    @Override
    protected Object getSpan() {
        QuoteSpan span;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            span = new QuoteSpan(color, stripWidth, gapWidth);
        } else {
            span = new QuoteSpan(color);
        }
        return span;
    }
}
