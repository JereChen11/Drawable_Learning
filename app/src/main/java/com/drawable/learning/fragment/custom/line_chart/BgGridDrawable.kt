package com.drawable.learning.fragment.custom.line_chart

import android.graphics.*
import android.graphics.drawable.Drawable
import com.drawable.learning.tools.px

/**
 * @author jere
 *
 * Draws a mesh dotted background
 */
class BgGridDrawable : Drawable() {
    private val lineCount = 4
    private val columnCount = 5
    private val path: Path = Path()

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 1f.px
        color = Color.parseColor("#B5B5B5")
        pathEffect = DashPathEffect(floatArrayOf(10f.px, 5f.px), 0f)
    }

    override fun draw(canvas: Canvas) {
        for (i in 0 until lineCount) {
            val y = (bounds.top + bounds.height() / lineCount * i).toFloat()
            path.moveTo(bounds.left.toFloat(), y)
            path.lineTo(bounds.right.toFloat(), y)
            canvas.drawPath(path, paint)
        }
        for (i in 0 until columnCount) {
            val x = (bounds.left + bounds.width() / columnCount * i).toFloat()
            path.moveTo(x, bounds.top.toFloat())
            path.lineTo(x, bounds.bottom.toFloat())
            canvas.drawPath(path, paint)
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