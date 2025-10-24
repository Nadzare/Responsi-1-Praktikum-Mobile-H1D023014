package com.unsoed.responsi1mobileh1d023014.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.responsi1mobileh1d023014.databinding.ActivityCoachBinding
import com.unsoed.responsi1mobileh1d023014.ui.viewmodel.TeamViewModel

class CoachActivity : AppCompatActivity() {

    private val viewModel: TeamViewModel by viewModels()
    private lateinit var binding: ActivityCoachBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.team.observe(this) { team ->
            team.coach?.let {
                binding.tvCoachName.text = it.name ?: "Unknown Coach"
                binding.tvCoachNationality.text = it.nationality ?: "Unknown Nationality"


                binding.tvCoachDob.text = formatDate(it.dateOfBirth) ?: "Unknown DoB"
            }
        }


        viewModel.fetchTeamData()
    }


    private fun formatDate(date: String?): String? {
        if (date == null) return null


        return try {
            val parts = date.split("-")
            if (parts.size == 3) {
                val year = parts[0]
                val month = getMonthName(parts[1].toInt())
                val day = parts[2]
                "$day $month $year"
            } else {
                date
            }
        } catch (e: Exception) {
            date
        }
    }

    private fun getMonthName(month: Int): String {
        return when (month) {
            1 -> "January"
            2 -> "February"
            3 -> "March"
            4 -> "April"
            5 -> "May"
            6 -> "June"
            7 -> "July"
            8 -> "August"
            9 -> "September"
            10 -> "October"
            11 -> "November"
            12 -> "December"
            else -> ""
        }
    }
}

