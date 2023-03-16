package com.drawable.learning.fragment.custom.stroke

import com.drawable.learning.databinding.FragmentHighlightAnimBinding
import com.drawable.learning.fragment.BaseFragment
import com.drawable.learning.tools.px

class HighlightAnimFragment : BaseFragment<FragmentHighlightAnimBinding>() {


    override fun initView() {
        val bubbleChatRectDrawable = BubbleChatRectDrawable()

        val intArray = IntArray(2)
        binding.testIv.getLocationOnScreen(intArray)

        bubbleChatRectDrawable.setBounds(
            intArray[0],
            intArray[1],
            (intArray[0] + 200f.px).toInt(),
            (intArray[1] + 100f.px).toInt()
        )
        binding.testIv.background = bubbleChatRectDrawable
    }

}