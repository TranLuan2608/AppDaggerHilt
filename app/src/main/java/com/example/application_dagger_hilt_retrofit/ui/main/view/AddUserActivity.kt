package com.example.application_dagger_hilt_retrofit.ui.main.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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
            var dataNameUse = edtNameUser.text.toString()
            var dataEmail  = edtEmailUser.text.toString()
            var dataAvatar = edtAvatarUser.text.toString()
            var firstNameUser = ""
            var lastNameUser = ""
            if(dataAvatar==""||dataNameUse==""||dataEmail==""){
                Toast.makeText(this,"Điền thông tin User",Toast.LENGTH_LONG).show()
            }else {

                var arr: List<String> = dataNameUse.split(" ")
                if(arr.size==1){
                     firstNameUser = arr[0]
                }else if(arr.size==2){
                     firstNameUser = arr[0]
                     lastNameUser = arr[1].capitalize()
                }else{
                    firstNameUser = arr[0]
                    for(i in 1 until (arr.size))
                    {
                        firstNameUser = arr[0]
                        lastNameUser = lastNameUser.plus(" " + arr[i].capitalize())
                    }
                }
                var id: Int = addUserViewModel.countUsers()
                var listAddDataUser = User(id, firstNameUser.capitalize(), lastNameUser, dataEmail, dataAvatar)
                addUserViewModel.addDataUser(listAddDataUser)

            }

        }

        addUserViewModel.status.observe(this, Observer {
            if(it==true){
                Toast.makeText(this,"Add thanh cong",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Add that bai",Toast.LENGTH_LONG).show()
            }

        })
    }
}

//Tạo một cái view mới ,trên view đó nhập thông tin user, submit lưu thông tin xuống db
//Tạo một view mới > tạo edit text lấy thông tin > tạo button bắt sự kiện > tạo một viewModel để gọi sang db
//Tạo sự kiện nhấn nút
//Lưu thông tin User vào db
