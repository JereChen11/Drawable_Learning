package com.drawable.learning.fragment


import android.graphics.drawable.ClipDrawable
import android.view.Gravity
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.drawable.learning.R
import com.drawable.learning.databinding.FragmentClipDrawableBinding

/**
 * @author jere
 */
class ClipDrawableFragment : BaseFragment<FragmentClipDrawableBinding>() {

    private val clipDrawable by lazy {
        ContextCompat.getDrawable(context!!, R.drawable.clip_drawable)
    }
    private val manualClipDrawable by lazy {
        ClipDrawable(
            ContextCompat.getDrawable(context!!, R.drawable.nick),
            Gravity.CENTER,
            ClipDrawable.VERTICAL
        )
    }

    override fun initView() {
        binding.clipDrawableInclude.apply {
            tv1.setText(R.string.clip_drawable)
            tv1.background = clipDrawable
            tv2.setText(R.string.clip_drawable)
            tv2.background = manualClipDrawable
        }

        //level 默认级别为 0，即完全裁剪，使图像不可见。当级别为 10,000 时，图像不会裁剪，而是完全可见。
        binding.seekBar.apply {
            //init level
            clipDrawable?.level = progress
            manualClipDrawable.level = progress
            //add listener
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    clipDrawable?.level = progress
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