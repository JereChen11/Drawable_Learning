package com.drawable.learning.custom.ball

import android.graphics.*
import android.graphics.drawable.Drawable
import com.drawable.learning.px

class BallDrawable : Drawable() {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#D2691E")
    }

    override fun draw(canvas: Canvas) {
        canvas.drawCircle(
            bounds.width().toFloat() / 2,
            bounds.height().toFloat() / 2,
            15f.px,
            paint
        )
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