package com.drawable.learning

import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import com.drawable.learning.databinding.FragmentShapeDrawableBinding


class ShapeDrawableFragment : BaseFragment<FragmentShapeDrawableBinding>() {

    override fun initView() {

        val roundRectShape =
            RoundRectShape(floatArrayOf(20f.px, 20f.px, 20f.px, 20f.px, 0f, 0f, 0f, 0f), null, null)
        binding.shapeDrawableTv2.background = MyShapeDrawable(roundRectShape)
    }

    /**
     * TODO: //使用 GradientDrawable 效果更好
     */
    class MyShapeDrawable(shape: Shape) : ShapeDrawable(shape) {
        private val fillPaint = Paint().apply {
            style = Paint.Style.FILL
            color = Color.parseColor("#4169E1")
        }
        private val strokePaint = Paint().apply {
            style = Paint.Style.STROKE
            color = Color.parseColor("#FFBB86FC")
//            strokeCap = Paint.Cap.ROUND
//            strokeJoin = Paint.Join.ROUND
            strokeMiter = 10f
            strokeWidth = 5f.px
            pathEffect = DashPathEffect(floatArrayOf(10f.px, 5f.px), 0f)
        }

        override fun onDraw(shape: Shape?, canvas: Canvas?, paint: Paint?) {
            super.onDraw(shape, canvas, paint)
            shape?.draw(canvas, fillPaint)
            shape?.draw(canvas, strokePaint)
        }
    }

}