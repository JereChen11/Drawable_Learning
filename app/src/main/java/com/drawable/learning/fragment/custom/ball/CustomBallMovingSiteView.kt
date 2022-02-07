package com.drawable.learning.fragment.custom.ball

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.Gravity
import android.view.MotionEvent
import android.widget.FrameLayout
import android.widget.ImageView
import com.drawable.learning.tools.px

/**
 * @author jere
 */
class CustomBallMovingSiteView(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) :
    FrameLayout(context, attributeSet, defStyleAttr) {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    private lateinit var ballContainerIv: ImageView
    private val ballDrawable = BallDrawable()
    private val radius = 50

    private var rippleAlpha = 0
    private var rippleRadius = 10f

    private var rawTouchEventX = 0f
    private var rawTouchEventY = 0f
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
        //generate a ball by dynamic
        ballContainerIv = ImageView(context).apply {
            layoutParams = LayoutParams(radius * 2, radius * 2).apply {
                gravity = Gravity.CENTER
            }

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
            rawTouchEventX = it.x
            rawTouchEventY = it.y
            touchEventX = it.x - radius
            touchEventY = it.y - radius
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

        val oaMoving = ObjectAnimator.ofFloat(ballContainerIv, "x", "y", path)
        val oaRotating = ObjectAnimator.ofFloat(ballContainerIv, "rotation", 0f, 360f)

        AnimatorSet().apply {
            duration = 1000
            playTogether(oaMoving, oaRotating)
            start()
        }

        return super.onTouchEvent(event)
    }

    fun setRippleValue(currentValue: Float) {
        rippleRadius = currentValue * radius
        rippleAlpha = ((1 - currentValue) * 255).toInt()
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        ripplePaint.alpha = rippleAlpha
        //draw ripple for click event
        canvas?.drawCircle(rawTouchEventX, rawTouchEventY, rippleRadius, ripplePaint)
    }
}