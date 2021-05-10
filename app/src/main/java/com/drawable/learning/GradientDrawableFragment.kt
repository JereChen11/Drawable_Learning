package com.drawable.learning

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Build
import androidx.annotation.RequiresApi
import com.drawable.learning.databinding.FragmentGradientDrawableBinding

class GradientDrawableFragment : BaseFragment<FragmentGradientDrawableBinding>() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun initView() {

        val gradientDrawable = GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            gradientType = GradientDrawable.RADIAL_GRADIENT
            colors = intArrayOf(Color.parseColor("#00F5FF"), Color.parseColor("#BBFFFF"))
            gradientRadius = 100f.px
        }

        binding.gradientDrawableTv.background = gradientDrawable
    }



}