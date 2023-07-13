package com.zrh.span

import android.graphics.BlurMaskFilter
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zrh.span.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setColor()
        setBackgroundColor()
        setClick()
        setImage()
        setSize()
        setBold()
        setUnderline()
        setBullet()
        setQuote()
        setStrikethrough()
        setSubscript()
        setSuperscript()
        setFamily()
        setMask()
    }

    private fun setColor() {
        val keyword = "关键字"
        val source = "设置文字颜色：$keyword"
        SpanHelper(source)
            .setColor(keyword, Color.RED)
            .into(mBinding.tvColor)
    }

    private fun setBackgroundColor() {
        val keyword = "关键字"
        val source = "设置文字背景颜色：$keyword"
        SpanHelper(source)
            .setBackgroundColor(keyword, Color.GRAY)
            .into(mBinding.tvBackgroundColor)
    }

    private fun setClick() {
        val keyword = "链接"
        val source = "设置文字点击：$keyword"
        SpanHelper(source)
            .setColor(keyword, Color.BLUE)
            .setClick(keyword) {
                toast("Hello world!")
            }
            .into(mBinding.tvClick)
    }

    private fun setImage() {
        val keyword = "<image>"
        val source = "设置图片：$keyword"
        SpanHelper(source)
            .setImage(keyword, drawable(R.mipmap.ic_launcher_round), dp2Px(20), dp2Px(20))
            .into(mBinding.tvImage)
    }

    private fun setSize() {
        val keyword = "关键字"
        val source = "设置文字大小：$keyword"
        SpanHelper(source)
            .setSize(keyword, sp2Px(24))
            .into(mBinding.tvSize)
    }

    private fun setBold() {
        val keyword = "关键字"
        val source = "设置文字粗体：$keyword"
        SpanHelper(source)
            .setBold(keyword)
            .into(mBinding.tvBold)
    }

    private fun setUnderline() {
        val keyword = "关键字"
        val source = "设置文字下划线：$keyword"
        SpanHelper(source)
            .setUnderline(keyword)
            .into(mBinding.tvUnderline)
    }

    private fun setBullet() {
        val source = "设置段落圆点"
        SpanHelper(source)
            .setBullet(dp2Px(2), Color.BLUE, dp2Px(2))
            .into(mBinding.tvBullet)
    }

    private fun setQuote() {
        val source = "设置段落引用"
        SpanHelper(source)
            .setQuote(dp2Px(2), Color.BLUE, dp2Px(2))
            .into(mBinding.tvQuote)
    }

    private fun setStrikethrough() {
        val keyword = "关键字"
        val source = "设置删除线：$keyword"
        SpanHelper(source)
            .setStrikethrough(keyword)
            .into(mBinding.tvStrikethrough)
    }

    private fun setSubscript() {
        val keyword = "关键字"
        val source = "设置文字下标：$keyword\n"
        SpanHelper(source)
            .setSubscript(keyword)
            .into(mBinding.tvSubscript)
    }

    private fun setSuperscript() {
        val keyword = "关键字"
        val source = "设置文字上标：$keyword\n"
        SpanHelper(source)
            .setSuperscript(keyword)
            .into(mBinding.tvSuperscript)
    }

    private fun setMask() {
        val keyword = "关键字"
        val source = "设置文字遮罩：$keyword"
        SpanHelper(source)
            .setMaskFilter(keyword, BlurMaskFilter(5f, BlurMaskFilter.Blur.NORMAL))
            .into(mBinding.tvMask)
    }

    private fun setFamily() {
        val keyword = "关键字"
        val source = "设置文字字体族：$keyword"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            SpanHelper(source)
                .setTypeface(keyword, Typeface.MONOSPACE)
                .into(mBinding.tvTypeface)
        }
    }
}