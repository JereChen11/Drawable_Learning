package com.drawable.learning.custom.ball

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import com.drawable.learning.px

class SiteFrameLayout(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) :
    FrameLayout(context, attributeSet, defStyleAttr) {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    private lateinit var ballContainerIv: ImageView
    private val ballDrawable = BallDrawable()

    private var rippleAlpha = 0
    private var rippleRadius = 10f

    private var touchEventX = 0f
    private var touchEventY = 0f
    private var lastTouchEventX = 0f
    private var lastTouchEventY = 0f

    private val ripplePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        isDither = true
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 2f.px
        alpha = rippleAlpha
    }

    init {
        initView(context, attributeSet)
    }

    private fun initView(context: Context, attributeSet: AttributeSet?) {

        ballContainerIv = ImageView(context).apply {
            layoutParams = LayoutParams(100, 100)
            setImageDrawable(ballDrawable)
            //setBackgroundColor(Color.BLUE)
        }

        addView(ballContainerIv)
        setWillNotDraw(false)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        lastTouchEventX = touchEventX
        lastTouchEventY = touchEventY

        event?.let {
            touchEventX = it.x
            touchEventY = it.y
        }

        ObjectAnimator.ofFloat(this, "rippleValue", 0f, 1f).apply {
            duration = 1000
            start()
        }

        val path = Path().apply {
            moveTo(lastTouchEventX, lastTouchEventY)
            quadTo(
                lastTouchEventX,
                lastTouchEventY,
                touchEventX,
                touchEventY
            )
        }

        ObjectAnimator.ofFloat(ballContainerIv, "x", "y", path).apply {
            duration = 1000
            interpolator = AccelerateDecelerateInterpolator()
            start()
        }

        return super.onTouchEvent(event)
    }

    fun setRippleValue(currentValue: Float) {
        rippleRadius = currentValue * 30f.px
        rippleAlpha = ((1 - currentValue) * 255).toInt()
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        ripplePaint.alpha = rippleAlpha
        //draw ripple for click event
        canvas?.drawCircle(touchEventX, touchEventY, rippleRadius, ripplePaint)
    }
}