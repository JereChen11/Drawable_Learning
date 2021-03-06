package com.drawable.learning.fragment

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.drawable.learning.R
import com.drawable.learning.databinding.FragmentGradientDrawableBinding
import com.drawable.learning.tools.px

/**
 * @author jere
 */
class GradientDrawableFragment : BaseFragment<FragmentGradientDrawableBinding>() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun initView() {
        binding.gradientDrawableInclude.apply {
            tv1.setText(R.string.gradient_drawable)
            tv1.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.gradient_drawable)
            tv2.setText(R.string.gradient_drawable)

            val gradientDrawable = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                gradientType = GradientDrawable.RADIAL_GRADIENT
                colors = intArrayOf(Color.parseColor("#00F5FF"), Color.parseColor("#BBFFFF"))
                gradientRadius = 100f.px
            }
            tv2.background = gradientDrawable
        }
    }
}