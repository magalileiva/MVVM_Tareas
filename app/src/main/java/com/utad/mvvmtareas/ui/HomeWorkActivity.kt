package com.utad.mvvmtareas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utad.mvvmtareas.databinding.ActivityHomeWorkBinding
import com.utad.mvvmtareas.databinding.ActivityMainBinding

class HomeWorkActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityHomeWorkBinding
    private val binding: ActivityHomeWorkBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}