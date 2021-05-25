package com.drawable.learning

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import com.drawable.learning.databinding.FragmentBitmapDrawableBinding

class BitmapDrawableFragment : BaseFragment<FragmentBitmapDrawableBinding>() {

    override fun initView() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.nick)
        val bitmapShape = BitmapDrawable(resources, bitmap)
        binding.bitmapDrawableTv2.background = bitmapShape
    }

}