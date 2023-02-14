package com.drawable.learning.fragment.custom.line_chart

import android.graphics.*
import android.graphics.drawable.Drawable
import com.drawable.learning.fragment.BaseFragment
import com.drawable.learning.databinding.FragmentLineChartBinding
import com.drawable.learning.tools.px

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
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = 2f.px
            color = Color.parseColor("#96CDCD")
        }

        //hard code the points of the line chart
        private val path = Path()

        private fun calculatePath() {
            path.apply {
                reset()
                moveTo(bounds.left.toFloat(), bounds.bottom.toFloat())
                lineTo(bounds.left.toFloat(), 150f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.05f, 200f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.1f, 130f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.15f, 250f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.2f, 80f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.25f, 220f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.3f, 200f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.35f, 30f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.4f, 240f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.45f, 260f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.5f, 160f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.55f, 100f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.6f, 80f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.65f, 20f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.7f, 150f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.75f, 170f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.8f, 320f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.85f, 220f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.9f, 300f)
                lineTo(bounds.left.toFloat() + bounds.width() * 0.95f, 120f)
                lineTo(bounds.left.toFloat() + bounds.width() * 1f, 360f)
                lineTo(bounds.left.toFloat() + bounds.width() * 1f, bounds.bottom.toFloat())
            }
        }

        override fun draw(canvas: Canvas) {
            paint.shader = null
            calculatePath()

            canvas.drawRect(
                bounds.left.toFloat(),
                bounds.top.toFloat(),
                bounds.right.toFloat(),
                bounds.bottom.toFloat(),
                paint
            )

            bgDrawable.bounds = bounds
            bgDrawable.draw(canvas)


//            paint.apply {
//                style = Paint.Style.STROKE
//                strokeWidth = 2f.px
//                color = Color.WHITE
//            }
//            canvas.drawPath(path, paint)

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