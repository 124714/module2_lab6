package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cfsuman.jetpack.RandomNumberViewModel


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: RandomNumberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = ViewModelProvider(this)
        viewModel = provider.get(RandomNumberViewModel::class.java)

        observeViewModel()
        initView()

    }
    
    fun observeViewModel() {
        val rndNum = findViewById<EditText>(R.id.rndNum)
        viewModel.currentRandomNumber.observe(this, Observer {
            rndNum.setText(it.toString())
        })
    }

    fun initView() {
        val getRnd = findViewById<Button>(R.id.getRnd)
        getRnd.setOnClickListener {
            viewModel.random()
        }
    }
}

