package com.drawable.learning

import android.graphics.drawable.AnimationDrawable
import androidx.core.content.ContextCompat
import com.drawable.learning.databinding.FragmentAnimationDrawableBinding

class AnimationDrawableFragment : BaseFragment<FragmentAnimationDrawableBinding>() {

    override fun initView() {

        (binding.animationDrawableTv.background as AnimationDrawable).start()

        val animationDrawable = AnimationDrawable().apply {
            ContextCompat.getDrawable(context!!, R.drawable.nick)?.let { addFrame(it, 1000) }
            ContextCompat.getDrawable(context!!, R.drawable.basketball)?.let { addFrame(it, 1000) }
        }
        binding.animationDrawableTv2.background = animationDrawable
        animationDrawable.start()
    }


}