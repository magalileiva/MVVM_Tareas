package com.utad.mvvmtareas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.mvvmtareas.databinding.ActivityHomeWorkBinding
import com.utad.mvvmtareas.databinding.ActivityMainBinding
import com.utad.mvvmtareas.ui.adapter.HomeWorkAdapter

class HomeWorkActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityHomeWorkBinding
    private val binding: ActivityHomeWorkBinding get() = _binding
    // 1 creo el adapter (y lo importo)
    private val adapter = HomeWorkAdapter()
    // instancio el viewModel
    private val viewModel: HomeWorkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeWorkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2 hago los binding del adapter
        binding.rvHomeWork.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvHomeWork.adapter = adapter

        viewModel.getUserName(this)
        observeViewModel()


    }

    private fun observeViewModel() {
        viewModel.userName.observe(this){userName ->
            if(userName!=null){
                //llamamos a la Api
                viewModel.getHomeWork(userName)
            }
        }
        viewModel.uiState.observe(this){ uiState ->
            if (uiState.info!=null){
                adapter.submitList(uiState.info)
            }
            if (uiState.isLoading){
                //mostrar carga
            }else{
                //ocultar carga
            }
            if (uiState.error){
                // mensaje de error
            }
        }
    }
}