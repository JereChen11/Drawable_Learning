package com.drawable.learning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.drawable.learning.fragment.custom.ball.MoveBallFragment
import com.drawable.learning.fragment.custom.line_chart.LineChartFragment
import com.drawable.learning.databinding.ActivityMainBinding
import com.drawable.learning.fragment.*
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @author jere
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val tabList by lazy {
        listOf(
            getString(R.string.bitmap_drawable),
            getString(R.string.shape_drawable),
            getString(R.string.gradient_drawable),
            getString(R.string.layer_drawable),
            getString(R.string.state_list_drawable),
            getString(R.string.level_list_drawable),
            getString(R.string.scale_drawable),
            getString(R.string.transition_drawable),
            getString(R.string.inset_drawable),
            getString(R.string.clip_drawable),
            getString(R.string.animation_drawable),
            getString(R.string.animated_vector_drawable),
            getString(R.string.custom_drawable_1),
            getString(R.string.custom_drawable_2)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vp.adapter = VpAdapter(this, tabList)

        TabLayoutMediator(binding.tabLayout, binding.vp) { tab, position ->
            tab.text = tabList[position]
        }.attach()

        binding.vp.currentItem = tabList.size - 1
    }


    class VpAdapter(
        private val activity: FragmentActivity,
        private val tabList: List<String>
    ) : FragmentStateAdapter(activity) {

        override fun getItemCount() = tabList.size

        override fun createFragment(position: Int): Fragment {

            activity.apply {
                return when (tabList[position]) {
                    getString(R.string.bitmap_drawable) -> BitmapDrawableFragment()
                    getString(R.string.shape_drawable) -> ShapeDrawableFragment()
                    getString(R.string.gradient_drawable) -> GradientDrawableFragment()
                    getString(R.string.layer_drawable) -> LayerDrawableFragment()
                    getString(R.string.state_list_drawable) -> StateListDrawableFragment()
                    getString(R.string.level_list_drawable) -> LevelListDrawableFragment()
                    getString(R.string.scale_drawable) -> ScaleDrawableFragment()
                    getString(R.string.transition_drawable) -> TransitionDrawableFragment()
                    getString(R.string.inset_drawable) -> InsetDrawableFragment()
                    getString(R.string.clip_drawable) -> ClipDrawableFragment()
                    getString(R.string.animation_drawable) -> AnimationDrawableFragment()
                    getString(R.string.animated_vector_drawable) -> AnimatedVectorDrawableFragment()
                    getString(R.string.custom_drawable_1) -> LineChartFragment()
                    else -> MoveBallFragment()
                }
            }

        }

    }

}