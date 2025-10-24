package com.unsoed.responsi1mobileh1d023014.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.unsoed.responsi1mobileh1d023014.data.model.Player
import com.unsoed.responsi1mobileh1d023014.databinding.ItemPlayerBinding
import com.unsoed.responsi1mobileh1d023014.ui.fragment.PlayerDetailFragment
import com.unsoed.responsi1mobileh1d023014.utils.PositionColor

class PlayerAdapter(private val players: List<Player>) :
    RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {


    class PlayerViewHolder(private val binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(player: Player) {

            binding.tvPlayerName.text = player.name
            binding.tvPlayerPosition.text = player.position ?: "Unknown"


            binding.root.setBackgroundColor(PositionColor.getColorForPosition(player.position))


            binding.root.setOnClickListener {
                val context = binding.root.context

                if (context is AppCompatActivity) {
                    val fragment = PlayerDetailFragment.newInstance(player)
                    fragment.show(context.supportFragmentManager, "PlayerDetailFragment")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.bind(player)
    }

    override fun getItemCount() = players.size
}

