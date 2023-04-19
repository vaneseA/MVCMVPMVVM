package com.example.mvcmvpmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mvcmvpmvvm.databinding.ActivityMainBinding


//Controller
class MainActivity : AppCompatActivity(), ViewInterface {
    lateinit var binding: ActivityMainBinding

    var presenter = Presenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this
    }

    fun clickNumber(i: Int) {

        presenter.clickNumber(i)
    }

    override fun toastMessage(i: Int) {
        Toast.makeText(this, "$i 번을 클릭했습니다.", Toast.LENGTH_SHORT).show()
    }

    override fun checkPasswordMessage() {
        //4자리 이상 비밀번호가 1234일
        binding.messageSuccess.visibility = View.VISIBLE
    }
}