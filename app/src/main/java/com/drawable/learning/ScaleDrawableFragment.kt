package com.drawable.learning

import android.graphics.drawable.ScaleDrawable
import android.util.Log
import android.view.Gravity
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.drawable.learning.databinding.FragmentScaleDrawableBinding

class ScaleDrawableFragment : BaseFragment<FragmentScaleDrawableBinding>() {

    override fun initView() {

        val scaleDrawable = ScaleDrawable(
            context?.let { ContextCompat.getDrawable(it, R.drawable.nick) },
            Gravity.CENTER,
            1f,
            1f
        )
        binding.scaleDrawableTv2.background = scaleDrawable

        binding.seekBar.apply {
            //init level
            binding.scaleDrawableTv.background.level = progress
            scaleDrawable.level = progress
            //add listener
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    binding.scaleDrawableTv.background.level = progress
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