package com.utad.mvvmtareas.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utad.mvvmtareas.data.storage.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//guardamos los datos del usuario haciendo uso de nuestra DataStoreManager

class MainViewModel: ViewModel() {

    fun saveData(context: Context, username: String){
      viewModelScope.launch (Dispatchers.IO){
      //uso la funcion de guardar datos del DataStore
      DataStoreManager.saveData(context, username)
      }
    }
}