package com.ps2001.mypokemonlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val name: String?,
    val type: String?,
    val img: String?,
    val desc: String?,
    val weakness: String?,
    val ability: String?,
    val ability_desc: String?,
) : Parcelable
