package com.drawable.learning.fragment

import android.graphics.drawable.Drawable
import android.graphics.drawable.LevelListDrawable
import android.util.Log
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.drawable.learning.R
import com.drawable.learning.databinding.FragmentLevelListDrawableBinding

/**
 * @author jere
 */
class LevelListDrawableFragment : BaseFragment<FragmentLevelListDrawableBinding>() {

    private val lld by lazy {
        LevelListDrawable().apply {
            addLevel(0, 1, getDrawable(R.drawable.nick))
            addLevel(0, 2, getDrawable(R.drawable.tom1))
            addLevel(0, 3, getDrawable(R.drawable.tom2))
            addLevel(0, 4, getDrawable(R.drawable.tom3))
            addLevel(0, 5, getDrawable(R.drawable.tom4))
            addLevel(0, 6, getDrawable(R.drawable.tom5))
            addLevel(0, 7, getDrawable(R.drawable.tom6))
            addLevel(0, 8, getDrawable(R.drawable.tom7))
            addLevel(0, 9, getDrawable(R.drawable.tom8))
            addLevel(0, 10, getDrawable(R.drawable.tom9))
        }
    }

    private fun getDrawable(id: Int): Drawable {
        return (ContextCompat.getDrawable(requireContext(), id)
            ?: ContextCompat.getDrawable(requireContext(), R.drawable.nick)) as Drawable
    }

    private val levelListDrawable by lazy {
        ContextCompat.getDrawable(requireContext(), R.drawable.level_list_drawable)
    }

    override fun initView() {

        binding.levelListDrawableInclude.apply {
            tv1.setText(R.string.level_list_drawable)
            tv1.background = levelListDrawable
            tv2.setText(R.string.level_list_drawable)

            tv2.background = lld
        }

        binding.seekBar.apply {
            //init level
            levelListDrawable?.level = progress
            lld.level = progress
            //add listener
            setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    levelListDrawable?.level = progress
                    lld.level = progress
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