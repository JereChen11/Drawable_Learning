package com.drawable.learning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.drawable.learning.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val tabList = listOf(
            "BitmapDrawable",
            "ShapeDrawable",
            "GradientDrawable",
            "ScaleDrawable",
            "TransitionDrawable",
            "InsetDrawable",
            "ClipDrawable",
            "AnimationDrawable",
            "VectorDrawable",
            "Custom Drawable"
        )

        binding.vp.adapter = VpAdapter(this, tabList)

        TabLayoutMediator(binding.tabLayout, binding.vp) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }


    class VpAdapter(
        activity: FragmentActivity,
        private val tabList: List<String>
    ) : FragmentStateAdapter(activity) {

        override fun getItemCount() = tabList.size

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> BitmapDrawableFragment()
                1 -> ShapeDrawableFragment()
                2 -> GradientDrawableFragment()
                3 -> ScaleDrawableFragment()
                4 -> TransitionDrawableFragment()
                5 -> InsetDrawableFragment()
                6 -> ClipDrawableFragment()
                7 -> AnimationDrawableFragment()
                8 -> VectorDrawableFragment()
                else -> CustomDrawableFragment()
            }
        }

    }

}