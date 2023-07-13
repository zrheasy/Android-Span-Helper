package com.zrh.span.decorator;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

import androidx.annotation.NonNull;

/**
 * @author zrh
 * @date 2023/7/13
 */
public abstract class Decoration {
    protected final int[] range;

    public Decoration(@NonNull int[] range) {
        this.range = range;
    }

    public void setup(@NonNull SpannableStringBuilder builder) {
        builder.setSpan(getSpan(), range[0], range[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    public void setup(@NonNull SpannableString spannableString) {
        int start = range[0];
        int end = range[1];
        int length = spannableString.length();
        if (start >= 0 && end <= length && start <= end)
            spannableString.setSpan(getSpan(), range[0], range[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    @NonNull
    protected abstract Object getSpan();
}
