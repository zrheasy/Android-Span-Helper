package com.zrh.span;

import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.zrh.span.decorator.BackgroundDecoration;
import com.zrh.span.decorator.BulletDecoration;
import com.zrh.span.decorator.ClickDecoration;
import com.zrh.span.decorator.ColorDecoration;
import com.zrh.span.decorator.Decoration;
import com.zrh.span.decorator.ImageDecoration;
import com.zrh.span.decorator.MaskFilterDecoration;
import com.zrh.span.decorator.QuoteDecoration;
import com.zrh.span.decorator.SizeDecoration;
import com.zrh.span.decorator.StrikethroughDecoration;
import com.zrh.span.decorator.StyleDecoration;
import com.zrh.span.decorator.SubscriptDecoration;
import com.zrh.span.decorator.SuperscriptDecoration;
import com.zrh.span.decorator.TypefaceDecoration;
import com.zrh.span.decorator.UnderlineDecoration;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zrh
 * @date 2023/7/13
 */
public class SpanHelper {
    private final String source;
    private final List<Decoration> decorations = new LinkedList<>();

    public SpanHelper(String source) {
        this.source = source;
    }

    public SpanHelper addDecoration(Decoration decoration) {
        decorations.add(decoration);
        return this;
    }

    public SpanHelper setColor(String keyword, int color) {
        int[] range = getRange(keyword);
        addDecoration(new ColorDecoration(range, color));
        return this;
    }

    public SpanHelper setBackgroundColor(String keyword, int color) {
        int[] range = getRange(keyword);
        addDecoration(new BackgroundDecoration(range, color));
        return this;
    }

    public SpanHelper setBold(String keyword) {
        int[] range = getRange(keyword);
        addDecoration(new StyleDecoration(range, Typeface.BOLD));
        return this;
    }

    public SpanHelper setUnderline(String keyword) {
        int[] range = getRange(keyword);
        addDecoration(new UnderlineDecoration(range));
        return this;
    }

    public SpanHelper setSize(String keyword, int size) {
        int[] range = getRange(keyword);
        addDecoration(new SizeDecoration(range, size));
        return this;
    }

    public SpanHelper setClick(String keyword, View.OnClickListener listener) {
        int[] range = getRange(keyword);
        addDecoration(new ClickDecoration(range, listener));
        return this;
    }

    public SpanHelper setImage(String keyword, Drawable drawable, int width, int height) {
        int[] range = getRange(keyword);
        addDecoration(new ImageDecoration(range, drawable, width, height));
        return this;
    }

    public SpanHelper setBullet(int gapWidth, int color, int radius) {
        int[] range = new int[]{0, source.length()};
        addDecoration(new BulletDecoration(range, gapWidth, color, radius));
        return this;
    }

    public SpanHelper setQuote(int gapWidth, int color, int stripWidth) {
        int[] range = new int[]{0, source.length()};
        addDecoration(new QuoteDecoration(range, color, stripWidth, gapWidth));
        return this;
    }

    public SpanHelper setStrikethrough(String keyword) {
        int[] range = getRange(keyword);
        addDecoration(new StrikethroughDecoration(range));
        return this;
    }

    public SpanHelper setSubscript(String keyword) {
        int[] range = getRange(keyword);
        addDecoration(new SubscriptDecoration(range));
        return this;
    }

    public SpanHelper setSuperscript(String keyword) {
        int[] range = getRange(keyword);
        addDecoration(new SuperscriptDecoration(range));
        return this;
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public SpanHelper setTypeface(String keyword, Typeface typeface) {
        int[] range = getRange(keyword);
        addDecoration(new TypefaceDecoration(range, typeface));
        return this;
    }

    public SpanHelper setMaskFilter(String keyword, MaskFilter filter) {
        int[] range = getRange(keyword);
        addDecoration(new MaskFilterDecoration(range, filter));
        return this;
    }

    private int[] getRange(String keyword) {
        int index = source.indexOf(keyword);
        return new int[]{index, index + keyword.length()};
    }

    public void into(TextView textView) {
        SpannableString builder = new SpannableString(source);
        boolean clickable = false;
        for (Decoration decoration : decorations) {
            if (decoration instanceof ClickDecoration) {
                clickable = true;
            }
            decoration.setup(builder);
        }
        textView.setText(builder);
        if (clickable) {
            textView.setHighlightColor(Color.TRANSPARENT);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
