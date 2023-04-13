package com.drawable.learning.fragment.custom.stroke

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.drawable.learning.tools.px

class HighlightAnimView(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) :
    View(context, attributeSet, defStyleAttr), DefaultLifecycleObserver {
    private val TAG = "HighlightAnimView"

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    private var percent = 0f

    private var realValueAnimator: ValueAnimator =
        ValueAnimator.ofFloat(0f, 1f).apply {
            interpolator = LinearInterpolator()
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
            duration = 600
            addUpdateListener {
                it.animatedValue.toString().toFloat().let { valuePercent ->
                    percent = valuePercent
//                    Log.e(TAG, "percent = $percent: ")
                }
                postInvalidate()
            }
        }

    private fun startAnim() {
        Log.e(TAG, "startAnim: realValueAnimator.isRunning = ${realValueAnimator.isRunning}")
        if (!realValueAnimator.isRunning) {
            realValueAnimator.start()
        }
    }

    private fun stopAnim() {
        Log.e(TAG, "stopAnim: realValueAnimator.isRunning = ${realValueAnimator.isRunning}")
        if (realValueAnimator.isRunning) {
            realValueAnimator.cancel()
        }

    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.e(TAG, "onResume: ")
        startAnim()
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.e(TAG, "onPause: ")
        stopAnim()
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.e(TAG, "onStop: ")
        stopAnim()
    }


    private val dashPathEffect by lazy {
        DashPathEffect(floatArrayOf(5f.px, 5f.px, 5f.px, 5f.px), 1f)
    }

    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#FFE524")
        style = Paint.Style.STROKE
        strokeWidth = 5f.px
        pathEffect = dashPathEffect
    }

    private val topPath = Path()
    private val rightPath = Path()
    private val bottomPath = Path()
    private val leftPath = Path()

    private val distance = 10f.px

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        topPath.reset()
        topPath.moveTo(distance * percent, 0f)
        topPath.lineTo(width.toFloat(), 0f)
        canvas?.drawPath(topPath, linePaint)

        rightPath.reset()
        rightPath.moveTo(width.toFloat(), distance * percent)
        rightPath.lineTo(width.toFloat(), height.toFloat())
        canvas?.drawPath(rightPath, linePaint)

        bottomPath.reset()
        bottomPath.moveTo(width.toFloat() - distance * percent, height.toFloat())
        bottomPath.lineTo(0f, height.toFloat())
        canvas?.drawPath(bottomPath, linePaint)

        leftPath.reset()
        leftPath.moveTo(0f, height.toFloat() - distance * percent)
        leftPath.lineTo(0f, 0f)
        canvas?.drawPath(leftPath, linePaint)
    }

}