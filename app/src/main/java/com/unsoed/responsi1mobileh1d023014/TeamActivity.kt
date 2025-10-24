package com.unsoed.responsi1mobileh1d023014

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unsoed.responsi1mobileh1d023014.ui.adapter.PlayerAdapter
import com.unsoed.responsi1mobileh1d023014.ui.viewmodel.TeamViewModel

class TeamActivity : AppCompatActivity() {

    private val viewModel: TeamViewModel by viewModels()
    private lateinit var rvTeam: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        rvTeam = findViewById(R.id.rv_team)
        rvTeam.layoutManager = LinearLayoutManager(this)

        // Observasi data dari ViewModel
        viewModel.team.observe(this) { team ->
            val adapter = PlayerAdapter(team.squad)
            rvTeam.adapter = adapter
        }

        // Panggil API
        viewModel.fetchTeamData()
    }
}
