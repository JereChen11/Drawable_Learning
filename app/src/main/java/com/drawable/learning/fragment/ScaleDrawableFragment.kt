package com.drawable.learning.fragment

import android.graphics.drawable.ScaleDrawable
import android.util.Log
import android.view.Gravity
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.drawable.learning.R
import com.drawable.learning.databinding.FragmentScaleDrawableBinding

/**
 * @author jere
 */
class ScaleDrawableFragment : BaseFragment<FragmentScaleDrawableBinding>() {

    override fun initView() {
        binding.scaleDrawableInclude.apply {
            tv1.setText(R.string.scale_drawable)
            tv1.background = ContextCompat.getDrawable(context!!, R.drawable.scale_drawable)
            tv2.setText(R.string.scale_drawable)

            val scaleDrawable = ScaleDrawable(
                context?.let { ContextCompat.getDrawable(it, R.drawable.nick) },
                Gravity.CENTER,
                1f,
                1f
            )
            tv2.background = scaleDrawable

            binding.seekBar.apply {
                //init level
                tv1.background.level = progress
                scaleDrawable.level = progress
                //add listener
                setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        tv1.background.level = progress
                        scaleDrawable.level = progress
                        Log.e(TAG, "onProgressChanged: progreess = $progress")
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {

                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {

                    }

                })
            }
        }


    }

}