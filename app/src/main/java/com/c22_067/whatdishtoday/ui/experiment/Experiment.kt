package com.c22_067.whatdishtoday.ui.experiment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Experiment(
    val img: Int,
    val name: String
): Parcelable
