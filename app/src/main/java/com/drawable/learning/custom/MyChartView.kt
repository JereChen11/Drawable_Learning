package com.drawable.learning.custom

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class MyChartView(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) :
    View(context, attributeSet, defStyleAttr) {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)

    private val bgDrawable = BgDrawable()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        bgDrawable.draw(canvas)
    }
}