package com.drawable.learning.custom

import android.graphics.*
import android.graphics.drawable.Drawable
import com.drawable.learning.px

class BgDrawable : Drawable() {
    private val lineCount = 4
    private val columnCount = 5

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 1f.px
        color = Color.parseColor("#B5B5B5")
        pathEffect = DashPathEffect(floatArrayOf(5f, 5f, 5f, 5f), 1f)
    }

    override fun draw(canvas: Canvas) {
        for (i in 0 until lineCount) {
            val y = (bounds.top + bounds.height() / lineCount * i).toFloat()
            canvas.drawLine(bounds.left.toFloat(), y, bounds.right.toFloat(), y, paint)
        }
        for (i in 0 until columnCount) {
            val x = (bounds.left + bounds.width() / columnCount * i).toFloat()
            canvas.drawLine(x, bounds.top.toFloat(), x, bounds.bottom.toFloat(), paint)
        }
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getOpacity(): Int {
        return when (paint.alpha) {
            0xff -> PixelFormat.OPAQUE
            0x00 -> PixelFormat.TRANSPARENT
            else -> PixelFormat.TRANSLUCENT
        }
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

}