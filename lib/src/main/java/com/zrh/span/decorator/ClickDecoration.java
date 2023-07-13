package com.zrh.span.decorator;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class ClickDecoration extends Decoration {
    private final View.OnClickListener listener;

    public ClickDecoration(int[] range, View.OnClickListener listener) {
        super(range);
        this.listener = listener;
    }

    @Override
    protected Object getSpan() {
        ClickableSpan span = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                listener.onClick(widget);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
            }
        };
        return span;
    }
}
