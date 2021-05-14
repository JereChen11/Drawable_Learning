package com.drawable.learning

import android.graphics.drawable.InsetDrawable
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.drawable.learning.databinding.FragmentInsetDrawableBinding

class InsetDrawableFragment : BaseFragment<FragmentInsetDrawableBinding>() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initView() {

        val insetDrawable = InsetDrawable(
            ContextCompat.getDrawable(context!!, R.drawable.nick),
            0f, 0f, 0.5f, 0.25f
        )
        binding.insetDrawableTv2.background = insetDrawable
    }

}