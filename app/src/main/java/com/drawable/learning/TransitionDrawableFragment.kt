package com.drawable.learning

import android.graphics.drawable.TransitionDrawable
import android.util.Log
import androidx.core.content.ContextCompat
import com.drawable.learning.databinding.FragmentTransitionDrawableBinding

class TransitionDrawableFragment : BaseFragment<FragmentTransitionDrawableBinding>() {

    private var isShow = false
    private lateinit var bgDrawable: TransitionDrawable
    private lateinit var manualDrawable: TransitionDrawable

    override fun initView() {

        bgDrawable = binding.transitionDrawableTv.background as TransitionDrawable

        val drawableArray = arrayOf(
            ContextCompat.getDrawable(context!!, R.drawable.nick),
            ContextCompat.getDrawable(context!!, R.drawable.basketball)
        )
        manualDrawable = TransitionDrawable(drawableArray)
        binding.transitionDrawableTv2.background = manualDrawable
    }

    private fun setTransition() {
        if (isShow) {
            bgDrawable.reverseTransition(1500)
            manualDrawable.reverseTransition(3000)
        } else {
            bgDrawable.startTransition(1500)
            manualDrawable.startTransition(3000)
        }
    }

    override fun onResume() {
        super.onResume()
        setTransition()
        isShow = !isShow
    }

}