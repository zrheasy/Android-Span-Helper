package com.zrh.span.decorator;

import android.graphics.Typeface;
import android.os.Build;
import android.text.style.TypefaceSpan;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class TypefaceDecoration extends Decoration {
    private final Typeface typeface;

    public TypefaceDecoration(@NonNull int[] range, Typeface typeface) {
        super(range);
        this.typeface = typeface;
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @NonNull
    @Override
    protected Object getSpan() {
        return new TypefaceSpan(typeface);
    }
}
