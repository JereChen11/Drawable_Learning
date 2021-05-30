package com.drawable.learning

import android.graphics.drawable.LevelListDrawable
import android.util.Log
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import com.drawable.learning.databinding.FragmentLevelListDrawableBinding


class LevelListDrawableFragment : BaseFragment<FragmentLevelListDrawableBinding>() {

    private val lld by lazy {
        LevelListDrawable().apply {
            addLevel(0, 1, ContextCompat.getDrawable(context!!, R.drawable.nick))
            addLevel(0, 2, ContextCompat.getDrawable(context!!, R.drawable.tom1))
            addLevel(0, 3, ContextCompat.getDrawable(context!!, R.drawable.tom2))
            addLevel(0, 4, ContextCompat.getDrawable(context!!, R.drawable.tom3))
            addLevel(0, 5, ContextCompat.getDrawable(context!!, R.drawable.tom4))
            addLevel(0, 6, ContextCompat.getDrawable(context!!, R.drawable.tom5))
            addLevel(0, 7, ContextCompat.getDrawable(context!!, R.drawable.tom6))
            addLevel(0, 8, ContextCompat.getDrawable(context!!, R.drawable.tom7))
            addLevel(0, 9, ContextCompat.getDrawable(context!!, R.drawable.tom8))
            addLevel(0, 10, ContextCompat.getDrawable(context!!, R.drawable.tom9))
        }
    }
    private val levelListDrawable by lazy {
        ContextCompat.getDrawable(context!!, R.drawable.level_list_drawable)
    }

    override fun initView() {
//        val lld = LevelListDrawable().apply {
//            addLevel(0, 1, ContextCompat.getDrawable(context!!, R.drawable.nick))
//            addLevel(0, 2, ContextCompat.getDrawable(context!!, R.drawable.tom1))
//            addLevel(0, 3, ContextCompat.getDrawable(context!!, R.drawable.tom2))
//            addLevel(0, 4, ContextCompat.getDrawable(context!!, R.drawable.tom3))
//            addLevel(0, 5, ContextCompat.getDrawable(context!!, R.drawable.tom4))
//            addLevel(0, 6, ContextCompat.getDrawable(context!!, R.drawable.tom5))
//            addLevel(0, 7, ContextCompat.getDrawable(context!!, R.drawable.tom6))
//            addLevel(0, 8, ContextCompat.getDrawable(context!!, R.drawable.tom7))
//            addLevel(0, 9, ContextCompat.getDrawable(context!!, R.drawable.tom8))
//            addLevel(0, 10, ContextCompat.getDrawable(context!!, R.drawable.tom9))
//        }

        binding.levelListDrawableInclude.apply {
            tv1.setText(R.string.level_list_drawable)
//            tv1.background = ContextCompat.getDrawable(context!!, R.drawable.level_list_drawable)
            tv1.background = levelListDrawable
            tv2.setText(R.string.level_list_drawable)

            tv2.background = lld

//            val bgDrawable = tv1.background as LevelListDrawable
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