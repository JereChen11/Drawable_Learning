package com.drawable.learning

import android.graphics.drawable.StateListDrawable
import android.util.Log
import android.util.StateSet
import androidx.core.content.ContextCompat
import com.drawable.learning.databinding.FragmentStateListDrawableBinding

class StateListDrawableFragment : BaseFragment<FragmentStateListDrawableBinding>() {

    override fun initView() {
        binding.stateListDrawableTv.apply {
            setOnClickListener {
                Log.e(TAG, "stateListDrawableTv: isPressed = $isPressed")
            }
        }

        val sld = StateListDrawable().apply {
            addState(
                intArrayOf(android.R.attr.state_pressed),
                ContextCompat.getDrawable(context!!, R.drawable.basketball)
            )
            addState(StateSet.WILD_CARD, ContextCompat.getDrawable(context!!, R.drawable.nick))
        }
        binding.stateListDrawableTv2.apply {
            background = sld
            setOnClickListener {
                Log.e(TAG, "stateListDrawableTv2: isPressed = $isPressed")
            }
        }

    }

}