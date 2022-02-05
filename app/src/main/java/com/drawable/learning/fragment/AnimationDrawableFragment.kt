package com.drawable.learning.fragment

import android.graphics.drawable.AnimationDrawable
import androidx.core.content.ContextCompat
import com.drawable.learning.R
import com.drawable.learning.databinding.FragmentAnimationDrawableBinding

/**
 * @author jere
 */
class AnimationDrawableFragment : BaseFragment<FragmentAnimationDrawableBinding>() {
    private val animationDrawable by lazy {
        ContextCompat.getDrawable(
            requireContext(),
            R.drawable.animation_drawable
        ) as AnimationDrawable
    }

    override fun initView() {
        binding.animationDrawableInclude.apply {
            tv1.setText(R.string.animation_drawable)
            tv1.background = animationDrawable
            tv2.setText(R.string.animation_drawable)

            animationDrawable.start()

            val animationDrawable = AnimationDrawable().apply {
                ContextCompat.getDrawable(requireContext(), R.drawable.nick)
                    ?.let { addFrame(it, 1000) }
                ContextCompat.getDrawable(requireContext(), R.drawable.basketball)
                    ?.let { addFrame(it, 1000) }
            }
            tv2.background = animationDrawable
            animationDrawable.start()
        }
    }

}