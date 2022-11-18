package com.c22_067.whatdishtoday.ui.favorite

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TempFavorite (
    var name: String,
    var photo: Int
): Parcelable

