package com.zrh.span

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlin.math.roundToInt

/**
 *
 * @author zrh
 * @date 2023/7/13
 *
 */
class ContextUtils {
}

fun Context.color(res: Int): Int {
    return ContextCompat.getColor(this, res)
}

fun Context.drawable(res: Int): Drawable? {
    return ContextCompat.getDrawable(this, res)
}

fun Context.dp2Px(dp: Int): Int {
    return (resources.displayMetrics.density * dp).roundToInt()
}

fun Context.sp2Px(sp: Int): Int {
    return (resources.displayMetrics.scaledDensity * sp).roundToInt()
}

fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}