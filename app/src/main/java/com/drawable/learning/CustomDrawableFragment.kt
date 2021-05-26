package com.drawable.learning

import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import com.drawable.learning.databinding.FragmentCustomDrawableBinding

class CustomDrawableFragment : BaseFragment<FragmentCustomDrawableBinding>() {
    override fun initView() {
        binding.customDrawableTv.apply {

            measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
            Log.e(TAG, "initView: width = $measuredWidth")
            Log.e(TAG, "initView: height = $measuredHeight")
            background = MyDrawable(measuredWidth, measuredHeight)
        }

    }

    class MyDrawable(private val width: Int, private val height: Int) : Drawable() {
        private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
            color = Color.parseColor("#FFA07A")
        }

        override fun draw(canvas: Canvas) {
            canvas.drawRect(Rect(0, 0, width, height), paint)

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