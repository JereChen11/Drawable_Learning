package com.drawable.learning


import android.graphics.drawable.ClipDrawable
import android.view.Gravity
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.drawable.learning.databinding.FragmentClipDrawableBinding

class ClipDrawableFragment : BaseFragment<FragmentClipDrawableBinding>() {

    private lateinit var clipDrawable: ClipDrawable
    private val manualClipDrawable by lazy {
        ClipDrawable(
            ContextCompat.getDrawable(context!!, R.drawable.nick),
            Gravity.CENTER,
            ClipDrawable.VERTICAL
        )
    }

    override fun initView() {
        clipDrawable = binding.clipDrawableTv.background as ClipDrawable
        binding.clipDrawableTv2.background = manualClipDrawable

        //level 默认级别为 0，即完全裁剪，使图像不可见。当级别为 10,000 时，图像不会裁剪，而是完全可见。
        binding.seekBar.apply {
            //init level
            clipDrawable.level = progress
            manualClipDrawable.level = progress
            //add listener
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    clipDrawable.level = progress
                    manualClipDrawable.level = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

            })
        }
    }

}