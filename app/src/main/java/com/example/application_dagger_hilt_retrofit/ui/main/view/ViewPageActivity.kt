package com.example.application_dagger_hilt_retrofit.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.application_dagger_hilt_retrofit.R
import com.example.application_dagger_hilt_retrofit.ui.main.adapter.ViewPageAdapter
import com.example.application_dagger_hilt_retrofit.ui.main.fragment.OneFragment
import com.example.application_dagger_hilt_retrofit.ui.main.fragment.TwoFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_tab_view.*

@AndroidEntryPoint
class ViewPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_view)
        setUpTabs()
    }

    private fun setUpTabs() {
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(OneFragment(), "TabOne")
        adapter.addFragment(TwoFragment(), "TabTwo")
        viewPage.adapter = adapter
        tabs.setupWithViewPager(viewPage)
    }
}