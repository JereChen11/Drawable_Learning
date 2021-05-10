package com.drawable.learning

import android.graphics.drawable.TransitionDrawable
import androidx.core.content.ContextCompat
import com.drawable.learning.databinding.FragmentTransitionDrawableBinding

class TransitionDrawableFragment : BaseFragment<FragmentTransitionDrawableBinding>() {

    override fun initView() {

//        val drawable = binding.transitionDrawableTv.background as TransitionDrawable
//        drawable.startTransition(1500)


        val transitionDrawable: TransitionDrawable = ContextCompat.getDrawable(
            context!!,
            R.drawable.transition_drawable
        ) as TransitionDrawable
        binding.transitionDrawableTv.background = transitionDrawable
        transitionDrawable.startTransition(1000)
    }

}