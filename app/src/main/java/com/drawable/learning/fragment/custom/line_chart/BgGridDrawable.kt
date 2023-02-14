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
        color = Color.parseColor("#80B5B5B5")
        pathEffect = DashPathEffect(floatArrayOf(5f.px, 5f.px, 5f.px, 5f.px), 0f)
    }

    private var pixelX = 0f
    private var pixelY = 0f
    override fun draw(canvas: Canvas) {
        for (i in 0 until lineCount) {
            pixelY = (bounds.top + bounds.height() / lineCount * i).toFloat()
            path.moveTo(bounds.left.toFloat(), pixelY)
            path.lineTo(bounds.right.toFloat(), pixelY)
            canvas.drawPath(path, paint)
        }
        for (i in 0 until columnCount) {
            pixelX = (bounds.left + bounds.width() / columnCount * i).toFloat()
            path.moveTo(pixelX, bounds.top.toFloat())
            path.lineTo(pixelX, bounds.bottom.toFloat())
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