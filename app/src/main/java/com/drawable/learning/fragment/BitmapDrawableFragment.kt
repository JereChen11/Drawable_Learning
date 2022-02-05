package com.drawable.learning.fragment

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import androidx.core.content.ContextCompat
import com.drawable.learning.R
import com.drawable.learning.databinding.FragmentBitmapDrawableBinding

/**
 * @author jere
 */
class BitmapDrawableFragment : BaseFragment<FragmentBitmapDrawableBinding>() {

    override fun initView() {
        binding.bitmapDrawableInclude.apply {
            tv1.setText(R.string.bitmap_drawable)
            tv1.background = ContextCompat.getDrawable(requireContext(), R.drawable.bitmap_drawable)
            tv2.setText(R.string.bitmap_drawable)

            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.nick)
            val bitmapShape = BitmapDrawable(resources, bitmap)
            tv2.background = bitmapShape
        }
    }

}