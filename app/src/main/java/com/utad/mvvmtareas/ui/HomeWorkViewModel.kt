package com.utad.mvvmtareas.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utad.mvvmtareas.data.network.SchoolApi
import com.utad.mvvmtareas.data.network.model.HomeWorkResponse
import com.utad.mvvmtareas.data.storage.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class HomeWorkUiState(
    val isLoading: Boolean = false,
    val error: Boolean = false,
    val info: List<HomeWorkResponse>? = null
)
class HomeWorkViewModel: ViewModel() {

    private var _userName: MutableLiveData<String> = MutableLiveData(null)
    val userName: LiveData<String> = _userName

    private var _uiState: MutableLiveData<HomeWorkUiState> = MutableLiveData(HomeWorkUiState())
    val uiState: LiveData<HomeWorkUiState> get() = _uiState


    fun getUserName(context: Context){
         viewModelScope.launch(Dispatchers.IO){
             DataStoreManager.getData(context).collect{ userName ->
                 if(userName!="No hay datos"){
                     _userName.postValue(userName)
                 }
             }
         }
    }

    fun getHomeWork(userName: String){

        _uiState.postValue(HomeWorkUiState(isLoading = true))

        viewModelScope.launch(Dispatchers.IO){
            val response = SchoolApi.service.getAllTareas(userName, "U-tad")
            if(response.isSuccessful){
                _uiState.postValue(HomeWorkUiState(info = response.body()))

            }else{
                _uiState.postValue(HomeWorkUiState(error = true))
            }
        }
    }
}