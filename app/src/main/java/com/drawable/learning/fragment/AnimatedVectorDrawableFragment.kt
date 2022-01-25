package com.drawable.learning.fragment

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.drawable.Animatable
import com.drawable.learning.databinding.FragmentAnimatedVectorDrawableBinding

/**
 * @author jere
 */
class AnimatedVectorDrawableFragment : BaseFragment<FragmentAnimatedVectorDrawableBinding>() {
    override fun initView() {
        (binding.vectorDrawableIv.drawable as Animatable).start()


        //如果你想对 VectorDrawable (也就是binding.vectorDrawableIv2.drawable) 做动画处理，你需要使用 AnimatedVectorDrawable
        //不然你会发现报错信息 Method setScaleX() with type float not found on target class class android.graphics.drawable.VectorDrawable
        //refer link：https://stackoverflow.com/a/32007436/11641198
        val iv = binding.vectorDrawableIv2
        val an1 = ObjectAnimator.ofFloat(iv, "scaleX", 0f, 1f).apply {
            duration = 3000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        }
        val an2 = ObjectAnimator.ofFloat(iv, "scaleY", 0f, 1f).apply {
            duration = 3000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
        }
        AnimatorSet().apply {
            duration = 3000
            playTogether(an1, an2)
            start()
        }
    }
}