package com.unsoed.responsi1mobileh1d023014.data.model



data class Team(
    val id: Int,
    val name: String,
    val tla: String,
    val shortName: String,
    val area: Area,
    val crest: String,
    val coach: Coach,
    val squad: List<Player>
)

data class Area(
    val name: String
)

