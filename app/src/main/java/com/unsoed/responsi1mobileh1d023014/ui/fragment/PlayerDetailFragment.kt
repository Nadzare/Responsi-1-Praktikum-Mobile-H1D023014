package com.unsoed.responsi1mobileh1d023014.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.unsoed.responsi1mobileh1d023014.R
import com.unsoed.responsi1mobileh1d023014.data.model.Player

class PlayerDetailFragment : BottomSheetDialogFragment() {

    private lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // Ambil data Player yang dikirim dari Adapter
            player = it.getParcelable(ARG_PLAYER) ?: return
        }

        // Panggil style rounded corner
        setStyle(STYLE_NORMAL, R.style.ThemeOverlay_App_BottomSheetDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.activity_player_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val tvDetailName: TextView = view.findViewById(R.id.tvDetailName)
        val tvDetailNationality: TextView = view.findViewById(R.id.tvDetailNationality)
        val tvDetailPosition: TextView = view.findViewById(R.id.tvDetailPosition)
        val btnClose: Button = view.findViewById(R.id.btnClose)


        val tvDetailDob: TextView = view.findViewById(R.id.tvDetailDob)


        tvDetailName.text = player.name
        tvDetailNationality.text = player.nationality ?: "N/A"
        tvDetailPosition.text = player.position ?: "N/A"


        tvDetailDob.text = formatDate(player.dateOfBirth) ?: "N/A"


        btnClose.setOnClickListener {
            dismiss()
        }
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



    companion object {
        private const val ARG_PLAYER = "player_data"

        fun newInstance(player: Player): PlayerDetailFragment {
            val fragment = PlayerDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_PLAYER, player)
            fragment.arguments = args
            return fragment
        }
    }
}

