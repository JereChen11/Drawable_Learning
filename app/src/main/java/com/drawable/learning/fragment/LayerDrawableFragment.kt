package com.drawable.learning.fragment

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.drawable.learning.R
import com.drawable.learning.databinding.FragmentLayerDrawableBinding
import com.drawable.learning.tools.px

/**
 * @author jere
 */
class LayerDrawableFragment : BaseFragment<FragmentLayerDrawableBinding>() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun initView() {
        binding.layerDrawableInclude.apply {
            tv1.setText(R.string.layer_drawable)
            tv1.background = ContextCompat.getDrawable(requireContext(), R.drawable.layer_drawable)
            tv2.setText(R.string.layer_drawable)

            val itemLeft = GradientDrawable().apply {
                setColor(ContextCompat.getColor(requireContext(), R.color.royal_blue))
                setSize(50.px, 50.px)
                shape = GradientDrawable.OVAL
            }
            val itemCenter = GradientDrawable().apply {
                setColor(ContextCompat.getColor(requireContext(), R.color.indian_red))
                shape = GradientDrawable.OVAL
            }
            val itemRight = GradientDrawable().apply {
                setColor(ContextCompat.getColor(requireContext(), R.color.yellow))
                shape = GradientDrawable.OVAL
            }
            val arr = arrayOf(
                ContextCompat.getDrawable(requireContext(), R.drawable.nick)!!,
                itemLeft,
                itemCenter,
                itemRight
            )
            val ld = LayerDrawable(arr).apply {
                setLayerInset(1, 0.px, 0.px, 250.px, 150.px)
                setLayerInset(2, 125.px, 75.px, 125.px, 75.px)
                setLayerInset(3, 250.px, 150.px, 0.px, 0.px)
            }
            tv2.background = ld
        }

    }

}