package com.unsoed.responsi1mobileh1d023014.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unsoed.responsi1mobileh1d023014.data.api.ApiClient
import com.unsoed.responsi1mobileh1d023014.data.model.Team
import kotlinx.coroutines.launch

class TeamViewModel : ViewModel() {

    // LiveData yang akan diamati di Activity
    private val _team = MutableLiveData<Team>()
    val team: LiveData<Team> get() = _team

    // Fungsi untuk memanggil API dan mengisi data ke LiveData
    fun fetchTeamData() {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getTeam(529) // ID klub kamu: Stade Rennais FC
                _team.postValue(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
