package com.unsoed.responsi1mobileh1d023014

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen // <-- 1. IMPORT BARU
import com.unsoed.responsi1mobileh1d023014.databinding.ActivityMainBinding
import com.unsoed.responsi1mobileh1d023014.databinding.LayoutMenuBinding
import com.unsoed.responsi1mobileh1d023014.ui.activity.CoachActivity
import com.unsoed.responsi1mobileh1d023014.HistoryActivity
import com.unsoed.responsi1mobileh1d023014.TeamActivity

class MainActivity : AppCompatActivity() {

    // Inisialisasi ViewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // --- 2. TAMBAHKAN BARIS INI ---
        // Panggil installSplashScreen() SEBELUM super.onCreate()
        installSplashScreen()
        // ------------------------------------

        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupMenu(binding.layoutHistory, "Club History", R.drawable.ic_bola)
        setupMenu(binding.layoutCoach, "Head Coach", R.drawable.ic_coach)
        setupMenu(binding.layoutTeam, "Team Squad", R.drawable.ic_team)


        binding.layoutHistory.root.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        binding.layoutCoach.root.setOnClickListener {
            startActivity(Intent(this, CoachActivity::class.java))
        }

        binding.layoutTeam.root.setOnClickListener {
            startActivity(Intent(this, TeamActivity::class.java))
        }
    }


    private fun setupMenu(cardBinding: LayoutMenuBinding, title: String, iconRes: Int) {

        cardBinding.tvMenuTitle.text = title
        cardBinding.imgIcon.setImageResource(iconRes)
    }
}

