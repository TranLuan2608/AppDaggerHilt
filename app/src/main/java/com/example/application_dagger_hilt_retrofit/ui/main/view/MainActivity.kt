package com.example.application_dagger_hilt_retrofit.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        btnAddUser.setOnClickListener {
            startActivity(Intent(this,AddUserActivity::class.java))
        }
//        var animal = Animal("anthit","ngu ngay")
//        var dog = Dog("gau gau","an thit","ngu dem")
//        Log.d("TagA","ThuocTinh ${animal.eat} ${animal.sleep}")
//        Log.d("TagA","ThuocTinhConCho ${dog.bark} ${dog.sleep} ${dog.eat}")
//        var cat = Cat("trong nha","ca","ban ngay")
//        var bear = Bear("thit","winter","trong hang")
//        var rat = Rat("co","khong biet","trong hang")
//        Log.d("TagA","ThuocTinhConMeo ${cat.eat} ${cat.sleep} ${cat.whereSleep}")
//        Log.d("TagA","ThuocTinhConGau ${bear.eat} ${bear.sleep} ${bear.whereSleep}")
//        Log.d("TagA","ThuocTinhConChuot ${rat.eat} ${rat.sleep} ${rat.whereSleep}")
////        var dog1: Dog = Animal("anthit","dem")
//        var animail1: Animal = Dog("gau","thit","dem")
//        if (animail1 is Dog){
//            Log.d("TagB","kiemtra ${animail1.bark}")
//        }
//        if (animail1 is Cat){
//            Log.d("TagB","kiemtra ${animail1.whereSleep}")
//        }

//        var personA: Person? = Person("NameA","Male")
//        var a: Int = 1
//        var b: String = "a"
//        var c: Boolean = false
//        var personC: Person = Person("NameC")
//        var personB = Person("NameB","Male")
//        Log.d("TagB","kiemtra ${personA==personB}")
//        personA = null
//        var sosanh = personA?:personB
//        Log.d("TagB","kiemtra ${sosanh.name}")
//
//        fun a(a: Int) {}
//        fun b(b: String,c: String){}
//        a(1)
//        b("b","c")
//        fun a1(a: Int): Int {
//            return a + 10
//        }
//        fun b1(b: String,c: String){}
//
//        var e = a1(2)
//        Log.d("TagB","kiemtra $e")
//        var t = a(3)
//        Log.d("TagB","kiemtra $t")




//        open class A(x: Int) {
//            public open val y: Int = x
//        }
//
//        var name = DataProviderManager.getUserName()
//        Log.d("TagB","kiemtra $name")
//
//
//        var h: NhanVien = GiamDoc()
//        var user: MutableList<NhanVien> = mutableListOf()
//        for(i in 1 until 100)
//        {
//            if(i%10==0)
//            {
//                user.add(GiamDoc())
//            }else {
//                user.add(CuLI())
//            }
//        }
//        user.forEach {
//            nhanVien ->
//                if(nhanVien is GiamDoc)
//                {
//                    nhanVien.chucVu()
//                }
//                if(nhanVien is CuLI)
//                {
//                    nhanVien.chucVu()
//                    nhanVien.tuoi()
//                }
//
//        }


        var ten = SetName()
        var tenB= ten.fullName("tran","luan")
        var tenA = ten.firstName
        Log.d("TagB","Day la Name ten A $tenA")
        Log.d("TagB","Day la Name $tenB")

    }

}

//   interface NhanVien {
//       fun chucVu()
//   }
//    class GiamDoc:NhanVien{
//        override fun chucVu() {
//            Log.d("TagB","Day la GiamDoc")
//
//        }
//
//    }
//
//    class CuLI:NhanVien{
//        override fun chucVu() {
//            Log.d("TagB","Day la CuLi")
//        }
//
//        fun tuoi() {
//            Log.d("TagB","Day la tuoi CuLi")
//        }
//
//    }
//    //mot so cai fun khong thay doi theo thoi gian
//    //dung de check du lieu
//object DataProviderManager  {
//    fun getUserName(): String {
//        return "Luan"
//    }
//
//    val allDataProviders: String
//        get() = ""
//
//}


abstract class Name  {
    var firstName: String = ""
    var lastName: String = ""
    abstract fun fullName(first: String, last: String): String
}

class SetName: Name()
{
    override fun fullName(first: String, last: String): String{
        firstName = first
        lastName = last
        return firstName + " " + lastName
    }


}



