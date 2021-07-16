package com.example.application_dagger_hilt_retrofit.ui.main.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.application_dagger_hilt_retrofit.R
import com.example.application_dagger_hilt_retrofit.data.model.User
import com.example.application_dagger_hilt_retrofit.ui.main.adapter.MainAdapter
import com.example.application_dagger_hilt_retrofit.ui.main.viewmodel.MainViewModel
import com.example.application_dagger_hilt_retrofit.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_call_api.*

@AndroidEntryPoint
class CallApiActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter
    lateinit var layoutManager: LinearLayoutManager
    var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_api)
        setupUI()
        setupObserver()

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!isLoading) {
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == (adapter.itemCount-1)) {
                        if (recyclerView.canScrollVertically(-1)) {
                            mainViewModel.fetchUser(2)
                            loadMore()
                        }
                    }
                }
            }
        })
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
        //What i want todo
        //nhan nut lay ten user
        btnGetNameUser.setOnClickListener {
            //Lay ten user
            var nameUser: String = searchUser.text.toString()
            var arr:List<String> = nameUser.split(" ")

            var firstNameUser: String
            var lastNameUser: String

            if(arr.size == 1)
            {
                firstNameUser = arr[0]
                lastNameUser = firstNameUser
            }else{
                firstNameUser = arr[0]
                lastNameUser = arr[1]
            }
            //liveCircle Activity
            //Lay user tu dataBase
            // CallApiActivity > MainViewModel > MainRepository > UserDataBase
            mainViewModel.fetchNameUser(firstNameUser,lastNameUser)
            mainViewModel.user.observe(this, Observer {
                it.data?.let { user -> clearAndRenderList(user) }
            })
        }

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
    private fun clearAndRenderList(user: List<User>) {
        adapter.clearAndData(user)
        adapter.notifyDataSetChanged()

    }



}