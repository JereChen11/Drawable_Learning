package com.drawable.learning.custom.line_chart

import android.graphics.*
import android.graphics.drawable.Drawable
import com.drawable.learning.BaseFragment
import com.drawable.learning.databinding.FragmentLineChartBinding
import com.drawable.learning.px

/**
 * @author jere
 *
 * drawing line chart
 */
class LineChartFragment : BaseFragment<FragmentLineChartBinding>() {
    override fun initView() {
        binding.customDrawableTv.apply {
            background = MyDrawable()
        }
    }

    class MyDrawable : Drawable() {
        private val bgDrawable = BgGridDrawable()

        private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
            color = Color.parseColor("#96CDCD")
        }

        override fun draw(canvas: Canvas) {
            paint.shader = null

            canvas.drawRect(
                bounds.left.toFloat(),
                bounds.top.toFloat(),
                bounds.right.toFloat(),
                bounds.bottom.toFloat(),
                paint
            )

            bgDrawable.bounds = bounds
            bgDrawable.draw(canvas)

            //hard code the points of the line chart
            val path = Path().apply {
                moveTo(bounds.left.toFloat(), bounds.bottom.toFloat())
                lineTo(bounds.left.toFloat(), 150f)
                lineTo(10f, 200f)
                lineTo(50f, 130f)
                lineTo(90f, 250f)
                lineTo(110f, 180f)
                lineTo(170f, 220f)
                lineTo(181f, 200f)
                lineTo(195f, 130f)
                lineTo(250f, 240f)
                lineTo(290f, 260f)
                lineTo(300f, 160f)
                lineTo(360f, 300f)
                lineTo(400f, 280f)
                lineTo(440f, 200f)
                lineTo(490f, 150f)
                lineTo(530f, 170f)
                lineTo(bounds.right.toFloat(), 320f)
                lineTo(bounds.right.toFloat(), bounds.bottom.toFloat())
            }
            paint.apply {
                style = Paint.Style.STROKE
                strokeWidth = 2f.px
                color = Color.WHITE
            }
            canvas.drawPath(path, paint)

            //draw the shader for path
            path.close()
            paint.apply {
                style = Paint.Style.FILL
                shader = LinearGradient(
                    bounds.left.toFloat(), bounds.top.toFloat(),
                    bounds.left.toFloat(), bounds.bottom.toFloat(),
                    intArrayOf(Color.parseColor("#FF6A6A"), Color.TRANSPARENT),
                    null,
                    Shader.TileMode.CLAMP
                )
            }
            canvas.drawPath(path, paint)
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

}