package com.example.application_dagger_hilt_retrofit.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.application_dagger_hilt_retrofit.R
import com.example.application_dagger_hilt_retrofit.data.model.User
import com.example.application_dagger_hilt_retrofit.ui.main.viewmodel.AddUserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.acticity_add_user.*


@AndroidEntryPoint
class AddUserActivity : AppCompatActivity() {
   private val addUserViewModel : AddUserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acticity_add_user)

        btnAddDataUser.setOnClickListener {
            var dataNameUse = edtNameUser.text
            var dataEmail  = edtEmailUser.text.toString()
            var dataAvatar = edtAvatarUser.text.toString()
            var arr:List<String> = dataNameUse.split(" ")
            var firstNameUser: String = arr[0].capitalize()
            var lastNameUser: String = arr[1].capitalize()
            var id: Int = addUserViewModel.countUsers()
            var listAddDataUser = User(id,firstNameUser,lastNameUser,dataEmail,dataAvatar)
            addUserViewModel.addDataUser(listAddDataUser)
        }
    }
}

//Tạo một cái view mới ,trên view đó nhập thông tin user, submit lưu thông tin xuống db
//Tạo một view mới > tạo edit text lấy thông tin > tạo button bắt sự kiện > tạo một viewModel để gọi sang db
//Tạo sự kiện nhấn nút
//Lưu thông tin User vào db
