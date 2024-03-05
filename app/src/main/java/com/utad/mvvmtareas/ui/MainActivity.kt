package com.utad.mvvmtareas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.utad.mvvmtareas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding: ActivityMainBinding get() = _binding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bntAccess.setOnClickListener {
            saveUsers()

        }

    }

    private fun saveUsers() {
        val name =  binding.etUserName.text.toString().trim()
        if (!name.isNullOrEmpty()){
            viewModel.saveData(this, name) // guardo los datos con la funcion de VM
            goToHomeWorkScreen() // navego a la siguiente pantalla
        }else{
            Toast.makeText(this, "Introduce texto", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToHomeWorkScreen() {
        val intent = Intent(this, HomeWorkActivity::class.java)
        startActivity(intent)
        finish()
    }
}