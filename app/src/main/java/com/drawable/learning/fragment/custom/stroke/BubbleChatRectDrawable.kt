package com.drawable.learning.fragment.custom.stroke

import android.graphics.*
import android.graphics.drawable.Drawable
import com.drawable.learning.tools.px

class BubbleChatRectDrawable : Drawable() {
    private val pathPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#ECF6ED")
        style = Paint.Style.FILL
    }

    private val padding = 2f.px

    private var paddingStart = 30f.px
    private var paddingBottom = 20f.px

    private val outPath = Path()
    private val inPath = Path()

    override fun draw(canvas: Canvas) {

        bounds.apply {

            //外边框
            pathPaint.color = Color.parseColor("#2BDEA8")
            canvas.drawRoundRect(
                left.toFloat(),
                top.toFloat(),
                right.toFloat(),
                bottom.toFloat() - paddingBottom,
                5f.px,
                5f.px,
                pathPaint
            )

            //内边框
            pathPaint.color = Color.parseColor("#ECF6ED")
            canvas.drawRoundRect(
                left.toFloat() + padding,
                top.toFloat() + padding,
                right.toFloat() - padding,
                bottom.toFloat() - paddingBottom - padding,
                5f.px,
                5f.px,
                pathPaint
            )

            outPath.reset()
            outPath.moveTo(bounds.left + paddingStart, bottom - paddingBottom - padding)
            outPath.lineTo(bounds.left + paddingStart + 10f.px, bottom - paddingBottom + 13f.px)
            outPath.lineTo(bounds.left + paddingStart + 20f.px, bottom - paddingBottom - padding)
            outPath.close()
            pathPaint.color = Color.parseColor("#2BDEA8")
            canvas.drawPath(outPath, pathPaint)

            inPath.reset()
            inPath.moveTo(
                bounds.left + paddingStart + padding,
                bottom - paddingBottom - padding * 2
            )
            inPath.lineTo(
                bounds.left + paddingStart + 10f.px,
                bottom - paddingBottom + 13f.px - padding * 2
            )
            inPath.lineTo(
                bounds.left + paddingStart - padding + 20f.px,
                bottom - paddingBottom - padding * 2
            )
            inPath.close()
            pathPaint.color = Color.parseColor("#ECF6ED")
            canvas.drawPath(inPath, pathPaint)
        }

    }

    override fun setAlpha(alpha: Int) {
        pathPaint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        pathPaint.colorFilter = colorFilter
    }

    override fun getOpacity(): Int {
        return when (pathPaint.alpha) {
            0xff -> PixelFormat.OPAQUE
            0x00 -> PixelFormat.TRANSPARENT
            else -> PixelFormat.TRANSLUCENT
        }
    }

}