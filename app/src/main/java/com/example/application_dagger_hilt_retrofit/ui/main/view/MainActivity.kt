package com.example.application_dagger_hilt_retrofit.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.application_dagger_hilt_retrofit.R
import com.example.application_dagger_hilt_retrofit.data.fragment.OneFragment
import com.example.application_dagger_hilt_retrofit.data.fragment.TwoFragment
import com.example.application_dagger_hilt_retrofit.data.fragment.fragmentAdapter.viewPageAdapter
import com.example.application_dagger_hilt_retrofit.data.model.User
import com.example.application_dagger_hilt_retrofit.ui.main.adapter.MainAdapter
import com.example.application_dagger_hilt_retrofit.ui.main.viewmodel.MainViewModel
import com.example.application_dagger_hilt_retrofit.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter
    lateinit var layoutManager: LinearLayoutManager
    var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // setupUI()
       // setupObserver()
        setUpTabs()

//        layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = layoutManager
//        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (!isLoading) {
//                    if (layoutManager.findLastCompletelyVisibleItemPosition() == (adapter.itemCount-1)) {
//                        if (recyclerView.canScrollVertically(-1)) {
//                            mainViewModel.fetchUser(2)
//                            loadMore()
//                        }
//                    }
//                }
//            }
//        })
    }

    private fun setUpTabs() {
        val adapter = viewPageAdapter(supportFragmentManager)
        adapter.addFragment(OneFragment(),"TabOne")
        adapter.addFragment(TwoFragment(),"TabTwo")
        viewPage.adapter = adapter
        tabs.setupWithViewPager(viewPage)
    }

    private fun loadMore() {
        isLoading = true
    }


    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.user.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { user -> renderList(user)
                    }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(user: List<User>) {
        adapter.addData(user)
        adapter.notifyDataSetChanged()

    }

}
