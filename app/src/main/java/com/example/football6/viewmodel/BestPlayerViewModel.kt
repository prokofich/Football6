package com.example.football6.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.football6.api.Repository
import com.example.football6.model.player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class BestPlayerViewModel:ViewModel() {


    val repo = Repository()
    var Player:MutableLiveData<Response<player>> = MutableLiveData()

    fun getPlayerPenalty(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getPlayerPenalty()
            withContext(Dispatchers.Main){
                Player.value = responce
            }
        }
    }

    fun getPlayerFreeKick(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getPlayerFreeKick()
            withContext(Dispatchers.Main){
                Player.value = responce
            }
        }
    }

    fun getPlayerCorners(){
        viewModelScope.launch(Dispatchers.IO) {
            val responce = repo.getPlayerCorners()
            withContext(Dispatchers.Main){
                Player.value = responce
            }
        }
    }


}