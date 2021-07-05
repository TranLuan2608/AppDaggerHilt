package com.example.application_dagger_hilt_retrofit.data.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.application_dagger_hilt_retrofit.R
import com.example.application_dagger_hilt_retrofit.data.model.User
import com.example.application_dagger_hilt_retrofit.ui.main.adapter.MainAdapter
import com.example.application_dagger_hilt_retrofit.ui.main.viewmodel.MainViewModel
import com.example.application_dagger_hilt_retrofit.utils.Status
import kotlinx.android.synthetic.main.fragment_one.*

class OneFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_one, container, false)
    }

}