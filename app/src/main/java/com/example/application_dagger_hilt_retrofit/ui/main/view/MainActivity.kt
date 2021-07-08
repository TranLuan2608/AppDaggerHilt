package com.example.application_dagger_hilt_retrofit.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.application_dagger_hilt_retrofit.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTestApi.setOnClickListener {
            startActivity(Intent(this, CallApiActivity::class.java))
        }
        btnTestViewPager.setOnClickListener {
            startActivity(Intent(this, ViewPageActivity::class.java))
        }


    }

}
