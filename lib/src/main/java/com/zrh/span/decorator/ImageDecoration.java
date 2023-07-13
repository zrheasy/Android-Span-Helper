package com.zrh.span.decorator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class ImageDecoration extends Decoration {
    private final Drawable drawable;

    public ImageDecoration(@NonNull int[] range, Drawable drawable, int width, int height) {
        super(range);
        this.drawable = drawable;
        drawable.setBounds(0, 0, width, height);
    }

    @NonNull
    @Override
    protected Object getSpan() {
        return new CenterImageSpan(drawable);
    }

    public static class CenterImageSpan extends ImageSpan {

        public CenterImageSpan(@NonNull Drawable drawable) {
            super(drawable, ALIGN_BASELINE);
        }

        @Override
        public int getSize(@NonNull Paint paint,
                           CharSequence text,
                           int start,
                           int end,
                           @Nullable Paint.FontMetricsInt fm) {
            Drawable drawable = getDrawable();

            Rect rect = drawable.getBounds();
            int imageHeight = rect.bottom - rect.top;
            if (fm != null) {
                Paint.FontMetricsInt textFm = paint.getFontMetricsInt();
                int fontHeight = textFm.descent - textFm.ascent;
                fm.ascent = textFm.ascent - (imageHeight - fontHeight) / 2;
                fm.descent = fm.ascent + imageHeight;
                fm.top = fm.ascent;
                fm.bottom = fm.descent;
            }
            return rect.right;
        }

        @Override
        public void draw(@NonNull Canvas canvas,
                         CharSequence text,
                         int start,
                         int end,
                         float x,
                         int top,
                         int y,
                         int bottom,
                         @NonNull Paint paint) {
            Drawable drawable = getDrawable();
            Rect rect = drawable.getBounds();
            int imageHeight = rect.bottom - rect.top;
            canvas.save();
            Paint.FontMetricsInt textFm = paint.getFontMetricsInt();
            int fontHeight = textFm.descent - textFm.ascent;
            int ascent = textFm.ascent - (imageHeight - fontHeight) / 2;
            int transY = y + ascent;
            canvas.translate(x, transY);
            drawable.draw(canvas);
            canvas.restore();
        }
    }
}
